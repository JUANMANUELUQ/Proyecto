package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana del inicio de sesión para los usuarios.
 */
public class LoginController {
	
	@FXML
	private TextField nombre;
	@FXML
	private TextField correo;
	@FXML
	private TextField contrasenia;
	
	private Aplicacion aplicacion; //
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana=mfm.getVentana();

	/**
	 * Constructor de la clase LoginController.
	 */
	public LoginController() {
		
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}

	/**
	 * Metodo que verifica si existen campos vacíos en el formulario de inicio de sesión.
	 * @return true si hay campos vacíos, false si todos los campos están llenos.
	 */
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

	/**
	 * Metodo que inicia sesión para un usuario administrador.
	 */
	public void iniciarSesionAdministrador() {
		ventana.close();
		aplicacion.mostrarVentanaPrincipalAdministrador();
	}

	/**
	 * Metodo que inicia sesión para un empleado.
	 * @param empleado El objeto Empleado correspondiente al empleado que ha iniciado sesión.
	 */	
	public void iniciarSesionEmpleado(Empleado empleado) {
		ventana.close();
		aplicacion.mostrarEmpleadoVentanaPrincipal(empleado);
	}

	/**
	 * Método que se ejecuta al presionar el botón "Ingresar"
	 * Realiza el proceso de inicio de sesión cuando se presiona el botón "Ingresar".
	 */
	@FXML
	private void Ingresar() {
		String tipoUsuario;
		if (!existenCamposVacios()) {
			if (mfm.existeUsuario(nombre.getText(), correo.getText(), contrasenia.getText())) {
				if (mfm.estaEmpleadoBloqueado(nombre.getText(), correo.getText(), contrasenia.getText())) {
					JOptionPane.showMessageDialog(null, "El usuario esta bloqueado","Cuentabloqueada", JOptionPane.WARNING_MESSAGE);
				} else {
					tipoUsuario=mfm.obtenerTipoCuenta(nombre.getText(), correo.getText(), contrasenia.getText());
					switch (tipoUsuario) {
						case "Administrador": iniciarSesionAdministrador(); break;
						case "Empleado": iniciarSesionEmpleado((Empleado)
								mfm.obtenerUsuarioDatos(nombre.getText(), correo.getText(), contrasenia.getText())); break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe una cuenta con los datos ingresados","Cuenta no encontrada", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/**
	 * Establece la aplicación principal.
	 * @param aplicacion La aplicación principal.
	 */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}

	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
}
