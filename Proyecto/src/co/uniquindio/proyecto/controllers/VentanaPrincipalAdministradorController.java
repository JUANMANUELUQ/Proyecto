package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Concesionario;
import javafx.fxml.FXML;
import javafx.stage.Stage;


public class VentanaPrincipalAdministradorController {
	
	
	
	private Aplicacion aplicacion;
	private Stage primaryStage;
	private Concesionario concesionario;
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void reportes() {
		JOptionPane.showMessageDialog(null, "En construccion", "Funcion en desarrollo", JOptionPane.WARNING_MESSAGE);
	}
	
	@FXML
	private void empleados() {
		aplicacion.mostrarListaEmpleados();
	}
	
	@FXML
	private void cerrarSesion() {
		aplicacion.mostrarLogin();
	}

	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}

	public void setVentana(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario=concesionario;
	}

}
