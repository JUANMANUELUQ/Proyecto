package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana principal para empleados.
 */
public class VentanaPrincipalEmpleadoController {
	
	private Aplicacion aplicacion;
	private Stage primaryStage;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Empleado empleado;
	
	/**
	 * Método que se ejecuta al presionar el botón "Cambiar Contraseña"
	 * Abre la ventana de cambio de contraseña.
	 */
	@FXML
	private void cambiarContrasenia() {
		aplicacion.mostrarCambioContrasenia(primaryStage,empleado);
	}

	/**
	 * Método que se ejecuta al presionar el botón "Realizar Transaccion"
	 * Abre la ventana de realización de transacciones.
	 */
	@FXML
	private void realizarTransaccion() {
		aplicacion.mostrarIngresoTransaccion(primaryStage, empleado);
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Usuarios"
	 * Abre la ventana de gestión de usuarios.
	 */
	@FXML
	private void usuarios() {
		aplicacion.mostrarIngresoUsuarios(primaryStage);
	}

	/**
	 * Método que se ejecuta al presionar el botón "Volver"
	 * Cierra la sesión del empleado y muestra la ventana de inicio de sesión.
	 */
	@FXML
	private void volver() {
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

	/**
	 * Metodo que obtiene el Empleado asociado a esta ventana.
	 * @param empleado El objeto de Empleado.
	 */
	public void obtenerEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}

}
