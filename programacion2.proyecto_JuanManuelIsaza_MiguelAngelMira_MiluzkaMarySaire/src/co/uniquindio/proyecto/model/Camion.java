package co.uniquindio.proyecto.model;

import javafx.scene.image.Image;


/**
 * La clase Camion representa un camión en el sistema.
 * Hereda los atributos y métodos de la clase Vehiculo.
 */
public class Camion extends Vehiculo {
	
	private Double capacidadCarga;
	private boolean tieneABS;
	private Integer numeroEjes;
	private boolean tieneFrenosAire;
	private String tipoCamion;
	
	/**
	 * Metodo constructor
	 */
	public Camion() {
				
	}

    /**
     * Constructor de la clase Camion.
     * Crea una instancia de Camion con los atributos especificados.
     * 
     * @param marca la marca del camión
     * @param nuevo indica si el camión es nuevo
     * @param modelo el modelo del camión
     * @param cambios el número de cambios del camión
     * @param velocidadMaxima la velocidad máxima del camión
     * @param cilindraje el cilindraje del camión
     * @param autonomiaCargaCompleta la autonomía del camión con carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga del camión
     * @param esEnchufable indica si el camión es enchufable
     * @param esHibridoLigero indica si el camión es híbrido ligero
     * @param tieneRevisionTecnica indica si el camión tiene revisión técnica vigente
     * @param foto la foto del camión
     */
	public Camion(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima,
			Double cilindraje, Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable,
			boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor) {
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga,
				esEnchufable, esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

    /**
     * Obtiene la capacidad de carga del camión.
     * @return la capacidad de carga del camión
     */
	public Double getCapacidadCarga() {
		return capacidadCarga;
	}

    /**
     * Establece la capacidad de carga del camión.
     * @param capacidadCarga la capacidad de carga del camión
     */
	public void setCapacidadCarga(Double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

    /**
     * Verifica si el camión tiene sistema de frenos ABS.
     * @return true si el camión tiene ABS, false de lo contrario
     */
	public boolean isTieneABS() {
		return tieneABS;
	}

    /**
     * Establece si el camión tiene sistema de frenos ABS.
     * @param tieneABS true si el camión tiene ABS, false de lo contrario
     */
	public void setTieneABS(boolean tieneABS) {
		this.tieneABS = tieneABS;
	}

    /**
     * Obtiene el número de ejes del camión.
     * @return el número de ejes del camión
     */
	public Integer getNumeroEjes() {
		return numeroEjes;
	}

    /**
     * Establece el número de ejes del camión.
     * @param numeroEjes el número de ejes del camión
     */
	public void setNumeroEjes(Integer numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

    /**
     * Verifica si el camión tiene frenos de aire.
     * @return true si el camión tiene frenos de aire, false de lo contrario
     */
	public boolean isTieneFrenosAire() {
		return tieneFrenosAire;
	}

    /**
     * Establece si el camión tiene frenos de aire.
     * @param tieneFrenosAire true si el camión tiene frenos de aire, false de lo contrario
     */
	public void setTieneFrenosAire(boolean tieneFrenosAire) {
		this.tieneFrenosAire = tieneFrenosAire;
	}

    /**
     * Obtiene el tipo de camión.
     * @return el tipo de camión
     */
	public String getTipoCamion() {
		return tipoCamion;
	}

    /**
     * Establece el tipo de camión.
     * @param tipoCamion el tipo de camión
     */
	public void setTipoCamion(String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}
	
}