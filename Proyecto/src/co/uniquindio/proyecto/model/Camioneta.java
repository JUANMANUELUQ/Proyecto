package co.uniquindio.proyecto.model;

public class Camioneta extends CarroNoDeportivo {
	private Double capacidadMaletero;
	private boolean tieneVelocidadCrucero;
	private boolean tieneSensorColison;
	private boolean tieneSensorTraficoCruzado;
	private boolean tieneAsistentePermanenciaCarril;
	private boolean es4x4;
	
	/**
	 * Metodo constructor
	 */
	public Camioneta() {
		
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
	 * @param tieneVelocidadCrucero
	 * @param tieneSensorColison
	 * @param tieneSensorTraficoCruzado
	 * @param tieneAsistentePermanenciaCarril
	 * @param es4x4
	 */
	public Camioneta(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto, Integer numeroPasajeros,
			Integer numeroPuertas, Integer numeroBolsasAire, boolean tieneAireAcondicionado, boolean tieneCamaraReversa,
			boolean tieneABS, Double capacidadMaletero, boolean tieneVelocidadCrucero, boolean tieneSensorColison,
			boolean tieneSensorTraficoCruzado, boolean tieneAsistentePermanenciaCarril, boolean es4x4) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, numeroPasajeros, numeroPuertas,
				numeroBolsasAire, tieneAireAcondicionado, tieneCamaraReversa, tieneABS);
		this.capacidadMaletero = capacidadMaletero;
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
		this.tieneSensorColison = tieneSensorColison;
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
		this.es4x4 = es4x4;
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
	public boolean isTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

	/**
	 * 
	 * @param tieneVelocidadCrucero
	 */
	public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneSensorColison() {
		return tieneSensorColison;
	}

	/**
	 * 
	 * @param tieneSensorColison
	 */
	public void setTieneSensorColison(boolean tieneSensorColison) {
		this.tieneSensorColison = tieneSensorColison;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneSensorTraficoCruzado() {
		return tieneSensorTraficoCruzado;
	}

	/**
	 * 
	 * @param tieneSensorTraficoCruzado
	 */
	public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTieneAsistentePermanenciaCarril() {
		return tieneAsistentePermanenciaCarril;
	}

	/**
	 * 
	 * @param tieneAsistentePermanenciaCarril
	 */
	public void setTieneAsistentePermanenciaCarril(boolean tieneAsistentePermanenciaCarril) {
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEs4x4() {
		return es4x4;
	}

	/**
	 * 
	 * @param es4x4
	 */
	public void setEs4x4(boolean es4x4) {
		this.es4x4 = es4x4;
	}
	
}	
