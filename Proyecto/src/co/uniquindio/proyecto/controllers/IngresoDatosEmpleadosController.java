package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana de ingreso y actualización de empleados.
 */
public class IngresoDatosEmpleadosController {
	
	@FXML
	private Label etiqueta;
	@FXML
	private TextField nombre;
	@FXML
	private TextField documento;
	@FXML
	private TextField contrasenia;
	@FXML
	private TextField correo;
	@FXML
	private Button boton;
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance(); // Instancia de ModelFactoryController para acceder a sus métodos
	private Stage ventana=mfm.getVentana(); // Ventana actual
	private EmpleadoAccion accion; // Acción a realizar (agregar o actualizar empleado)
	private Empleado empleado; // Empleado a actualizar
	boolean botonPresionado=false; // Indica si el botón fue presionado
	
	/**
	 * Asigna la acción a realizar (agregar o actualizar empleado).
	 * @param accion Acción a realizar.
	 */
	public void obtenerAccion(EmpleadoAccion accion) {
		this.accion=accion;
	}

	/**
	 * Verifica si los datos ingresados por el usuario son válidos.
	 * @return true si los datos son válidos, false si no lo son.
	 */
	public boolean sonDatosValidos() {
		boolean sonValidos=false;
		String msj="";
		if (nombre.getText()==null || nombre.getText().trim().equals("")) {
			msj+="El nombre no debe estar vacio";
		}
		if (documento.getText()==null || documento.getText().trim().equals("")) {
			msj+="\n\nEl documento no debe estar vacio";
		} else if (!documento.getText().trim().matches("[0-9]+")) {
			msj+="\n\nValor del documento no valido";
		}
		if (contrasenia.getText()==null || contrasenia.getText().trim().equals("")) {
			msj+="\n\nLa contrasenia no debe estar vacia";
		}
		if (correo.getText()==null || correo.getText().trim().equals("")) {
			msj+="\n\nEl correo no debe estar vacio";
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			JOptionPane.showMessageDialog(null, msj, "Entradas no validas", JOptionPane.ERROR_MESSAGE);
		}
		return sonValidos;
	}

	/**
	 * Agrega un nuevo empleado a la lista de empleados.
	 */
	public void agregarEmpleado() {
		Empleado empleado=new Empleado(nombre.getText(),documento.getText(),contrasenia.getText(),correo.getText());
		try {
			if (mfm.existeDocumentoRegistrado(empleado.getDocumento())) {
				JOptionPane.showMessageDialog(null, "Ya existe un usurio con ese documento", "Documento existente", JOptionPane.WARNING_MESSAGE);
			} else {
				mfm.agregarEmpleado(empleado);
				botonPresionado=true;
				ventana.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Usuario ya existente", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Actualiza los datos de un empleado existente.
	 */
	public void actualizarEmpleado() {
		if (mfm.existeDocumentoRegistrado(documento.getText()) && !empleado.getDocumento().trim().equals(documento.getText().trim())) {
			JOptionPane.showMessageDialog(null, "Documento ya registrado", "Documento ya existente", JOptionPane.WARNING_MESSAGE);
		} else {
			empleado.setNombre(nombre.getText().trim());
			empleado.setDocumento(documento.getText().trim());
			empleado.setCorreo(correo.getText().trim());
			botonPresionado=true;
			ventana.close();
		}
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Método que se ejecuta al presionar el botón "Continuar".
	 * Verifica los datos ingresados y realiza la acción correspondiente (agregar o actualizar empleado).
	 */
	@FXML
	private void continuar() {
		if (sonDatosValidos()) {
			switch (accion) {
				case AGREGAR: agregarEmpleado(); break;
				case ACTUALIZAR: actualizarEmpleado(); break;
			}
		}
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
	 * Verifica si el botón fue presionado.
	 * @return true si el botón fue presionado, false si no lo fue.
	 */
	public boolean fueBotonPresionado() {
		return botonPresionado;
	}

	/**
	 * Configura la ventana para agregar un empleado.
	 */
	public void organizarAgregarEmpleado() {
		etiqueta.setText("Ingrese los datos del empleado a agregar");
		boton.setText("Agregar");
	}

	/**
	 * Configura la ventana para actualizar los datos de un empleado.
	 */
	public void organizarActualizarDatos() {
		etiqueta.setText("Modifique los correspondietes datos a actualizar del empleado");
		boton.setText("Actualizar");
		contrasenia.setEditable(false);
		contrasenia.setStyle("-fx-background-color: #aaaaaa;");
		contrasenia.setText("N/A");
		nombre.setText(empleado.getNombre());
		documento.setText(empleado.getDocumento());
		correo.setText(empleado.getCorreo());
		
	}

	/**
	 * Asigna el empleado a actualizar.
	 * @param empleado Empleado a actualizar.
	 */
	public void obtenerEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}

	/**
	 * Establece la ventana actual.
	 * @param ventana Ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

}
