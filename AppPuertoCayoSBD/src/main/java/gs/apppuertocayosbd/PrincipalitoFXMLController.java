/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Proyectito.CConexion objetoConexion= new Proyectito.CConexion();
       objetoConexion.estableceConexion();
       btnHuesped.setOnAction(event -> irADatosHuesped());
    }    
    
    private void irADatosHuesped() {
        try {
            // Cambia la escena a DatosHuesped
            App.setRoot("DatosHuesped");
            showAlert("Informacion", "Se cargo con exito la ventana DatosHuesped");
        } catch (IOException e) {
            // Manejo de excepciones
            showAlert("Informacion", "o se pudo cargar la ventana de DatosHuesped: "+ e.toString());
        }
    }
    
    private void showAlert(String title, String content){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }    
    
    
}    
    

