package co.uniquindio.proyecto.model;

import java.time.LocalDate;

public class Venta extends Transaccion {
	
	public Venta(LocalDate fecha, Double valor, Empleado empleado, Cliente cliente) {
		super(valor, empleado, cliente);
	}
	
	public Venta() {
		
	}

}
