/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

/**
 *
 * @author marsa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consultas {

    private static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/puertoCayoSBD";
        String usuario = "root";
        String contraseña = "salvatore";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
     // se realizan consultas 
    // Consulta 1: Total cobrado por tipo de habitación
    public static void consulta1() {
        String query = "SELECT h.tipoHabitacion, "
                + "SUM(DATEDIFF(r.fechaFin, r.fechaInicio) * h.precioxHuespeHabi) AS totalCobrado "
                + "FROM reserva r "
                + "JOIN habitacion h ON r.nroHabitacion = h.nroHabitacion "
                + "GROUP BY h.tipoHabitacion";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Cobro por tipo de habitación:");
            while (rs.next()) {
                String tipoHabitacion = rs.getString("tipoHabitacion");
                double totalCobrado = rs.getDouble("totalCobrado");
                System.out.println("Tipo de Habitación: " + tipoHabitacion);
                System.out.println("Total Cobrado: " + totalCobrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     //
    // Consulta 2: Huéspedes que reservaron en julio
    public static void consulta2() {
        String query = "SELECT h.nombres, h.apellidos, r.fechaInicio, r.fechaFin, r.nroHabitacion "
                + "FROM reserva r "
                + "JOIN huesped h ON r.cedHuesped = h.cedHuesped "
                + "WHERE r.fechaInicio BETWEEN '2024-07-01' AND '2024-07-31' "
                + "AND r.fechaFin BETWEEN '2024-07-01' AND '2024-07-31'";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nHuéspedes que reservaron en julio:");
            while (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String fechaInicio = rs.getString("fechaInicio");
                String fechaFin = rs.getString("fechaFin");
                int nroHabitacion = rs.getInt("nroHabitacion");
                System.out.println("Nombres: " + nombres);
                System.out.println("Apellidos: " + apellidos);
                System.out.println("Fecha Inicio: " + fechaInicio);
                System.out.println("Fecha Fin: " + fechaFin);
                System.out.println("Número de Habitación: " + nroHabitacion);
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Consulta 3: Habitación con más huéspedes
    public static void consulta3() {
        String query = "SELECT nroHabitacion, COUNT(cedHuesped) AS numHuespedes "
                + "FROM reserva "
                + "GROUP BY nroHabitacion "
                + "HAVING COUNT(cedHuesped) > 1";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nHabitación con más huéspedes:");
            while (rs.next()) {
                int nroHabitacion = rs.getInt("nroHabitacion");
                int numHuespedes = rs.getInt("numHuespedes");
                System.out.println("Número de Habitación: " + nroHabitacion);
                System.out.println("Número de Huéspedes: " + numHuespedes);
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Consulta 4: Producto de limpieza con el menor stock junto a su proveedor
    public static void consulta4() {
        String query = "SELECT p.nombreProducto, p.stock, prov.nombre AS proveedor "
                + "FROM inventarioProducto p "
                + "JOIN proveedor prov ON p.idProveedor = prov.idProveedor "
                + "WHERE p.tipoInventario = 'LIMPIEZA' "
                + "ORDER BY p.stock ASC "
                + "LIMIT 1";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nProducto de limpieza con el menor stock:");
            if (rs.next()) {
                String nombreProducto = rs.getString("nombreProducto");
                int stock = rs.getInt("stock");
                String proveedor = rs.getString("proveedor");
                System.out.println("Nombre del Producto: " + nombreProducto);
                System.out.println("Stock: " + stock);
                System.out.println("Proveedor: " + proveedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
