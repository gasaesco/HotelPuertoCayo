/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gasaesco
 */
public class Huesped extends Usuario{
    private String nacionalidad;

    public Huesped(String nacionalidad, String cedula, String nombre, String apellido, String correo, String telefono) {
        super(cedula, nombre, apellido, correo, telefono);
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    // Sobreescribir el método de la clase padre
}
