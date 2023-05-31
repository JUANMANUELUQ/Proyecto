package co.uniquindio.proyecto.model;
import java.io.Serializable;

import javafx.scene.image.Image;
/**
 * La clase abstracta Carro es una subclase de Vehiculo y también implementa la interfaz Serializable. 
 * Representa un tipo genérico de carro.
 */
public abstract class Carro extends Vehiculo implements Serializable{
	
	private Integer numeroPasajeros;
	private Integer numeroPuertas;
	private Integer numeroBolsasAire;
	
	/**
	 * Metodo constructor
	 */
	public Carro(){
				
	}
	
	/**
	 * Constructor de la clase Carro que recibe los atributos iniciales del carro.
	 * @param marca La marca del carro.
	 * @param nuevo Indica si el carro es nuevo o usado.
	 * @param modelo El modelo del carro.
	 * @param cambios El número de cambios del carro.
	 * @param velocidadMaxima La velocidad máxima del carro.
	 * @param cilindraje El cilindraje del carro.
	 * @param autonomiaCargaCompleta La autonomía de carga completa del carro.
	 * @param tiempoPromedioCarga El tiempo promedio de carga del carro.
	 * @param esEnchufable Indica si el carro es enchufable.
	 * @param esHibridoLigero Indica si el carro es híbrido ligero.
	 * @param tieneRevisionTecnica Indica si el carro tiene revisión técnica vigente.
	 * @param foto La foto del carro.
	 */
    public Carro (String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, 
	String foto, Integer precio, String codeColor){
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga, esEnchufable, 
		esHibridoLigero, tieneRevisionTecnica, foto, precio, codeColor);
	}

    /**
     * Obtiene el número de pasajeros del carro.
     * @return El número de pasajeros del carro.
     */
	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}

	/**
	 * Establece el número de pasajeros del carro.
	 * @param numeroPasajeros El número de pasajeros del carro.
	 */
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	/**
	 * Obtiene el número de puertas del carro.
	 * @return El número de puertas del carro.
	 */
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * Establece el número de puertas del carro.
	 * @param numeroPuertas El número de puertas del carro.
	 */
	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	/**
	 * Obtiene el número de bolsas de aire del carro.
	 * @return El número de bolsas de aire del carro.
	 */
	public Integer getNumeroBolsasAire() {
		return numeroBolsasAire;
	}

	/**
	 * El número de bolsas de aire del carro.
	 * @param numeroBolsasAire  El número de bolsas de aire del carro.
	 */
	public void setNumeroBolsasAire(Integer numeroBolsasAire) {
		this.numeroBolsasAire = numeroBolsasAire;
	}  
    
}
