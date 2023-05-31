package co.uniquindio.proyecto.controllers;

import javafx.event.ActionEvent;

import java.net.URL;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Administrador;
import co.uniquindio.proyecto.model.Concesionario;
import co.uniquindio.proyecto.model.Empleado;
import co.uniquindio.proyecto.model.Usuario;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * La clase IniciarSesionController es el controlador de la vista de inicio de sesión.
 * Gestiona la lógica y la interacción de la interfaz gráfica para iniciar sesión.
 */
public class IniciarSesionController {
	
	@FXML
    private ImageView imageLogo;

    @FXML
    private Button btn_registrarse;

    @FXML
    private TextField txtShowPassword;

    @FXML
    private Button btn_ingresar;

    @FXML
    private PasswordField txtHidePassword;
    
    @FXML
    private ImageView lblOpen_Eye;
    
    @FXML
    private ImageView lblClose_Eye;
    
    @FXML
    private TextField txtCorreo;
    
    @FXML
    private TextField txtNombre;
    
    @FXML
    private ImageView autoTransparente;

    @FXML
    private ImageView logoPic;
    
    @FXML
    private ImageView userLogo;
    
    @FXML
    private ImageView emailLogo;
    
    @FXML
    private ImageView imagenPrincipalBackground;

    private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana = mfm.getVentana();
	private Aplicacion aplicacion = mfm.getAplicacion();
    
    public String password;
    
    /**
	 * Constructor de la clase IniciarSesionController.
	 */
    public IniciarSesionController() {
		
	}
    
    /**
	 * Método que se ejecuta al inicializar el controlador.
	 * Realiza las configuraciones iniciales de la vista de inicio de sesión.
	 */
    public void initialize() {
    	
    	txtShowPassword.setVisible(false);
    	lblOpen_Eye.setVisible(false);
    	iniciarImagenes();
    	
    }
    
    /**
	 * Método que carga las imágenes utilizadas en la vista de inicio de sesión.
	 */
    public void iniciarImagenes() {
    	// Obtener la URL de la imagen
        URL url = getClass().getResource("/imagenes/final.jpg");
        // Cargar la imagen
        Image image = new Image(url.toExternalForm());
        // Establecer la imagen en el ImageView
        imagenPrincipalBackground.setImage(image);
        
        URL url2 = getClass().getResource("/imagenes/carone.png");
        Image image2 = new Image(url2.toExternalForm());
        autoTransparente.setImage(image2);
        
        URL url3 = getClass().getResource("/imagenes/no background logo.png");
        Image image3 = new Image(url3.toExternalForm());
        logoPic.setImage(image3);
        
        URL url4 = getClass().getResource("/imagenes/logo user.png");
        Image image4 = new Image(url4.toExternalForm());
        userLogo.setImage(image4);
        
        URL url5 = getClass().getResource("/imagenes/logo email.png");
        Image image5 = new Image(url5.toExternalForm());
        emailLogo.setImage(image5);
        
        URL url6 = getClass().getResource("/imagenes/closed eye.png");
        Image image6 = new Image(url6.toExternalForm());
        lblClose_Eye.setImage(image6);
        
        URL url7 = getClass().getResource("/imagenes/open eye.png");
        Image image7 = new Image(url7.toExternalForm());
        lblOpen_Eye.setImage(image7);
    }
    
    /**
	 * Verifica si existen campos vacíos en el formulario de recuperación de contraseña.
	 * @return true si hay campos vacíos, false si todos los campos están llenos.
	 */
    public boolean existenCamposVaciosRecuperarContrasenia() {
		boolean sonValidos=true;
		String msj="";
		if (txtNombre.getText()==null || txtNombre.getText().trim().equals("")) {
			msj+="El nombre no debe estar vacío";
		}
		if (txtCorreo.getText()==null || txtCorreo.getText().trim().equals("")) {
			msj+="\n\nEl correo no debe estar vacío";
		}
		if (msj.equals("")) {
			sonValidos=false;
		} else {
			ClaseUtilitaria.mostrarMensaje("Datos no válidos", "Datos no válidos", msj, AlertType.ERROR);
		}
		return sonValidos;
	}

