package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.model.Cliente;
import co.uniquindio.proyecto.model.Empleado;
import co.uniquindio.proyecto.model.Usuario;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 * 
 * Controlador para la ventana con la pregunta de seguridad para la recuperacion de contrasenia
 *
 */
public class PreguntaController {
	
	@FXML
	private TextField txtDocumento;
	private Stage ventana;
	private Usuario usuario;
	private boolean fueAceptado=false;
	
	/**
	 * Verifica si el documento ingresado es válido.
	 * @return true si el documento es válido, false de lo contrario.
	 */
	public boolean esDocumentoValido() {
		boolean esCorrecto=false;
		String msj="";
		if (txtDocumento.getText()==null || txtDocumento.getText().trim().equals("")) {
			msj+="Debe ingresar el numero de documento";
		} else if(!txtDocumento.getText().trim().matches("[0-9]+")){
            msj+="\n\nDocumento no valido";
        }
		if (msj.equals("")) {
			esCorrecto=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Entrada no valida", "Entradas no valida", msj, AlertType.ERROR);
		}
		return esCorrecto;
		
	}
	
	/**
	 * Verifica si el documento ingresado es correcto.
	 * @return true si el documento es correcto, false de lo contrario.
	 */
	public boolean esDocumentoCorrecto() {
		boolean esCorrecto=false;
		if (usuario.verificarDocumento(txtDocumento.getText().trim())) {
			esCorrecto=true;
		}
		return esCorrecto;
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
	 * Acepta la respuesta ingresada.
	 * Si el documento es válido y correcto, establece la bandera de "fueAceptado" en verdadero y cierra la ventana.
	 * De lo contrario, muestra un mensaje de error.
	 */
	@FXML
	private void aceptar() {
		if (esDocumentoValido()) {
			if (esDocumentoCorrecto()) {
				fueAceptado=true;
				ventana.close();
			} else {
				ClaseUtilitaria.mostrarMensaje("Documento incorrecto", "Documento incorrecto", "El documento es incorrecto", AlertType.ERROR);
			}
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
	 * Establece el objeto Usuario.
	 * @param usuario El objeto Usuario.
	 */
	public void obtenerUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	/**
	 * 	Verifica si la pregunta fue aceptada.
	 * @return true si la pregunta fue aceptada, false de lo contrario.
	 */
	public boolean fueAceptado() {
		return fueAceptado;
	}

}
