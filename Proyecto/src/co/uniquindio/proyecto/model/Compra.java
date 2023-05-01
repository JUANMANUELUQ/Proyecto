package co.uniquindio.proyecto.model;

import java.time.LocalDate;

public class Compra extends Transaccion{
	
	public Compra(){
		
	}

	public Compra(LocalDate fecha, Double valor, Empleado empleado, Cliente cliente) {
		super(valor, empleado, cliente);
	}
	
}
