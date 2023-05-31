package co.uniquindio.proyecto.model;
import java.io.Serializable;

import javafx.scene.image.Image;

public abstract class Vehiculo implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private String marca;
	private boolean nuevo;
	private String modelo; //name
	private Integer cambios;
	private Double velocidadMaxima;
	private Double cilindraje;
	private Integer autonomiaCargaCompleta;
	private Integer tiempoPromedioCarga;
	private boolean esEnchufable ;
	private boolean esHibridoLigero;
	private boolean tieneRevisionTecnica;
	private String foto;
	private TipoCombustible tipoCombustible;
	private Transmision transmision;
	private Integer precio;
	private String codeColor;
	
	/**
     * Constructor por defecto de la clase Vehiculo.
     */
	public Vehiculo(){
				
	}
	
	  /**
     * Constructor de la clase Vehiculo.
     *
     * @param marca la marca del vehículo
     * @param nuevo indica si el vehículo es nuevo
     * @param modelo el modelo del vehículo
     * @param cambios el número de cambios del vehículo
     * @param velocidadMaxima la velocidad máxima del vehículo
     * @param cilindraje el cilindraje del vehículo
     * @param autonomiaCargaCompleta la autonomía del vehículo con carga completa
     * @param tiempoPromedioCarga el tiempo promedio de carga del vehículo
     * @param esEnchufable indica si el vehículo es enchufable
     * @param esHibridoLigero indica si el vehículo es híbrido ligero
     * @param tieneRevisionTecnica indica si el vehículo tiene revisión técnica
     * @param foto la ruta de la foto del vehículo
     * @param precio El precio del vehiculo
     * @param codeColor El color del vehiculo
     */
	public Vehiculo(String marca, boolean nuevo, String modelo, Integer cambios, Double velocidadMaxima, Double cilindraje, 
	Integer autonomiaCargaCompleta, Integer tiempoPromedioCarga, boolean esEnchufable, boolean esHibridoLigero, boolean tieneRevisionTecnica, String foto, Integer precio, String codeColor){
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
		this.precio=precio;
		this.codeColor=codeColor;
	}
	
	/**
     * Obtiene la marca del vehículo.
     * @return la marca del vehículo
     */
	public String getMarca() {
		return marca;
	}
	
    /**
     * Establece la marca del vehículo.
     * @param marca la marca del vehículo
     */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
    /**
     * Verifica si el vehículo es nuevo.
     * @return true si el vehículo es nuevo, false de lo contrario
     */
	public boolean isNuevo() {
		return nuevo;
	}

    /**
     * Establece si el vehículo es nuevo.
     * @param nuevo true si el vehículo es nuevo, false de lo contrario
     */
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
    /**
     * Obtiene el modelo del vehículo.
     * @return el modelo del vehículo
     */
	public String getModelo() {
		return modelo;
	}

    /**
     * Establece el modelo del vehículo.
     * @param modelo el modelo del vehículo     
     */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
    /**
     * Obtiene el número de cambios del vehículo.
     * @return el número de cambios del vehículo
     */
	public Integer getCambios() {
		return cambios;
	}

    /**
     * Establece el número de cambios del vehículo.
     * @param cambios el número de cambios del vehículo
     */
	public void setCambios(Integer cambios) {
		this.cambios = cambios;
	}
	
    /**
     * Obtiene la velocidad máxima del vehículo.
     * @return la velocidad máxima del vehículo
     */
	public Double getVelocidadMaxima() {
		return velocidadMaxima;
	}

    /**
     * Establece la velocidad máxima del vehículo.
     * @param velocidadMaxima la velocidad máxima del vehículo
     */
	public void setVelocidadMaxima(Double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	
    /**
     * Obtiene el cilindraje del vehículo.
     * @return el cilindraje del vehículo
     */
	public Double getCilindraje() {
		return cilindraje;
	}

    /**
     * Establece el cilindraje del vehículo.
     * @param cilindraje el cilindraje del vehículo
     */
	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
    /**
     * Obtiene la autonomía del vehículo con carga completa.
     * @return la autonomía del vehículo con carga completa
     */
	public Integer getAutonomiaCargaCompleta() {
		return autonomiaCargaCompleta;
	}

    /**
     * Establece la autonomía del vehículo con carga completa.
     * @param autonomiaCargaCompleta la autonomía del vehículo con carga completa
     */
	public void setAutonomiaCargaCompleta(Integer autonomiaCargaCompleta) {
		this.autonomiaCargaCompleta = autonomiaCargaCompleta;
	}
	
    /**
     * Obtiene el tiempo promedio de carga del vehículo.
     * @return el tiempo promedio de carga del vehículo
     */
	public Integer getTiempoPromedioCarga() {
		return tiempoPromedioCarga;
	}

    /**
     * Establece el tiempo promedio de carga del vehículo.
     * @param tiempoPromedioCarga el tiempo promedio de carga del vehículo
     */
	public void setTiempoPromedioCarga(Integer tiempoPromedioCarga) {
		this.tiempoPromedioCarga = tiempoPromedioCarga;
	}
	
    /**
     * Verifica si el vehículo es enchufable.
     * @return true si el vehículo es enchufable, false de lo contrario
     */
	public boolean isEsEnchufable() {
		return esEnchufable;
	}

    /**
     * Establece si el vehículo es enchufable.
     * @param esEnchufable true si el vehículo es enchufable, false de lo contrario
     */
	public void setEsEnchufable(boolean esEnchufable) {
		this.esEnchufable = esEnchufable;
	}
	
    /**
     * Verifica si el vehículo es híbrido ligero.
     * @return true si el vehículo es híbrido ligero, false de lo contrario
     */	
	public boolean isEsHibridoLigero() {
		return esHibridoLigero;
	}

    /**
     * Establece si el vehículo es híbrido ligero.
     * @param esHibridoLigero true si el vehículo es híbrido ligero, false de lo contrario
     */
	public void setEsHibridoLigero(boolean esHibridoLigero) {
		this.esHibridoLigero = esHibridoLigero;
	}
	
    /**
     * Verifica si el vehículo tiene revisión técnica.
     * @return true si el vehículo tiene revisión técnica, false de lo contrario
     */
	public boolean isTieneRevisionTecnica() {
		return tieneRevisionTecnica;
	}

    /**
     * Establece si el vehículo tiene revisión técnica.
     * @param tieneRevisionTecnica true si el vehículo tiene revisión técnica, false de lo contrario
     */
	public void setTieneRevisionTecnica(boolean tieneRevisionTecnica) {
		this.tieneRevisionTecnica = tieneRevisionTecnica;
	}
	
    /**
     * Obtiene la ruta de la foto del vehículo.
     * @return la ruta de la foto del vehículo
     */
	public String getFoto() {
		return foto;
	}

    /**
     * Establece la ruta de la foto del vehículo.
     * @param foto la ruta de la foto del vehículo
     */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
    /**
     * Obtiene el tipo de combustible del vehículo.
     * @return el tipo de combustible del vehículo
     */
	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}

    /**
     * Establece el tipo de combustible del vehículo.
     * @param tipoCombustible el tipo de combustible del vehículo
     */
	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

    /**
     * Obtiene la transmisión del vehículo.
     * @return la transmisión del vehículo
     */
	public Transmision getTransmision() {
		return transmision;
	}

    /**
     * Establece la transmisión del vehículo
     * @param transmision la transmisión del vehículo
     */
	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}
	
	/**
	 * Ontiene el precio del vehiculo
	 * @return el precio del vehiculo
	 */
	public Integer getPrecio() {
		return precio;
	}
	
	/**
	 * Establece el precio del vehiculo
	 * @param precio el precio del vehiculo
	 */
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	/**
	 * Obtiene el color del vehiculo
	 * @return El codigo del color del vehiculo
	 */
	public String getCodeColor() {
		return codeColor;
	}
	
	/**
	 * Establece el color del vehiculo
	 * @param codeColor el color del vehiculo
	 */
	public void setCodeColor(String codeColor) {
		this.codeColor = codeColor;
	}

	/**
	 * Obtiene el tipo de vehículo basado en la instancia actual.
	 * @return el tipo de vehículo (TipoVehiculo)
	 */
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
	
	/**
	 * Obtiene el tipo de vehículo en forma de cadena de texto basado en la instancia actual.
	 * @return el tipo de vehículo como cadena de texto
	 */
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
	
	/**
	 * Obtiene el tipo de vehículo en forma de cadena de texto basado en la instancia actual.
	 * @return el tipo de vehículo como cadena de texto
	 */
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
	
	/**
	 * Obtiene el tipo de transmisión en forma de cadena de texto.
	 * @return el tipo de transmisión como cadena de texto
	 */
	public String obtenerTransmisionCadena() {
		String msj="";
		switch(transmision) {
			case AUTOMATICA: msj="Automatica"; break;
			case MANUAL: msj="Manual"; break;
		}
		return msj;
	}

}
