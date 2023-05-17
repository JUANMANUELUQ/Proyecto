package co.uniquindio.proyecto.controllers;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IngresoAlquilerVentaController {
	
	@FXML
	private TextField txtSubtotal;
	@FXML
	private TextField txtCantidad;
	@FXML
	private TableView<Vehiculo> tableVehiculos;
	@FXML
	private TableColumn<Vehiculo,String> columnModelo;
	@FXML
	private TableColumn<Vehiculo,String> columnCantidadDisponible;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana;
	private boolean fueGuadado=false;
	
	public boolean sonDatosValidos() {
		boolean sonValidos=false;
		String msj="";
		try {
			if (Double.parseDouble(txtSubtotal.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtSubtotal.getText().trim().equals("")) {
				msj+="\n\nEl subtotal no debe estar vacio";
			} else {
				msj+="\n\nSubtotal no valido";
			}
		}
		try {
			if (Integer.parseInt(txtCantidad.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCantidad.getText().trim().equals("")) {
				msj+="\n\nLa cantidad no debe estar vacia";
			} else {
				msj+="\n\nCantidad no valido";
			}
		}
		if (tableVehiculos.getSelectionModel().getSelectedIndex() < 0) {
			msj+="\n\nDebe elejir un vehiculo";
		} 
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			JOptionPane.showMessageDialog(null,msj,"Entradas no validas",JOptionPane.ERROR_MESSAGE);
		}
		return sonValidos;
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void volver() {
		ventana.close();
	}
	
	@FXML
	private void verVehiculo() {
		
	}
	
	@FXML
	private void guardar() {
		if (sonDatosValidos()) {
			ventana.close();
		}
	}

	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

	public boolean fueGuadado() {
		return fueGuadado;
	}

}
