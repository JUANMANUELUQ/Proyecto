package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;
/**
 * La clase Bus representa un autobús en el sistema.
 * Hereda los atributos y métodos de la clase CarroNoDeportivo.
 */
public class Bus extends CarroNoDeportivo{
	private Double capacidadMaletero;
	private Integer numeroEjes;
	private Integer numeroSalidasEmergencia;
	
	/**
	 * Metodo constructor
	 */
	public Bus() {
		
	}
	
    /**
     * Constructor de la clase Bus.
     * Crea una instancia de Bus con los atributos especificados.
     * 
     * @param marca la marca del autobús
     * @param nuevo indica si el autobús es nuevo
     * @param modelo el modelo del autobús
     * @param cambios el número de cambios del autobús
     * @param velocidadMaxima la velocidad máxima del autobús
     * @param cilindraje el cilindraje del autobús
     * @param autonomiaCargaCompleta la autonomía del autobús con carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga del autobús
     * @param esEnchufable indica si el autobús es enchufable
     * @param esHibridoLigero  indica si el autobús es híbrido ligero
     * @param tieneRevisionTecnica indica si el autobús tiene revisión técnica vigente
     * @param foto la foto del autobús
     */
	public Bus(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje,
			Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero,
			boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}


    /**
     * Obtiene la capacidad del maletero del autobús.
     * @return la capacidad del maletero del autobús
     */
	public Double getCapacidadMaletero() {
		return capacidadMaletero;
	}

    /**
     * Establece la capacidad del maletero del autobús.
     * @param capacidadMaletero la capacidad del maletero del autobús
     */
	public void setCapacidadMaletero(Double capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

    /**
     * Obtiene el número de ejes del autobús.
     * @return el número de ejes del autobús
     */
	public Integer getNumeroEjes() {
		return numeroEjes;
	}

    /**
     * Establece el número de ejes del autobús.
     * @param numeroEjes el número de ejes del autobús
     */
	public void setNumeroEjes(Integer numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

    /**
     * Obtiene el número de salidas de emergencia del autobús.
     * @return el número de salidas de emergencia del autobús
     */
	public Integer getNumeroSalidasEmergencia() {
		return numeroSalidasEmergencia;
	}

    /**
     * Establece el número de salidas de emergencia del autobús.
     * @param numeroSalidasEmergencia el número de salidas de emergencia del autobús
     */
	public void setNumeroSalidasEmergencia(Integer numeroSalidasEmergencia) {
		this.numeroSalidasEmergencia = numeroSalidasEmergencia;
	}
}
