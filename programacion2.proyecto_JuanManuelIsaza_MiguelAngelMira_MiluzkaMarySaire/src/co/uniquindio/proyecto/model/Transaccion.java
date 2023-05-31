package co.uniquindio.proyecto.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * La clase abstracta Transaccion implementa la interfaz Serializable. 
 * Representa un tipo genérico de Transaccion  y proporciona atributos y métodos comunes a las transacciones.
 */
public abstract class Transaccion implements Serializable{
	
	private Double valor;
	private Empleado empleadoTransaccion;
	private Cliente cliente;
	private LocalDate fecha;
	private List<DetalleTransaccion> listaDetalleTransacciones;
	
    /**
     * Constructor por defecto de la clase Transaccion.
     */
	public Transaccion(){
		
	}
	
    /**
     * Constructor de la clase Transaccion.
     * 
     * @param valor el valor de la transacción
     * @param empleado el empleado que realizó la transacción
     * @param cliente el cliente relacionado con la transacción
     * @param fecha la fecha de la transacción
     * @param listaDetalleTransacciones la lista de detalles de la transacción
     */
	public Transaccion(Double valor, Empleado empleado,Cliente cliente,LocalDate fecha,List<DetalleTransaccion> listaDetalleTransacciones) {
		this.valor = valor;
		this.empleadoTransaccion = empleado;
		this.cliente = cliente;
		this.fecha=fecha;
		this.listaDetalleTransacciones=listaDetalleTransacciones;
	}

    /**
     * Obtiene el valor de la transacción.
     * @return el valor de la transacción
     */
	public Double getValor() {
		return valor;
	}

    /**
     * Establece el valor de la transacción.
     * @param valor el valor de la transacción
     */
	public void setValor(Double valor) {
		this.valor = valor;
	}

    /**
     * Obtiene el cliente relacionado con la transacción.
     * @return el cliente relacionado con la transacción
     */
	public Cliente getCliente() {
		return cliente;
	}

    /**
     * Establece el cliente relacionado con la transacción.
     * @param cliente el cliente relacionado con la transacción
     */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    /**
     * Obtiene el empleado que realizó la transacción.
     * @return el empleado que realizó la transacción
     */
	public Empleado getEmpleadoTransaccion() {
		return empleadoTransaccion;
	}

    /**
     * Establece el empleado que realizó la transacción.
     * @param empleadoTransaccion el empleado que realizó la transacción
     */
	public void setEmpleadoTransaccion(Empleado empleadoTransaccion) {
		this.empleadoTransaccion = empleadoTransaccion;
	}

    /**
     * Obtiene la fecha de la transacción.
     * @return la fecha de la transacción
     */
	public LocalDate getFecha() {
		return fecha;
	}

    /**
     * Establece la fecha de la transacción.
     * @param fecha la fecha de la transacción
     */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

    /**
     * Obtiene la lista de detalles de la transacción.
     * @return la lista de detalles de la transacción
     */
	public List<DetalleTransaccion> getListaDetalleTransacciones() {
		return listaDetalleTransacciones;
	}

    /**
     * Establece la lista de detalles de la transacción.
     * @param listaDetalleTransacciones la lista de detalles de la transacción
     */
	public void setListaDetalleTransacciones(List<DetalleTransaccion> listaDetalleTransacciones) {
		this.listaDetalleTransacciones = listaDetalleTransacciones;
	}
	
    /**
     * Verifica si el empleado de la transacción tiene el documento especificado.
     * 
     * @param documentoEmpleado el documento a verificar
     * @return true si el empleado tiene el documento, false de lo contrario
     */
	public boolean verificarEmpleado(String documentoEmpleado){
		boolean verificado=empleadoTransaccion.verificarPersona(documentoEmpleado);
		return verificado;
	}

    /**
     * Verifica si la fecha de la transacción está dentro del rango especificado.
     * Si ambos límites del rango son null, se considera que la fecha está dentro del rango.
     * 
     * @param fechaMin la fecha mínima del rango
     * @param fechaMax la fecha máxima del rango
     * @return true si la fecha está dentro del rango, false de lo contrario
     */
	public boolean estaFechaRango(LocalDate fechaMin, LocalDate fechaMax) {
		if (fechaMin==null && fechaMax==null) {
			 return true;
		}
		if (fecha.isAfter(fechaMin.plusDays(-1)) && fecha.isBefore(fechaMax.plusDays(1))) {
            return true;
        }
		return false;
	}

    /**
     * Verifica si la transacción tiene el empleado con el documento especificado.
     * 
     * @param documentoEmpleado el documento a verificar
     * @return true si la transacción tiene el empleado con el documento, false de lo contrario
     */
	public boolean tieneEmpleado(String documentoEmpleado) {
		if (empleadoTransaccion.tieneDocumento(documentoEmpleado)) {
			return true;
		}
		return false;
	}

    /**
     * Obtiene el tipo de transacción de la transacción.
     * 
     * @return el tipo de transacción de la transacción
     */
	public TipoTransaccion obtenerTipoTransaccion() {
		TipoTransaccion tipoTransaccion=null;
		if (this instanceof Alquiler) {
			tipoTransaccion=TipoTransaccion.ALQUILER;
		}
		if (this instanceof Venta) {
			tipoTransaccion=TipoTransaccion.VENTA;
		}
		if (this instanceof Compra) {
			tipoTransaccion=TipoTransaccion.COMPRA;
		}
		return tipoTransaccion;
	}
	
    /**
     * Obtiene el tipo de transacción de la transacción como una cadena de texto.
     * 
     * @return el tipo de transacción de la transacción como una cadena de texto
     */
	public String obtenerTipoTransaccionCadena() {
		String tipoTransaccion="";
		if (this instanceof Alquiler) {
			tipoTransaccion="Alquiler";
		}
		if (this instanceof Venta) {
			tipoTransaccion="Venta";
		}
		if (this instanceof Compra) {
			tipoTransaccion="Compra";
		}
		return tipoTransaccion;
	}

    /**
     * Verifica si la transacción es del tipo especificado.
     * Si el tipoTransaccion es null, se considera que la transacción es del tipo especificado.
     * 
     * @param tipoTransaccion el tipo de transacción a verificar
     * @return true si la transacción es del tipo especificado, false de lo contrario
     */
	public boolean esTipoTransaccion(TipoTransaccion tipoTransaccion) {
		boolean respuesta=false;
		if (tipoTransaccion==null) {
			respuesta=true;
		} else if (obtenerTipoTransaccion()==tipoTransaccion) {
			respuesta=true;
		}
		return respuesta;
	}

}