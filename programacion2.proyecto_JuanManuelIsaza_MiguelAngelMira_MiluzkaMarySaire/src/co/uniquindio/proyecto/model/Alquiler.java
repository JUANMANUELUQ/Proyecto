package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

/**
 * La clase Alquiler representa una transacción de alquiler en el sistema.
 * Hereda los atributos y métodos de la clase Transaccion.
 */
public class Alquiler extends Transaccion{
	
	private Integer diasAlquiler;
	
	/**
	 * Metodo constructor
	 */
	public Alquiler() {
		
	}

    /**
     * Constructor de la clase Alquiler.
     * Crea una instancia de Alquiler con los atributos especificados.
     * 
     * @param valor el valor de la transacción de alquiler
     * @param empleado el empleado asociado a la transacción
     * @param cliente el cliente asociado a la transacción
     * @param fecha la fecha de la transacción
     * @param listaDetalleTransacciones la lista de detalles de la transacción
     * @param diasAlquiler la cantidad de días del alquiler
     */
	public Alquiler(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones, Integer diasAlquiler) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
		this.diasAlquiler = diasAlquiler;
	}

    /**
     * Obtiene la cantidad de días del alquiler.
     * @return la cantidad de días del alquiler
     */
	public Integer getDiasAlquiler() {
		return diasAlquiler;
	}

    /**
     * Establece la cantidad de días del alquiler.
     * @param diasAlquiler la cantidad de días del alquiler
     */
	public void setDiasAlquiler(Integer diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

}