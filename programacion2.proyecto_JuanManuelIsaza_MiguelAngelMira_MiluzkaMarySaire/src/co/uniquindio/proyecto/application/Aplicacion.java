package co.uniquindio.proyecto.application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import co.uniquindio.proyecto.controllers.*;
import co.uniquindio.proyecto.model.*;

/**
 * 
 * @author Juan Manuel Isaza
 * @author Miguel Angel Mira
 * @author Miluzka Mary Saire
 * Clase que dirige la ejecucion y union de la interfaz de la aplicacion
 */
public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	public static final String CURRENCY = "$";
	
	/**
	 * Metodo que inica la ejecucion de la aplicacion
	 */
	@Override
	public void start(Stage primaryStage) {
		ModelFactoryController mfm = ModelFactoryController.getInstance();
		mfm.setAplicacion(this);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Concesionario UQ");
		this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
		this.primaryStage.setResizable(false); //para prohibir al usuario maximizar la ventana
		mostrarLogin();
	}
	
	/**
	 * Inicia la ventana principal
	 */
	public void mostrarLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IniciarSesion.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
			IniciarSesionController controlador = loader.getController();
			controlador.setVentana(primaryStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicia la interfaz con el menú principal para el administrador
	 */
	public void mostrarVentanaPrincipalAdministrador(Administrador admin) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VentanaPrincipalAdministrador.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			VentanaPrincipalAdministradorController controlador = loader.getController();
			controlador.setVentana(primaryStage);
			controlador.setAdmin(admin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicia la interfaz con la lista de empleados registrados
	 */
	public void mostrarListaEmpleados() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/ListaEmpleados.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Empleados");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(primaryStage);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			ListaEmpleadosController controller = loader.getController();
			controller.setAplicacionPrincipal(this);
			controller.setVentana(ventana);
			controller.actualizarTabla();
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicia la interfaz para ingresar nuevos empleados
	 * @param ventanaLista Direccion de la ventana con la lista de empleados
	 * @param accion Accion a realizar en la interfaz actual (Agregar-Actualizar)
	 * @param empleado Nuevo empleado a crear con los datos ingresados 
	 * @return
	 */
	public boolean mostrarIngresosDatosEmpleados(Stage ventanaLista,EmpleadoAccion accion, Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoDatosEmpleados.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Ingreso de los datos de empleados");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			IngresoDatosEmpleadosController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerAccion(accion);
			controller.obtenerEmpleado(empleado);
			switch(accion) {
				case AGREGAR: 
					controller.organizarAgregarEmpleado();
					ventana.setTitle("Agregar empleado");
					break;
				case ACTUALIZAR: 
					controller.organizarActualizarDatos();
					ventana.setTitle("Actualizacion de datos");
					break;
			}
			ventana.showAndWait();
			return controller.fueBotonPresionado();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Inicia la interfaz con el menú principal para los empleados
	 */
	public void mostrarEmpleadoVentanaPrincipal(Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VentanaPrincipalEmpleado.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			primaryStage.setResizable(false); 
			primaryStage.show();
			VentanaPrincipalEmpleadoController controlador = loader.getController();
			controlador.setVentana(primaryStage);
			controlador.obtenerEmpleado(empleado);
			controlador.crearNombre();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inica la interfaz para el cambio de contrasenia
	 * @param ventanaAnterior Direccion de la ventana anterior (Interfaz principal del empleado)
	 * @param usuario Usuario actualmente logueado
	 */
	public void mostrarCambioContrasenia(Stage ventanaAnterior,Usuario usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/CambioContrasenia.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Cambio de contrasenia");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			CambioContraseniaController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerUsuario(usuario);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Muestra la interfaz para el ingreso de una nueva transaccion
	 * @param ventanaAnterior Dirreccion de la ventana anterior (Interfaz principal del empleado)
	 * @param empleado Empleado que está realizando la transaccion
	 */
	public void mostrarIngresoTransaccion(Stage ventanaAnterior,Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoTransaccion.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Ingreso de transaccion");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			IngresoTransaccionController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerEmpleado(empleado);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Inicia la ventana para registrar nuevos clientes 
	 * @param ventanaAnterior Direccion de la ventana anterior (Interfaz principal del empleado)
	 */
	public void mostrarIngresoUsuarios(Stage ventanaAnterior) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoCliente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Ingreso de los datos del los clientes");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			IngresoClienteController controller = loader.getController();
			controller.setVentana(ventana);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Inicia la interfaz para seleccionar el tipo y atributos del vehiculo a comprar 
	 * @param ventanaLista Direccion de la ventana en la que se concretan la transaccion a realizar
	 * @param detalle Detalles de la transaccion arealizar
	 * @return Detalles de la transaccion realizada
	 */
	public DetalleTransaccion mostrarIngresoCompra(Stage ventanaLista,DetalleTransaccion detalle) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoCompra.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Ingreso de datos del detalle de la transaccion");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			IngresoCompraController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerDetalleTransaccion(detalle);
			controller.organizarEntradas();
			ventana.showAndWait();
			return controller.detalleObtenido();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Inicia la interfaz con el reporte de las transacciones 
	 */
	public void mostrarReporte() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/Reporte.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Reporte de las transacciones");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(primaryStage);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			ReporteController controller = loader.getController();
			controller.setVentana(ventana);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Inica la interfaz en la que se muestra los detalles de un vehiculo seleccionado
	 * @param ventanaAnterior Ventana anterior (reportes-alquiler)
	 * @param vehiculo vehiculo del cual se mostraran los detalles
	 */
	public void mostrarVistaVehiculo(Stage ventanaAnterior,Vehiculo vehiculo) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VistaVehiculo.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Informacion del vehiculo");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			VistaVehiculoController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerVehiculo(vehiculo);
			controller.ponerDatosCorrespondientes();
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Muestra la ventana con la pregunta de seguridad para recuperar la contrasenia
	 * @param ventanaAnterior Direccion de la ventana de login
	 * @param usuario usuario el cual quiere recuperar la contasenia
	 * @return Respuesta de que si se respondio la pregunta correctamente
	 */
	public boolean mostrarPregunta(Stage ventanaAnterior,Usuario usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/Pregunta.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Pregunta para confirmar la identidad");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			PreguntaController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerUsuario(usuario);
			ventana.showAndWait();
			return controller.fueAceptado();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Inicia la interfaz en que se muestran los vehiculos disponibles para la venta y/o alquiler
	 * @param ventanaLista Direccion de la ventana en la que se concretan la transaccion a realizar
	 * @param vehiculosTemporales vehiculos actualmente registrados en el concesionario
	 * @return Detalles de la transaccion realizada
	 */
	public DetalleTransaccion mostrarVentanaVehiculos(Stage ventanaLista,List<Vehiculo> vehiculosTemporales) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VentanaVehiculos.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.setTitle("Detalle de Compra");
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			ventana.getIcons().add(new Image(getClass().getResourceAsStream("/imagenes/logoFinalVentana.png"))); //logo en la ventana
			ventana.setResizable(false); 
			VentanaVehiculosController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerVehiculosTemporales(vehiculosTemporales);
			controller.iniciarGridPane();
			ventana.showAndWait();
			return controller.detalleObtenido();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Metodo principal 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
