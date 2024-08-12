/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gs.apppuertocayosbd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author crisp
 */
public class DatosHuespedController implements Initializable {
    
    @FXML
    private TextField txtCedHuesped;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCorreo;
   @FXML
   private TableView<Object[]> tbHuesped;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Proyectito.CHuesped objetoHuesped= new Proyectito.CHuesped();
        objetoHuesped.MostrarHuesped(tbHuesped);
        txtCedHuesped.setDisable(true);
    }    
    
    
    @FXML
    
    private void guardarHuesped(ActionEvent event){
        Proyectito.CHuesped objetoHuesped= new Proyectito.CHuesped();
        objetoHuesped.agregarHuesped(txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);
        tbHuesped.getColumns().clear();
        tbHuesped.getItems().clear();
        objetoHuesped.MostrarHuesped(tbHuesped);
        objetoHuesped.limpiarCampos(txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);
    }
    
    @FXML
    private void seleccionaHuesped (MouseEvent event){
        Proyectito.CHuesped objetoUsuarios = new Proyectito.CHuesped();
        objetoUsuarios.SeleccionarHuesped(tbHuesped, txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);

    }
    
    @FXML
    private void modificarHuesped(ActionEvent event){
        Proyectito.CHuesped objetoHuesped = new Proyectito.CHuesped();
        objetoHuesped.ModificarHuesped(txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);
        tbHuesped.getColumns().clear();
        tbHuesped.getItems().clear();
        objetoHuesped.MostrarHuesped(tbHuesped);
        objetoHuesped.limpiarCampos(txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);
    }

    @FXML
    private void eliminarHuesped(ActionEvent event){

    Proyectito.CHuesped objetoHuesped = new Proyectito.CHuesped();
    objetoHuesped.EliminarHuesped(txtCedHuesped);
    tbHuesped.getColumns().clear();
    tbHuesped.getItems().clear();
    objetoHuesped.MostrarHuesped(tbHuesped);
    objetoHuesped.limpiarCampos(txtCedHuesped, txtNombres, txtApellidos, txtNacionalidad, txtTelefono, txtCorreo);
    }
    
    
}
