package Proyectito;


import Proyectito.EstadoHab;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gasaesco
 */
public class Habitacion {
    private int nroHabitacion;
    private int cantCamas;
    private TipoHab tipoHabitacion;
    private EstadoHab estado;

    public Habitacion(int nroHabitacion, int cantCamas, TipoHab tipoHabitacion, EstadoHab estado) {
        this.nroHabitacion = nroHabitacion;
        this.cantCamas = cantCamas;
        this.tipoHabitacion = tipoHabitacion;
        this.estado = estado;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public TipoHab getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHab tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public EstadoHab getEstado() {
        return estado;
    }

    public void setEstado(EstadoHab estado) {
        this.estado = estado;
    }
    
    
    
}
