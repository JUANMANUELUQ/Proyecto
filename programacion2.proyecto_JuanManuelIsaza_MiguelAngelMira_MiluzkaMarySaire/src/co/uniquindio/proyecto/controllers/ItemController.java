package co.uniquindio.proyecto.controllers;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Camion;
import co.uniquindio.proyecto.model.Vehiculo;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * La clase ItemController es el controlador de la vista de elementos.
 * Gestiona la lógica y la interacción de la interfaz gráfica para cada elemento.
 */
public class ItemController {
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Stage ventana = mfm.getVentana();
	private Aplicacion aplicacion = mfm.getAplicacion();
	
	@FXML
    private ImageView imageVehicle;
	
	@FXML
	private Text textPrice;
	
    @FXML
    private Text textName;
    
    private Vehiculo vehiculo;
    
    private Integer price;
    
    private MyListener myListener;
    
    @FXML
    private Label lblCantidad;
    
	private List<Vehiculo> listaVehiculosTemporales = mfm.obtenerCopiaVehiculos();
    
    /**
	 * Inicializa la clase controlador.
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Método invocado cuando se hace clic en el elemento.
	 * Notifica al listener de clic con el vehículo asociado.
	 */
	@FXML
	private void click() {
		myListener.onClickListener(vehiculo);
	}
	
	/**
	 * Establece los datos del vehículo y el listener para el elemento.
	 * @param vehiculo El vehículo asociado al elemento.
	 * @param myListener El listener de clic para el elemento.
	 */
	public void setData(Vehiculo vehiculo, MyListener myListener) {
		this.myListener = myListener;
		this.vehiculo = vehiculo;
		price = vehiculo.getPrecio();
		textName.setText(vehiculo.getModelo());
		String numeroFormateado = NumberFormat.getNumberInstance(Locale.getDefault()).format(price);
		textPrice.setText(Aplicacion.CURRENCY + numeroFormateado);
		try {
			Image image = new Image(getClass().getResourceAsStream(vehiculo.getFoto()));
			imageVehicle.setImage(image);
		} catch (Exception e) {
			if (!vehiculo.getFoto().equals("")) {
				Image image = new Image(vehiculo.getFoto());
				imageVehicle.setImage(image);
			}
		}
		int canti = ClaseUtilitaria.obtenerCantidadVehiculo(vehiculo, listaVehiculosTemporales);
		lblCantidad.setText(String.valueOf(canti));
	}
	
	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}
	
	/**
	 * Establece la aplicación principal.
	 * @param aplicacion La aplicación principal.
	 */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}