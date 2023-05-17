package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.List;

public class Alquiler extends Transaccion{
	
	private Integer diasAlquiler;
	
	/**
	 * Metodo constructor
	 */
	public Alquiler() {
		
	}

	/**
	 * 
	 * @param valor
	 * @param empleado
	 * @param cliente
	 * @param fecha
	 * @param listaDetalleTransacciones
	 * @param diasAlquiler
	 */
	public Alquiler(Double valor, Empleado empleado, Cliente cliente, LocalDate fecha,
			List<DetalleTransaccion> listaDetalleTransacciones, Integer diasAlquiler) {
		super(valor, empleado, cliente, fecha, listaDetalleTransacciones);
		this.diasAlquiler = diasAlquiler;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getDiasAlquiler() {
		return diasAlquiler;
	}

	/**
	 * 
	 * @param diasAlquiler
	 */
	public void setDiasAlquiler(Integer diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

}
