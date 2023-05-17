package co.uniquindio.proyecto.util;
import java.io.Serializable;
import java.util.List;

import co.uniquindio.proyecto.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ClaseUtilitaria {
	
	public static boolean serializarObjeto( String direccionArchivo, Serializable objeto){
		boolean bandera=false;
		try (FileOutputStream fos = new FileOutputStream(direccionArchivo);
                ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(objeto);
            bandera = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bandera;
		
	}
	
	public static <E> E deserializarObjeto(String direccionArchivo, Class<E> claseObjetivo) {
        E objeto = null;
        try (FileInputStream fis = new FileInputStream(direccionArchivo);
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
            objeto = (E) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }

	public String obtenerNuevaContradenia() {
        String contrasenia="";
        for (int i=0;i<6;i++) {
            contrasenia+=(int)(Math.random()*10);
        }
        return contrasenia;
    }
	
	public static boolean obtenerRespuestaCadena(String cadena) {
		boolean respuesta=false;
		if (cadena.equals("Si")) {
			respuesta=true;
		}
		return respuesta;
	}
	
	public static String obtenerRespuestaCadena(boolean respuesta) {
		String cadena="No";
		if (respuesta) {
			cadena="Si";
		}
		return cadena;
	}
	
	public static Transmision obtenerTransmision(String cadena) {
		Transmision transmision=null;
		switch(cadena) {
			case "Automatica": transmision=Transmision.AUTOMATICA; break;
			case "Manual": transmision=Transmision.MANUAL; break;
		}
		return transmision;
	}
	
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
	
	public static void ponerDatosCarro(Carro carro,Integer numeroPasajeros,Integer numeroPuertas,Integer numeroBolsasAire) {
		carro.setNumeroPasajeros(numeroPasajeros);
		carro.setNumeroPuertas(numeroPuertas);
		carro.setNumeroBolsasAire(numeroBolsasAire);
	}
	
	public static void ponerDatosCarroNoDeportivo(CarroNoDeportivo carroNoDeportivo,boolean tieneAireAcondicionado,
	boolean tieneCamaraReversa,boolean tieneABS) {
		carroNoDeportivo.setTieneAireAcondicionado(tieneAireAcondicionado);
		carroNoDeportivo.setTieneCamaraReversa(tieneCamaraReversa);
		carroNoDeportivo.setTieneABS(tieneABS);
	}
	
	public static Double obtenerTotal(List<DetalleTransaccion> detalles) {
		Double total=0.0;
		for (DetalleTransaccion detalleTransaccion : detalles) {
			total+=detalleTransaccion.getSubTotal();
		}
		return total;
	}

}