	/**
	 * Verifica si existen campos vacíos en el formulario de inicio de sesión.
	 * @return true si hay campos vacíos, false si todos los campos están llenos.
	 */
	public boolean existenCamposVacios() {
		boolean sonValidos=true;
		String msj="";
		if (txtNombre.getText()==null || txtNombre.getText().trim().equals("")) {
			msj+="El nombre no debe estar vacío";
		}
		if (txtCorreo.getText()==null || txtCorreo.getText().trim().equals("")) {
			msj+="\n\nEl correo no debe estar vacío";
		}
		if (txtHidePassword.getText()==null || txtHidePassword.getText().trim().equals("")) {
			msj+="\n\nLa contraseña no debe estar vacía";
		}
		if (msj.equals("")) {
			sonValidos=false;
		} else {
			ClaseUtilitaria.mostrarMensaje("Datos no válidos", "Datos no válidos", msj, AlertType.ERROR);
		}
		return sonValidos;
	}
	
    /**
	 * Inicia sesión para un usuario administrador.
	 * @param admin El objeto Administrador correspondiente al administrador que ha iniciado sesión.
	 */
	public void iniciarSesionAdministrador(Administrador admin) {
		ventana.close();
		aplicacion.mostrarVentanaPrincipalAdministrador(admin);
	}

