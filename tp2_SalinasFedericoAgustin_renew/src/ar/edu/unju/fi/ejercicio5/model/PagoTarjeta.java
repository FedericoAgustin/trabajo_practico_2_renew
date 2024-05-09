package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoTarjeta implements IPago {

	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;

	public PagoTarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public double realizarPago(double monto) {
		return montoPagado -= (montoPagado * 15) / 100;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Número de la tarjeta: " + numeroTarjeta);
		System.out.println("Fecha de pago: " + fechaPago);
		System.out.println("Monto Pagado: " + montoPagado);
	}
}
