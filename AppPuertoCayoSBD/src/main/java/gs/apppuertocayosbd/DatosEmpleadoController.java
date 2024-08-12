/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marsa
 */
public class DatosEmpleadoController implements Initializable {

    @FXML
    private TextField campoCed;
    
    @FXML
    private TextField campoNombres;
    
    @FXML
    private TextField campoApellidos;
    
    @FXML
    private TextField campoTelf;
    
    @FXML
    private TextField campoCorreo;
    
    @FXML
    private TextField campoSueldo;
    
    @FXML
    private TextField campoJefe;
    
    @FXML
    private TableView tablaDatos;
    
    @FXML
    private Button btnGuardar;
    
    @FXML
    private Button btnModificar;
    
    @FXML
    private Button btnEliminar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }   
      @FXML
    
    private void guardarEmpleado(ActionEvent event){
        Proyectito.CEmpleado objetoEmpleado= new Proyectito.CEmpleado();
        objetoEmpleado.agregarEmpleado(campoCed,campoNombres,campoApellidos, campoTelf,campoCorreo,campoSueldo,campoJefe);
    }

    
}
