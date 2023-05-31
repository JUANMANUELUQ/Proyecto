package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase abstracta carroNoDeportivo es una subclase de Carro.
 * Representa un tipo generico de carro no deportivo
 */
public abstract class CarroNoDeportivo extends Carro {
	
	private boolean tieneAireAcondicionado;
	private boolean tieneCamaraReversa;
	private boolean tieneABS;
	
	/**
	 * Metodo constructor
	 */
	public CarroNoDeportivo(){
		
	}
	
    /**
     * Constructor de la clase CarroNoDeportivo.
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
	public CarroNoDeportivo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}
		

	 /**
     * Verifica si el carro tiene aire acondicionado.
     * @return true si el carro tiene aire acondicionado, false de lo contrario
     */
	public boolean isTieneAireAcondicionado() {
		return tieneAireAcondicionado;
	}

    /**
     * Establece si el carro tiene aire acondicionado.
     * @param tieneAireAcondicionado true si el carro tiene aire acondicionado, false de lo contrario
     */
	public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
		this.tieneAireAcondicionado = tieneAireAcondicionado;
	}

    /**
     * Verifica si el carro tiene cámara de reversa.
     * @return true si el carro tiene cámara de reversa, false de lo contrario
     */
	public boolean isTieneCamaraReversa() {
		return tieneCamaraReversa;
	}

    /**
     * Establece si el carro tiene cámara de reversa.
     * @param tieneCamaraReversa true si el carro tiene cámara de reversa, false de lo contrario
     */
	public void setTieneCamaraReversa(boolean tieneCamaraReversa) {
		this.tieneCamaraReversa = tieneCamaraReversa;
	}

    /**
     * Verifica si el carro tiene sistema de frenos ABS.
     * @return true si el carro tiene sistema de frenos ABS, false de lo contrario
     */
	public boolean isTieneABS() {
		return tieneABS;
	}

    /**
     * Establece si el carro tiene sistema de frenos ABS.
     * @param tieneABS true si el carro tiene sistema de frenos ABS, false de lo contrario
     */
	public void setTieneABS(boolean tieneABS) {
		this.tieneABS = tieneABS;
	}
	
}
