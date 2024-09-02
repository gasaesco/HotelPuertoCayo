/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import Proyectito.Empleado;
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
public class InicioEmpleadoController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button manager;

    @FXML
    private Button temporal;

    @FXML
    private Button permanente;

    @FXML
    private Button administrador;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        back.setOnAction(event -> {
           try {
               regresar();
           } catch (IOException ex) {
               Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
        IniciarBotones();
        
    }    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("PrincipalitoFXML");
    }
    @FXML
private void irAPrincipalito() throws IOException {
    App.setRoot("PrincipalitoFXML");
}

@FXML
private void irAManager() throws IOException {
    App.setRoot("InicioManager");
}

@FXML
private void irATemporal() throws IOException {
    App.setRoot("InicioTemporal");
}

@FXML
private void irAPermanente() throws IOException {
    App.setRoot("InicioPermanente");
}

@FXML
private void irAAdministrador() throws IOException {
    App.setRoot("InicioAdministrador");
}

private void IniciarBotones(){
    manager.setOnAction(event -> {
    try {
        irAManager();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
temporal.setOnAction(event -> {
    try {
        irATemporal();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
permanente.setOnAction(event -> {
    try {
        irAPermanente();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
administrador.setOnAction(event -> {
    try {
        irAAdministrador();
    } catch (IOException ex) {
        Logger.getLogger(PrincipalitoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
});

}
    
    
    
    
}
