package co.uniquindio.proyecto.model;

import java.time.LocalDate;

public class Alquiler extends Transaccion{
	
	private Integer diasAlquiler;
	
	/**
	 * Metodo constructor
	 */
	public Alquiler() {
		
	}

	/**
	 * Metodo constructor
	 * @param fecha
	 * @param valor
	 * @param empleado
	 * @param cliente
	 * @param diasAlquiler
	 */
	public Alquiler(LocalDate fecha, Double valor, Empleado empleado, Cliente cliente, Integer diasAlquiler) {
		super(valor, empleado, cliente);
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
