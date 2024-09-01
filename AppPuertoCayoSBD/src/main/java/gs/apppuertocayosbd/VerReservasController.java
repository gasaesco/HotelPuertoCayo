/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import Proyectito.Reserva;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;

public class VerReservasController implements Initializable {
    
    @FXML
    private Button back;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnBuscar;

    @FXML
    private VBox seccion;

   @FXML
   private TableView<Reserva> tablaReservas;

    @FXML
    private TableColumn<Reserva, String> cedula;

    @FXML
    private TableColumn<Reserva, LocalDate> fechainicio;

    @FXML
    private TableColumn<Reserva, LocalDate> fechasalida;

    @FXML
    private TableColumn<Reserva, String> habitacion;

    @FXML
    private Button btnCancelar;

    @FXML
    private VBox textoModificar;

    @FXML
    private Button btnModificar;

    @FXML
    private VBox modificar;

    @FXML
    private ComboBox habitaciones;

    @FXML
    private Button btnEnviar;
    
    @FXML
    private DatePicker dateInicio;
    
    @FXML
    private DatePicker dateFin;
    
    private static String cedulaUsr;
    ObservableList<Reserva> reservas = FXCollections.observableArrayList();
    private final ObservableList<Integer> habitacionesDisponibles= FXCollections.observableArrayList();
    private static int numHabitacion;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ocultarSeccion();
        IniciarBotones();
        
        
    }  
     @FXML
    private void regresar() throws IOException{
        App.setRoot("InicioHuesped");
    }   
     private void botonRegresar(){
    back.setOnAction(event -> {
           try {
               regresar();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }
    
     private void botonBuscar(){
    btnBuscar.setOnAction(event -> {
           try {
               activarSeccion();
               rellenarTabla();
           } catch (SQLException ex) {
            Logger.getLogger(VerReservasController.class.getName()).log(Level.SEVERE, null, ex);
        }
       });
    }
    
     private void IniciarBotones(){  
        botonRegresar(); 
        botonBuscar();
        botonCancelar();
    }
    private void ocultarSeccion(){
        seccion.setVisible(false);
    }
    private void mostrarSeccion(){
        
        seccion.setVisible(true);
    }
     private int buscarClientePorCedula(String cedula) throws SQLException {
    int resultado = 0;
    Connection conexion = null;
    CallableStatement stmt = null;

    try {
        // Establecer conexión
        conexion = AzureConexion.getConnection();
        String consulta = "{CALL BuscarClientePorCedula(?, ?)}";
        stmt = conexion.prepareCall(consulta);
        stmt.setString(1, cedula);
        stmt.registerOutParameter(2, Types.INTEGER);

        // Ejecutar el procedimiento
        stmt.execute();
        

        // Obtener el valor del parámetro de salida
        resultado = stmt.getInt(2);
    } catch (SQLException e) { // Puedes hacer logging o manejar la excepción según sea necesario
        // Puedes hacer logging o manejar la excepción según sea necesario
        throw e; // Opcional: vuelve a lanzar la excepción si deseas que la maneje el llamador
    } finally {
        // Cerrar recursos en el bloque finally
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // Manejo de errores en el cierre del Statement
                
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                // Manejo de errores en el cierre de la conexión
                
            }
        }
    }
    return resultado;
}
     @FXML
     private void botonCancelar(){
         btnCancelar.setOnAction(event -> {
             Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Está seguro de eliminar su reserva?");
            alerta.setHeaderText(null);
            alerta.setContentText("Está de acuerdo con eliminar su reserva?");
            alerta.showAndWait().ifPresent(response ->{
                if (response == ButtonType.OK) {
                 eliminarReserva(numHabitacion, cedulaUsr);
            } else {
             Alert aler = new Alert(Alert.AlertType.INFORMATION);
             aler.setTitle("Reserva no Eliminada");
            aler.setHeaderText(null);
            aler.setContentText("La reserva NO se eliminó");
            aler.showAndWait();
             tablaReservas.getItems().clear();
             dateInicio.setValue(null);
             dateFin.setValue(null);
             habitaciones.setValue(null);
            }
                Alert aler = new Alert(Alert.AlertType.INFORMATION);
                   aler.setTitle("Reserva Eliminada");
                   aler.setHeaderText(null);
                   aler.setContentText("Se ha eliminado la reserva");
                   aler.showAndWait();
            });
             tablaReservas.getItems().clear();
             try {
                 rellenarTabla();
             } catch (SQLException ex) {
                 Logger.getLogger(VerReservasController.class.getName()).log(Level.SEVERE, null, ex);
             }
             dateInicio.setValue(null);
             dateFin.setValue(null);
             habitaciones.setValue(null);
       });
     }
    @FXML
     private void activarSeccion() throws SQLException{
       cedulaUsr = txtCedula.getText();
       int valido = buscarClientePorCedula(cedulaUsr);
       if(valido == 1){
           mostrarSeccion();
           txtCedula.setVisible(true);
           tablaReservas.getItems().clear();
           btnCancelar.setDisable(true);
           btnModificar.setDisable(true);
           rellenarCombos();
         
                  
       }else{
           txtCedula.setText("");
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Usuario no encontrado");
            alerta.setHeaderText(null);
            alerta.setContentText("Usted no tiene reservas");
            alerta.showAndWait();
       
       }
       
   }
     
     
   
   private void rellenarTabla() throws SQLException{
        String sql = "{CALL ObtenerReservasPorCedula (?)}";
         try (Connection conn = AzureConexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, cedulaUsr);
            ResultSet rs = stmt.executeQuery();
           cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
           fechainicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
           fechasalida.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
           habitacion.setCellValueFactory(new PropertyValueFactory<>("habitacion"));
        while (rs.next()) {
                String cedHuesped = rs.getString("cedHuesped");
                LocalDate fechaInicio = rs.getDate("fechaInicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fechaFin").toLocalDate();
                int  nroHabitacion = Integer.parseInt(rs.getString("nroHabitacion"));

                Reserva reserva = new Reserva(cedHuesped, fechaInicio, fechaFin, nroHabitacion);
                reservas.add(reserva);
            }
        tablaReservas.setItems(reservas);
        selectorData();

        } catch (SQLException e) {
            
        }
   }
   private void selectorData(){
        tablaReservas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            Reserva reservaSeleccionada = newValue;
            
            txtCedula.setText(reservaSeleccionada.getCedula());
            dateInicio.setValue(reservaSeleccionada.getFechaInicio());
            dateFin.setValue(reservaSeleccionada.getFechaFin());
            numHabitacion = reservaSeleccionada.getHabitacion();
            habitaciones.setValue(reservaSeleccionada.getHabitacion());
            btnCancelar.setDisable(false);
           btnModificar.setDisable(false);
            
        }
    });
   }
   
   
   
   private void eliminarReserva(int nHabitacion, String cedula){
        String sql = "{call EliminarReserva (?, ?)}";
        try (Connection conn = AzureConexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, nHabitacion);
            stmt.setString(2, cedula);
            stmt.executeUpdate();
            
            
        stmt.close();
        conn.close();

        } catch (SQLException e) {
             Alert aler = new Alert(Alert.AlertType.ERROR);
             aler.setTitle("No se ha eliminado ");
            aler.setHeaderText("No se pudo eliminar");
            aler.setContentText("La reserva NO se eliminó porque el pago ya fue realizado");
            aler.showAndWait();
        }
        
    }
    private void setearComboHabitaciones() throws SQLException {
        Connection conexion = null;
        CallableStatement stmt = null;
         try {
        // Establecer conexión
        conexion = AzureConexion.getConnection();
        String consulta = "{CALL habitacionesDisponibles()}";
        stmt = conexion.prepareCall(consulta);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            int nroHabitacion = rs.getInt("nroHabitacion");
            habitacionesDisponibles.add(nroHabitacion);
            
        }
        habitaciones.setItems(habitacionesDisponibles);
         
         }catch (SQLException e) { 
         
            }
   
   }
    
    private void ModificarReserva(String cedula, int ahabitacion, LocalDate fechain, LocalDate fechafin , int nHabitacion){
        String sql = "{call ModificarReserva (?, ?,?,?,?)}";
        try (Connection conn = AzureConexion.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, cedula);
            stmt.setInt(2, ahabitacion);
            stmt.setDate(3, Date.valueOf(fechain));  
            stmt.setDate(4, Date.valueOf(fechafin)); 
            stmt.setInt(5, nHabitacion);
            stmt.executeUpdate();
            
            
        stmt.close();
        conn.close();
        

        } catch (SQLException e) {
            
        }
        
    }
    @FXML
    private void darInformación(){
         ModificarReserva(cedulaUsr, numHabitacion, dateInicio.getValue(), dateFin.getValue(), (int) habitaciones.getValue());
          Alert aler = new Alert(Alert.AlertType.INFORMATION);
             aler.setTitle("Reserva Actualizada");
            aler.setHeaderText(null);
            aler.setContentText("La reserva se ha actualizado");
            aler.showAndWait();
    }
    private void rellenarCombos() throws SQLException{
        setearComboHabitaciones();
    }
}
