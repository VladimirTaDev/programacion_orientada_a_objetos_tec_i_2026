package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {
	public static int cantidadCuentas = 0;
	private int numero;
	private String cliente;
	private double saldo;
	private LocalDateTime fechaCreacion;
	
	public Cuenta(String nombre) {
        this(nombre, 0.0);
    }
	public Cuenta(String nombre, double saldo) {
		this.cliente = nombre;
		this.saldo = saldo;
		
		this.fechaCreacion = LocalDateTime.now();
		Cuenta.cantidadCuentas ++;
		this.numero = Cuenta.cantidadCuentas;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void depositar(double monto) throws Exception {
		if (monto <= 0) {
			throw new Exception("El monto a depositar debe ser positivo.");
		}
		this.setSaldo(
				this.getSaldo() + monto);
	}
	public void retirar(double monto) throws Exception {
		if (monto <= 0) {
			throw new Exception("El monto a retirar debe ser positivo.");
		}
		this.setSaldo(
				this.getSaldo() - monto);
	}
	
	public String toString() {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String fecha = fechaCreacion.format(fmt);
	return "Cuenta número: " + numero + "\nCliente: " + cliente 
		+ "\nSaldo: " + saldo + "\nFecha creación: " + fecha;
}
}
