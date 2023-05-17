package co.uniquindio.proyecto.model;
import java.io.Serializable;

public abstract class Vehiculo implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private String marca;
	private boolean nuevo;
	private String modelo;
	private Integer cambios;
	private Double velocidadMaxima;
	private Double cilindraje;
	private Integer autonomiaCargaCompleta;
	private Integer tiempoPromedioCarga;
	private boolean esEnchufable ;
	private boolean esHibridoLigero;
	private boolean tieneRevisionTecnica;
	private Object foto;
	private TipoCombustible tipoCombustible;
	private Transmision transmision;
	
	public Vehiculo(){
				
	}
	
	public Vehiculo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, Object foto){
		this.marca=marca;
		this.nuevo=nuevo;
		this.modelo=modelo;
		this.cambios=cambios;
		this.velocidadMaxima=velocidadMaxima;
		this.cilindraje=cilindraje;
		this.autonomiaCargaCompleta=autonomiaCargaCompleta;
		this.tiempoPromedioCarga=tiempoPromedioCarga;
		this.esEnchufable=esEnchufable;
		this.esHibridoLigero=esHibridoLigero;
		this.tieneRevisionTecnica=tieneRevisionTecnica;
		this.foto=foto;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMarca() {
		return marca;
	}
	
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public Integer getCambios() {
		return cambios;
	}

	public void setCambios(Integer cambios) {
		this.cambios = cambios;
	}
	
	
	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	
	
	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	public Integer getAutonomiaCargaCompleta() {
		return autonomiaCargaCompleta;
	}

	public void setAutonomiaCargaCompleta(Integer autonomiaCargaCompleta) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
	}
	
	
	public Integer getTiempoPromedioCarga() {
		return tiempoPromedioCarga;
	}

	public void setTiempoPromedioCarga(Integer tiempoPromedioCarga) {
		this.tiempoPromedioCarga = tiempoPromedioCarga;
	}
	
	
	public boolean isEsEnchufable() {
		return esEnchufable;
	}

	public void setEsEnchufable(boolean esEnchufable) {
		this.esEnchufable = esEnchufable;
	}
	
	
	public boolean isEsHibridoLigero() {
		return esHibridoLigero;
	}

	public void setEsHibridoLigero(boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
	}
	
	
	public boolean isTieneRevisionTecnica() {
		return tieneRevisionTecnica;
	}

	public void setTieneRevisionTecnica(boolean tieneRevisionTecnica) {
		this.tieneRevisionTecnica = tieneRevisionTecnica;
	}
	
	
	public Object getFoto() {
		return foto;
	}

	public void setFoto(Object foto) {
		this.foto = foto;
	}
	
	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public Transmision getTransmision() {
		return transmision;
	}

	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}

	public TipoVehiculo obtenerTipoVehiculo() {
		TipoVehiculo tipo=null;
		if (this instanceof Moto) {
			tipo=TipoVehiculo.MOTO;
		}
		if (this instanceof Deportivo) {
			tipo=TipoVehiculo.DEPORTIVO;
		}
		if (this instanceof Sedan) {
			tipo=TipoVehiculo.SEDAN;
		}
		if (this instanceof Camioneta) {
			tipo=TipoVehiculo.CAMIONETA;
		}
		if (this instanceof Bus) {
			tipo=TipoVehiculo.BUS;
		}
		if (this instanceof PickUp) {
			tipo=TipoVehiculo.PICK_UP;
		}
		if (this instanceof Van) {
			tipo=TipoVehiculo.VAN;
		}
		if (this instanceof Camion) {
			tipo=TipoVehiculo.CAMION;
		}
		return tipo;
	}
	
	public String obtenerTipoVehiculoCadena() {
		String tipoVehiculo="";
		if (this instanceof Moto) {
			tipoVehiculo="Moto";
		}
		if (this instanceof Deportivo) {
			tipoVehiculo="Deportivo";
		}
		if (this instanceof Sedan) {
			tipoVehiculo="Sedan";
		}
		if (this instanceof Camioneta) {
			tipoVehiculo="Camioneta";
		}
		if (this instanceof Bus) {
			tipoVehiculo="Bus";
		}
		if (this instanceof PickUp) {
			tipoVehiculo="Pick up";
		}
		if (this instanceof Van) {
			tipoVehiculo="Van";
		}
		if (this instanceof Camion) {
			tipoVehiculo="Camion";
		}
		return tipoVehiculo;
	}
	
	public String obtenerTipoCombustibleCadena() {
		String msj="";
		switch(tipoCombustible) {
			case GASOLINA: msj="Gasolina"; break;
			case DIESEL: msj="Diesel"; break;
			case ELECTRICO: msj="Electrico"; break;
			case HIBRIDO: msj="Hibrido"; break;
		}
		return msj;
	}
	
	public String obtenerTransmisionCadena() {
		String msj="";
		switch(transmision) {
			case AUTOMATICA: msj="Automatica"; break;
			case MANUAL: msj="Manual"; break;
		}
		return msj;
	}

}
