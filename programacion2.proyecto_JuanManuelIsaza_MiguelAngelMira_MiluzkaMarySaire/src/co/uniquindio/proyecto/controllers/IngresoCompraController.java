package co.uniquindio.proyecto.controllers;

import java.util.List;

import javax.imageio.ImageIO;

import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Clase controlador encargada de gestionar la ventana de ingreso de datos de vehiculos que el concesionario va a comprar.
 */
public class IngresoCompraController {
	
	private Integer precio=65120000;
	private String codeColor="3a9bdc";
	
	@FXML
	private TextField txtSubtotal;
	@FXML
	private TextField txtCantidad;
	@FXML
	private ComboBox tipoVehiculo;
	@FXML
	private TextField txtMarca;
	@FXML
	private TextField txtModelo;
	@FXML
	private TextField txtVelocidadMaxima;
	@FXML
	private TextField txtAutonomiaCargaCompleta;
	@FXML
	private ComboBox enchufable;
	@FXML
	private ComboBox revisionTecnica;
	@FXML
	private ComboBox tipoCombustible;
	@FXML
	private TextField txtNumeroPuertas;
	@FXML
	private ComboBox aireAcondicionado;
	@FXML
	private ComboBox ABS;
	@FXML
	private TextField txtNumeroEjes;
	@FXML
	private ComboBox frenosAire;
	@FXML
	private TextField txtCaballosFuerza;
	@FXML
	private TextField txtCapacidadMaletero;
	@FXML
	private TextField txtCapacidadCajaCarga;
	@FXML
	private ComboBox txtSensoresColision;
	@FXML
	private ComboBox nuevo;
	@FXML
	private TextField txtCambios;
	@FXML
	private TextField txtCilindraje;
	@FXML
	private TextField txtPromedioCarga;
	@FXML
	private ComboBox hibridoLigero;
	@FXML
	private ComboBox transmision;
	@FXML
	private TextField txtNumeroPasajeros;
	@FXML
	private TextField txtNumeroBolsasAire;
	@FXML
	private ComboBox camaraReversa;
	@FXML
	private TextField txtCapacidadCarga;
	@FXML
	private TextField txtTipoCamion;
	@FXML
	private TextField txtTiempoAlcanza100;
	@FXML
	private ComboBox combo4x4;
	@FXML
	private ComboBox velocidadCrucero;
	@FXML
	private ComboBox sensorTraficoCruzado;
	@FXML
	private ComboBox asistentePermanenciaCarril;
	@FXML
	private TextField numeroSalidasEmergencia;
	@FXML
	private Label lblSeleccion;
	@FXML
	private Button btnSeleccion;
	@FXML
	private ImageView foto;
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana;
	private DetalleTransaccion detalle;
	private boolean fueGuardado=false;
	private List<Vehiculo> listaVehiculosTemporales= mfm.obtenerCopiaVehiculos();
	
