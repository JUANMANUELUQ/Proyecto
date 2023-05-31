package co.uniquindio.proyecto.controllers;

import java.net.URL;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana principal para empleados.
 */
public class VentanaPrincipalEmpleadoController {
	
	private Stage primaryStage;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Aplicacion aplicacion=mfm.getAplicacion();
	private Empleado empleado;
	@FXML
    private ImageView iconLabelUser;
	@FXML
    private Text lblNameEmpleado;
	@FXML
    private ImageView imageback;
	
	/**
	 * Metodo que inicializa valores en la ventana 
	 */
	@FXML
	private void initialize(){
		URL url2 = getClass().getResource("/imagenes/userIcon.png");
        Image image2 = new Image(url2.toExternalForm());
        
		iconLabelUser.setImage(image2);
		
		
		URL url3= getClass().getResource("/imagenes/BACKGROUND ADMIN.png");
        Image image3 = new Image(url3.toExternalForm());
        
		imageback.setImage(image3);
		
		
	}
	
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
	 * Establece la ventana principal.
	 * @param primaryStage La ventana principal.
	 */
	public void setVentana(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
	
	/**
	 * Establece el nombre del empleado logueado
	 */
	public void crearNombre() {
		lblNameEmpleado.setText(empleado.getNombre());
	}

	/**
	 * Metodo que obtiene el Empleado asociado a esta ventana.
	 * @param empleado El objeto de Empleado.
	 */
	public void obtenerEmpleado(Empleado empleado) {
		this.empleado=empleado;
		
	}

}
