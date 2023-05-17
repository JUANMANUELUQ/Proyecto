package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.model.Concesionario;
import co.uniquindio.proyecto.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase controlador encargada de gestionar la ventana de cambio de contraseña.
 */
public class CambioContraseniaController {
	
	@FXML
	private TextField contraseniaAntigua;
	@FXML
	private TextField contraseniaNueva;
	@FXML
	private TextField contraseniaConfirmacion;
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance(); // Instancia de ModelFactoryController para acceder a sus métodos
	private Stage ventana=mfm.getVentana(); // Ventana actual
	private Usuario usuario; //Usuario a modificar 
	
	/**
 	 * Verifica si las contraseñas nuevas coinciden.
 	 * @return true si las contraseñas nuevas coinciden, false de lo contrario
	 */
	public boolean contraseniasNuevasCoinciden() {
		boolean respuesta=false;
		if (contraseniaNueva.getText().trim().equals(contraseniaConfirmacion.getText().trim())) {
			respuesta=true;
		}
		return respuesta;
	}
	
	/**
 	 * Verifica si las contraseñas antiguas coinciden.
 	 * @return true si las contraseñas antiguas coinciden, false de lo contrario
 	 */
	public boolean contraseniasAntiguasCoinciden() {
		boolean respuesta=false;
		if (contraseniaAntigua.getText().trim().equals(usuario.getContrasenia())) {
			respuesta=true;
		}
		return respuesta;
	}
	
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Volver".
	 * Cierra la ventana actual.
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Guardar".
	 * Verifica las contraseñas ingresadas y actualiza a niega la actualización de contraseña.
	 */
	@FXML
	private void guardar() {
		if (sonDatosValidos()) {
			if (contraseniasNuevasCoinciden()) {
				if (contraseniasAntiguasCoinciden()) {
					usuario.setContrasenia(contraseniaNueva.getText().trim());
					ventana.close();
				} else {
					JOptionPane.showMessageDialog(null, "Contrasenia antigua incorrecta", "Contrasenias no coinciden", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "La nueva contrasenia y su confirmacion no son iguales", "Contrasenias no coinciden", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
 	 * Verifica si los datos ingresados son válidos.
 	 * @return true si los datos son válidos, false de lo contrario
	 */
	public boolean sonDatosValidos() {
		boolean sonValidos=false;
		String msj="";
		if (contraseniaAntigua.getText()==null || contraseniaAntigua.getText().trim().equals("")) {
			msj+="La contrasenia antigua no debe estar vacia";
		}
		if (contraseniaNueva.getText()==null || contraseniaNueva.getText().trim().equals("")) {
			msj+="\n\nLa contrasenia nueva no debe estar vacia";
		}
		if (contraseniaConfirmacion.getText()==null || contraseniaConfirmacion.getText().trim().equals("")) {
			msj+="\n\nDebe confirmar la contrasenia nueva, la confirmacion no debe estar vacia";
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			JOptionPane.showMessageDialog(null, msj, "Entradas no validas", JOptionPane.ERROR_MESSAGE);
		}
		return sonValidos;
	}

	/**
	 * Establece el usuario actual.
	 * @param usuario el usuario actual
	 */
	public void obtenerUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	/**
	 * Establece la ventana actual.
	 * @param ventana la ventana actual
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

}
