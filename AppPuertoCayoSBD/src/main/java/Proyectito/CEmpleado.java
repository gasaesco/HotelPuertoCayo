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
public class CEmpleado {
    public void agregarEmpleado(TextField campoCed, TextField campoNombres, TextField campoApellidos, TextField campoTelf, TextField campoCorreo, TextField campoSueldo,TextField campoJefe){
        CConexion objetoCConexion= new CConexion();
        String consulta= "insert into empleado(campoCed,campoNombres,campoApellidos, campoTelf,campoCorreo,campoSueldo,campoJefe) values (?,?,?,?,?,?,?);";
        try(CallableStatement cs= objetoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setString(1, campoCed.getText());
            cs.setString(2, campoNombres.getText());
            cs.setString(3, campoApellidos.getText());
            cs.setString(4, campoTelf.getText());
            cs.setString(5, campoCorreo.getText());
            cs.setString(6, campoSueldo.getText());
            cs.setString(7, campoJefe.getText());
            
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
