/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import Proyectito.Huesped;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author crisp
 */
public class DatosHuespedController implements Initializable {
 
@FXML
private TableView<Huesped> tablaHuesped;
@FXML
private TableColumn<Huesped, String> cedula;
@FXML
private TableColumn<Huesped, String> nombres;
@FXML
private TableColumn<Huesped, String> apellidos;
@FXML
private TableColumn<Huesped, String> nacionalidad;
@FXML
private TableColumn<Huesped, String> telefono;
@FXML
private TableColumn<Huesped, String> correo;

@FXML
private Button back;

private final ObservableList<Huesped> lHuesped = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         back.setOnAction(event -> {
           try {
               regresar();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
        
    try {
        setearTabla();
    } catch (SQLException ex) {
        Logger.getLogger(DatosHuespedController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    
    
    private void setearTabla() throws SQLException{
            Connection connection = AzureConexion.getConnection();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM huesped"; 
            ResultSet resultSet = statement.executeQuery(sqlQuery);
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        nombres.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
        nacionalidad.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        correo.setCellValueFactory(new PropertyValueFactory("correo"));
        
        
        
            while (resultSet.next()) {
                Huesped h = new Huesped(resultSet.getString("cedHuesped"),resultSet.getString("nombres"), resultSet.getString("apellidos"), resultSet.getString("nacionalidad"), resultSet.getString("telefono"), resultSet.getString("correo"));
                lHuesped.add(h);
                
            }
        tablaHuesped.setItems(lHuesped);
            
    
   }
    @FXML
    private void regresar() throws IOException{
        App.setRoot("InicioAdministrador");
    }
    
  
}
