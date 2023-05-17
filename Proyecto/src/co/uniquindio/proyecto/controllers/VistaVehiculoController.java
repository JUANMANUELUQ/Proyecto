package co.uniquindio.proyecto.controllers;

import javafx.scene.control.*;
import javafx.fxml.FXML;


public class VistaVehiculoController {
	
	@FXML
	private Label lblMarca;
	@FXML
	private Label lblModelo;
	@FXML
	private Label lblVelocidadMax;
	@FXML
	private Label lblAutonomiaCarga;
	@FXML
	private Label lblEnchufable;
	@FXML
	private Label lblRevisionTec;
	@FXML
	private Label lblTipCombustible;
	@FXML
	private Label lblTipVehiculo;
	@FXML
	private Label lblNumPuertas;
	@FXML
	private Label lblAireAcondicionado;
	@FXML
	private Label lblABS;
	@FXML
	private Label lblNumEjes;
	@FXML
	private Label lblFrenosAire;
	@FXML
	private Label lblNumCaballosFuerza;
	@FXML
	private Label lblCapMaletero;
	@FXML
	private Label lblCapCajaCarga;
	@FXML
	private Label lblSensoresColision;
	@FXML
	private Label lblNuevo;
	@FXML
	private Label lblCambios;
	@FXML
	private Label lblCilindraje;
	@FXML
	private Label lblTiempoCarga;
	@FXML
	private Label lblHibriLigero;
	@FXML
	private Label lblTransmision;
	@FXML
	private Label lblNumPasajeros;
	@FXML
	private Label lblNumBolsasAire;
	@FXML
	private Label lblCamReversa;
	@FXML
	private Label lblCapacidadCarga;
	@FXML
	private Label lblTipCamion;
	@FXML
	private Label lblTiempo100km;
	@FXML
	private Label lbl4x4;
	@FXML
	private Label lblVelCrucero;
	@FXML
	private Label lblSensorTrafCruz;
	@FXML
	private Label lblAsisPermCarril;
	@FXML
	private Label lblNumSalidasEmer;
	
	
	public VistaVehiculoController() {
		
	}
	
	public void initialize(){
		lblMarca.setText("");
		lblModelo.setText("");
		lblVelocidadMax.setText("");
		lblAutonomiaCarga.setText("");
		lblEnchufable.setText("");
		lblRevisionTec.setText("");
		lblTipCombustible.setText("");
		lblTipVehiculo.setText("");
		lblNumPuertas.setText("");
		lblAireAcondicionado.setText("");
		lblABS.setText("");
		lblNumEjes.setText("");
		lblFrenosAire.setText("");
		lblNumCaballosFuerza.setText("");
		lblCapMaletero.setText("");
		lblCapCajaCarga.setText("");
		lblSensoresColision.setText("");
		lblNuevo.setText("");
		lblCambios.setText("");
		lblCilindraje.setText("");
		lblTiempoCarga.setText("");
		lblHibriLigero.setText("");
		lblTransmision.setText("");
		lblNumPasajeros.setText("");
		lblNumBolsasAire.setText("");
		lblCamReversa.setText("");
		lblCapacidadCarga.setText("");
		lblTipCamion.setText("");
		lblTiempo100km.setText("");
		lbl4x4.setText("");
		lblVelCrucero.setText("");
		lblSensorTrafCruz.setText("");
		lblAsisPermCarril.setText("");
		lblNumSalidasEmer.setText("");
	}

}
