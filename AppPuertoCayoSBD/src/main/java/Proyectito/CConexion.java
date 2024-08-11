/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author crisp
 */
public class CConexion {
    Connection conectar = null;
    String usuario = "admincayo";
    String contraseña = "HPC_118server";
    String bd = "personal";
    String ip = "serverhpc.mysql.database.azure.com";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            showAlert("Mensaje", "Se conectó a la base de datos");
        }catch(Exception e){
            showAlert("Mensaje", "No se conectó a la base de datos, error:"+e.toString());
            e.printStackTrace();
        }
        return conectar;
    }
    
    private void showAlert(String title, String content){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public void cerrarConexion(){
        try{
            if (conectar!= null && !conectar.isClosed()){
                conectar.close();
                showAlert("Mensaje", "Conexion cerrada");
            }
            
        }
        
        catch(Exception e){
            showAlert("Mensaje", "Error al cerrar");
        }
    }
}    