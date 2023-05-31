package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;

/**
 * La clase Sedan representa un carro Sedan en el sistema.
 * Hereda los atributos y métodos de la clase CarroNoDeportivo.
 */
public class Sedan extends CarroNoDeportivo {
	
	private Double capacidadMaletero;
	private boolean tieneVelocidadCrucero;
	private boolean tieneSensoresColision;
	private boolean tieneSensorTraficoCruzado;
	private boolean tieneAsistentePermanenciaCarril;
    
    /**
     * Constructor por defecto de la clase Sedan.
     */
	public Sedan() {
		
	}
	
    /**
     * Constructor de la clase Sedan.
     * 
     * @param marca la marca del sedán
     * @param nuevo indica si el sedán es nuevo
     * @param modelo el modelo del sedán
     * @param cambios el número de cambios del sedán
     * @param velocidadMaxima la velocidad máxima del sedán
     * @param cilindraje el cilindraje del sedán
     * @param autonomiaCargaCompleta la autonomía de carga completa del sedán
     * @param tiempoPromedioCarga el tiempo promedio de carga del sedán
     * @param esEnchufable indica si el sedán es enchufable
     * @param esHibridoLigero indica si el sedán es híbrido ligero
     * @param tieneRevisionTecnica indica si el sedán tiene revisión técnica
     * @param foto la foto del sedán
     */
	public Sedan(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

	   /**
     * Obtiene la capacidad del maletero del sedán.
     * @return la capacidad del maletero del sedán
     */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

    /**
     * Establece la capacidad del maletero del sedán.
     * @param capacidadMaletero la capacidad del maletero del sedán
     */
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

    /**
     * Verifica si el sedán tiene control de velocidad crucero.
     * @return true si tiene control de velocidad crucero, false de lo contrario
     */
	public boolean isTieneVelocidadCrucero() {
		return tieneVelocidadCrucero;
	}

    /**
     * Establece si el sedán tiene control de velocidad crucero.
     * @param tieneVelocidadCrucero true si tiene control de velocidad crucero, false de lo contrario
     */
	public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
		this.tieneVelocidadCrucero = tieneVelocidadCrucero;
	}

    /**
     * Verifica si el sedán tiene sensores de colisión.
     * @return true si tiene sensores de colisión, false de lo contrario
     */
	public boolean isTieneSensoresColision() {
		return tieneSensoresColision;
	}

    /**
     * Establece si el sedán tiene sensores de colisión.
     * @param tieneSensoresColision true si tiene sensores de colisión, false de lo contrario
     */
	public void setTieneSensoresColision(boolean tieneSensoresColision) {
		this.tieneSensoresColision = tieneSensoresColision;
	}
	
    /**
     * Verifica si el sedán tiene sensor de tráfico cruzado.
     * 
     * @return true si tiene sensor de tráfico cruzado, false de lo contrario
     */
	public boolean isTieneSensorTraficoCruzado() {
		return tieneSensorTraficoCruzado;
	}

    /**
     * Establece si el sedán tiene sensor de tráfico cruzado.
     * 
     * @param tieneSensorTraficoCruzado true si tiene sensor de tráfico cruzado, false de lo contrario
     */
	public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
		this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
	}

    /**
     * Verifica si el sedán tiene asistente de permanencia en carril.
     * @return true si tiene asistente de permanencia en carril, false de lo contrario
     */
	public boolean isTieneAsistentePermanenciaCarril() {
		return tieneAsistentePermanenciaCarril;
	}

    /**
     * Establece si el sedán tiene asistente de permanencia en carril.
     * @param tieneAsistentePermanenciaCarril true si tiene asistente de permanencia en carril, false de lo contrario
     */
	public void setTieneAsistentePermanenciaCarril(boolean tieneAsistentePermanenciaCarril) {
		this.tieneAsistentePermanenciaCarril = tieneAsistentePermanenciaCarril;
	}

}
