/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

import java.sql.CallableStatement;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author crisp
 */
public class CHuesped {
    public void agregarHuesped(TextField cedHuesped, TextField nombres, TextField apellidos, TextField nacionalidad, TextField telefono, TextField correo){
        CConexion objetoCConexion= new CConexion();
        String consulta= "insert into huesped(cedHuesped, nombres, apellidos, nacionalidad, telefono, correo) values (?,?,?,?,?,?);";
        try(CallableStatement cs= objetoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setString(1, cedHuesped.getText());
            cs.setString(2, nombres.getText());
            cs.setString(3, apellidos.getText());
            cs.setString(4, nacionalidad.getText());
            cs.setString(5, telefono.getText());
            cs.setString(6, correo.getText());
            cs.execute();
            showAlert("Informacion", "Se guardó correctamente");
            
            
        }
        catch(Exception e){
            showAlert("Informacion", "Error al guardar: "+ e.toString());
            objetoCConexion.cerrarConexion();
        }
        finally{
            
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