package co.uniquindio.proyecto.model;

public class Deportivo extends Carro {
	
	private Integer numeroCaballosFuerza;
	private Integer tiempoAlcanza100Kmh;
	
	public Deportivo() {
		
	}

	public Deportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto, Integer numeroPasajeros,
			Integer numeroPuertas, Integer numeroBolsasAire, Integer numeroCaballosFuerza,
			Integer tiempoAlcanza100Kmh) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, numeroPasajeros, numeroPuertas,
				numeroBolsasAire);
		this.numeroCaballosFuerza = numeroCaballosFuerza;
		this.tiempoAlcanza100Kmh = tiempoAlcanza100Kmh;
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
