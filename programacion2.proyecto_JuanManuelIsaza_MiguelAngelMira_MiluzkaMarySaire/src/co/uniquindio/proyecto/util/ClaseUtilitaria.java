package co.uniquindio.proyecto.util;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import co.uniquindio.proyecto.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/*
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
*/
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * La clase ClaseUtilitaria proporciona métodos útiles y de utilidad para diversas operaciones comunes.
 */
public class ClaseUtilitaria {

    /**
     * Genera y devuelve una nueva contraseña compuesta por 6 dígitos aleatorios.
     *
     * @return la nueva contraseña generada
     */
	public static String obtenerNuevaContradenia() {
        String contrasenia="";
        for (int i=0;i<6;i++) {
            contrasenia+=(int)(Math.random()*10);
        }
        return contrasenia;
    }
	
    /**
     * Devuelve la respuesta booleana basada en la cadena proporcionada.
     * Si la cadena es "Si", devuelve true; de lo contrario, devuelve false.
     *
     * @param cadena la cadena de respuesta
     * @return la respuesta booleana
     */
	public static boolean obtenerRespuestaCadena(String cadena) {
		boolean respuesta=false;
		if (cadena.equals("Si")) {
			respuesta=true;
		}
		return respuesta;
	}
	
    /**
     * Devuelve la cadena correspondiente a la respuesta booleana proporcionada.
     * Si la respuesta es true, devuelve "Si"; de lo contrario, devuelve "No".
     *
     * @param respuesta la respuesta booleana
     * @return la cadena de respuesta
     */
	public static String obtenerRespuestaCadena(boolean respuesta) {
		String cadena="No";
		if (respuesta) {
			cadena="Si";
		}
		return cadena;
	}
	
    /**
     * Devuelve la transmisión correspondiente a la cadena proporcionada.
     * Si la cadena es "Automatica", devuelve Transmision.AUTOMATICA;
     * si es "Manual", devuelve Transmision.MANUAL.
     *
     * @param cadena la cadena de transmisión
     * @return la transmisión correspondiente
     */
	public static Transmision obtenerTransmision(String cadena) {
		Transmision transmision=null;
		switch(cadena) {
			case "Automatica": transmision=Transmision.AUTOMATICA; break;
			case "Manual": transmision=Transmision.MANUAL; break;
		}
		return transmision;
	}
	
    /**
     * Devuelve el tipo de combustible correspondiente a la cadena proporcionada.
     * Si la cadena es "Gasolina", devuelve TipoCombustible.GASOLINA;
     * si es "Diesel", devuelve TipoCombustible.DIESEL;
     * si es "Electrico", devuelve TipoCombustible.ELECTRICO;
     * si es "Hibrido", devuelve TipoCombustible.HIBRIDO.
     *
     * @param cadena la cadena de tipo de combustible
     * @return el tipo de combustible correspondiente
     */
	public static TipoCombustible obtenerTipoCombustible(String cadena) {
		TipoCombustible tipoCombustible=null;
		switch(cadena) {
			case "Gasolina": tipoCombustible=TipoCombustible.GASOLINA; break;
			case "Diesel": tipoCombustible=TipoCombustible.DIESEL; break;
			case "Electrico": tipoCombustible=TipoCombustible.ELECTRICO; break;
			case "Hibrido": tipoCombustible=TipoCombustible.HIBRIDO; break;
		}
		return tipoCombustible;
	}
	
    /**
     * Asigna los datos específicos de un carro a una instancia de Carro.
     *
     * @param carro el objeto Carro al que se le asignarán los datos
     * @param numeroPasajeros el número de pasajeros del carro
     * @param numeroPuertas el número de puertas del carro
     * @param numeroBolsasAire el número de bolsas de aire del carro
     */
	public static void ponerDatosCarro(Carro carro,Integer numeroPasajeros,Integer numeroPuertas,Integer numeroBolsasAire) {
		carro.setNumeroPasajeros(numeroPasajeros);
		carro.setNumeroPuertas(numeroPuertas);
		carro.setNumeroBolsasAire(numeroBolsasAire);
	}
	
