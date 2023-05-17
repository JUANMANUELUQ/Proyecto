package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

public class Venta extends Transaccion {
	
	public Venta() {
		
	}

	public Venta(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
	}
	
	

}
