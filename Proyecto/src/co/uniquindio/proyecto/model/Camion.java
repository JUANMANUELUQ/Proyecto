package co.uniquindio.proyecto.model;

public class Camion extends Vehiculo {
	
	private Double capacidadCarga;
	private boolean tieneABS;
	private Integer numeroEjes;
	private boolean tieneFrenosAire;
	private String tipoCamion;
	
	/**
	 * Metodo constructor
	 */
	public Camion() {
				
	}

	/**
	 * 
	 * @param marca
	 * @param nuevo
	 * @param modelo
	 * @param cambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param autonomiaCargaCompleta
	 * @param tiempoPromedioCarga
	 * @param esEnchufable
	 * @param esHibridoLigero
	 * @param tieneRevisionTecnica
	 * @param foto
	 */
	public Camion(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
	}

	/**
	 * 
	 * @return
	 */
	public Double getCapacidadCarga() {
		return capacidadCarga;
	}

	/**
	 * 
	 * @param capacidadCarga
	 */
	public void setCapacidadCarga(Double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneABS() {
		return tieneABS;
	}

	/**
	 * 
	 * @param tieneABS
	 */
	public void setTieneABS(boolean tieneABS) {
		this.tieneABS = tieneABS;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getNumeroEjes() {
		return numeroEjes;
	}

	/**
	 * 
	 * @param numeroEjes
	 */
	public void setNumeroEjes(Integer numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneFrenosAire() {
		return tieneFrenosAire;
	}

	/**
	 * 
	 * @param tieneFrenosAire
	 */
	public void setTieneFrenosAire(boolean tieneFrenosAire) {
		this.tieneFrenosAire = tieneFrenosAire;
	}

	/**
	 * 
	 * @return
	 */
	public String getTipoCamion() {
		return tipoCamion;
	}

	/**
	 * 
	 * @param tipoCamion
	 */
	public void setTipoCamion(String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}
	
}
