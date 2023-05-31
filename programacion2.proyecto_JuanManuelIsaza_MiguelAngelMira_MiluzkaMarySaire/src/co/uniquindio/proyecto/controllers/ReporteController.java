package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Cursor;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase controladora encargada de gestionar la ventana de reportes de transacciones.
 */
public class ReporteController {
	
	@FXML
	private ComboBox tipoTransaccion;
	@FXML
	private DatePicker fechaInicial;
	@FXML
	private DatePicker fechaFinal;
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
	private TableColumn<Transaccion,String> columnaDiasAlquiler;
	@FXML
	private TableView<DetalleTransaccion> tableDetallesTransaccion;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaSubtotal;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaCantidad;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnaVehiculo;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Aplicacion aplicacion=mfm.getAplicacion();
	private Stage ventana;
	
	/**
	 * Constructor de la clase ReporteController.
	 */
	public ReporteController() {
		
	}
	
	/**
     * Actualiza la tabla de detalles de transacciones con la información de una transacción específica.
     * @param transaccion La transacción de la cual se obtendrán los detalles.
     */
	public void actualizarTablaDetalles(Transaccion transaccion) {
		tableDetallesTransaccion.setItems(FXCollections.observableArrayList(transaccion.getListaDetalleTransacciones()));
		columnaSubtotal.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getSubTotal()));
		columnaCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getCantidad()));
		columnaVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getModelo()));
	}
	
	/**
     * Actualiza la tabla de transacciones con la lista de transacciones filtradas.
     * @param transaccionesFiltradas La lista de transacciones filtradas.
     */
	public void actualizarTabla(List<Transaccion> transaccionesFiltradas) {
		tablaTransacciones.setItems(FXCollections.observableArrayList(transaccionesFiltradas));
		columnaFecha.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getFecha()));
		columnaValor.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getValor()));
		columnaTipoTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().obtenerTipoTransaccionCadena()));
		columnaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleadoTransaccion().getNombre()));
		columnaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleadoTransaccion().getNombre()));
		columnaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
		columnaDiasAlquiler.setCellValueFactory(cellData -> {
			if (cellData.getValue().obtenerTipoTransaccion()==TipoTransaccion.ALQUILER) {
				return new SimpleStringProperty(""+((Alquiler)cellData.getValue()).getDiasAlquiler());
			} else {
				return new SimpleStringProperty("N/A");
			}
		}
		);
	}
	
	/**
     * Verifica si las fechas iniciales y finales están vacías.
     * @return true si ambas fechas están vacías, false en caso contrario.
     */
	public boolean sonFechasVacias() {
		boolean sonVacias=false;
		if (fechaInicial.getValue()==null && fechaFinal.getValue()==null) {
			sonVacias=true;
		}
		return sonVacias;
	}
	
	/**
     * Verifica si ninguna de las fechas iniciales o finales está vacía.
     * @return true si ninguna de las fechas está vacía, false en caso contrario.
     */
	public boolean esNingunaFechaVacia() {
		boolean noSonVacias=false;
		if (!(fechaInicial.getValue()==null) && !(fechaFinal.getValue()==null)) {
			noSonVacias=true;
		}
		return noSonVacias;
	}
	
	/**
     * Obtiene el tipo de transacción seleccionado.
     * @return El tipo de transacción seleccionado.
     */
	public TipoTransaccion obtenerTipoTransaccion() {
		TipoTransaccion tipoTransacion=null;
		switch(""+tipoTransaccion.getValue()) {
			case "Alquiler": tipoTransacion=TipoTransaccion.ALQUILER; break;
			case "Venta": tipoTransacion=TipoTransaccion.VENTA; break;
			case "Compra": tipoTransacion=TipoTransaccion.COMPRA; break;
		}
		return tipoTransacion;
	}
	
	/**
     * Verifica si los datos ingresados son válidos.
     * @return true si todos los campos están llenos, false si hay campos vacíos.
     */
	public boolean sonDatosValidos() {
		
		boolean sonValidos=false;
		String msj="";
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!sonFechasVacias() && !esNingunaFechaVacia()) {
			msj+="Debe ingresar ambas fechas o ninguna";
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
		}
		return sonValidos;
	}
	
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		fechaInicial.setEditable(false);
		fechaInicial.setStyle("-fx-background-color: #aaaaaa;");
		fechaInicial.getEditor().setStyle("-fx-background-color: #cccccc;");
		fechaFinal.setEditable(false);
		fechaFinal.setStyle("-fx-background-color: #aaaaaa;");
		fechaFinal.getEditor().setStyle("-fx-background-color: #cccccc;");
		ObservableList<String> tiposTransacciones=FXCollections.observableArrayList();
		tiposTransacciones.add("Todas");
		tiposTransacciones.add("Alquiler");
		tiposTransacciones.add("Venta");
		tiposTransacciones.add("Compra");
		tipoTransaccion.setItems(tiposTransacciones);
		tipoTransaccion.setValue("Todas");
		actualizarTabla(mfm.obtenerTransaccionesFiltradas(null, null, null));
	}

	/**
     * Cierra la ventana actual.
     */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
     * Realiza la búsqueda de transacciones según los filtros especificados.
     */
	@FXML
	private void buscar() {
		if (sonDatosValidos()) {
				LocalDate fechaInicial=null;
				LocalDate fechaFinal=null;
			if (!sonFechasVacias()) {
				fechaInicial=this.fechaInicial.getValue();
				fechaFinal=this.fechaFinal.getValue();
			}
			TipoTransaccion tipoTransaccion=obtenerTipoTransaccion();
			actualizarTabla(mfm.obtenerTransaccionesFiltradas(tipoTransaccion, fechaInicial, fechaFinal));
		}
	}
	
	/**
     * Actualiza la tabla de detalles de transacciones al seleccionar una transacción en la tabla principal.
     */
	@FXML
	public void seleccionTransaccion() {
		int selectedIndex = tablaTransacciones.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Transaccion transaccion = tablaTransacciones.getSelectionModel().getSelectedItem();
			actualizarTablaDetalles(transaccion);
		} 
	}
	
	/**
     * Muestra la información del empleado que realizó la transacción.
     */
	@FXML
	private void verEmpleado() {
		int selectedIndex = tablaTransacciones.getSelectionModel().getSelectedIndex();
		String msj="";
		if (selectedIndex >= 0) {
			Transaccion transaccion = tablaTransacciones.getSelectionModel().getSelectedItem();
			Empleado empleado=transaccion.getEmpleadoTransaccion();
			msj+="Nombre: "+empleado.getNombre();
			msj+="\n\nDocumento: "+empleado.getDocumento();
			msj+="\n\nCorreo elecronico: "+empleado.getCorreo();
			ClaseUtilitaria.mostrarMensaje("Informacion del empleado que realizo la transaccion", "Informacion del empleado que realizo la transaccion",
			msj, AlertType.INFORMATION);
		} else {
			ClaseUtilitaria.mostrarMensaje("Transaccion no seleccionada", "Transaccion no seleccionada", "Debe seleccionar una transaccion", AlertType.WARNING);
		}
	}
	
	/**
     * Abre la vista del vehículo correspondiente al detalle de transacción seleccionado.
     */
	@FXML
	private void verVehiculo() {
		int selectedIndex = tableDetallesTransaccion.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			DetalleTransaccion detalle = tableDetallesTransaccion.getSelectionModel().getSelectedItem();
			Vehiculo vehiculo=detalle.getVehiculo();
			aplicacion.mostrarVistaVehiculo(ventana,vehiculo);
		} else {
			ClaseUtilitaria.mostrarMensaje("Detalle de transaccion no seleccionado", "Detalle de transaccion no seleccionado", 
			"Debe seleccionar un detalle de una transaccion", AlertType.WARNING);
		}
	}
	
	/**
     * Muestra la información del cliente al que se le realizó la transacción.
     */
	@FXML
	private void verCliente() {
		int selectedIndex = tablaTransacciones.getSelectionModel().getSelectedIndex();
		String msj="";
		if (selectedIndex >= 0) {
			Transaccion transaccion = tablaTransacciones.getSelectionModel().getSelectedItem();
			Cliente cliente=transaccion.getCliente();
			msj+="Nombre: "+cliente.getNombre();
			msj+="\n\nDocumento: "+cliente.getDocumento();
			ClaseUtilitaria.mostrarMensaje("Informacion del cliente que se le realizo la transaccion", "Informacion del cliente que se le realizo la transaccion", 
			msj, AlertType.INFORMATION);
		} else {
			ClaseUtilitaria.mostrarMensaje("Transaccion no seleccionada", "Transaccion no seleccionada", "Debe seleccionar una transaccion", AlertType.WARNING);
		}
	}
	
    /**
     * Establece la ventana actual.
     * @param ventana La ventana actual.
     */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
}
