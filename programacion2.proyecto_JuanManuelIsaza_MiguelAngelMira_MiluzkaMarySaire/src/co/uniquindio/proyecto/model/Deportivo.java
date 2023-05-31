package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase Deportivo representa un caroo deportivo en el sistema.
 * Hereda los atributos y métodos de la clase Carro.
 */
public class Deportivo extends Carro {
	private Integer numeroCaballosFuerza;
	private Integer tiempoAlcanza100Kmh;
	
    /**
     * Constructor por defecto de la clase Deportivo.
     */
	public Deportivo() {
		
	}

    /**
     * Constructor de la clase Deportivo.
     * 
     * @param marca la marca del carro
     * @param nuevo indica si el carro es nuevo
     * @param modelo el modelo del carro
     * @param cambios el número de cambios del carro
     * @param velocidadMaxima la velocidad máxima del carro
     * @param cilindraje el cilindraje del carro
     * @param autonomiaCargaCompleta la autonomía del carro con la carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga del carro
     * @param esEnchufable indica si el carro es enchufable
     * @param esHibridoLigero indica si el carro es híbrido ligero
     * @param tieneRevisionTecnica indica si el carro tiene revisión técnica
     * @param foto la foto del carro
     */
	public Deportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}


    /**
     * Obtiene el número de caballos de fuerza del carro deportivo.
     * @return el número de caballos de fuerza del carro
     */
	public Integer getNumeroCaballosFuerza() {
		return numeroCaballosFuerza;
	}

    /**
     * Establece el número de caballos de fuerza del carro deportivo.
     * @param numeroCaballosFuerza el número de caballos de fuerza del carro
     */
	public void setNumeroCaballosFuerza(Integer numeroCaballosFuerza) {
		this.numeroCaballosFuerza = numeroCaballosFuerza;
	}

    /**
     * Obtiene el tiempo en alcanzar los 100 km/h del carro deportivo.
     * @return el tiempo en alcanzar los 100 km/h del carro
     */
	public Integer getTiempoAlcanza100Kmh() {
		return tiempoAlcanza100Kmh;
	}

    /**
     * Establece el tiempo en alcanzar los 100 km/h del carro deportivo.
     * @param tiempoAlcanza100Kmh el tiempo en alcanzar los 100 km/h del carro
     */
	public void setTiempoAlcanza100Kmh(Integer tiempoAlcanza100Kmh) {
		this.tiempoAlcanza100Kmh = tiempoAlcanza100Kmh;
	}

}
