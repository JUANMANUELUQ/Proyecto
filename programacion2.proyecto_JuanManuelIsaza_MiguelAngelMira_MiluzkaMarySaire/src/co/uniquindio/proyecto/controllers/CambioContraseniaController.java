package co.uniquindio.proyecto.controllers;

import java.net.URL;

import co.uniquindio.proyecto.model.Concesionario;
import co.uniquindio.proyecto.model.Usuario;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import co.uniquindio.proyecto.util.Persistencia;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	@FXML
    private ImageView back;
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
	
	/**
	 * Metodo que inicializa el controlador
	 */
	@FXML
	private void initialize() {
		URL url2 = getClass().getResource("/imagenes/BACKGROUND ADMIN.png");
        Image image2 = new Image(url2.toExternalForm());
        back.setImage(image2);
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
					Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
					ventana.close();
				} else {
					ClaseUtilitaria.mostrarMensaje("Contrasenias no coinciden", "Contrasenias no coinciden", "Contrasenia antigua incorrecta", AlertType.ERROR);
				}
			} else {
				ClaseUtilitaria.mostrarMensaje("Contrasenias no coinciden", "Contrasenias no coinciden", "La nueva contrasenia y su confirmacion no son iguales", AlertType.ERROR);
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
			ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
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
