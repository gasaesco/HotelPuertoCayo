/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gasaesco
 */
public class Empleado extends Usuario{
    private String cargo;
    private TipoEmpleado tipoEmpleado;
    private double salario;
    private String cedJefe;

    public Empleado(String cargo, TipoEmpleado tipoEmpleado, double salario, String cedJefe, String cedula, String nombre, String apellido, String correo, String telefono) {
        super(cedula, nombre, apellido, correo, telefono);
        this.cargo = cargo;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
        this.cedJefe = cedJefe;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCedJefe() {
        return cedJefe;
    }

    public void setCedJefe(String cedJefe) {
        this.cedJefe = cedJefe;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Sobreescribir el método de la clase padre
    
}
