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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author gasaesco
 */
public class InicioHuespedController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnRegistrarReserva;
    @FXML
    private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        back.setOnAction(event -> {
           try {
               regresar();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
        btnRegistrarReserva.setOnAction(event -> {
           try {
               irARegistrarReserva();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
        
    }    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("PrincipalitoFXML");
    }
    @FXML
    private void irARegistrarReserva() throws IOException{
        App.setRoot("RegistrarReserva");
    }
}
