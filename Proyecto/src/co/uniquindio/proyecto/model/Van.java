package co.uniquindio.proyecto.model;

public class Van extends CarroNoDeportivo {
	
	private Double capacidadMaletero;
	
	public Van(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, Object foto, Integer numeroPasajeros, Integer numeroPuertas,
			Integer numeroBolsasAire, boolean tieneAireAcondicionado, boolean tieneCamaraReversa, boolean tieneABS,
			Double capacidadMaletero) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, numeroPasajeros, numeroPuertas,
				numeroBolsasAire, tieneAireAcondicionado, tieneCamaraReversa, tieneABS);
		this.capacidadMaletero = capacidadMaletero;
	}

	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
