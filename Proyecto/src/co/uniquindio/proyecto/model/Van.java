package co.uniquindio.proyecto.model;

public class Van extends CarroNoDeportivo {
	
	private Double capacidadMaletero;
	
	public Van() {
		
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
	public Van(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
	}

	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
