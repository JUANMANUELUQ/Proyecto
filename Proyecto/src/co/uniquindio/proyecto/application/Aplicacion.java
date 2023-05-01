package co.uniquindio.proyecto.application;
	
import java.io.IOException;

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
	private Concesionario concesionario; 
	
	@Override
	public void start(Stage primaryStage) {
		concesionario=new Concesionario("Concesionario UQ");
		Administrador administrador=new Administrador("1","1090272239","3","2");
		try {
			concesionario.agregarAdministrador(administrador);
		} catch(Exception e) {}
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
			controlador.setConcesionario(concesionario);
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
			controlador.setConcesionario(concesionario);
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
			controller.setConcesionario(concesionario);
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
			controller.setConcesionario(concesionario);
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
	
	public void mostrarEmpleadoVentanaPrincipal() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
