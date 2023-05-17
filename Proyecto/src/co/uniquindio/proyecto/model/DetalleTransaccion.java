package co.uniquindio.proyecto.model;

public class DetalleTransaccion {
	
	private Double subTotal;
	private Integer cantidad;
	private Vehiculo vehiculo;
	
	public DetalleTransaccion() {
		
	}
	
	public DetalleTransaccion(Double subTotal, Integer cantidad, Vehiculo vehiculo) {
		this.subTotal=subTotal;
		this.cantidad=cantidad;
		this.vehiculo=vehiculo;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
