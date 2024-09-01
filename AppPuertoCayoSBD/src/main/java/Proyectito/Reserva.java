package Proyectito;


import Proyectito.Huesped;
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
public class Reserva {
    private String cedula;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int habitacion;

    public Reserva(String cedula, LocalDate fechaInicio, LocalDate fechaFin, int habitacion) {
        this.cedula = cedula;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
    }

    public String getCedula() {
        return cedula;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getHabitacion() {
        return habitacion;
    }
    
    
}
