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
public class CReserva {
        public void AgregarReserva(TextField codUnico, TextField horaCheckin, TextField horaCheckout, DatePicker fechaInicio, DatePicker fechaFin, TextField cedHuesped, TextField nroHab){
        CConexion obtejoCConexion = new CConexion();
        String consulta = "inset into reserva(codigoUnico, horaCheckin, horaCheckout, fechaInicio, fechaFin, cedHuesped, nroHabitacion) values(?,?,?,?,?,?,?);";
        try (CallableStatement cs = obtejoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setInt(1, Integer.parseInt(codUnico.getText()));
            cs.setString(2, horaCheckin.getText());
            cs.setString(3, horaCheckout.getText());
            
            LocalDate fechaI = fechaInicio.getValue();
            Date fechaIni = Date.valueOf(fechaI);
            cs.setDate(4, fechaIni);
            
            LocalDate fechaFinal = fechaFin.getValue();
            Date fechaF = Date.valueOf(fechaFinal);
            cs.setDate(5, fechaF);
            
            cs.setString(6, cedHuesped.getText());
            cs.setInt(7, Integer.parseInt(nroHab.getText()));
            
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
