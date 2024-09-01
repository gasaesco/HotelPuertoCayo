/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import Proyectito.EstadoHab;
import Proyectito.Habitacion;
import Proyectito.Huesped;
import Proyectito.TipoHab;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class VerHabitacionesController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TableView<Habitacion> tablaHabitaciones;
    @FXML
    private TableColumn<Habitacion, Integer> numero;
    @FXML
    private TableColumn<Habitacion, Integer> camas;
    @FXML
    private TableColumn<Habitacion, Double> precio;
    @FXML
    private TableColumn<Habitacion, String> tipo;
    @FXML
    private TableColumn<Habitacion, String> estado;
    private final ObservableList<Habitacion> habitaciones = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       IniciarBotones();
        try {
            setearTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VerHabitacionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }
  private void setearTabla() throws SQLException {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        connection = AzureConexion.getConnection();
        statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM habitacion WHERE estado = 'DISPONIBLE'";
        resultSet = statement.executeQuery(sqlQuery);

        
        numero.setCellValueFactory(new PropertyValueFactory<>("nroHabitacion"));
        camas.setCellValueFactory(new PropertyValueFactory<>("cantCamas"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precioXHuesp"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipoHabitacion"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        
        while (resultSet.next()) {
            int nroHabitacion = resultSet.getInt("nroHabitacion");
            int cantCamas = resultSet.getInt("cantCamas");
            double precioXHuesp = resultSet.getDouble("precioxHuespeHabi");
            String tipoHabitacionStr = resultSet.getString("tipoHabitacion").trim().toUpperCase();
            String estadoStr = resultSet.getString("estado").trim().toUpperCase(); 

            
            TipoHab tipoHabitacion = TipoHab.valueOf(tipoHabitacionStr);
            EstadoHab estadoN = EstadoHab.valueOf(estadoStr);

            Habitacion h = new Habitacion(nroHabitacion, cantCamas, precioXHuesp, tipoHabitacion, estadoN);
            habitaciones.add(h);
        }

        estado.setVisible(false);
        tablaHabitaciones.setItems(habitaciones);

    } finally {

        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

}
