package co.uniquindio.proyecto.controllers;

import java.util.List;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana de ingreso y registro de transacciones.
 */
public class IngresoTransaccionController {
	
	@FXML
	private ComboBox tipoTransaccion;
	@FXML
	private TextField txtDiasAlquiler;
	@FXML
	private Label lblNombre;
	@FXML
	private Label lblDocumento;
	@FXML
	private TableView<Cliente> tableClientes;
	@FXML
	private TableColumn<Cliente,String> columnNombre;
	@FXML
	private TableColumn<Cliente,String> columnDocumento;
	@FXML
	private TableView<DetalleTransaccion> tableDetallesTransaccion;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnVehiculo;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnCantidad;
	@FXML
	private TableColumn<DetalleTransaccion,String> columnSubtotal;
	@FXML
	private Label lblTotal;
	@FXML
    private Button btnAgregarDetalle;
	@FXML
    private Button btnSeleccionarVehiculo;

	private ModelFactoryController mfm = ModelFactoryController.getInstance();  // Instancia de ModelFactoryController para acceder a sus métodos
	private Stage ventana=mfm.getVentana(); // Ventana actual
	private Aplicacion aplicacion=mfm.getAplicacion(); // Aplicacion principal
	private Empleado empleado; // Emplado que registra la transaccion
	private Cliente cliente; // Cliente realiza la transaccion
	private List<DetalleTransaccion> listaDetallesTransaccion=new ArrayList<DetalleTransaccion>(); // Lista de los detalles de cada transaccion
	private List<Vehiculo> listaVehiculosTemporales= mfm.obtenerCopiaVehiculos();
	
	/**
	 * Verifica si el tipo de transacción seleccionado requiere un dato único (días de alquiler en este caso).
	 * @return true si el tipo de transacción requiere un dato único, false si no lo requiere.
	 */
	public boolean tieneDatoUnico() {
		boolean respuesta=true;
		if ((""+tipoTransaccion.getValue()).equals("Alquiler")) {
			if (txtDiasAlquiler.getText()==null || txtDiasAlquiler.getText().trim().equals("")) {
				respuesta=false;
			}
		}
		return respuesta;
	}
	
	/**
	 * Verifica si los datos ingresados son válidos.
	 * @return true si los datos son válidos, false si no lo son.
	 */
	public boolean verificarDatos() {
		boolean sonDatosValidos=false;
		String msj="";
		if (tipoTransaccion.getValue()==null || ((String) tipoTransaccion.getValue()).trim().equals("")) {
			msj+="Debe seleccionar un tipo de transaccion";
		} else if (!tieneDatoUnico()) {
			msj+="\n\nLos dias de alquiler no deben estar vacios";
		}
		if (cliente==null) {
			msj+="\n\nDebe seleccionar un usuario para realizar la transaccion";
		}
		if (listaDetallesTransaccion.size()==0) {
			msj+="\n\nDebe poner por lo menos un detalle de la transaccion";
		}
		if (msj.equals("")) {
			sonDatosValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Datos no validos", "Datos no validos", msj, AlertType.ERROR);
		}
		return sonDatosValidos;
	}
	
	
	/**
	 * Verifica si los datos ingresados son válidos.
	 * @return true si los datos son válidos, false si no lo son.
	 */
	public boolean verificarDatosParaCompras() {
		boolean sonDatosValidos=false;
		String msj="";
		if (tipoTransaccion.getValue()==null || ((String) tipoTransaccion.getValue()).trim().equals("")) {
			msj+="Debe seleccionar un tipo de transaccion";
		} else if (!tieneDatoUnico()) {
			msj+="\n\nLos dias de alquiler no deben estar vacios";
		}
		if (cliente==null) {
			msj+="\n\nDebe seleccionar un usuario para realizar la transaccion";
		}
		if (msj.equals("")) {
			sonDatosValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Datos no validos", "Datos no validos", msj, AlertType.ERROR);
		}
		return sonDatosValidos;
	}
	