	/**
 	 * Metodo que verifica si los datos del vehículo son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosVehiculoValidos() {
		String msj="";
		if (txtMarca.getText()==null || txtMarca.getText().trim().equals("")) {
			msj+="\n\nLa marca no debe estar vacia";
		}
		if (txtModelo.getText()==null || txtModelo.getText().trim().equals("")) {
			msj+="\n\nEl modelo no debe estar vacio";
		}
		if (enchufable.getValue()==null || (""+enchufable.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si en enchufable no debe estar vacia";
		}
		if (revisionTecnica.getValue()==null || (""+revisionTecnica.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene la revision tecnica no debe estar vacio";
		} else if ((""+revisionTecnica.getValue()).equals("No")) {
			msj+="\n\nNo se puede comprar un vehiculo sin revision tecnico mecanica";
		}
		if (tipoCombustible.getValue()==null || (""+tipoCombustible.getValue()).equals("")) {
			msj+="\n\nEl tipo de combustible no debe estar vacio";
		}
		if (nuevo.getValue()==null || (""+nuevo.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si es nuevo no debe estar vacia";
		}
		if (tipoCombustible.getValue()==null || (""+tipoCombustible.getValue()).equals("")) {
			msj+="\n\nEl tipo de combustible no debe estar vacio";
		}
		if (transmision.getValue()==null || (""+transmision.getValue()).equals("")) {
			msj+="\n\nLa transmision no debe estar vacia";
		}
		try {
			if (Integer.parseInt(txtCambios.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCambios.getText().trim().equals("")) {
				msj+="\n\nLa cantidad de cambios no puede estar vacia";
			} else {
				msj+="\n\nCantidad de cambios no valida";
			}
		}
		try {
			if (Double.parseDouble(txtVelocidadMaxima.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtVelocidadMaxima.getText().trim().equals("")) {
				msj+="\n\nLa cantidad de velocidad maxima no puede estar vacia";
			} else {
				msj+="\n\nCantidad de velocidad maxima no es valida";
			}
		}
		try {
			if (Double.parseDouble(txtCilindraje.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCilindraje.getText().trim().equals("")) {
				msj+="\n\nLa cantidad de cilindraje no puede estar vacia";
			} else {
				msj+="\n\nCantidad de cilindraje maxima no es valida";
			}
		}
		try {
			if (Integer.parseInt(txtAutonomiaCargaCompleta.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtAutonomiaCargaCompleta.getText().trim().equals("")) {
				msj+="\n\nLa cantidad de autonomia carga completa no puede estar vacia";
			} else {
				msj+="\n\nCantidad de autonomia carga completa no valida";
			}
		}
		try {
			if (Integer.parseInt(txtPromedioCarga.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtPromedioCarga.getText().trim().equals("")) {
				msj+="\n\nLa cantidad de tiempo de carga no puede estar vacia";
			} else {
				msj+="\n\nCantidad de tiempo de carga no valida";
			}
		}
		if (hibridoLigero.getValue()==null || (""+hibridoLigero.getValue()).equals("")) {
			msj+="\n\n no debe estar vacio";
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del carro son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosCarroValidos() {
		String msj=datosVehiculoValidos();
		try {
			if (Integer.parseInt(txtNumeroPasajeros.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtNumeroPasajeros.getText().trim().equals("")) {
				msj+="\n\nEl numero de pasajeros no puede estar vaco";
			} else {
				msj+="\n\nNumero de pasajeros no valido";
			}
		}
		try {
			if (Integer.parseInt(txtNumeroPuertas.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtNumeroPuertas.getText().trim().equals("")) {
				msj+="\n\nEl numero de puertas no puede estar vacio";
			} else {
				msj+="\n\nNumero de puertas no valido";
			}
		}
		try {
			if (Integer.parseInt(txtNumeroBolsasAire.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtNumeroBolsasAire.getText().trim().equals("")) {
				msj+="\n\nEl numero de bolsas no puede estar vacio";
			} else {
				msj+="\n\nNumero de bolsas no valido";
			}
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del carro no deportivo son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosCarroNoDeportivoValidos() {
		String msj=datosCarroValidos();
		if (aireAcondicionado.getValue()==null || (""+aireAcondicionado.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene aire acondicionado no debe estar vacia";
		}
		if (camaraReversa.getValue()==null || (""+camaraReversa.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene la camara de reversa no debe estar vacia";
		}
		if (ABS.getValue()==null || (""+ABS.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene ABS no debe estar vacia";
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del carro deportivo son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosDeportivoValidos() {
		String msj=datosCarroValidos();
		try {
			if (Integer.parseInt(txtCaballosFuerza.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCaballosFuerza.getText().trim().equals("")) {
				msj+="\n\nEl numero de caballos de fuerza no puede estar vacio";
			} else {
				msj+="\n\nNumero de caballos de fuerza no valido";
			}
		}
		try {
			if (Integer.parseInt(txtTiempoAlcanza100.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtTiempoAlcanza100.getText().trim().equals("")) {
				msj+="\n\nEl tiempo en que alcanza los 100 Km/h no puede estar vacio";
			} else {
				msj+="\n\nTiempo en que alcanza los 100 Km/h";
			}
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del sedan son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosSedanValidos() {
		String msj=datosCarroNoDeportivoValidos();
		try {
			if (Double.parseDouble(txtCapacidadMaletero.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadMaletero.getText().trim().equals("")) {
				msj+="\n\nLa capacidad del maletero no puede estar vacia";
			} else {
				msj+="\n\nCapacidad del maletero  no es valida";
			}
		}
		if (velocidadCrucero.getValue()==null || (""+velocidadCrucero.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene velocidad de crucero no debe estar vacia";
		}
		if (txtSensoresColision.getValue()==null || (""+txtSensoresColision.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene sensores de colision no debe estar vacia";
		}
		if (sensorTraficoCruzado.getValue()==null || (""+sensorTraficoCruzado.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene sensor de trafico cruzado no debe estar vacio";
		}
		if (asistentePermanenciaCarril.getValue()==null || (""+asistentePermanenciaCarril.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si de que si tiene una asitente de permanecia de carril no debe estar vacio";
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos de la camioneta son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosCamionetaValidos() {
		String msj=datosCarroNoDeportivoValidos();
		try {
			if (Double.parseDouble(txtCapacidadMaletero.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadMaletero.getText().trim().equals("")) {
				msj+="\n\nLa capacidad del maletero no puede estar vacia";
			} else {
				msj+="\n\nCapacidad del maletero  no es valida";
			}
		}
		if (sensorTraficoCruzado.getValue()==null || (""+sensorTraficoCruzado.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene sensor de trafico cruzado no debe estar vacia";
		}
		if (velocidadCrucero.getValue()==null || (""+velocidadCrucero.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene velocidad de crucero no debe estar vacia";
		}
		if (txtSensoresColision.getValue()==null || (""+txtSensoresColision.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene sensores de colision no debe estar vacia";
		}
		if (asistentePermanenciaCarril.getValue()==null || (""+asistentePermanenciaCarril.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene asistentt no debe estar vacia";
		}
		if (combo4x4.getValue()==null || (""+combo4x4.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si es 4x4 no debe estar vacia";
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del bus son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosBusValidos() {
		String msj=datosCarroNoDeportivoValidos();
		try {
			if (Double.parseDouble(txtCapacidadMaletero.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadMaletero.getText().trim().equals("")) {
				msj+="\n\nLa capacidad del maletero no puede estar vacia";
			} else {
				msj+="\n\nCapacidad del maletero  no es valida";
			}
		}
		try {
			if (Integer.parseInt(txtNumeroEjes.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtNumeroEjes.getText().trim().equals("")) {
				msj+="\n\nEl numero de ejes no puede estar vacio";
			} else {
				msj+="\n\nNumero de ejes no valido";
			}
		}
		try {
			if (Integer.parseInt(numeroSalidasEmergencia.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (numeroSalidasEmergencia.getText().trim().equals("")) {
				msj+="\n\nEl numero de salidas de emergencia no puede estar vacio";
			} else {
				msj+="\n\nNumero de salidas de emergencia no valido";
			}
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del Pick Up son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosPickUpValidos() {
		String msj=datosCarroNoDeportivoValidos();
		if (combo4x4.getValue()==null || (""+combo4x4.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si es 4x4 no debe estar vacia";
		}
		try {
			if (Double.parseDouble(txtCapacidadCajaCarga.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadCajaCarga.getText().trim().equals("")) {
				msj+="\n\nLa capacidad de carga de la caja no puede estar vacia";
			} else {
				msj+="\n\nCapacidad de carga de la caja no es valida";
			}
		}
		return msj;
	}
	
	public String datosVanValidos() {
		String msj=datosCarroNoDeportivoValidos();
		try {
			if (Double.parseDouble(txtCapacidadMaletero.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadMaletero.getText().trim().equals("")) {
				msj+="\n\nLa capacidad del maletero no puede estar vacia";
			} else {
				msj+="\n\nCapacidad del maletero  no es valida";
			}
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos del camion son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public String datosCamionValidos() {
		String msj=datosVehiculoValidos();
		try {
			if (Double.parseDouble(txtCapacidadCajaCarga.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtCapacidadCajaCarga.getText().trim().equals("")) {
				msj+="\n\nLa capacidad de carga de la caja no puede estar vacia";
			} else {
				msj+="\n\nCapacidad de carga de la caja no es valida";
			}
		}
		if (ABS.getValue()==null || (""+ABS.getValue()).equals("")) {
			msj+="\n\n no debe estar vacio";
		}
		try {
			if (Integer.parseInt(txtNumeroEjes.getText())<=0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			if (txtNumeroEjes.getText().trim().equals("")) {
				msj+="\n\nEl numero de ejes no puede estar vacio";
			} else {
				msj+="\n\nNumero de ejes no valido";
			}
		}
		if (frenosAire.getValue()==null || (""+frenosAire.getValue()).equals("")) {
			msj+="\n\nLa informacion de que si tiene frenos de aire no debe estar vacia";
		}
		if (txtTipoCamion.getText()==null || txtTipoCamion.getText().trim().equals("")) {
			msj+="\n\nEl tipo de camion no debe estar vacio";
		}
		return msj;
	}
	
	/**
 	 * Metodo que verifica si los datos de la transaccion son válidos.
 	 * @return Un mensaje de error que indica los campos inválidos, o una cadena vacía si los datos son válidos.
 	 */
	public boolean sonDatosCorrespondienetesValidos() {
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
		switch(""+tipoVehiculo.getValue()) {
			case "Moto":
				msj+=datosVehiculoValidos();
				break;
			case "Deportivo":
				msj+=datosDeportivoValidos();
				break;
			case "Sedan":
				msj+=datosSedanValidos();
				break;
			case "Camioneta":
				msj+=datosCamionetaValidos();
				break;
			case "Bus":
				msj+=datosBusValidos();
				break;
			case "Pick up":
				msj+=datosPickUpValidos();
				break;
			case "Van":
				msj+=datosVanValidos();
				break;
			case "Camion":
				msj+=datosCamionValidos();
				break;
			default : msj+="\n\nDe elejir un tipo de vehiculo";
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
		}
 		return sonValidos;
	}
	
