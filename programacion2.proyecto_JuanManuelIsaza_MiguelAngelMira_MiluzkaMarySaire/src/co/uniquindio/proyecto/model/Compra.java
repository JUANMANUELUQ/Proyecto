package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase representa una transacción de compra que extiende la clase Transaccion.
 */
public class Compra extends Transaccion{
	
    /**
     * Constructor por defecto de la clase Compra.
     */
	public Compra(){
		
	}

    /**
     * Constructor de la clase Compra.
     * 
     * @param valor el valor de la compra
     * @param empleado el empleado que realizó la compra
     * @param cliente el cliente que realizó la compra
     * @param fecha la fecha de la compra
     * @param listaDetalleTransacciones la lista de detalles de transacción de la compra
     */
	public Compra(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
	}

	
	
}
