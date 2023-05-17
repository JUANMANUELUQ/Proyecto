package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.*;
import javafx.collections.FXCollections;

/**
 * Clase controladora encargada de gestionar la ventana de reportes de transacciones.
 */
public class ReporteController {
	
	@FXML
	private TextField fechaInicial;
	@FXML
	private TextField fechaFinal;
	@FXML
	private TableView<Transaccion> tablaTransacciones;
	@FXML
	private TableColumn<Transaccion,String> columnaFecha;
	@FXML
	private TableColumn<Transaccion,String> columnaValor;
	@FXML
	private TableColumn<Transaccion,String> columnaTipoTransaccion;
	@FXML
	private TableColumn<Transaccion,String> columnaEmpleado;
	@FXML
	private TableColumn<Transaccion,String> columnaCliente;
	@FXML
	private TableView<DetalleTransaccion> tablaDetallesTransaccion;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaSubtotal;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaCantidad;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaDiasAlquiler;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaVehiculo;
	
	private Stage reporteStage;
	
	/**
	 * Constructor de la clase ReporteController.
	 */
	public ReporteController() {
		
	}
	
	/**
	 * Metodo que verifica si existen campos vacíos en el formulario del reporte.
	 * @return true si hay campos vacíos, false si todos los campos están llenos.
	 */
	public boolean existenCamposVacios() {
		boolean sonValidos=false;
		String msj="";
		if (fechaInicial.getText()==null || fechaInicial.getText().trim().equals("")) {
			msj+="Ingrese una fecha inicial para hacer una busqueda";
		}
		if (fechaInicial.getText()==null || fechaFinal.getText().trim().equals("")) {
			msj+="\n\nIngrese una fecha final para establecer un límite para la busqueda";
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			System.out.println(msj);
		}
		return sonValidos;
	}

	/**
	 * Método que se ejecuta al presionar el botón "Volver"
	 * Cierra la ventana actual.
	 */
	@FXML
	private void volver() {
		reporteStage.close();
	}
	
	@FXML
	private void buscar() {
		if (existenCamposVacios()) {
			Concesionario tempPerson = new Concesionario();
	        LocalDate fechaIni = LocalDate.parse(fechaInicial.getText());
	        LocalDate fechaFin = LocalDate.parse(fechaFinal.getText());
	        List<Transaccion> transaccionesEnRango = new ArrayList<>();
//	        for ( registroTransaccion : tempPerson.getListaRegistroTransacciones()) {
//				for(Transaccion transaccion : registroTransaccion.getListaTransacciones())
//				{
//					if (registroTransaccion.estaFechaRango(fechaIni, fechaFin)) {
//	                	transaccionesEnRango.add(transaccion);
//	            	}
//				}
//	           
//	        }
        tablaTransacciones.setItems(FXCollections.observableArrayList(transaccionesEnRango));
    }
	}
	
	//al cerrar la ventana de reportes se activa el metodo CerrarVentana para guardar los datos de Concesionario
	//llamar en ventana.setOnCloseRequest
	public void CerrarVentana(){
		Concesionario.conce.guardar();
	}
	
}
