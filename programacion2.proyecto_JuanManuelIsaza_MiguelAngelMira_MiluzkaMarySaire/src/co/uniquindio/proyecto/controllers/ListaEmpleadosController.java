package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import co.uniquindio.proyecto.util.Persistencia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana de la vista de la lista de empleados.
 */
public class ListaEmpleadosController {
	
	@FXML
	private TableView<Empleado> tablaEmpleados;
	@FXML
	private TableColumn<Empleado,String> columnaNombre;
	@FXML
	private TableColumn<Empleado,String> columnaDocumento;
	@FXML
	private TableColumn<Empleado,String> columnaCorreo;
	@FXML
	private TableColumn<Empleado,String> columnaEstado;
	private Aplicacion aplicacion;
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana=mfm.getVentana();
	private ObservableList<Empleado> listaEmpleadosProperty;

	/**
	 * Establece la aplicación principal.
	 * @param aplicacion La instancia de la aplicación principal.
	 */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}

	/**
	 * Metodo que actualiza la tabla de empleados con la lista de empleados actualizada.
	 */
	public void actualizarTabla() {
		tablaEmpleados.getItems().clear();
		ObservableList<Empleado> listaEmpleadosProperty=FXCollections.observableArrayList();
		for (Empleado empleado : mfm.obtenerEmpleados()) {
			listaEmpleadosProperty.add(empleado);
		}
		tablaEmpleados.setItems(listaEmpleadosProperty);
		columnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		columnaDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
		columnaCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
		columnaEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().obtenerEstadoCadena()));
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Agregar Empleado"
	 * Agrega un nuevo empleado.
	 */
	@FXML
	private void agregarEmpleado() {
		if (aplicacion.mostrarIngresosDatosEmpleados(ventana,EmpleadoAccion.AGREGAR,null)) {
			Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
			actualizarTabla();
		}
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Actualizar Datos".
	 * Actualiza los datos de un empleado seleccionado.
	 */
	@FXML
	private void actualizarDatos() {
		int selectedIndex = tablaEmpleados.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Empleado empleadoSeleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
			if (aplicacion.mostrarIngresosDatosEmpleados(ventana,EmpleadoAccion.ACTUALIZAR,empleadoSeleccionado)) {
				Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
				actualizarTabla();
			}
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un empleado seleccionado", "No hay un empleado seleccionado", "Elija un empleado", AlertType.ERROR);
		}
	}

	/**
	 * Método que se ejecuta al presionar el botón "Bloquear"
	 * Bloquea o desbloquea un empleado seleccionado.
	 */
	@FXML
	private void bloquear() {
		int selectedIndex = tablaEmpleados.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Empleado empleadoSeleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
			switch(empleadoSeleccionado.getEstado()) {
				case ACTIVO:empleadoSeleccionado.setEstado(EstadoUsuario.BLOQUEADO); break;
				case BLOQUEADO:empleadoSeleccionado.setEstado(EstadoUsuario.ACTIVO); break;
			}
			Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
			actualizarTabla();
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un grupo seleccionado", "No hay un grupo seleccionado", "Elija un empleado", AlertType.ERROR);
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
	 * Establece la ventana principal.
	 * @param ventana La ventana principal.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

}
