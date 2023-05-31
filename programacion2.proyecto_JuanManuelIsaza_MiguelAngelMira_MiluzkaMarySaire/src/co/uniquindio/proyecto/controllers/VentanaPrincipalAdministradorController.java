package co.uniquindio.proyecto.controllers;

import java.net.URL;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Administrador;
import co.uniquindio.proyecto.model.Concesionario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana principal para el administrador.
 */
public class VentanaPrincipalAdministradorController {
	
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Aplicacion aplicacion=mfm.getAplicacion();
	private Stage primaryStage;
	@FXML
    private ImageView background;
	@FXML
    private Text lblName;

	@FXML
    private ImageView picAdmin;
	private Administrador admin;
	
	
	/**
	 * Inicializa la clase controladora.
	 */
	@FXML
	private void initialize() {
		iniciarImagenes();
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Reportes" * Muestra un mensaje indicando que la función está en construcción.
	 */
	@FXML
	private void reportes() {
		aplicacion.mostrarReporte();
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
	 * Establece la ventana principal.
	 * @param primaryStage La ventana principal.
	 */
	public void setVentana(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	
	/**
	 * Muestra las imagenes por defecto para un usuario de tipo Administrador
	 */
	public void iniciarImagenes() {
    	
        URL url = getClass().getResource("/imagenes/BACKGROUND ADMIN.png");
        Image image = new Image(url.toExternalForm());
        background.setImage(image);
        
        URL url2 = getClass().getResource("/imagenes/ADMINpic.png");
        Image image2 = new Image(url2.toExternalForm());
        picAdmin.setImage(image2);
	}
	
	/**
	 * Muestra el nombre del abministrador logueado
	 */
	public void iniciarNombreAdmin() {
		lblName.setText(admin.getNombre());
	}
	
	/**
	 * Establece al administrador logueado
	 * @param admin administrador logueado
	 */
	public void setAdmin(Administrador admin) {
		this.admin=admin;
		iniciarNombreAdmin();
		
	}

}
