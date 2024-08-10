
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
    private int codigoUnico;
    private LocalTime horaCheckin;
    private LocalTime hraCheckout;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Huesped huesped;

    public Reserva(int codigoUnico, LocalTime horaCheckin, LocalTime hraCheckout, LocalDate fechaInicio, LocalDate fechaFin, Huesped huesped) {
        this.codigoUnico = codigoUnico;
        this.horaCheckin = horaCheckin;
        this.hraCheckout = hraCheckout;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.huesped = huesped;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public LocalTime getHoraCheckin() {
        return horaCheckin;
    }

    public void setHoraCheckin(LocalTime horaCheckin) {
        this.horaCheckin = horaCheckin;
    }

    public LocalTime getHraCheckout() {
        return hraCheckout;
    }

    public void setHraCheckout(LocalTime hraCheckout) {
        this.hraCheckout = hraCheckout;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    
    
}
