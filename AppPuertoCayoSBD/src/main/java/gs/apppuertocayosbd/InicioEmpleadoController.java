/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.Empleado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author gasaesco
 */
public class InicioEmpleadoController implements Initializable {

    @FXML
    private Label titulo;
    
    @FXML
    private Button btnRegistrarEmp;
    
    @FXML
    private Button btnRegistrarServ;
    
    @FXML
    private Button btnRegistrarProv;
    
    @FXML
    private Button btnRegistrarHab;
    
    @FXML
    private Button btnVerInventario;
    
    @FXML
    private Button btnSalir;
    
    /**
     * Initializes the controller class.
     */
    
    public void actualizarTitulo(Empleado emp){
        if (emp != null && emp.getNombre() != null){
            titulo.setText(("¡Bienvenido/a, "+ emp.getNombre() + "!"));
        }else{
            titulo.setText("¡Bienvenido/a!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
