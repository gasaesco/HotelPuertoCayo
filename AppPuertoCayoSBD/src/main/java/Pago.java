/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gasaesco
 */
public class Pago {
    private double valorMascota;
    private Reserva reserva;
    private double subtotal;
    private MetodoPago metodoPego;
    private Huesped huesped;

    public Pago(double valorMascota, Reserva reserva, double subtotal, MetodoPago metodoPego, Huesped huesped) {
        this.valorMascota = valorMascota;
        this.reserva = reserva;
        this.subtotal = subtotal;
        this.metodoPego = metodoPego;
        this.huesped = huesped;
    }

    public double getValorMascota() {
        return valorMascota;
    }

    public void setValorMascota(double valorMascota) {
        this.valorMascota = valorMascota;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public MetodoPago getMetodoPego() {
        return metodoPego;
    }

    public void setMetodoPego(MetodoPago metodoPego) {
        this.metodoPego = metodoPego;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    
    
}