    /**
     * Asigna los datos específicos de un carro no deportivo a una instancia de CarroNoDeportivo.
     *
     * @param carroNoDeportivo el objeto CarroNoDeportivo al que se le asignarán los datos
     * @param tieneAireAcondicionado indica si el carro no deportivo tiene aire acondicionado
     * @param tieneCamaraReversa indica si el carro no deportivo tiene cámara de reversa
     * @param tieneABS indica si el carro no deportivo tiene sistema de frenos ABS
     */
	public static void ponerDatosCarroNoDeportivo(CarroNoDeportivo carroNoDeportivo,boolean tieneAireAcondicionado,
	boolean tieneCamaraReversa,boolean tieneABS) {
		carroNoDeportivo.setTieneAireAcondicionado(tieneAireAcondicionado);
		carroNoDeportivo.setTieneCamaraReversa(tieneCamaraReversa);
		carroNoDeportivo.setTieneABS(tieneABS);
	}
	
    /**
     * Calcula y devuelve el total basado en la lista de detalles de transacciones proporcionada.
     *
     * @param detalles la lista de detalles de transacciones
     * @return el total calculado
     */	
	public static Double obtenerTotal(List<DetalleTransaccion> detalles) {
		Double total=0.0;
		for (DetalleTransaccion detalleTransaccion : detalles) {
			total+=detalleTransaccion.getSubTotal();
		}
		return total;
	}
	
    /**
     * Organiza la lista de vehículos y devuelve una instancia de ObservableList.
     * Los vehículos duplicados se eliminan y la lista se organiza según el orden de aparición.
     *
     * @param listaVehiculos la lista de vehículos a organizar
     * @return la lista de vehículos organizada como ObservableList
     */
	public static ObservableList<Vehiculo> organizarListaVehiculos(List<Vehiculo> listaVehiculos) {
		List<Vehiculo> vehiculosOrganizados=new ArrayList<Vehiculo>(); 
		Vehiculo vehiculoObtenido=null;
		for (Vehiculo vehiculo : listaVehiculos) {
			if (vehiculoObtenido!=vehiculo) {
				vehiculosOrganizados.add(vehiculo);
				vehiculoObtenido=vehiculo;
			}
		}
		return FXCollections.observableArrayList(vehiculosOrganizados);
	}
	
    /**
     * Obtiene la cantidad de vehículos en la lista proporcionada que son iguales al vehículo especificado.
     *
     * @param vehiculo el vehículo para el que se obtendrá la cantidad
     * @param listaVehiculos la lista de vehículos
     * @return la cantidad de vehículos iguales al vehículo especificado en la lista
     */
	public static int obtenerCantidadVehiculo(Vehiculo vehiculo,List<Vehiculo> listaVehiculos) {
		int cant=0,pos=listaVehiculos.indexOf(vehiculo);
		for (int i=pos;i<listaVehiculos.size();i++) {
			if (vehiculo==listaVehiculos.get(i)) {
				cant++;
			} else {
				break;
			}
		}
		return cant;
	}
	
    /**
     * Reduce la cantidad de vehículos en la lista proporcionada eliminando el vehículo especificado.
     *
     * @param listaVehiculos la lista de vehículos
     * @param vehiculo el vehículo a reducir en cantidad
     * @param cantidad la cantidad de vehículos a reducir
     */
	public static void reducirCantidadVehiculo(List<Vehiculo> listaVehiculos,Vehiculo vehiculo, int cantidad) {
		for(int i=0;i<cantidad;i++) {
			listaVehiculos.remove(vehiculo);
		}
	}
	
    /**
     * Aumenta la cantidad de vehículos en la lista proporcionada insertando el vehículo especificado.
     *
     * @param listaVehiculos la lista de vehículos
     * @param vehiculo el vehículo a aumentar en cantidad
     * @param cantidad la cantidad de vehículos a aumentar
     */
	public static void aumentarCantidadVehiculo(List<Vehiculo> listaVehiculos,Vehiculo vehiculo, int cantidad) {
		int pos=listaVehiculos.indexOf(vehiculo)+1;
		for(int i=0;i<cantidad;i++) {
			listaVehiculos.add(pos,vehiculo);
		}
	}
	
	/**
	 * Metodo que muestra un mensaje
	 * @param titulo Titulo del mensaje
	 * @param encabezado Cabecera del mensaje
	 * @param texto Texto principal del mensaje
	 * @param alerta Alerta del mensaje
	 */
	public static void mostrarMensaje(String titulo,String encabezado,String texto,AlertType alerta) {
		Alert alert = new Alert(alerta);
		alert.setTitle(titulo);
		alert.setHeaderText(encabezado);
		alert.setContentText(texto);
		alert.showAndWait();
	}

}
