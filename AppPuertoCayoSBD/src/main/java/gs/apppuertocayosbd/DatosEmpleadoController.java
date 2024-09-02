/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import Proyectito.Empleado;
import Proyectito.TipoEmpleado;
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

/**
 * FXML Controller class
 *
 * @author Marsa
 */
public class DatosEmpleadoController implements Initializable {
    
     
@FXML
private TableView<Empleado> tablaEmpleados;
@FXML
private TableColumn<Empleado, String> cedula;
@FXML
private TableColumn<Empleado, String> nombres;
@FXML
private TableColumn<Empleado, String> apellidos;
@FXML
private TableColumn<Empleado, String> cargo;
@FXML
private TableColumn<Empleado, TipoEmpleado> tipo;
@FXML
private TableColumn<Empleado, Double> salario;
private TableColumn<Empleado, String> jefe;

@FXML
private Button back;

private final ObservableList<Empleado> lEmpleado = FXCollections.observableArrayList();

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
        Logger.getLogger(DatosEmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    
    
    private void setearTabla() throws SQLException{
            Connection connection = AzureConexion.getConnection();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Empleado"; 
            ResultSet resultSet = statement.executeQuery(sqlQuery);
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        nombres.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
        cargo.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        tipo.setCellValueFactory(new PropertyValueFactory("telefono"));
        salario.setCellValueFactory(new PropertyValueFactory("correo"));
        jefe.setCellValueFactory(new PropertyValueFactory("jefe"));
        
        
        
            while (resultSet.next()) {
               Empleado e = new Empleado(
                resultSet.getString("cargo"),
                TipoEmpleado.valueOf(resultSet.getString("tipoEmpleado")), 
                Double.parseDouble(resultSet.getString("salario")),
                resultSet.getString("cedeJefe"),
                resultSet.getString("cedEmpleado"),
                resultSet.getString("nombres"),
                resultSet.getString("apellidos"),
                resultSet.getString("correo"),
                resultSet.getString("telefono"));
               

                lEmpleado.add(e);
                
            }
        tablaEmpleados.setItems(lEmpleado);
            
    
   }
    @FXML
    private void regresar() throws IOException{
        App.setRoot("InicioAdministrador");
    }
    

}

   