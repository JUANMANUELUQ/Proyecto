package co.uniquindio.proyecto.model;

public class Bus extends CarroNoDeportivo{
	private Double capacidadMaletero;
	private Integer numeroEjes;
	private Integer numeroSalidasEmergencia;
	
	/**
	 * Metodo constructor
	 */
	public Bus() {
		
	}
	
	/**
	 * Metodo constructor
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
	 * @param numeroPasajeros
	 * @param numeroPuertas
	 * @param numeroBolsasAire
	 * @param tieneAireAcondicionado
	 * @param tieneCamaraReversa
	 * @param tieneABS
	 * @param capacidadMaletero
	 * @param numeroEjes
	 * @param numeroSalidasEmergencia
	 */
	public Bus(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
	}

	/**
	 * 
	 * @return
	 */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	/**
	 * 
	 * @param capacidadMaletero
	 */
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
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
	public Integer getNumeroSalidasEmergencia() {
		return numeroSalidasEmergencia;
	}

	/**
	 * 
	 * @param numeroSalidasEmergencia
	 */
	public void setNumeroSalidasEmergencia(Integer numeroSalidasEmergencia) {
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}
	
	
}
