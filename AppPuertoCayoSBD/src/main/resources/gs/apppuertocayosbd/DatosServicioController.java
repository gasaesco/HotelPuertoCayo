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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gasaesco
 */
public class DatosServicioController implements Initializable {

    @FXML
    private TextField campoHora;
    
    @FXML
    private DatePicker campoFecha;
    
    @FXML
    private TextField campoTipo;
    
    @FXML
    private TextField campoCedHuesp;
            
    @FXML
    private TextField campoCedEmp;
    
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
        // TODO
    }    
    
}
