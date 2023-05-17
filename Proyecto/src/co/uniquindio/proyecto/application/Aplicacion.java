package co.uniquindio.proyecto.application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import co.uniquindio.proyecto.controllers.*;
import co.uniquindio.proyecto.model.*;


public class Aplicacion extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Concesionario UQ");
		mostrarLogin();
	}
	
	/**
	 * Inicia la ventana principal
	 */
	public void mostrarLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/Login.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			LoginController controlador = loader.getController();
			controlador.setAplicacionPrincipal(this);
			controlador.setVentana(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPrincipalAdministrador() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VentanaPrincipalAdministrador.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			VentanaPrincipalAdministradorController controlador = loader.getController();
			controlador.setAplicacionPrincipal(this);
			controlador.setVentana(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
			ListaEmpleadosController controller = loader.getController();
			controller.setAplicacionPrincipal(this);
			controller.setVentana(ventana);
			controller.actualizarTabla();
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean mostrarIngresosDatosEmpleados(Stage ventanaLista,EmpleadoAccion accion, Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoDatosEmpleados.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
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
	
	public void mostrarEmpleadoVentanaPrincipal(Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/VentanaPrincipalEmpleado.fxml"));
			rootLayout = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			VentanaPrincipalEmpleadoController controlador = loader.getController();
			controlador.setAplicacionPrincipal(this);
			controlador.setVentana(primaryStage);
			controlador.obtenerEmpleado(empleado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void mostrarCambioContrasenia(Stage ventanaAnterior,Usuario usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/CambioContrasenia.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			CambioContraseniaController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerUsuario(usuario);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void mostrarIngresoTransaccion(Stage ventanaAnterior,Empleado empleado) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoTransaccion.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			IngresoTransaccionController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerEmpleado(empleado);
			controller.obtenerAplicacion(this);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void mostrarIngresoUsuarios(Stage ventanaAnterior) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoCliente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaAnterior);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			IngresoClienteController controller = loader.getController();
			controller.setVentana(ventana);
			ventana.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public boolean mostrarIngresoCompra(Stage ventanaLista,List<DetalleTransaccion> detalle) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoCompra.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			IngresoCompraController controller = loader.getController();
			controller.setVentana(ventana);
			controller.obtenerDetalleTransaccion(detalle);
			controller.organizarEntradas();
			ventana.showAndWait();
			return controller.fueGuadado();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean mostrarIngresoAlquilerVenta(Stage ventanaLista) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/proyecto/view/IngresoAlquilerVenta.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage ventana = new Stage();
			ventana.initModality(Modality.WINDOW_MODAL);
			ventana.initOwner(ventanaLista);
			Scene scene = new Scene(page);
			ventana.setScene(scene);
			IngresoAlquilerVentaController controller = loader.getController();
			controller.setVentana(ventana);
			ventana.showAndWait();
			return controller.fueGuadado();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
