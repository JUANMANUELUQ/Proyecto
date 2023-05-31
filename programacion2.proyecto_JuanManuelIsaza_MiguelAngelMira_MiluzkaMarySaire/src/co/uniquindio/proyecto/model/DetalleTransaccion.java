package co.uniquindio.proyecto.model;

import java.io.Serializable;

/**
 * Esta clase representa un detalle de transacción que implementa la interfaz Serializable.
 */
public class DetalleTransaccion implements Serializable {
	
	private Double subTotal; 
	private Integer cantidad;
	private Vehiculo vehiculo;
	
    /**
     * Constructor por defecto de la clase DetalleTransaccion.
     */
	public DetalleTransaccion() {
		
	}
	
    /**
     * Constructor de la clase DetalleTransaccion.
     * 
     * @param subTotal el subtotal del detalle de transacción
     * @param cantidad la cantidad del detalle de transacción
     * @param vehiculo el vehículo asociado al detalle de transacción
     */
	public DetalleTransaccion(Double subTotal, Integer cantidad, Vehiculo vehiculo) {
		this.subTotal=subTotal;
		this.cantidad=cantidad;
		this.vehiculo=vehiculo;
	}

    /**
     * Obtiene el subtotal del detalle de transacción.
     * @return el subtotal del detalle de transacción
     */
	public Double getSubTotal() {
		return subTotal;
	}

    /**
     * Establece el subtotal del detalle de transacción.
     * @param subTotal el subtotal del detalle de transacción
     */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

    /**
     * Obtiene la cantidad del detalle de transacción.
     * @return la cantidad del detalle de transacción
     */
	public Integer getCantidad() {
		return cantidad;
	}

    /**
     * Establece la cantidad del detalle de transacción.
     * @param cantidad la cantidad del detalle de transacción
     */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

    /**
     * Obtiene el vehículo asociado al detalle de transacción.      
     * @return el vehículo asociado al detalle de transacción
     */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

    /**
     * Establece el vehículo asociado al detalle de transacción.      
     * @param vehiculo el vehículo asociado al detalle de transacción
     */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
