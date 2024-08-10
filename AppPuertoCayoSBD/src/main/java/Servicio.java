
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gasaesco
 */
public class Servicio {
    private LocalTime horaRealizacion;
    private LocalDate fecha;
    private TipoServicio tipoServicio;
    private Huesped huesped;
    private Empleado empleado;

    public Servicio(LocalTime horaRealizacion, LocalDate fecha, TipoServicio tipoServicio, Huesped huesped, Empleado empleado) {
        this.horaRealizacion = horaRealizacion;
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
        this.huesped = huesped;
        this.empleado = empleado;
    }

    public LocalTime getHoraRealizacion() {
        return horaRealizacion;
    }

    public void setHoraRealizacion(LocalTime horaRealizacion) {
        this.horaRealizacion = horaRealizacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
}