	/**
	 * Obtiene una lista de ComboBoxes.
	 * @return La lista de ComboBoxes.
	 */
	public List<ComboBox> obtenerCombox() {
		List<ComboBox> combos=new ArrayList<ComboBox>();
		combos.add(enchufable);
		combos.add(nuevo);
		combos.add(revisionTecnica);
		combos.add(aireAcondicionado);
		combos.add(ABS);
		combos.add(frenosAire);
		combos.add(txtSensoresColision);
		combos.add(hibridoLigero);
		combos.add(camaraReversa);
		combos.add(combo4x4);
		combos.add(velocidadCrucero);
		combos.add(sensorTraficoCruzado);
		combos.add(asistentePermanenciaCarril);
		return combos;
	}
	
	/**
	 * Organiza las opciones binarias en los ComboBoxes proporcionados.
	 * @param combos La lista de ComboBoxes con opciones binarias.
	 */
	public void organizarOpcionesBinarias(List<ComboBox> combos) {
		ObservableList<String> opciones=FXCollections.observableArrayList();
		opciones.add("Si");
		opciones.add("No");
		for (ComboBox comboBox : combos) {
			comboBox.setItems(opciones);
		}
	}

    /**
     * Bloquea la entrada de texto en un campo de texto y establece el estilo de fondo como gris.
     * @param texto El campo de texto a bloquear.
     */
	public void bloquearEntrada(TextField texto) {
		texto.setEditable(false);
		texto.setStyle("-fx-background-color: #aaaaaa;");
		texto.setText("N/A");
	}
	
