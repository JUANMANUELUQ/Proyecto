package co.uniquindio.proyecto.model;

public abstract class CarroNoDeportivo extends Carro {
	
	private boolean tieneAireAcondicionado;
	private boolean tieneCamaraReversa;
	private boolean tieneABS;
	
	/**
	 * Metodo constructor
	 */
	public CarroNoDeportivo(){
		
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
	 */
	public CarroNoDeportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto, Integer numeroPasajeros,
			Integer numeroPuertas, Integer numeroBolsasAire, boolean tieneAireAcondicionado, boolean tieneCamaraReversa,
			boolean tieneABS) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, numeroPasajeros, numeroPuertas,
				numeroBolsasAire);
		this.tieneAireAcondicionado = tieneAireAcondicionado;
		this.tieneCamaraReversa = tieneCamaraReversa;
		this.tieneABS = tieneABS;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneAireAcondicionado() {
		return tieneAireAcondicionado;
	}

	/**
	 * 
	 * @param tieneAireAcondicionado
	 */
	public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneCamaraReversa() {
		return tieneCamaraReversa;
	}

	/**
	 * 
	 * @param tieneCamaraReversa
	 */
	public void setTieneCamaraReversa(boolean tieneCamaraReversa) {
		this.tieneCamaraReversa = tieneCamaraReversa;
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
	
}
