/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

import java.sql.CallableStatement;
import java.sql.Date;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author gasaesco
 */
public class CInventarioProducto {
    public void AgregsrInventarioProducto(TextField nombreProducto, TextField precio, TextField tipoInventario, TextField stock, DatePicker fechaInventario, TextField cedEmpleado, TextField idProveedor){
        CConexion obtejoCConexion = new CConexion();
        String consulta = "inset into inventarioProducto(idInventario, nombreProducto, precio, tipoInventario, stock, fechaInventario, cedEmpleado, idProveedor) values(?,?,?,?);";
        try (CallableStatement cs = obtejoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setInt(1, 0);
            cs.setString(2, nombreProducto.getText());
            cs.setDouble(3, Double.parseDouble(precio.getText()));
            cs.setString(4, tipoInventario.getText());
            cs.setInt(5, Integer.parseInt(stock.getText()));
            
            LocalDate fechaInv = fechaInventario.getValue();
            Date fechaInvent = Date.valueOf(fechaInv);
            cs.setDate(6, fechaInvent);
            
            cs.setInt(7, Integer.parseInt(idProveedor.getText()));
            
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
