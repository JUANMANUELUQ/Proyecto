package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	private Stage ventana;
	private Concesionario concesionario;
	private EmpleadoAccion accion;
	private Empleado empleado;
	boolean botonPresionado=false;
	
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario=concesionario;
	}
	
	public void obtenerAccion(EmpleadoAccion accion) {
		this.accion=accion;
	}
	
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
	
	public void agregarEmpleado() {
		Empleado empleado=new Empleado(nombre.getText(),documento.getText(),contrasenia.getText(),correo.getText());
		try {
			if (concesionario.existeDocumentoRegistrado(empleado.getDocumento())) {
				JOptionPane.showMessageDialog(null, "Ya existe un usurio con ese documento", "Documento existente", JOptionPane.WARNING_MESSAGE);
			} else {
				concesionario.agregarEmpleado(empleado);
				botonPresionado=true;
				ventana.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Usuario ya existente", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void actualizarEmpleado() {
		if (concesionario.existeDocumentoRegistrado(documento.getText()) && !empleado.getDocumento().trim().equals(documento.getText().trim())) {
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
	
	@FXML
	private void continuar() {
		if (sonDatosValidos()) {
			switch (accion) {
				case AGREGAR: agregarEmpleado(); break;
				case ACTUALIZAR: actualizarEmpleado(); break;
			}
		}
	}
	
	@FXML
	private void volver() {
		ventana.close();
	}

	public boolean fueBotonPresionado() {
		return botonPresionado;
	}

	public void organizarAgregarEmpleado() {
		etiqueta.setText("Ingrese los datos del empleado a agregar");
		boton.setText("Agregar");
	}

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

	public void obtenerEmpleado(Empleado empleado) {
		this.empleado=empleado;
	}

}