    /**
     * Desbloquea la entrada de texto en un campo de texto y restablece el estilo de fondo predeterminado.
     * @param texto El campo de texto a desbloquear.
     */
	public void desbloquearEntrada(TextField texto) {
		texto.setEditable(true);
		texto.setStyle(null);
		texto.setText("");
	}

    /**
     * Bloquea la selección y la entrada de texto en un ComboBox estableciendo el valor predeterminado como "N/A".
     * @param comboBox El ComboBox a bloquear.
     */

	public void bloquearEntrada(ComboBox comboBox) {
		comboBox.setEditable(false);
		comboBox.setValue("N/A");
		comboBox.setDisable(true);
		
	}

	/**
     * Desbloquea la selección y la entrada de texto en un ComboBox restableciendo el valor predeterminado.
     * @param comboBox El ComboBox a desbloquear.
     */
	public void desbloquearEntrada(ComboBox comboBox) {
		comboBox.setValue("");
		comboBox.setDisable(false);
		
	}

    /**
     * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro.
     */
	public void desbloquearCarro() {
		desbloquearEntrada(txtNumeroPasajeros);
		desbloquearEntrada(txtNumeroPuertas);
		desbloquearEntrada(txtNumeroBolsasAire);
	}

    /**
     * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro no deportivo.
     */
	public void desbloquearCarroNoDeportivo() {
		desbloquearCarro();
		desbloquearEntrada(aireAcondicionado);
		desbloquearEntrada(camaraReversa);
		desbloquearEntrada(ABS);
	}
	
    /**
     * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro deportivo.
     */
	public void desbloquearDeportivoEntradas() {
		desbloquearCarro();
		desbloquearEntrada(txtCaballosFuerza);
		desbloquearEntrada(txtTiempoAlcanza100);
	}

    /**
     * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro sedán.
     */
	public void desbloquearSedanEntradas() {
		desbloquearCarroNoDeportivo();
		desbloquearEntrada(txtCapacidadMaletero);
		desbloquearEntrada(velocidadCrucero);
		desbloquearEntrada(txtSensoresColision);
		desbloquearEntrada(sensorTraficoCruzado);
		desbloquearEntrada(asistentePermanenciaCarril);
	}
	
	/**
     * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro camioneta.
	 */
	public void desbloquearCamionetaEntradas() {
		desbloquearCarroNoDeportivo();
		desbloquearEntrada(txtCapacidadMaletero);
		desbloquearEntrada(sensorTraficoCruzado);
		desbloquearEntrada(txtSensoresColision);
		desbloquearEntrada(asistentePermanenciaCarril);
		desbloquearEntrada(combo4x4);
		desbloquearEntrada(velocidadCrucero);
	}
	
	/**
	 * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro bus.
	 */
	public void desbloquearBusEntradas() {
		desbloquearCarroNoDeportivo();
		desbloquearEntrada(txtCapacidadMaletero);
		desbloquearEntrada(txtNumeroEjes);
		desbloquearEntrada(numeroSalidasEmergencia);
	}
	
	/**
 	 * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro pick-up.
 	 */
	public void desbloquearPickUpEntradas() {
		desbloquearCarroNoDeportivo();
		desbloquearEntrada(combo4x4);
		desbloquearEntrada(txtCapacidadCajaCarga);
	}
		
	/**
 	 * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro van.
 	 */
	public void desbloquearVanEntradas() {
		desbloquearCarroNoDeportivo();
		desbloquearEntrada(txtCapacidadMaletero);
	}
	
	/**
	 * Desbloquea las entradas de texto de varios campos relacionados con un tipo de carro camión.
	 */
	public void desbloquearCamionEntradas() {
		desbloquearEntrada(txtCapacidadCarga);
		desbloquearEntrada(ABS);
		desbloquearEntrada(txtNumeroEjes);
		desbloquearEntrada(frenosAire);
		desbloquearEntrada(txtTipoCamion);
	}

	/**
	 * Bloquea todas las entradas de texto adicionales en el formulario.
	 */
	public void bloquearEntradasExtra() {
		bloquearEntrada(txtNumeroPasajeros);
		bloquearEntrada(txtNumeroPuertas);
		bloquearEntrada(txtNumeroBolsasAire);
		bloquearEntrada(aireAcondicionado);
		bloquearEntrada(camaraReversa);
		bloquearEntrada(ABS);
		bloquearEntrada(txtCaballosFuerza);
		bloquearEntrada(txtTiempoAlcanza100);
		bloquearEntrada(txtCapacidadMaletero);
		bloquearEntrada(velocidadCrucero);
		bloquearEntrada(txtSensoresColision);
		bloquearEntrada(sensorTraficoCruzado);
		bloquearEntrada(asistentePermanenciaCarril);
		bloquearEntrada(combo4x4);
		bloquearEntrada(txtNumeroEjes);
		bloquearEntrada(numeroSalidasEmergencia);
		bloquearEntrada(txtCapacidadCajaCarga);
		bloquearEntrada(txtCapacidadCarga);
		bloquearEntrada(frenosAire);
		bloquearEntrada(txtTipoCamion);
	}
	
