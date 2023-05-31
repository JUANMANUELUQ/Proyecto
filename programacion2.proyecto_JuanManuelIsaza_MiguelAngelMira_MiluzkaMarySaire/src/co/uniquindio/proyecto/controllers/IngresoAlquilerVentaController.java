package co.uniquindio.proyecto.controllers;

import java.util.List;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Clase controlador encargada de gestionar la ventana para el ingreso de datos para de un alquiler o venta.
 */
public class IngresoAlquilerVentaController {
	
	@FXML
	private TextField txtSubtotal;
	@FXML
	private TextField txtCantidad;
	@FXML
	private TableView<Vehiculo> tableVehiculos;
	@FXML
	private TableColumn<Vehiculo,String> columnModelo;
	@FXML
	private TableColumn<Vehiculo,String> columnCantidadDisponible;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Aplicacion aplicacion=mfm.getAplicacion();
	private Stage ventana;
	private TipoTransaccion tipoTransaccion;
	private DetalleTransaccion detalleObtenido=null;
	List<Vehiculo> vehiculosTemporales;
	
	/**
	 * Verifica si los datos ingresados por el usuario son válidos.
	 * @return true si los datos son válidos, false de lo contrario.
	 */
	public boolean sonDatosValidos() {
		boolean sonValidos=false;
		String msj="";
		try {
			if (Double.parseDouble(txtSubtotal.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtSubtotal.getText().trim().equals("")) {
				msj+="\n\nEl subtotal no debe estar vacio";
			} else {
				msj+="\n\nSubtotal no valido";
			}
		}
		try {
			if (Integer.parseInt(txtCantidad.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCantidad.getText().trim().equals("")) {
				msj+="\n\nLa cantidad no debe estar vacia";
			} else {
				msj+="\n\nCantidad no valido";
			}
		}
		if (tableVehiculos.getSelectionModel().getSelectedIndex() < 0) {
			msj+="\n\nDebe elejir un vehiculo";
		} else {
			Vehiculo vehiculo=tableVehiculos.getSelectionModel().getSelectedItem();
			if (msj.equals("") && Integer.parseInt(txtCantidad.getText())>
			ClaseUtilitaria.obtenerCantidadVehiculo(vehiculo, vehiculosTemporales)) {
				msj+="\n\nLa cantidad indicada supera a la cantidad del vehiculo seleccionado";
			}
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
		}
		return sonValidos;
	}
	
	/**
	 * Actualiza la tabla de vehículos con la lista de vehículos temporales.
	 */
	public void actualizarTabla() {
		tableVehiculos.setItems(ClaseUtilitaria.organizarListaVehiculos(vehiculosTemporales));
		columnModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
		columnCantidadDisponible.setCellValueFactory(cellData -> new SimpleStringProperty(
		""+ClaseUtilitaria.obtenerCantidadVehiculo(cellData.getValue(), vehiculosTemporales)));
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Cierra la ventana actual.
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Muestra los detalles del vehículo seleccionado.
	 */
	@FXML
	private void verVehiculo() {
		int selectedIndex = tableVehiculos.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Vehiculo vehiculo = tableVehiculos.getSelectionModel().getSelectedItem();
			aplicacion.mostrarVistaVehiculo(ventana,vehiculo);
		} else {
			ClaseUtilitaria.mostrarMensaje("Vehiculo no seleccionado", "", "Debe seleccionar un vehiculo", AlertType.ERROR);
		}
	}
	
	/**
	 * Guarda los datos ingresados por el usuario en el detalle de la transacción.
	 * Si los datos son válidos, reduce la cantidad de vehículos disponibles y cierra la ventana.
	 */
	@FXML
	private void guardar() {
		if (sonDatosValidos()) {
			Vehiculo vehiculoEscogido = tableVehiculos.getSelectionModel().getSelectedItem();
			DetalleTransaccion detalle=new DetalleTransaccion(Double.parseDouble(txtSubtotal.getText()),Integer.parseInt(txtCantidad.getText()),
			vehiculoEscogido);
			ClaseUtilitaria.reducirCantidadVehiculo(vehiculosTemporales,vehiculoEscogido,Integer.parseInt(txtCantidad.getText()));
			detalleObtenido=detalle;
			ventana.close();
		}
	}

	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
	/**
	 * Obtiene el detalle de la transacción.
	 * @return El detalle de la transacción.
	 */
	public DetalleTransaccion detalleObtenido() {
		return detalleObtenido;
	}

	/**
	 * Obtiene el detalle de la transacción.
	 * @return El detalle de la transacción.
	 */
	public void obtenerVehiculosTemporales(List<Vehiculo> vehiculosTemporales) {
		this.vehiculosTemporales=vehiculosTemporales;
	}

}
