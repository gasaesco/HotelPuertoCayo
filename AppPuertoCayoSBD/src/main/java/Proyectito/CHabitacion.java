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
 * @author gasaesco
 */
public class CHabitacion {
    public void AgregarHabitacion(TextField nroHab, TextField cantCamas, TextField precioXHab, TextField estado){
        CConexion obtejoCConexion = new CConexion();
        String consulta = "inset into habitacion(nroHabitacion, cantCamas, tipoHabitacion, estado) values(?,?,?,?);";
        try (CallableStatement cs = obtejoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setInt(1, Integer.parseInt(nroHab.getText()));
            cs.setInt(2, Integer.parseInt(cantCamas.getText()));
            cs.setDouble(3, Double.parseDouble(precioXHab.getText()));
            cs.setString(4, estado.getText());
            showAlert("Informacion", "Se guardó correctamente");
            
        } catch (Exception e){
            showAlert("Informacion", "Error al guardar: "+ e.toString());
            
        } finally {
            obtejoCConexion.cerrarConexion();
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
