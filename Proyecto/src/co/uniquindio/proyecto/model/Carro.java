package co.uniquindio.proyecto.model;
import java.io.Serializable;
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
	 * 
	 * @param marca
	 * @param nuevo
	 * @param modelo
	 * @param cambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param autonomiaCargaCompleta
	 * @param tiempoPromedioCarga
	 * @param esEnchufable
	 * @param esHibridoLigero
	 * @param tieneRevisionTecnica
	 * @param foto
	 */
    public Carro (String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, 
	Object foto){
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga, esEnchufable, 
		esHibridoLigero, tieneRevisionTecnica, foto);
	}

    /**
     * 
     * @return
     */
	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}

	/**
	 * 
	 * @param numeroPasajeros
	 */
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * 
	 * @param numeroPuertas
	 */
	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getNumeroBolsasAire() {
		return numeroBolsasAire;
	}

	/**
	 * 
	 * @param numeroBolsasAire
	 */
	public void setNumeroBolsasAire(Integer numeroBolsasAire) {
		this.numeroBolsasAire = numeroBolsasAire;
	}  
    
}
