package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase Camioneta representa una camioneta en el sistema.
 * Hereda los atributos y métodos de la clase CarroNoDeportivo.
 */
public class Camioneta extends CarroNoDeportivo {
	private Double capacidadMaletero;
	private boolean tieneVelocidadCrucero;
	private boolean tieneSensorColision;
	private boolean tieneSensorTraficoCruzado;
	private boolean tieneAsistentePermanenciaCarril;
	private boolean es4x4;
	
	/**
	 * Metodo constructor
	 */
	public Camioneta() {
		
	}

    /**
     * Constructor de la clase Camioneta.
     * Crea una instancia de Camioneta con los atributos especificados.
     * 
     * @param marca la marca de la camioneta
     * @param nuevo indica si la camioneta es nueva
     * @param modelo el modelo de la camioneta
     * @param cambios el número de cambios de la camioneta
     * @param velocidadMaxima la velocidad máxima de la camioneta
     * @param cilindraje el cilindraje de la camioneta
     * @param autonomiaCargaCompleta la autonomía de la camioneta con carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga de la camioneta
     * @param esEnchufable indica si la camioneta es enchufable
     * @param esHibridoLigero indica si la camioneta es híbrida ligera
     * @param tieneRevisionTecnica indica si la camioneta tiene revisión técnica vigente
     * @param foto la foto de la camioneta
     */
	public Camioneta(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

	/**
     * Obtiene la capacidad del maletero de la camioneta.
     * @return la capacidad del maletero de la camioneta
     */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

    /**
     * Establece la capacidad del maletero de la camioneta.
     * @param capacidadMaletero la capacidad del maletero de la camioneta
     */
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

    /**
     * Verifica si la camioneta tiene velocidad crucero.    
     * @return true si la camioneta tiene velocidad crucero, false de lo contrario
     */
	public boolean isTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

    /**
     * Establece si la camioneta tiene velocidad crucero     
     * @param tieneVelocidadCrucero true si la camioneta tiene velocidad crucero, false de lo contrario
     */
	public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

    /**
     * Verifica si la camioneta tiene sensor de colisión.
     * @return true si la camioneta tiene sensor de colisión, false de lo contrario
     */
	public boolean isTieneSensorColision() {
		return tieneSensorColision;
	}

    /**
     * Establece si la camioneta tiene sensor de colisión.     
     * @param tieneSensorColison true si la camioneta tiene sensor de colisión, false de lo contrario
     */
	public void setTieneSensorColision(boolean tieneSensorColison) {
		this.tieneSensorColision = tieneSensorColison;
	}

    /**
     * Verifica si la camioneta tiene sensor de tráfico cruzado.     
     * @return true si la camioneta tiene sensor de tráfico cruzado, false de lo contrario
     */
	public boolean isTieneSensorTraficoCruzado() {
		return tieneSensorTraficoCruzado;
	}

    /**
     * Establece si la camioneta tiene sensor de tráfico cruzado.      
     * @param tieneSensorTraficoCruzado true si la camioneta tiene sensor de tráfico cruzado, false de lo contrario
     */
	public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
	}

    /**
     * Verifica si la camioneta tiene asistente de permanencia en carril.     
     * @return true si la camioneta tiene asistente de permanencia en carril, false de lo contrario
     */
	public boolean isTieneAsistentePermanenciaCarril() {
		return tieneAsistentePermanenciaCarril;
	}

    /**
     * Establece si la camioneta tiene asistente de permanencia en carril.      
     * @param tieneAsistentePermanenciaCarril true si la camioneta tiene asistente de permanencia en carril, false de lo contrario
     */
	public void setTieneAsistentePermanenciaCarril(boolean tieneAsistentePermanenciaCarril) {
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
	}

    /**
     * Verifica si la camioneta es 4x4.      
     * @return true si la camioneta es 4x4, false de lo contrario
     */
	public boolean isEs4x4() {
		return es4x4;
	}

    /**
     * Establece si la camioneta es 4x4.      
     * @param es4x4 true si la camioneta es 4x4, false de lo contrario
     */
	public void setEs4x4(boolean es4x4) {
		this.es4x4 = es4x4;
	}
	
}	