	/**
	 * Actualiza la tabla de detalles de transacción.
	 */
	public void actualizarTabla() {
		ObservableList<DetalleTransaccion> listaDetallesProperty=FXCollections.observableArrayList();
		for (DetalleTransaccion detalle : listaDetallesTransaccion) {
			listaDetallesProperty.add(detalle);
			
		}
		
		tableDetallesTransaccion.setItems(listaDetallesProperty);
		columnVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getModelo()));
		columnCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getCantidad()));
		columnSubtotal.setCellValueFactory(cellData -> {
	        Double subtotal = cellData.getValue().getSubTotal();
	        String subtotalFormateado = String.format("%.0f", subtotal); // Formato completo sin decimales
	        return new SimpleStringProperty(subtotalFormateado);
	    });
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
		
		
		//llenar combobox
		ObservableList<String> tiposTransacciones=FXCollections.observableArrayList();
		tiposTransacciones.add("Alquiler");
		tiposTransacciones.add("Venta");
		tiposTransacciones.add("Compra");
		tipoTransaccion.setItems(tiposTransacciones);
		
		//llenar Tabla clientes
		tableClientes.getItems().clear();
		
		//establece para alquiler
		txtDiasAlquiler.setEditable(false);
		txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
		txtDiasAlquiler.setText("N/A");
		
		//no deberia ser listaClientesProperty??
		ObservableList<Cliente> listaEmpleadosProperty=FXCollections.observableArrayList();
		for (Cliente cliente : mfm.obtenerClientes()) {
			listaEmpleadosProperty.add(cliente);
		}
		tableClientes.setItems(listaEmpleadosProperty);
		
		//columna nombre y documento
		columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		columnDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
		
		//total en formato NO exponencial, ej 7E90
		double total = ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion);
		String totalFormateado = String.format("%.0f", total); // Formato completo sin decimales
		lblTotal.setText(totalFormateado);

		
		btnAgregarDetalle.setVisible(false);
		
		listaVehiculosTemporales= mfm.obtenerCopiaVehiculos();
	}
	
	/**	 
	 * Método que bloquea las acciones dependiendo del tipo de transacción seleccionado.
	 * Si el tipo de transacción es "Alquiler", habilita la edición del campo de días de alquiler.
	 * Si el tipo de transacción es "Venta" o "Compra", deshabilita la edición del campo de días de alquiler.
	 */
	@FXML
	private void bloquearAcciones() {  //CADA VEZ QUE EL COMBO BOX SE USE, DE MANERA QUE SE ACTUALICE CUANDO SE CAMBIE DE TIPODETRANS
		if (listaDetallesTransaccion.size()>0) {
			listaDetallesTransaccion.clear();
			actualizarTabla();
		}
		switch(""+tipoTransaccion.getValue()) {
			case "Alquiler": 
				txtDiasAlquiler.setEditable(true);
				txtDiasAlquiler.setStyle(null);
				txtDiasAlquiler.setText("");
				btnAgregarDetalle.setVisible(false);
				btnSeleccionarVehiculo.setVisible(true);
				break;
			case "Venta": 
				txtDiasAlquiler.setEditable(false);
				txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
				txtDiasAlquiler.setText("N/A");
				btnAgregarDetalle.setVisible(false);
				btnSeleccionarVehiculo.setVisible(true);
				break;
			case "Compra":
				txtDiasAlquiler.setEditable(false);
				txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
				txtDiasAlquiler.setText("N/A");
				btnAgregarDetalle.setVisible(true);
				btnSeleccionarVehiculo.setVisible(false);
				break;
		}
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Volver"
	 * Cierra la ventana actual.
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Agregar Detalle"
	 * Muestra la ventana de ingreso de compra y actualiza la tabla de detalles de transacción.
	 */
	@FXML
	private void agregarDetalle() {  //SOLO PARA VENTA DE VEHICULOS DE CLIENTES AL CONCESIONARIO
		
		if (verificarDatosParaCompras()) {
			DetalleTransaccion detalleObtenido;
			detalleObtenido=aplicacion.mostrarIngresoCompra(ventana,null);
			if (detalleObtenido!=null) {
				listaDetallesTransaccion.add(detalleObtenido);
				actualizarTabla();
				
				double total = ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion);
				String totalFormateado = String.format("%.0f", total); // Formato completo sin decimales
				lblTotal.setText(totalFormateado);
				//nueva posible lista de vehiculos
				listaVehiculosTemporales= mfm.retornarPosiblesVehiculos();

			}
		}
		
	
		
	}
	

	/**
	 * Método que se ejecuta al presionar el botón "Editar Detalle".
	 * Muestra un mensaje de advertencia indicando que la función está en desarrollo.
	 */
	@FXML
	private void editarDetalle() {
		int selectedIndex = tableDetallesTransaccion.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			DetalleTransaccion detalleElejido= tableDetallesTransaccion.getSelectionModel().getSelectedItem();
			switch(""+tipoTransaccion.getValue()) {
				case "Alquiler": 
					
					break;
				case "Venta": 
					
					break;
				case "Compra": 
					DetalleTransaccion detalle=aplicacion.mostrarIngresoCompra(ventana,detalleElejido);
					if (detalle!=detalleElejido) {
						int pos=listaDetallesTransaccion.indexOf(detalleElejido);
						listaDetallesTransaccion.set(pos,detalle);
						actualizarTabla();
						
						double total = ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion);
						String totalFormateado = String.format("%.0f", total); // Formato completo sin decimales
						lblTotal.setText(totalFormateado);
					
					}
					break;
			}
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un detalle transaccion seleccionado", "No hay un detalle transaccion seleccionado", 
					"Elija un detalle transaccion", AlertType.ERROR);
		}
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Guardar".
	 * Verifica si los datos ingresados son válidos y cierra la ventana si lo son.
	 */
	@FXML
	private void guardar() {
		if (verificarDatos()) {
			Transaccion transaccion=null;
			switch(""+tipoTransaccion.getValue()) {
				case "Alquiler": 
					transaccion=new Alquiler(Double.parseDouble(lblTotal.getText()),empleado,cliente,LocalDate.now(),listaDetallesTransaccion,
					Integer.parseInt(txtDiasAlquiler.getText()));
					break;
				case "Venta": 
					transaccion=new Venta(Double.parseDouble(lblTotal.getText()),empleado,cliente,LocalDate.now(),listaDetallesTransaccion);
					break;
				case "Compra": 
						transaccion=new Compra(Double.parseDouble(lblTotal.getText()),empleado,cliente,LocalDate.now(),listaDetallesTransaccion);
					break;
			}
			
			listaVehiculosTemporales=mfm.retornarPosiblesVehiculos();
			mfm.actualizarListaVehiculos(listaVehiculosTemporales);
			mfm.agregarTransaccion(transaccion,listaVehiculosTemporales);
			Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
			ventana.close();
		}
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Eliminar Detalle".
	 * Obtiene el detalle de transacción seleccionado y lo elimina de la tabla y la lista de detalles de transacción.
	 * Muestra un mensaje de error si no se ha seleccionado ningún detalle de transacción.
	 */
	@FXML
	private void eliminarDetalle() {
		int selectedIndex = tableDetallesTransaccion.getSelectionModel().getSelectedIndex();
		DetalleTransaccion detalle= tableDetallesTransaccion.getSelectionModel().getSelectedItem();
		String tipoSeleccion=""+tipoTransaccion.getValue();
		if (tipoSeleccion.equals("Compra")) {
			if (selectedIndex >= 0) {
				ClaseUtilitaria.reducirCantidadVehiculo(listaVehiculosTemporales, detalle.getVehiculo(), detalle.getCantidad());;
				tableDetallesTransaccion.getItems().remove(selectedIndex);
				listaDetallesTransaccion.remove(detalle);
				lblTotal.setText("0");
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un detalle transaccion seleccionado", "No hay un detalle transaccion seleccionado", 
			"Elija un detalle transaccion", AlertType.ERROR);
		}
		}else {
			if (selectedIndex >= 0) {
				
				ClaseUtilitaria.aumentarCantidadVehiculo(listaVehiculosTemporales, detalle.getVehiculo(), detalle.getCantidad());
				tableDetallesTransaccion.getItems().remove(selectedIndex);
				listaDetallesTransaccion.remove(detalle);
				lblTotal.setText("0");
			} else {
				ClaseUtilitaria.mostrarMensaje("No hay un detalle transaccion seleccionado", "No hay un detalle transaccion seleccionado", 
				"Elija un detalle transaccion", AlertType.ERROR);
			}
		}
		
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Seleccionar Cliente"
	 * Obtiene el cliente seleccionado de la tabla y actualiza los campos de nombre y documento en la interfaz.
	 * Muestra un mensaje de error si no se ha seleccionado ningún cliente.
 	 */
	@FXML
	private void seleccionarCliente() {
		int selectedIndex = tableClientes.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			cliente = tableClientes.getSelectionModel().getSelectedItem();
			lblNombre.setText(cliente.getNombre());;
			lblDocumento.setText(cliente.getDocumento());
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un cliente seleccionado", "No hay un cliente seleccionado", "Elija un cliente", AlertType.ERROR);
		}
	}

	/**
	 * Establece el empleado que realiza la transacción.
	 * @param empleado El empleado que realiza la transacción.
	 */
	public void obtenerEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}

	/**
	 * Establece la ventana de la transacción.
	 * @param ventana La ventana de la transacción.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Seleccionar Vehiculo"
	 * Abre la ventana para seleccionar un vehiculo en caso de venta o alquiler
	 */
	@FXML
	private void seleccionarVehiculo() {
		if (!((""+tipoTransaccion.getValue()).equals("Alquiler") || (""+tipoTransaccion.getValue()).equals("Venta"))) {
			ClaseUtilitaria.mostrarMensaje("Tipo de transaccion no seleccionada", "Tipo de transaccion no seleccionada", 
			"Debe seleccionar un tipo de transaccion", AlertType.ERROR);
		} else {
			DetalleTransaccion detalleObtenido;
			detalleObtenido=aplicacion.mostrarVentanaVehiculos(ventana,listaVehiculosTemporales);
			if (detalleObtenido!=null) {
				listaDetallesTransaccion.add(detalleObtenido);
				actualizarTabla();
				double total = ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion);
				String totalFormateado = String.format("%.0f", total); // Formato completo sin decimales
				lblTotal.setText(totalFormateado);
				//nueva posible lista de vehiculos
				listaVehiculosTemporales= mfm.retornarPosiblesVehiculos();
			}
		}
	}

}
