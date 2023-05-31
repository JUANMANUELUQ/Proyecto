package co.uniquindio.proyecto.controllers;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;

import co.uniquindio.proyecto.model.Bus;
import co.uniquindio.proyecto.model.Camion;
import co.uniquindio.proyecto.model.Camioneta;
import co.uniquindio.proyecto.model.Carro;
import co.uniquindio.proyecto.model.CarroNoDeportivo;
import co.uniquindio.proyecto.model.Deportivo;
import co.uniquindio.proyecto.model.DetalleTransaccion;
import co.uniquindio.proyecto.model.PickUp;
import co.uniquindio.proyecto.model.Sedan;
import co.uniquindio.proyecto.model.Van;
import co.uniquindio.proyecto.model.Vehiculo;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.fxml.FXML;

/**
 * 
 * Clase controlador de la interfaz con los vehiculos disponibles para la venta y alquiler
 *
 */
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
	private Label lblTipoCombustible;
	@FXML
	private Label lblTipoVehiculo;
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
	private Label lblTipoCamion;
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
	@FXML
	private ImageView foto;
	private Stage ventana;
	private Vehiculo vehiculo;
	
	/**
	 * Establece los datos de un vehículo en la interfaz gráfica.
	 * @param vehiculo El vehículo del cual se obtendrán los datos.
	 */
	public void ponerDatosVehiculo(Vehiculo vehiculo) {
		try {
			Image image = new Image(getClass().getResourceAsStream(vehiculo.getFoto()));
			foto.setImage(image);
		}
		catch (Exception e){
			if (!vehiculo.getFoto().equals("")) {
				Image image = new Image(vehiculo.getFoto());
				foto.setImage(image);
			}
		}
		
		lblTipoVehiculo.setText(vehiculo.obtenerTipoVehiculoCadena());
		lblMarca.setText(vehiculo.getMarca());
		lblModelo.setText(vehiculo.getModelo());
		lblEnchufable.setText(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsEnchufable()));
		lblRevisionTec.setText(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isTieneRevisionTecnica()));
		lblTipoCombustible.setText(vehiculo.obtenerTipoCombustibleCadena());
		lblNuevo.setText(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isNuevo()));
		lblTransmision.setText(vehiculo.obtenerTransmisionCadena());
		lblCambios.setText(""+vehiculo.getCambios());
		lblVelocidadMax.setText(""+vehiculo.getVelocidadMaxima());
		lblCilindraje.setText(""+vehiculo.getCilindraje());
		lblAutonomiaCarga.setText(""+vehiculo.getAutonomiaCargaCompleta());
		lblTiempoCarga.setText(""+vehiculo.getTiempoPromedioCarga());
		lblHibriLigero.setText(ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsHibridoLigero()));
	}
	
	/**
 	 * Establece los datos de un carro en la interfaz gráfica.
	 * @param carro El carro del cual se obtendrán los datos.
	 */
	public void ponerDatosCarro(Carro carro) {
		ponerDatosVehiculo(carro);
		lblNumPasajeros.setText(""+carro.getNumeroPasajeros());
		lblNumPuertas.setText(""+carro.getNumeroPuertas());
		lblNumBolsasAire.setText(""+carro.getNumeroBolsasAire());
	}
	
	/**
 	 * Establece los datos de un carro no deportivo en la interfaz gráfica.
	 * @param carroNoDeportivo El carro no deportivo del cual se obtendrán los datos.
	 */
	public void ponerDatosCarroNoDeportivo(CarroNoDeportivo CarroNoDeportivo) {
		ponerDatosCarro(CarroNoDeportivo);
		lblAireAcondicionado.setText(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneAireAcondicionado()));
		lblCamReversa.setText(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneCamaraReversa()));
		lblABS.setText(ClaseUtilitaria.obtenerRespuestaCadena(CarroNoDeportivo.isTieneABS()));
	}
	
	/**
	 * Establece los datos de un vehículo deportivo en la interfaz gráfica.
	 * @param deportivo El vehículo deportivo del cual se obtendrán los datos.
	 */
	public void ponerDatosDeportivo(Deportivo deportivo) {
		ponerDatosCarro(deportivo);
		lblNumCaballosFuerza.setText(""+deportivo.getNumeroCaballosFuerza());
		lblTiempo100km.setText(""+deportivo.getTiempoAlcanza100Kmh());
	}
	
	/**
	 * Establece los datos de un sedán en la interfaz gráfica.
	 * @param sedan El sedán del cual se obtendrán los datos.
	 */
	public void ponerDatosSedan(Sedan sedan) {
		ponerDatosCarroNoDeportivo(sedan);
		lblCapMaletero.setText(""+sedan.getCapacidadMaletero());
		lblVelCrucero.setText(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneVelocidadCrucero()));
		lblSensoresColision.setText(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneSensoresColision()));
		lblSensorTrafCruz.setText(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneSensorTraficoCruzado()));
		lblAsisPermCarril.setText(ClaseUtilitaria.obtenerRespuestaCadena(sedan.isTieneAsistentePermanenciaCarril()));
	}
	
	/**
	 * Establece los datos de una camioneta en la interfaz gráfica.
	 * @param camioneta La camioneta de la cual se obtendrán los datos.
	 */
	public void ponerDatosCamioneta(Camioneta camioneta) {
		ponerDatosCarroNoDeportivo(camioneta);
		lblCapMaletero.setText(null);
		lblSensorTrafCruz.setText(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneSensorTraficoCruzado()));
		lblSensoresColision.setText(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneSensorColision()));
		lblAsisPermCarril.setText(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneAsistentePermanenciaCarril()));
		lbl4x4.setText(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isEs4x4()));
		lblVelCrucero.setText(ClaseUtilitaria.obtenerRespuestaCadena(camioneta.isTieneVelocidadCrucero()));
	}
	
	/**
	 * Establece los datos de un bus en la interfaz gráfica.
	 * @param bus El bus del cual se obtendrán los datos.
	 */
	public void ponerDatosBus(Bus bus) {
		ponerDatosCarroNoDeportivo(bus);
		lblCapMaletero.setText(""+bus.getCapacidadMaletero());
		lblNumEjes.setText(""+bus.getNumeroEjes());
		lblNumSalidasEmer.setText(""+bus.getNumeroSalidasEmergencia());
	}
	
	/**
	 * Establece los datos de una camioneta pick-up en la interfaz gráfica.
	 * @param pickUp La camioneta pick-up de la cual se obtendrán los datos.
	 */
	public void ponerDatosPickUp(PickUp pickUp) {
		ponerDatosCarroNoDeportivo(pickUp);
		lbl4x4.setText(ClaseUtilitaria.obtenerRespuestaCadena(pickUp.isEs4x4()));
		lblCapCajaCarga.setText(""+pickUp.getCapacidadCajaCarga());
	}
	
	/**
	 * Establece los datos de una van en la interfaz gráfica.
	 * @param van La van de la cual se obtendrán los datos.
	 */
	public void ponerDatosVan(Van van) {
		ponerDatosCarroNoDeportivo(van);
		lblCapMaletero.setText(""+van.getCapacidadMaletero());
	}
	
	/**
	 * Establece los datos de un camión en la interfaz gráfica.
	 * @param camion El camión del cual se obtendrán los datos.
	 */
	public void ponerDatosCamion(Camion camion) {
		ponerDatosVehiculo(camion);
		lblCapacidadCarga.setText(""+camion.getCapacidadCarga());
		lblABS.setText(ClaseUtilitaria.obtenerRespuestaCadena(camion.isTieneABS()));
		lblNumEjes.setText(""+camion.getNumeroEjes());
		lblFrenosAire.setText(ClaseUtilitaria.obtenerRespuestaCadena(camion.isTieneFrenosAire()));
		lblTipoCamion.setText(camion.getTipoCamion());
	}

	/**
	 * Establece los datos correspondientes al vehículo en la interfaz gráfica, según su tipo.
	 */
	public void ponerDatosCorrespondientes() {
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
	 * Metodo que inicializa el controlador
	 */
	public void initialize(){

	}
	
	/**
	 * Cierra la ventana actual
	 */
	@FXML
	public void volver() {
		ventana.close();
	}
	
	/**
	 * Establece el vehículo del cual se obtendrán los datos.
	 * @param vehiculo El vehículo del cual se obtendrán los datos.
	 */
	public void obtenerVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
	}

	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}

}
