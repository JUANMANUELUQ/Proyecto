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
	public CarroNoDeportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
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
