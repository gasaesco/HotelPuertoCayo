/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sebas
 */
public class AzureConexion {
    private static final String URL = "jdbc:sqlserver://puertocayo.database.windows.net:1433;database=hotelpuertocayodb;"
                + "user=administrador@puertocayo;"
                + "password={Pxndx_24};encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";
    
    public static Connection getConnection() throws SQLException {
        System.out.print("Base de datos conectada!");
        return DriverManager.getConnection(URL);
    }
    
}
