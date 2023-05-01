package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ListaEmpleadosController {
	
	@FXML
	private TableView<Empleado> tablaEmpleados;
	@FXML
	private TableColumn<Empleado,String> columnaNombre;
	@FXML
	private TableColumn<Empleado,String> columnaDocumento;
	@FXML
	private TableColumn<Empleado,String> columnaCorreo;
	private Aplicacion aplicacion;
	private Concesionario concesionario;
	private Stage ventana;
	private ObservableList<Empleado> listaEmpleadosProperty;
	
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}

	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario=concesionario;
	}
	
	public void actualizarTabla() {
		tablaEmpleados.getItems().clear();
		ObservableList<Empleado> listaEmpleadosProperty=FXCollections.observableArrayList();
		for (Empleado empleado : concesionario.obtenerEmpleados()) {
			listaEmpleadosProperty.add(empleado);
		}
		tablaEmpleados.setItems(listaEmpleadosProperty);
		columnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		columnaDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
		columnaCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void agregarEmpleado() {
		if (aplicacion.mostrarIngresosDatosEmpleados(ventana,EmpleadoAccion.AGREGAR,null)) {
			actualizarTabla();
		}
	}
	
	@FXML
	private void actualizarDatos() {
		int selectedIndex = tablaEmpleados.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Empleado empleadoSeleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
			if (aplicacion.mostrarIngresosDatosEmpleados(ventana,EmpleadoAccion.ACTUALIZAR,empleadoSeleccionado)) {
				actualizarTabla();
			}
		} else {
			JOptionPane.showMessageDialog(null,"Elija un grupo","No hay un grupo seleccionado",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@FXML
	private void bloquear() {
		JOptionPane.showMessageDialog(null, "Funcion en construccion", "Funcion en desarrollo", JOptionPane.WARNING_MESSAGE);
	}
	
	@FXML
	private void volver() {
		ventana.close();
	}

}
