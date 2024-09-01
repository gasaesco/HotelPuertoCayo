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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author gasaesco
 */
public class InicioHuespedController implements Initializable {
    @FXML
    private Button btnRegistrarReserva;
    @FXML
    private Button btnVerReservas;
    @FXML
    private Button back;
    @FXML
    private Button btnVerHabitaciones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
       IniciarBotones();  
    }    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("PrincipalitoFXML");
    }
    @FXML
    private void irARegistrarReserva() throws IOException{
        App.setRoot("RegistrarReserva");
    }
    @FXML
    private void irAVerReservas() throws IOException{
        App.setRoot("VerReservas");
    }
    @FXML
    private void irAVerHabitaciones() throws IOException{
        App.setRoot("VerHabitaciones");
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
     
     private void botonRegistrarReserva(){
         btnRegistrarReserva.setOnAction(event -> {
           try {
               irARegistrarReserva();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
     }
     
     private void botonVerReservas(){
         btnVerReservas.setOnAction((ActionEvent event) -> {
           try {
               irAVerReservas();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
     
     }
     
     private void botonVerHabitaciones(){
         btnVerHabitaciones.setOnAction((ActionEvent event) -> {
           try {
               irAVerHabitaciones();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
     
     }
     
     private void IniciarBotones(){
         botonRegresar();
         botonRegistrarReserva();
         botonVerReservas();
         botonVerHabitaciones();
    }
}
