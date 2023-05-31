package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa una transacción de venta realizada en un negocio.
 * Hereda de la clase Transaccion.
 */
public class Venta extends Transaccion {
	
    /**
     * Crea una instancia de la clase Venta.
     */
	public Venta() {
		
	}

    /**
     * Crea una instancia de la clase Venta con los parámetros especificados.
     *
     * @param valor el valor de la transacción de venta
     * @param empleado el empleado asociado a la venta
     * @param cliente el cliente asociado a la venta
     * @param fecha la fecha de la venta
     * @param listaDetalleTransacciones la lista de detalles de transacciones de la venta
     */
	public Venta(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
	}
	
	

}