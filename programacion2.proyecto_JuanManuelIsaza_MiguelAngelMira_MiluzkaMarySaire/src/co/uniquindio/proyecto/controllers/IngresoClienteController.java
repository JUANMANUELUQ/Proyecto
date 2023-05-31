package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import co.uniquindio.proyecto.util.Persistencia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Clase controladora encargada de gestionar la ventana de registro de clientes.
 */
public class IngresoClienteController {
	
	@FXML
	private TableView<Cliente> tableClientes;
	@FXML
	private TableColumn<Cliente,String> columnNombre;
	@FXML
	private TableColumn<Cliente,String> columnDocumento;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtDocumento;
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance(); // Instancia de ModelFactoryController para acceder a sus métodos
	private Stage ventana=mfm.getVentana(); // Ventana actual
	
	/**
	 * Metodo que actuliza la tabla de clientes con los nuevos datos ingresados a la lista de clientes
	 */
	public void actualizarTabla() {
		tableClientes.getItems().clear();
		ObservableList<Cliente> listaClienteProperty=FXCollections.observableArrayList();
		for (Cliente cliente : mfm.obtenerClientes()) {
			listaClienteProperty.add(cliente);
		}
		tableClientes.setItems(listaClienteProperty);
		columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		columnDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean verificarDatos() {
        boolean sonValidos=false;
        String msj="";
        if (txtNombre.getText()==null || txtNombre.getText().trim().equals("")) {
            msj+="El nombre no debe estar vacio";
        }
        if (txtDocumento.getText()==null || txtDocumento.getText().trim().equals("")) {
            msj+="\n\nEl documento no debe estar vacio";
        } else if(!txtDocumento.getText().trim().matches("[0-9]+")){
            msj+="\n\nDocumento no valido";
        }
        if (msj.equals("")) {
            sonValidos=true;
        } else {
        	ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
        }
        return sonValidos;
    }
	
	
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		actualizarTabla();
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
	 * Metodo que se ejecuta al presionar el botón "Agregar"
	 * Registra nuevos clientes al concesionario
	 */
	@FXML
	private void agregar() {
		if (verificarDatos()) {
			if (mfm.existeDocumentoCliente(txtDocumento.getText())) {
				ClaseUtilitaria.mostrarMensaje("Cliente ya existente", "Cliente ya existente", "Ya existe un cliente con ese documento", AlertType.ERROR);
			} else {
				Cliente clienteSeleccionado = new Cliente(txtNombre.getText(),txtDocumento.getText());
				mfm.agregarCliente(clienteSeleccionado);
				Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
				actualizarTabla();
			}
		}
	}
	
	/**
	 * Metodo que actualiza los datos de un cliente seleccionado de la tabla de clientes
	 */
	@FXML
	private void actualizar() {
		int selectedIndex = tableClientes.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			if (verificarDatos()) {
				if (mfm.existeDocumentoCliente(txtDocumento.getText())) {
					ClaseUtilitaria.mostrarMensaje("Usuario ya existente", "Usuario ya existente", "Ya existe un usuario con ese documento", AlertType.ERROR);
				} else {
					Cliente clienteSeleccionado = tableClientes.getSelectionModel().getSelectedItem();
					clienteSeleccionado.setNombre(txtNombre.getText());
					clienteSeleccionado.setDocumento(txtDocumento.getText());
					Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
					actualizarTabla();
				}
			}
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un cliente seleccionado", "No hay un cliente seleccionado", "Elija un cliente", AlertType.ERROR);
		}
	}
	
	/**
	 * Metodo que eliminar un cliente seleccionado de la tabla de clientes
	 */
	@FXML
	private void eliminar() {
		int selectedIndex = tableClientes.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
			tableClientes.getItems().remove(selectedIndex);
			mfm.eliminarCliente(cliente);
			Persistencia.serialize("src/archivo.dat", mfm.getConcesionario());
		} else {
			ClaseUtilitaria.mostrarMensaje("No hay un cliente seleccionado", "No hay un cliente seleccionado", "Elija un cliente", AlertType.ERROR);
		}
	}
	
	/**
	 * Metodo que establece valores para los textField de nombre y documento dependiendo del empleado seleccionado 
	 * en la tabla de clientes
	 */
	@FXML
	private void ponerDatos() {
		int selectedIndex = tableClientes.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
			txtNombre.setText(cliente.getNombre());
			txtDocumento.setText(cliente.getDocumento());
		}
	}

	/**
	 * Establece la ventana actual
	 * @param ventana la ventana actual
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

}
