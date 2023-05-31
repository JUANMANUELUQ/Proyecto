package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase Moto representa una motocicleta en el sistema.
 * Hereda los atributos y métodos de la clase Vehiculo.
 */
public class Moto extends Vehiculo{
	        
    /**
     * Constructor por defecto de la clase Moto.
     */
	public Moto() {
		
	}
	
    /**
     * Constructor de la clase Moto.
     * 
     * @param marca la marca de la moto
     * @param nuevo indica si la moto es nueva
     * @param modelo el modelo de la moto
     * @param cambios el número de cambios de la moto
     * @param velocidadMaxima la velocidad máxima de la moto
     * @param cilindraje el cilindraje de la moto
     * @param autonomiaCargaCompleta la autonomía de la moto con la carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga de la moto
     * @param esEnchufable indica si la moto es enchufable
     * @param esHibridoLigero indica si la moto es híbrido ligero
     * @param tieneRevisionTecnica indica si la moto tiene revisión técnica
     * @param foto la foto de la moto
     */
	public Moto(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor){
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga, esEnchufable, 
		esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

}
