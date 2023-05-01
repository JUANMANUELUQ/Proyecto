package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {
	
	@FXML
	private TextField nombre;
	@FXML
	private TextField correo;
	@FXML
	private TextField contrasenia;
	private Aplicacion aplicacion;
	private Stage primaryStage;
	private Concesionario concesionario;
	
	public LoginController() {
		
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	public boolean existenCamposVacios() {
		boolean sonValidos=true;
		String msj="";
		if (nombre.getText()==null || nombre.getText().trim().equals("")) {
			msj+="El nombre no debe estar vacio";
		}
		if (correo.getText()==null || correo.getText().trim().equals("")) {
			msj+="\n\nEl correo no debe estar vacio";
		}
		if (contrasenia.getText()==null || contrasenia.getText().trim().equals("")) {
			msj+="\n\nLa contrase\u00F1a no debe estar vacia";
		}
		if (msj.equals("")) {
			sonValidos=false;
		} else {
			JOptionPane.showMessageDialog(null, msj,"",JOptionPane.WARNING_MESSAGE);
		}
		return sonValidos;
	}
	
	public void iniciarSesionAdministrador() {
		primaryStage.close();
		aplicacion.mostrarVentanaPrincipalAdministrador();
	}
	
	public void iniciarSesionEmpleado() {
		aplicacion.mostrarEmpleadoVentanaPrincipal();
		primaryStage.close();
	}
	
	@FXML
	private void Ingresar() {
		String tipoUsuario;
		if (!existenCamposVacios()) {
			if (concesionario.existeUsuario(nombre.getText(), correo.getText(), contrasenia.getText())) {
				tipoUsuario=concesionario.obtenerTipoCuenta(nombre.getText(), correo.getText(), contrasenia.getText());
				switch (tipoUsuario) {
					case "Administrador": iniciarSesionAdministrador(); break;
					case "Empleado": iniciarSesionEmpleado(); break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe una cuenta con los datos ingresados","Cuenta no encontrada", JOptionPane.WARNING_MESSAGE);
			}
		}
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
