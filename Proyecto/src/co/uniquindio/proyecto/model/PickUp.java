package co.uniquindio.proyecto.model;

public class PickUp extends CarroNoDeportivo {
	
	private boolean es4x4;
	private Double capacidadCajaCarga;
	
	public PickUp() {
		
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
	public PickUp(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
	}

	public boolean isEs4x4() {
		return es4x4;
	}
	
	public void setEs4x4(boolean es4x4) {
		this.es4x4 = es4x4;
	}
	
	public Double getCapacidadCajaCarga() {
		return capacidadCajaCarga;
	}
	
	public void setCapacidadCajaCarga(Double capacidadCajaCarga) {
		this.capacidadCajaCarga = capacidadCajaCarga;
	}
	
}
