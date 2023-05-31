package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase Van representa un carro tipo van en el sistema.
 * Hereda los atributos y métodos de la clase CarroNoDeportivo.
 */
public class Van extends CarroNoDeportivo {
	
	private Double capacidadMaletero;
	
    /**
     * Constructor por defecto de la clase Van.
     */
	public Van() {
		
	}
	
    /**
     * Constructor de la clase Van.
     *
     * @param marca la marca de la Van
     * @param nuevo indica si la Van es nueva
     * @param modelo el modelo de la Van
     * @param cambios el número de cambios de la Van
     * @param velocidadMaxima la velocidad máxima de la Van
     * @param cilindraje el cilindraje de la Van
     * @param autonomiaCargaCompleta la autonomía de la Van con carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga de la Van
     * @param esEnchufable indica si la Van es enchufable
     * @param esHibridoLigero indica si la Van es híbrida ligera
     * @param tieneRevisionTecnica indica si la Van tiene revisión técnica
     * @param foto la ruta de la foto de la Van
     */
	public Van(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

    /**
     * Obtiene la capacidad del maletero de la Van.
     * @return la capacidad del maletero de la Van
     */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

    /**
     * Establece la capacidad del maletero de la Van.
     * @param capacidadMaletero la capacidad del maletero de la Van
     */
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
