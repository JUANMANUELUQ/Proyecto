package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


public class Transaccion implements Serializable{
	
	private Double valor;
	private Empleado empleadoTransaccion;
	private Cliente cliente;
	private LocalDate fecha;
	private List<DetalleTransaccion> listaDetalleTransacciones;
	
	
	public Transaccion(){
		
	}
	
	public Transaccion(Double valor, Empleado empleado,Cliente cliente,LocalDate fecha,List<DetalleTransaccion> listaDetalleTransacciones) {
		this.valor = valor;
		this.empleadoTransaccion = empleado;
		this.cliente = cliente;
		this.fecha=fecha;
		this.listaDetalleTransacciones=listaDetalleTransacciones;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		valor = valor;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleTransaccion> getListaDetalleTransacciones() {
		return listaDetalleTransacciones;
	}

	public void setListaDetalleTransacciones(List<DetalleTransaccion> listaDetalleTransacciones) {
		this.listaDetalleTransacciones = listaDetalleTransacciones;
	}
	
	public boolean verificarEmpleado(String documentoEmpleado){
		boolean verificado=empleadoTransaccion.verificarPersona(documentoEmpleado);
		return verificado;
	}
	/*
	public boolean verificarFecha(LocalDate fechaInicial, LocalDate fechaFinal){
		for (DetalleTransaccion detalle : listaDetalleTransacciones) {
	        LocalDate fecha = detalle.getFecha();
	        if (fecha.isAfter(fechaInicial) && fecha.isBefore(fechaFinal)) {
	            return true;
	        }
    }
    return false;
	}
	*/

	public boolean estaFechaRango(LocalDate fechaMin, LocalDate fechaMax) {
		if (fecha.isAfter(fechaMin) && fecha.isBefore(fechaMax)) {
            return true;
        }
		return false;
	}

	public boolean tieneEmpleado(String documentoEmpleado) {
		if (empleadoTransaccion.tieneDocumento(documentoEmpleado)) {
			return true;
		}
		return false;
	}

}
