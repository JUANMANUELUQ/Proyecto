package co.uniquindio.proyecto.controllers;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance();  // Instancia de ModelFactoryController para acceder a sus métodos
	private Stage ventana=mfm.getVentana(); // Ventana actual
	private Aplicacion aplicacion; // Aplicacion principal
	private Empleado empleado; // Emplado que registra la transaccion
	private Cliente cliente; // Cliente realiza la transaccion
	private List<DetalleTransaccion> listaDetallesTransaccion=new ArrayList<DetalleTransaccion>(); // Lista de los detalles de cada transaccion
	
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
			JOptionPane.showMessageDialog(null, msj,"Datos no validos",JOptionPane.ERROR_MESSAGE);
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
		columnSubtotal.setCellValueFactory(cellData -> new SimpleStringProperty(""+cellData.getValue().getSubTotal()));
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		ObservableList<String> tiposTransacciones=FXCollections.observableArrayList();
		tiposTransacciones.add("Alquiler");
		tiposTransacciones.add("Venta");
		tiposTransacciones.add("Compra");
		tipoTransaccion.setItems(tiposTransacciones);
		tableClientes.getItems().clear();
		txtDiasAlquiler.setEditable(false);
		txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
		txtDiasAlquiler.setText("N/A");
		ObservableList<Cliente> listaEmpleadosProperty=FXCollections.observableArrayList();
		for (Cliente cliente : mfm.obtenerClientes()) {
			listaEmpleadosProperty.add(cliente);
		}
		tableClientes.setItems(listaEmpleadosProperty);
		columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		columnDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
		lblTotal.setText(""+ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion));
	}
	
	/**	 
	 * Método que bloquea las acciones dependiendo del tipo de transacción seleccionado.
	 * Si el tipo de transacción es "Alquiler", habilita la edición del campo de días de alquiler.
	 * Si el tipo de transacción es "Venta" o "Compra", deshabilita la edición del campo de días de alquiler.
	 */
	@FXML
	private void bloquearAcciones() {
		if (listaDetallesTransaccion.size()>0) {
			listaDetallesTransaccion.clear();
			actualizarTabla();
		}
		switch(""+tipoTransaccion.getValue()) {
			case "Alquiler": 
				txtDiasAlquiler.setEditable(true);
				txtDiasAlquiler.setStyle(null);
				txtDiasAlquiler.setText("");
				break;
			case "Venta": 
				txtDiasAlquiler.setEditable(false);
				txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
				txtDiasAlquiler.setText("N/A");
				break;
			case "Compra":
				txtDiasAlquiler.setEditable(false);
				txtDiasAlquiler.setStyle("-fx-background-color: #aaaaaa;");
				txtDiasAlquiler.setText("N/A");
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
	private void agregarDetalle() {
		
		switch(""+tipoTransaccion.getValue()) {
			case "Alquiler": 
				aplicacion.mostrarIngresoAlquilerVenta(ventana);
				break;
			case "Venta": 
				aplicacion.mostrarIngresoAlquilerVenta(ventana);
				break;
			case "Compra": 
				List<DetalleTransaccion> detalle=new ArrayList<DetalleTransaccion>();
				if (aplicacion.mostrarIngresoCompra(ventana,detalle)) {
					listaDetallesTransaccion.add(detalle.get(0));
					actualizarTabla();
					lblTotal.setText(""+ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion));
				}
				break;
				
			default: JOptionPane.showMessageDialog(null,"Elija un tipo de transaccion","No hay un tipo de transaccion seleccionado",JOptionPane.ERROR_MESSAGE);
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
					List<DetalleTransaccion> detalle=new ArrayList<DetalleTransaccion>();
					detalle.add(detalleElejido);
					if (aplicacion.mostrarIngresoCompra(ventana,detalle)) {
						int pos=listaDetallesTransaccion.indexOf(detalleElejido);
						listaDetallesTransaccion.set(pos,detalle.get(0));
						actualizarTabla();
						lblTotal.setText(""+ClaseUtilitaria.obtenerTotal(listaDetallesTransaccion));
					}
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null,"Elija un detalle transaccion","No hay un detalle transaccion seleccionado",JOptionPane.ERROR_MESSAGE);
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
					
					break;
				case "Venta": 
					
					break;
				case "Compra": 
						transaccion=new Compra(Double.parseDouble(lblTotal.getText()),empleado,cliente,LocalDate.now(),listaDetallesTransaccion);
					break;
			}
			mfm.agregarTransaccion(transaccion);
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
		if (selectedIndex >= 0) {
			DetalleTransaccion detalle= tableDetallesTransaccion.getSelectionModel().getSelectedItem();
			tableDetallesTransaccion.getItems().remove(selectedIndex);
			listaDetallesTransaccion.remove(detalle);
		} else {
			JOptionPane.showMessageDialog(null,"Elija un detalle transaccion","No hay un detalle transaccion seleccionado",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null,"Elija un cliente","No hay un cliente seleccionado",JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Establece la aplicación de la transacción.
	 * @param aplicacion La aplicación de la transacción.
	 */
	public void obtenerAplicacion(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
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

}
