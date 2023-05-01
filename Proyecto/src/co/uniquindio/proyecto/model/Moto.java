package co.uniquindio.proyecto.model;

public class Moto extends Vehiculo{
	                                                     
	public Moto() {
		
	}
	
	public Moto(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto){
		super(marca, nuevo, modelo, cambios, velocidadMaxima, cilindraje, autonomiaCargaCompleta, tiempoPromedioCarga, esEnchufable, 
		esHibridoLigero, tieneRevisionTecnica, foto);
	}

}
