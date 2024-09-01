/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author crisp
 */
public class Usuario {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String telefono;

    public Usuario(String cedula, String nombre, String apellido, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
    

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
  
        
    private void showAlert(String title, String content){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }        
    
}