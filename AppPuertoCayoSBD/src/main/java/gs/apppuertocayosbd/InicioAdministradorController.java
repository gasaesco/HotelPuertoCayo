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
 *
 * @author gasaesco
 */
public class InicioAdministradorController implements Initializable {

       @FXML
    private Button back;
       @FXML
       private Button verEmpleados;
       @FXML
       private Button verHuespedes;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IniciarBotones();
    }   
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("PrincipalitoFXML");
    }
    @FXML 
    private void datosHuespedes() throws IOException{
        App.setRoot("DatosHuesped");
    }
    @FXML 
    private void datosEmpleados() throws IOException{
        App.setRoot("DatosEmpleados");
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
    private void botonverHuesped(){
    verHuespedes.setOnAction(event -> {
           try {
               datosHuespedes();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }
     private void botonverEmpleados(){
    verEmpleados.setOnAction(event -> {
           try {
               datosEmpleados();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }
    
    private void IniciarBotones(){
        botonRegresar();
        botonverHuesped();
        botonverEmpleados();
    }
    
}
 
