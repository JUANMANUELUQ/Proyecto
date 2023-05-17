package co.uniquindio.proyecto.model;

public class Deportivo extends Carro {
	
	private Integer numeroCaballosFuerza;
	private Integer tiempoAlcanza100Kmh;
	
	public Deportivo() {
		
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
	public Deportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto);
	}

	public Integer getNumeroCaballosFuerza() {
		return numeroCaballosFuerza;
	}

	public void setNumeroCaballosFuerza(Integer numeroCaballosFuerza) {
		this.numeroCaballosFuerza = numeroCaballosFuerza;
	}

	public Integer getTiempoAlcanza100Kmh() {
		return tiempoAlcanza100Kmh;
	}

	public void setTiempoAlcanza100Kmh(Integer tiempoAlcanza100Kmh) {
		this.tiempoAlcanza100Kmh = tiempoAlcanza100Kmh;
	}

}