	/**
	 * Crea una instancia de la clase Moto con los datos ingresados en el formulario.
	 * @return La moto creada.
	 */
	public Moto crearMoto() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Moto moto=new Moto(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		moto.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		moto.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		return moto;
	}
	
	/**
	 * Crea una instancia de la clase Deportivo con los datos ingresados en el formulario.
	 * @return El deportivo creado.
	 */
	public Deportivo crearDeportivo() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Deportivo deportivo=new Deportivo(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		deportivo.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		deportivo.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(deportivo, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()), 
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		deportivo.setNumeroCaballosFuerza(Integer.parseInt(txtCaballosFuerza.getText()));
		deportivo.setTiempoAlcanza100Kmh(Integer.parseInt(txtTiempoAlcanza100.getText()));
		return deportivo;
	}
	
	/**
	 * Crea una instancia de la clase Sedan con los datos ingresados en el formulario.
	 * @return El sedan creado.
	 */
	public Sedan crearSedan() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Sedan sedan=new Sedan(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		sedan.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		sedan.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(sedan, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()),
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		ClaseUtilitaria.ponerDatosCarroNoDeportivo(sedan, ClaseUtilitaria.obtenerRespuestaCadena(""+aireAcondicionado.getValue()),
		ClaseUtilitaria.obtenerRespuestaCadena(""+camaraReversa.getValue()),ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		sedan.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaletero.getText()));
		sedan.setTieneVelocidadCrucero(ClaseUtilitaria.obtenerRespuestaCadena(""+velocidadCrucero.getValue()));
		sedan.setTieneSensoresColision(ClaseUtilitaria.obtenerRespuestaCadena(""+txtSensoresColision.getValue()));
		sedan.setTieneSensorTraficoCruzado(ClaseUtilitaria.obtenerRespuestaCadena(""+sensorTraficoCruzado.getValue()));
		sedan.setTieneAsistentePermanenciaCarril(ClaseUtilitaria.obtenerRespuestaCadena(""+asistentePermanenciaCarril.getValue()));
		return sedan;
	}
	
	/**
	 * Crea una instancia de la clase Camioneta con los datos ingresados en el formulario.
	 * @return La camioneta creada.
	 */
	public Camioneta crearCamioneta() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Camioneta camioneta=new Camioneta(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		camioneta.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		camioneta.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(camioneta, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()),
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		ClaseUtilitaria.ponerDatosCarroNoDeportivo(camioneta, ClaseUtilitaria.obtenerRespuestaCadena(""+aireAcondicionado.getValue()),
		ClaseUtilitaria.obtenerRespuestaCadena(""+camaraReversa.getValue()),ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		camioneta.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaletero.getText()));
		camioneta.setTieneSensorTraficoCruzado(ClaseUtilitaria.obtenerRespuestaCadena(""+sensorTraficoCruzado.getValue()));
		camioneta.setTieneSensorColision(ClaseUtilitaria.obtenerRespuestaCadena(""+txtSensoresColision.getValue()));
		camioneta.setTieneAsistentePermanenciaCarril(ClaseUtilitaria.obtenerRespuestaCadena(""+asistentePermanenciaCarril.getValue()));
		camioneta.setEs4x4(ClaseUtilitaria.obtenerRespuestaCadena(""+combo4x4.getValue()));
		camioneta.setTieneVelocidadCrucero(ClaseUtilitaria.obtenerRespuestaCadena(""+velocidadCrucero.getValue()));
		return camioneta;
	}
	
	/**
	 * Crea una instancia de la clase Bus con los datos ingresados en el formulario.
	 * @return El bus creado.
	 */
	public Bus crearBus() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Bus bus=new Bus(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		bus.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		bus.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(bus, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()),
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		ClaseUtilitaria.ponerDatosCarroNoDeportivo(bus, ClaseUtilitaria.obtenerRespuestaCadena(""+aireAcondicionado.getValue()),
		ClaseUtilitaria.obtenerRespuestaCadena(""+camaraReversa.getValue()),ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		bus.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaletero.getText()));
		bus.setNumeroEjes(Integer.parseInt(txtNumeroEjes.getText()));
		bus.setNumeroSalidasEmergencia(Integer.parseInt(numeroSalidasEmergencia.getText()));
		return bus;
	}
	
	/**
	 * Crea una instancia de la clase PickUp con los datos ingresados en el formulario.
	 * @return La pick-up creada.
	 */
	public PickUp crearPickUp() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		PickUp pickUp=new PickUp(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		pickUp.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		pickUp.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(pickUp, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()),
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		ClaseUtilitaria.ponerDatosCarroNoDeportivo(pickUp, ClaseUtilitaria.obtenerRespuestaCadena(""+aireAcondicionado.getValue()),
		ClaseUtilitaria.obtenerRespuestaCadena(""+camaraReversa.getValue()),ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		pickUp.setEs4x4(ClaseUtilitaria.obtenerRespuestaCadena(""+combo4x4.getValue()));
		pickUp.setCapacidadCajaCarga(Double.parseDouble(txtCapacidadCajaCarga.getText()));
		return pickUp;
	}
	
	/**
	 * Crea una instancia de la clase Van con los datos ingresados en el formulario.
	 * @return La van creada.
	 */
	public Van crearVan() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Van van=new Van(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		van.setTransmision(ClaseUtilitaria.obtenerTransmision(""+transmision.getValue()));
		van.setTipoCombustible(ClaseUtilitaria.obtenerTipoCombustible(""+tipoCombustible.getValue()));
		ClaseUtilitaria.ponerDatosCarro(van, Integer.parseInt(txtNumeroPasajeros.getText()), Integer.parseInt(txtNumeroPuertas.getText()),
		Integer.parseInt(txtNumeroBolsasAire.getText()));
		ClaseUtilitaria.ponerDatosCarroNoDeportivo(van, ClaseUtilitaria.obtenerRespuestaCadena(""+aireAcondicionado.getValue()),
		ClaseUtilitaria.obtenerRespuestaCadena(""+camaraReversa.getValue()),ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		van.setCapacidadMaletero(Double.parseDouble(txtCapacidadMaletero.getText()));
		return van;
	}
	
	/**
	 * Crea una instancia de la clase Camion con los datos ingresados en el formulario.
	 * @return El camión creado.
	 */
	public Camion crearCamion() {
		String direccion="";
		if (foto.getImage()!=null) {
			direccion=foto.getImage().getUrl();
		} 	
		Camion camion=new Camion(txtMarca.getText(), ClaseUtilitaria.obtenerRespuestaCadena(""+nuevo.getValue()), txtModelo.getText(), 
		Integer.parseInt(txtCambios.getText()),Double.parseDouble(txtVelocidadMaxima.getText()), Double.parseDouble(txtCilindraje.getText()), 
		Integer.parseInt(txtAutonomiaCargaCompleta.getText()), Integer.parseInt(txtPromedioCarga.getText()), 
		ClaseUtilitaria.obtenerRespuestaCadena(""+enchufable.getValue()), ClaseUtilitaria.obtenerRespuestaCadena(""+hibridoLigero.getValue()) , 
		ClaseUtilitaria.obtenerRespuestaCadena(""+revisionTecnica.getValue()), direccion, Integer.valueOf(txtSubtotal.getText())/Integer.valueOf(txtCantidad.getText()), codeColor);
		camion.setCapacidadCarga(Double.parseDouble(txtCapacidadCarga.getText()));
		camion.setTieneABS(ClaseUtilitaria.obtenerRespuestaCadena(""+ABS.getValue()));
		camion.setNumeroEjes(Integer.parseInt(txtNumeroEjes.getText()));
		camion.setTieneFrenosAire(ClaseUtilitaria.obtenerRespuestaCadena(""+frenosAire.getValue()));
		camion.setTipoCamion(txtTipoCamion.getText());
		return camion;
	}
	
	/**
	 * Establece los datos del vehículo en los campos del formulario.
	 * @param vehiculo El vehículo del cual se obtendrán los datos.
	 */
	public void ponerDatosVehiculo(Vehiculo vehiculo) {
		Image imagen=null;
		if (!vehiculo.getFoto().equals("")) {
			imagen=new Image(vehiculo.getFoto());
			lblSeleccion.setText("");
		}
		foto.setImage(imagen);
		bloquearEntradasExtra();
		tipoVehiculo.setValue(vehiculo.obtenerTipoVehiculoCadena());
		txtMarca.setText(vehiculo.getMarca());
		txtModelo.setText(vehiculo.getModelo());
		enchufable.setValue(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsEnchufable()));
		revisionTecnica.setValue(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isTieneRevisionTecnica()));
		tipoCombustible.setValue(vehiculo.obtenerTipoCombustibleCadena());
		nuevo.setValue(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isNuevo()));
		transmision.setValue(vehiculo.obtenerTransmisionCadena());
		txtCambios.setText(""+vehiculo.getCambios());
		txtVelocidadMaxima.setText(""+vehiculo.getVelocidadMaxima());
		txtCilindraje.setText(""+vehiculo.getCilindraje());
		txtAutonomiaCargaCompleta.setText(""+vehiculo.getAutonomiaCargaCompleta());
		txtPromedioCarga.setText(""+vehiculo.getTiempoPromedioCarga());
		hibridoLigero.setValue(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsHibridoLigero()));
		switch(""+tipoVehiculo.getValue()) {
		case "Deportivo": desbloquearDeportivoEntradas(); break;
		case "Sedan": desbloquearSedanEntradas(); break;
		case "Camioneta": desbloquearCamionetaEntradas(); break;
		case "Bus": desbloquearBusEntradas(); break;
		case "Pick up": desbloquearPickUpEntradas(); break;
		case "Van": desbloquearVanEntradas(); break;
		case "Camion": desbloquearCamionEntradas(); break;
	}
	}
	
	/**
	 * Actualiza los datos de un objeto Carro en la interfaz gráfica.
	 * @param carro El objeto Carro del cual se obtendrán los datos.
	 */
	public void ponerDatosCarro(Carro carro) {
		txtNumeroPasajeros.setText(""+carro.getNumeroPasajeros());
		txtNumeroPuertas.setText(""+carro.getNumeroPuertas());
		txtNumeroBolsasAire.setText(""+carro.getNumeroBolsasAire());
	}
	
	/**
	 * Actualiza los datos de un objeto CarroNoDeportivo en la interfaz gráfica.
	 * @param carroNoDeportivo El objeto CarroNoDeportivo del cual se obtendrán los datos.
	 */
	public void ponerDatosCarroNoDeportivo(CarroNoDeportivo CarroNoDeportivo) {
		ponerDatosCarro(CarroNoDeportivo);
		aireAcondicionado.setValue(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneAireAcondicionado()));
		camaraReversa.setValue(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneCamaraReversa()));
		ABS.setValue(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneABS()));
	}
	
	/**
	 * Actualiza los datos de un objeto Deportivo en la interfaz gráfica.
	 * @param deportivo El objeto Deportivo del cual se obtendrán los datos.
	 */
	public void ponerDatosDeportivo(Deportivo deportivo) {
		ponerDatosCarro(deportivo);
		txtCaballosFuerza.setText(""+deportivo.getNumeroCaballosFuerza());
		txtTiempoAlcanza100.setText(""+deportivo.getTiempoAlcanza100Kmh());
	}
	
	/**
	 * Actualiza los datos de un objeto Sedan en la interfaz gráfica.
	 * @param sedan El objeto Sedan del cual se obtendrán los datos.
	 */
	public void ponerDatosSedan(Sedan sedan) {
		ponerDatosCarroNoDeportivo(sedan);
		txtCapacidadMaletero.setText(""+sedan.getCapacidadMaletero());
		velocidadCrucero.setValue(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneVelocidadCrucero()));
		txtSensoresColision.setValue(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneSensoresColision()));
		sensorTraficoCruzado.setValue(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneSensorTraficoCruzado()));
		asistentePermanenciaCarril.setValue(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneAsistentePermanenciaCarril()));
	}
	
	/**
	 * Actualiza los datos de un objeto Camioneta en la interfaz gráfica.
	 * @param camioneta El objeto Camioneta del cual se obtendrán los datos.
	 */
	public void ponerDatosCamioneta(Camioneta camioneta) {
		ponerDatosCarroNoDeportivo(camioneta);
		txtCapacidadMaletero.setText(null);
		sensorTraficoCruzado.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneSensorTraficoCruzado()));
		txtSensoresColision.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneSensorColision()));
		asistentePermanenciaCarril.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneAsistentePermanenciaCarril()));
		combo4x4.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isEs4x4()));
		velocidadCrucero.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneVelocidadCrucero()));
	}
	
	/**
	 * Actualiza los datos de un objeto Bus en la interfaz gráfica.
	 * @param bus El objeto Bus del cual se obtendrán los datos.
	 */
	public void ponerDatosBus(Bus bus) {
		ponerDatosCarroNoDeportivo(bus);
		txtCapacidadMaletero.setText(""+bus.getCapacidadMaletero());
		txtNumeroEjes.setText(""+bus.getNumeroEjes());
		numeroSalidasEmergencia.setText(""+bus.getNumeroSalidasEmergencia());
	}
	
	/**
	 * Actualiza los datos de un objeto PickUp en la interfaz gráfica.
	 * @param pickUp El objeto PickUp del cual se obtendrán los datos.
	 */
	public void ponerDatosPickUp(PickUp pickUp) {
		ponerDatosCarroNoDeportivo(pickUp);
		combo4x4.setValue(ClaseUtilitaria.obtenerRespuestaCadena(pickUp.isEs4x4()));
		txtCapacidadCajaCarga.setText(""+pickUp.getCapacidadCajaCarga());
	}
	
	/**
	 * Actualiza los datos de un objeto Van en la interfaz gráfica.
	 * @param van El objeto Van del cual se obtendrán los datos.
	 */
	public void ponerDatosVan(Van van) {
		ponerDatosCarroNoDeportivo(van);
		txtCapacidadMaletero.setText(""+van.getCapacidadMaletero());
	}
	
	/**
	 * Actualiza los datos de un objeto Camion en la interfaz gráfica.
	 * @param camion El objeto Camion del cual se obtendrán los datos.
	 */
	public void ponerDatosCamion(Camion camion) {
		ponerDatosVehiculo(camion);
		txtCapacidadCarga.setText(""+camion.getCapacidadCarga());
		ABS.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camion.isTieneABS()));
		txtNumeroEjes.setText(""+camion.getNumeroEjes());
		frenosAire.setValue(ClaseUtilitaria.obtenerRespuestaCadena(camion.isTieneFrenosAire()));
		txtTipoCamion.setText(camion.getTipoCamion());
	}

	/**
	 * Actualiza los datos correspondientes al tipo de vehículo en la interfaz gráfica.
	 * Selecciona qué método utilizar para mostrar los datos según el tipo de vehículo.
	 */
	public void ponerDatosCorrespondientes() {
		Vehiculo vehiculo=detalle.getVehiculo();
		txtSubtotal.setText(""+detalle.getSubTotal());
		txtCantidad.setText(""+detalle.getCantidad());
		switch(vehiculo.obtenerTipoVehiculo()) {
			case MOTO: ponerDatosVehiculo(vehiculo); break;
			case DEPORTIVO: ponerDatosDeportivo((Deportivo)vehiculo); break;
			case SEDAN: ponerDatosSedan((Sedan)vehiculo); break;
			case CAMIONETA: ponerDatosCamioneta((Camioneta)vehiculo); break;
			case BUS: ponerDatosBus((Bus)vehiculo); break;
			case PICK_UP: ponerDatosPickUp((PickUp)vehiculo); break;
			case VAN: ponerDatosVan((Van)vehiculo); break;
			case CAMION: ponerDatosCamion((Camion)vehiculo); break;
		}
	}
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {
		lblSeleccion.setText("Seleccionar imagen");
		organizarOpcionesBinarias(obtenerCombox());
		ObservableList<String> tiposVechiculos=FXCollections.observableArrayList();
		tiposVechiculos.add("Moto");
		tiposVechiculos.add("Deportivo");
		tiposVechiculos.add("Sedan");
		tiposVechiculos.add("Camioneta");
		tiposVechiculos.add("Bus");
		tiposVechiculos.add("Pick up");
		tiposVechiculos.add("Van");
		tiposVechiculos.add("Camion");
		tipoVehiculo.setItems(tiposVechiculos);
		ObservableList<String> tiposCombustibles=FXCollections.observableArrayList();
		tiposCombustibles.add("Gasolina");
		tiposCombustibles.add("Diesel");
		tiposCombustibles.add("Electrico");
		tiposCombustibles.add("Hibrido");
		tipoCombustible.setItems(tiposCombustibles);
		ObservableList<String> transmisiones=FXCollections.observableArrayList();
		transmisiones.add("Automatica");
		transmisiones.add("Manual");
		transmision.setItems(transmisiones);
		
	}
	
	/**
	 * Cierra la ventana actual.
	 */
	@FXML
	private void volver() {
		ventana.close();
	}
	
	/**
	 * Guarda los datos ingresados en el formulario.
	 * Si los datos son válidos, crea un objeto de tipo Vehiculo según el tipo seleccionado y lo asigna al detalle de la transacción.
 	 * Luego, establece la bandera de "fueGuardado" en verdadero y cierra la ventana.
	 */
	@FXML
	private void guardar() {
		if (sonDatosCorrespondienetesValidos()) {
			Vehiculo vehiculo=null;
			switch(""+tipoVehiculo.getValue()) {
				case "Moto": vehiculo=crearMoto(); break;
				case "Deportivo": vehiculo=crearDeportivo(); break;
				case "Sedan": vehiculo=crearSedan(); break;				
				case "Camioneta": vehiculo=crearCamioneta(); break;
				case "Bus": vehiculo=crearBus(); break;
				case "Pick up": vehiculo=crearPickUp(); break;
				case "Van": vehiculo=crearVan(); break;
				case "Camion": vehiculo=crearCamion(); break;
			}
			detalle=new DetalleTransaccion(Double.parseDouble(txtSubtotal.getText()),Integer.parseInt(txtCantidad.getText()),vehiculo);
			fueGuardado=true;
			ventana.close();
			
			//ClaseUtilitaria.aumentarCantidadVehiculo(listaVehiculosTemporales, detalle.getVehiculo(), detalle.getCantidad());
			
			mfm.listaPosibles(listaVehiculosTemporales);
		}
	}
	
	/**
	 * Bloquea las entradas correspondientes al tipo de vehículo seleccionado.
	 */
	@FXML
	private void bloquearDatosCorrespondienetes() {
		bloquearEntradasExtra();
		switch(""+tipoVehiculo.getValue()) {
			case "Deportivo": desbloquearDeportivoEntradas(); break;
			case "Sedan": desbloquearSedanEntradas(); break;
			case "Camioneta": desbloquearCamionetaEntradas(); break;
			case "Bus": desbloquearBusEntradas(); break;
			case "Pick up": desbloquearPickUpEntradas(); break;
			case "Van": desbloquearVanEntradas(); break;
			case "Camion": desbloquearCamionEntradas(); break;
		}
	}
	
	/**
	 * Organiza las entradas de acuerdo al detalle de la transacción.
	 * Si el detalle no es nulo, muestra los datos correspondientes en el formulario.
	 * De lo contrario, bloquea las entradas adicionales.
	 */
	public void organizarEntradas() {
		if (detalle!=null) {
			ponerDatosCorrespondientes();
		} else {
			bloquearEntradasExtra();
		}
	}
	
	/**
	 * Abre un cuadro de diálogo para seleccionar una imagen y la muestra en el ImageView.
	 */
	@FXML
	public void seleccionarImagen() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.jpg", "*.png", "*.jpeg"));
        //con el try intentar el prmero mio y el catch el de selectedfile en string
        // Mostrar el cuadro de diálogo para seleccionar un archivo
        File selectedFile = fileChooser.showOpenDialog(ventana);
        
        if (selectedFile != null) {
            // Cargar la imagen seleccionada en el ImageView
            Image image = new Image(selectedFile.toURI().toString());
            foto.setImage(image);
            lblSeleccion.setVisible(false);
            btnSeleccion.setVisible(false);
        } else {
        	foto.setImage(null);
        	lblSeleccion.setVisible(true);
        	btnSeleccion.setVisible(true);
        }
	}

	/**
	 * Devuelve el detalle de la transacción.
	 * @return El objeto DetalleTransaccion.
	 */
	public DetalleTransaccion detalleObtenido() {
		return detalle;
	}

	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
	/**
	 * La ventana actual.
	 * @param detalle El objeto DetalleTransaccion.
	 */
	public void obtenerDetalleTransaccion(DetalleTransaccion detalle) {
		this.detalle=detalle;
	}

}