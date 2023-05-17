package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

public class Compra extends Transaccion{
	
	public Compra(){
		
	}

	public Compra(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
	}

	
	
}
