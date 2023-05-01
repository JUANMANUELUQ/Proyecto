package co.uniquindio.proyecto.model;

public class Sedan extends CarroNoDeportivo {
	
	private Double capacidadMaletero;
	private boolean tieneVelocidadCrucero;
	private boolean tieneSensoresColision;
	private boolean tieneSensorTraficoCruzado;
	private boolean tieneAsistentePermanenciaCarril;
	
	public Sedan() {
		
	}
	
	public Sedan(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, Object foto, Integer numeroPasajeros, Integer numeroPuertas,
			Integer numeroBolsasAire, boolean tieneAireAcondicionado, boolean tieneCamaraReversa, boolean tieneABS,
			Double capacidadMaletero, boolean tieneVelocidadCrucero, boolean tieneSensoresColision,
			boolean tieneSensorTraficoCruzado, boolean tieneAsistentePermanenciaCarril) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, numeroPasajeros, numeroPuertas,
				numeroBolsasAire, tieneAireAcondicionado, tieneCamaraReversa, tieneABS);
		this.capacidadMaletero = capacidadMaletero;
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
		this.tieneSensoresColision = tieneSensoresColision;
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
	}

	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	public boolean isTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

	public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

	public boolean isTieneSensoresColision() {
		return tieneSensoresColision;
	}

	public void setTieneSensoresColision(boolean tieneSensoresColision) {
		this.tieneSensoresColision = tieneSensoresColision;
	}

	public boolean isTieneSensorTraficoCruzado() {
		return tieneSensorTraficoCruzado;
	}

	public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
	}

	public boolean isTieneAsistentePermanenciaCarril() {
		return tieneAsistentePermanenciaCarril;
	}

	public void setTieneAsistentePermanenciaCarril(boolean tieneAsistentePermanenciaCarril) {
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
	}

}
