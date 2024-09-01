/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author sebas
 */
public class RegistrarReservaController implements Initializable {
        @FXML
    private Button back;
        @FXML
        private ComboBox cmbMinutos;
        @FXML
        private ComboBox cmbHoras;
        @FXML
        private TextField txtCedula;
        @FXML
        private VBox campos;
        @FXML
        private VBox textoCampos;
        @FXML
        private Button btnValidar; 
        @FXML
        private Label mostrarNombre;
        @FXML
        private ComboBox cmbHabitaciones;
               
        
        private final ObservableList<String> horas= FXCollections.observableArrayList();
        private final ObservableList<Integer> habitacionesDisponibles= FXCollections.observableArrayList();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ocultarSecciones();
            try {
                rellenarCombos();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrarReservaController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    private void IniciarBotones(){  
        botonRegresar();    
        botonvalidar();   
    }
    
    private void setearComboMinutos(){
        cmbMinutos.getItems().addAll(
            "00",
            "30"
        );
    }
    
    private void setearComboHoras(){
        for (int i = 6; i<=22; i++){
            if (i<10){String hora = "0"+i; horas.add(hora);}else{
            horas.add(String.valueOf(i));
            }
        }
        System.out.println(horas);
        cmbHoras.setItems(horas);
    }
    
    private void rellenarCombos() throws SQLException{
        setearComboMinutos();
        setearComboHoras();
        setearComboHabitaciones();
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
        cmbHabitaciones.setItems(habitacionesDisponibles);
        
        
         
         }catch (SQLException e) { 
             
    }
   
   }
   
   @FXML
   private void activarSeccion() throws SQLException{
       String cedulaUsr = txtCedula.getText();
       int valido = buscarClientePorCedula(cedulaUsr);
       if(valido == 1){
           mostrarSecciones();
           btnValidar.setVisible(false);
           txtCedula.setVisible(false);
           mostrarNombre.setText("Sea bienvenido/a continue con su registro para la reserva");
                  
       }else{
           txtCedula.setText("");
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error Usuario no encontrado");
            alerta.setHeaderText(null);
            alerta.setContentText("Usted no es huésped por favor registrese en recepción");
            alerta.showAndWait();
       
       }
       
   }
   
   private void ocultarSecciones(){
       campos.setVisible(false);
       textoCampos.setVisible(false);
   }
   private void mostrarSecciones(){
       campos.setVisible(true);
       textoCampos.setVisible(true);
   }
   
    private void botonvalidar(){
    btnValidar.setOnAction(event -> {
        try {
            activarSeccion();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       });
    }
    

}
