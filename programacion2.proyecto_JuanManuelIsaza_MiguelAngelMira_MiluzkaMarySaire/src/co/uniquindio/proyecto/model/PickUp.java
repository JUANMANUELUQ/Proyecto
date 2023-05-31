package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase PickUp representa un carro PickUp en el sistema.
 * Hereda los atributos y métodos de la clase CarroNoDeportivo.
 */
public class PickUp extends CarroNoDeportivo {
	private boolean es4x4;
	private Double capacidadCajaCarga;
	
    /**
     * Constructor por defecto de la clase PickUp.
     */
	public PickUp() {
		
	}
	
    /**
     * Constructor de la clase PickUp.
     * 
     * @param marca la marca de la camioneta PickUp
     * @param nuevo indica si la camioneta PickUp es nueva
     * @param modelo el modelo de la camioneta PickUp
     * @param cambios el número de cambios de la camioneta PickUp
     * @param velocidadMaxima la velocidad máxima de la camioneta PickUp
     * @param cilindraje el cilindraje de la camioneta PickUp
     * @param autonomiaCargaCompleta la autonomía de carga completa de la camioneta PickUp
     * @param tiempoPromedioCarga el tiempo promedio de carga de la camioneta PickUp
     * @param esEnchufable indica si la camioneta PickUp es enchufable
     * @param esHibridoLigero indica si la camioneta PickUp es híbrido ligero
     * @param tieneRevisionTecnica indica si la camioneta PickUp tiene revisión técnica
     * @param foto la foto de la camioneta PickUp
     */
	public PickUp(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

    /**
     * Verifica si la camioneta PickUp es de tracción 4x4.
     * @return true si es 4x4, false de lo contrario
     */
	public boolean isEs4x4() {
		return es4x4;
	}
	
    /**
     * Establece si la camioneta PickUp es de tracción 4x4.
     * @param es4x4 true si es 4x4, false de lo contrario
     */
	public void setEs4x4(boolean es4x4) {
		this.es4x4 = es4x4;
	}
	
    /**
     * Obtiene la capacidad de carga de la caja de la camioneta PickUp.
     * @return la capacidad de carga de la caja de la camioneta PickUp
     */
	public Double getCapacidadCajaCarga() {
		return capacidadCajaCarga;
	}
	
    /**
     * Establece la capacidad de carga de la caja de la camioneta PickUp. 
     * @param capacidadCajaCarga la capacidad de carga de la caja de la camioneta PickUp
     */
	public void setCapacidadCajaCarga(Double capacidadCajaCarga) {
		this.capacidadCajaCarga = capacidadCajaCarga;
	}
	
}
