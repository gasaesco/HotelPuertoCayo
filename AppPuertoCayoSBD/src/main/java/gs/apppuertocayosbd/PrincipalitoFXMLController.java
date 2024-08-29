/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author crisp
 */
public class PrincipalitoFXMLController implements Initializable {
    
    @FXML
    private Button btnHuesped;
    @FXML
    private Button btnEmpleado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Proyectito.CConexion objetoConexion= new Proyectito.CConexion();
       
       btnHuesped.setOnAction(event -> {
           try {
               InicioHuesped();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       btnEmpleado.setOnAction(event -> {
           try {
               InicioEmpleado();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }    
    @FXML
    private void InicioHuesped() throws IOException {
        App.setRoot("InicioHuesped");      
    }
    
    @FXML
    private void InicioEmpleado() throws IOException {
        App.setRoot("InicioEmpleado");        
    }
    
    
}    
    

