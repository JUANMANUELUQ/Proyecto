package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Concesionario;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana principal para el administrador.
 */
public class VentanaPrincipalAdministradorController {
	
	
	
	private Aplicacion aplicacion;
	private Stage primaryStage;
	
	/**
	 * Inicializa la clase controladora.
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Reportes" * Muestra un mensaje indicando que la función está en construcción.
	 */
	@FXML
	private void reportes() {
		JOptionPane.showMessageDialog(null, "En construccion", "Funcion en desarrollo", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Empleados"
	 * Abre la ventana de lista de empleados.
	 */
	@FXML
	private void empleados() {
		aplicacion.mostrarListaEmpleados();
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Cerrar Sesión"
	 * Abre la ventana de lista de empleados.
	 */
	@FXML
	private void cerrarSesion() {
		aplicacion.mostrarLogin();
	}

	/**
	 * Establece la aplicación principal.
	 * @param aplicacion La aplicación principal.
	 */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}

	/**
	 * Establece la ventana principal.
	 * @param primaryStage La ventana principal.
	 */
	public void setVentana(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}

}