	/**
	 * Inicia sesión para un empleado.
	 * @param empleado El objeto Empleado correspondiente al empleado que ha iniciado sesión.
	 */	
	public void iniciarSesionEmpleado(Empleado empleado) {
		ventana.close();
		aplicacion.mostrarEmpleadoVentanaPrincipal(empleado);
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Ingresar".
	 * Realiza el proceso de inicio de sesión cuando se presiona el botón "Ingresar".
	 */
	@FXML
	private void Ingresar() {
		String tipoUsuario;
		if (!existenCamposVacios()) {
			if (mfm.existeUsuario(txtNombre.getText(), txtCorreo.getText(), txtHidePassword.getText())) {
				if (mfm.estaEmpleadoBloqueado(txtNombre.getText(), txtCorreo.getText(), txtHidePassword.getText())) {
					ClaseUtilitaria.mostrarMensaje("Cuenta bloqueada", "Cuenta bloqueada", "El usuario está bloqueado", AlertType.WARNING);
				} else {
					tipoUsuario = mfm.obtenerTipoCuenta(txtNombre.getText(), txtCorreo.getText(), txtHidePassword.getText());
					switch (tipoUsuario) {
						case "Administrador": iniciarSesionAdministrador((Administrador)
								mfm.obtenerUsuarioDatos(txtNombre.getText(), txtCorreo.getText(), txtHidePassword.getText())); break;
						case "Empleado": iniciarSesionEmpleado((Empleado)
								mfm.obtenerUsuarioDatos(txtNombre.getText(), txtCorreo.getText(), txtHidePassword.getText())); break;
					}
				}
			} else {
				ClaseUtilitaria.mostrarMensaje("Cuenta no encontrada", "Cuenta no encontrada", "No existe una cuenta con los datos ingresados", AlertType.WARNING);
			}
		}
	}
	
	/**
     * Evento que se ejecuta cuando se libera una tecla en el campo de texto para ocultar la contraseña.
     * 
     * Este método se ejecuta cuando se libera una tecla en el campo de texto designado para ocultar la contraseña.
     * Obtiene el texto ingresado en el campo de texto y lo establece como texto en el campo de texto para mostrar la
     * contraseña.
     * @param keyevent El evento de liberación de tecla.
     */
	@FXML
    public void HidePasswordKeyReleased(KeyEvent keyevent) {
		
		password = txtHidePassword.getText();
		txtShowPassword.setText(String.valueOf(password));
    }
	
    /**
     * Evento que se ejecuta cuando se realiza una acción en el campo de texto para mostrar la contraseña.
     * 
     * Este método se ejecuta cuando se realiza una acción en el campo de texto designado para mostrar la contraseña.
     * Obtiene el texto ingresado en el campo de texto y lo establece como texto en el campo de texto para ocultar la
     * contraseña.
     * @param keyevent La acción realizada en el campo de texto.
     */
	@FXML
    public void ShowPasswordOnAction(KeyEvent keyevent) {
		
		password = txtShowPassword.getText();
		txtHidePassword.setText(password);
		
    }
	
    /**
     * Evento que se ejecuta al hacer clic en el botón de cerrar ojo.
     * 
     * Este método se ejecuta cuando se hace clic en el botón de cerrar ojo. Cambia la visibilidad de los elementos de la
     * interfaz relacionados con la contraseña para mostrarlos u ocultarlos según sea necesario.
     * @param mousevent El evento de clic del ratón.
     */
    @FXML
    public void Close_Eye_ClickOnAction(MouseEvent mousevent) {
    	txtShowPassword.setVisible(true);
    	lblOpen_Eye.setVisible(true);
    	lblClose_Eye.setVisible(false);
    	txtHidePassword.setVisible(false);

    }
   
    /**
     * Evento que se ejecuta al hacer clic en el botón de abrir ojo.
     * 
     * Este método se ejecuta cuando se hace clic en el botón de abrir ojo. Cambia la visibilidad de los elementos de la
     * interfaz relacionados con la contraseña para mostrarlos u ocultarlos según sea necesario.
     * @param mousevent El evento de clic del ratón.
     */
    @FXML
    public void Open_Eye_OnClickAction(MouseEvent mousevent) {
    	
    	txtShowPassword.setVisible(false);
    	lblOpen_Eye.setVisible(false);
    	lblClose_Eye.setVisible(true);
    	txtHidePassword.setVisible(true);

    }
    
    /**
     * Evento que se ejecuta al pasar el ratón sobre el botón de ingresar.
     * 
     * Este método se ejecuta cuando se pasa el ratón sobre el botón de ingresar. Cambia el estilo de fondo del botón para
     * hacerlo transparente.
     * @param mousevent El evento de pasar el ratón.
     */
    @FXML
    public void cambiarColorIngresar(MouseEvent mousevent) {
    	btn_ingresar.setStyle("-fx-background-color: transparent;");

    }
    
    /**
     * Evento que se ejecuta al quitar el ratón del botón de ingresar.
     * 
     * Este método se ejecuta cuando se quita el ratón del botón de ingresar. Restablece el estilo de fondo del botón a su
     * valor predeterminado.
     * @param mousevent El evento de quitar el ratón.
     */
    @FXML
    public void resetarColorIngresar(MouseEvent mousevent) {
        btn_ingresar.setStyle("-fx-background-color: #04d9ff; -fx-background-radius: 50;");
    }
    
    /**
     * Método para recuperar la contraseña.
     * 
     * Este método se ejecuta cuando se solicita recuperar la contraseña. Verifica si se han ingresado los campos
     * requeridos y si el usuario y el correo electrónico proporcionados coinciden con un usuario existente. Si se cumplen
     * estas condiciones, se verifica si el usuario está bloqueado y se muestra un mensaje correspondiente. Si el usuario
     * no está bloqueado y se confirma la recuperación de la contraseña, se muestra la contraseña del usuario.
     */
    @FXML
	private void recuperarContrasenia() {
		if (!existenCamposVaciosRecuperarContrasenia()) {
			if (mfm.existeUsuario(txtNombre.getText(), txtCorreo.getText())) {
				if (mfm.estaEmpleadoBloqueado(txtNombre.getText(), txtCorreo.getText())) {
					ClaseUtilitaria.mostrarMensaje("Cuenta bloqueada", "Cuenta bloqueada", "El usuario está bloqueado", AlertType.WARNING);
				} else {
					Usuario usuario = mfm.obtenerUsuarioDatos(txtNombre.getText(), txtCorreo.getText());
					if (aplicacion.mostrarPregunta(ventana, usuario)) {
						ClaseUtilitaria.mostrarMensaje("Contraseña", "Contraseña", "La contraseña de la cuenta es:\n\n" + usuario.getContrasenia(), 
						AlertType.INFORMATION);
					} 
				}
			}
		}
	}
    
    /**
     * Establece la aplicación principal.
     * 
     * Este método establece la instancia de la aplicación principal en el controlador. 
     * @param aplicacion La instancia de la aplicación principal.
     */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

    /**
     * Establece la ventana principal.
     * 
     * Este método establece la instancia de la ventana principal en el controlador.
     * @param primaryStage La instancia de la ventana principal.
     */
	public void setVentana(Stage primaryStage) {
		this.ventana = primaryStage;
	}

}