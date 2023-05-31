package co.uniquindio.proyecto.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.JOptionPane;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.model.Alquiler;
import co.uniquindio.proyecto.model.Bus;
import co.uniquindio.proyecto.model.Camion;
import co.uniquindio.proyecto.model.Camioneta;
import co.uniquindio.proyecto.model.Carro;
import co.uniquindio.proyecto.model.CarroNoDeportivo;
import co.uniquindio.proyecto.model.Compra;
import co.uniquindio.proyecto.model.Deportivo;
import co.uniquindio.proyecto.model.DetalleTransaccion;
import co.uniquindio.proyecto.model.PickUp;
import co.uniquindio.proyecto.model.Sedan;
import co.uniquindio.proyecto.model.TipoCombustible;
import co.uniquindio.proyecto.model.TipoTransaccion;
import co.uniquindio.proyecto.model.Transaccion;
import co.uniquindio.proyecto.model.Transmision;
import co.uniquindio.proyecto.model.Van;
import co.uniquindio.proyecto.model.Vehiculo;
import co.uniquindio.proyecto.model.Venta;
import co.uniquindio.proyecto.util.ClaseUtilitaria;
import co.uniquindio.proyecto.util.Persistencia;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
/**
 * Controlador de la ventana de vehículos.
 */
public class VentanaVehiculosController {
	
	private ModelFactoryController mfm = ModelFactoryController.getInstance();
	private Aplicacion aplicacion=mfm.getAplicacion();
	private Stage ventana;
	private TipoTransaccion tipoTransaccion;
	private DetalleTransaccion detalleObtenido=null;
	List<Vehiculo> vehiculosTemporales= mfm.obtenerCopiaVehiculos();
	private Set<Vehiculo> vehiculosMostrados = new HashSet<>();
	

	 @FXML
	 private Pane chosenVehicle;

	 @FXML
	 private Label priceVehicle;
	 
	 @FXML
	 private Label cantidadVehiculo;

	 @FXML
	 private ImageView imageVehicle;

	 @FXML
	 private Text nameVehicle;
	 
	 @FXML
	 private GridPane grid;

	 @FXML
	 private ScrollPane scroll;
	
	 private List<Vehiculo> vehiculos = new ArrayList<>();
	 
	 private Image image;
	 
	 private MyListener myListener;
	 
	 @FXML
	 private TextArea textAreaDetalles;
	 
	 @FXML
	 private ComboBox<String> comboBoxCantidad;
	
	 @FXML
	 private ComboBox<String> comboBoxFiltrar;
	 
	 private Vehiculo vehiculoElegido=null;
	 
	
	/**
	 * Metodo que inicializa la clase controlador
	 */
	@FXML
	private void initialize() {	
		iniciarComboBoxes();
	}
	
	/**
	 * Verifica si los datos ingresados son válidos.
	 * @return true si los datos son válidos, false de lo contrario.
	 */
	public boolean sonDatosValidos() {
		boolean sonValidos=false;
		String msj="";
		try {
			if (desformatearPrecio(priceVehicle.getText())<0) {
				throw new Exception("Valor invalido");
			}
		} catch (Exception e) {
			
			if (desformatearPrecio(priceVehicle.getText())==0) {
				msj+="\n\nEl subtotal no debe estar vacio";
			} else {
				msj+="\n\nSubtotal no valido";
			}
		}
		if (vehiculoElegido==null) {
			msj+="\n\nDebe elejir un vehiculo";
		} else {
			if (msj.equals("") && Integer.parseInt(comboBoxCantidad.getValue())>
			ClaseUtilitaria.obtenerCantidadVehiculo(vehiculoElegido, vehiculosTemporales)) {
				msj+="\n\nLa cantidad indicada supera a la cantidad del vehiculo seleccionado";
			}
		}
		if (msj.equals("")) {
			sonValidos=true;
		} else {
			ClaseUtilitaria.mostrarMensaje("Entradas no validas", "Entradas no validas", msj, AlertType.ERROR);
		}
		return sonValidos;
	}
	
	/**
	 * Acción que se ejecuta al seleccionar un valor en el combo de cantidad.
	 */
	@FXML
	private void accionaComboCant() {
		accionComboCantidad();
		
	}
	
	/**
	 * Realiza la acción correspondiente al cambio de cantidad en el combo.
	 */
	private void accionComboCantidad() {
		Integer cantidad=Integer.parseInt(comboBoxCantidad.getValue());
		Integer price=vehiculoElegido.getPrecio() * cantidad;
		String numeroFormateado = NumberFormat.getNumberInstance(Locale.getDefault()).format(price);
		priceVehicle.setText(numeroFormateado);
	}
	
	/**
	 * Desformatea el precio formateado y lo devuelve como entero.
	 * @param precioFormateado El precio formateado.
	 * @return El precio desformateado.
	 */
	private int desformatearPrecio(String precioFormateado) {
	    try {
	        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
	        Number number = numberFormat.parse(precioFormateado);
	        return number.intValue();
	    } catch (ParseException e) {
	        e.printStackTrace();
	        // En caso de error, devuelve un valor predeterminado o lanza una excepción adecuada según tus necesidades
	        return -1;
	    }
	}

	/**
	 * Guarda los datos ingresados en la interfaz.
	 */
	@FXML
	private void guardar() {
		if (sonDatosValidos()) {  
			DetalleTransaccion detalle=new DetalleTransaccion((double)desformatearPrecio(priceVehicle.getText()),Integer.parseInt(comboBoxCantidad.getValue()),
					vehiculoElegido);
			
			ClaseUtilitaria.reducirCantidadVehiculo(vehiculosTemporales, vehiculoElegido ,Integer.parseInt(comboBoxCantidad.getValue()));
			detalleObtenido=detalle; 
			
			mfm.listaPosibles(vehiculosTemporales);
			ventana.close();
		}
	}
	
	/**
	 * Inicializa el GridPane con los datos de los vehículos.
	 */
	public void iniciarGridPane() {
		//GridPane
		vehiculosMostrados.clear();
				if(vehiculos.size()>0) {
					//selecciona automaticamente el vehiculo elegido como el primero en la lista
					setChosenVehicle(vehiculos.get(0));
					vehiculoElegido=vehiculos.get(0);
					myListener = new MyListener() {
						@Override
						public void onClickListener(Vehiculo vehiculo) {
							setChosenVehicle(vehiculo);
						}
					};
				}
				int column=0;
				int row=1;
				
				try {
					for (int i = 0; i < vehiculos.size(); i++) {
						if (vehiculosMostrados.contains(vehiculos.get(i))) {
					        continue; // Si el vehículo ya se ha mostrado, se salta a la siguiente iteración
					    }				    
					    vehiculosMostrados.add(vehiculos.get(i)); // Agregar el vehículo al conjunto de vehículos mostrados
						FXMLLoader fxmlLoader = new FXMLLoader();
						fxmlLoader.setLocation(getClass().getResource("/co/uniquindio/proyecto/view/Item.fxml"));
						AnchorPane anchorPane = fxmlLoader.load();
						
						ItemController itemController = fxmlLoader.getController();
						itemController.setData(vehiculos.get(i), myListener);
						
						if (column == 3) {
							column =0;
							row++;
						}	
						grid.add(anchorPane, column++, row);
						
						//grid width
						grid.setMinWidth(Region.USE_COMPUTED_SIZE);
						grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
						grid.setMaxWidth(Region.USE_PREF_SIZE);
						
						//grid height
						grid.setMinHeight(Region.USE_COMPUTED_SIZE);
						grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
						grid.setMaxHeight(Region.USE_PREF_SIZE);
						
						GridPane.setMargin(anchorPane, new Insets(10, 10, 10, 10));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/**
	 * Inicializa los ComboBoxes de la interfaz con sus respectivas opciones y valores predeterminados.
	 */
	private void iniciarComboBoxes() {
		List<String> opciones = Arrays.asList("1", "2", "3", "4", "5");
		comboBoxCantidad.setItems(FXCollections.observableArrayList(opciones));
		comboBoxCantidad.setValue("1");
		
		List<String> opcionesFiltro = Arrays.asList("Sedan", "Deportivo", "Camioneta", "Pick up", "Van", "Bus", "Camion", "Moto", "Todos");
		comboBoxFiltrar.setItems(FXCollections.observableArrayList(opcionesFiltro));
		comboBoxFiltrar.setValue("Todos");
	}
	
	/**
	 * Maneja el evento de selección del ComboBox de filtro.
	 * Filtra y muestra los vehículos según el tipo seleccionado en el ComboBox.
	 */
	@FXML
	private void seleccionarComboFiltro() {
	    String tipoSeleccionado = comboBoxFiltrar.getValue(); // Obtener el tipo seleccionado del ComboBox

	    grid.getChildren().clear(); // Limpiar los elementos existentes en el GridPane
	    int column = 0;
	    int row = 1;

	    if (tipoSeleccionado.equals("Todos")) {
	    	iniciarGridPane();
	    	
	    }else {
	    	vehiculosMostrados.clear();
	    	for (Vehiculo vehiculo : vehiculos) {
	    		if (vehiculosMostrados.contains(vehiculo) ){
			        continue; // Si el vehículo ya se ha mostrado, se salta a la siguiente iteración
			    }
	    		vehiculosMostrados.add(vehiculo);
		        if (vehiculo.obtenerTipoVehiculoCadena().equals(tipoSeleccionado)) { // Filtrar por el tipo seleccionado
		            try {
		                FXMLLoader fxmlLoader = new FXMLLoader();
		                fxmlLoader.setLocation(getClass().getResource("/co/uniquindio/proyecto/view/Item.fxml"));
		                AnchorPane anchorPane = fxmlLoader.load();

		                ItemController itemController = fxmlLoader.getController();
		                itemController.setData(vehiculo, myListener);

		                if (column == 3) {
		                    column = 0;
		                    row++;
		                }

		                grid.add(anchorPane, column++, row);

		                GridPane.setMargin(anchorPane, new Insets(10, 10, 10, 10));
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
	    }
	    

	    if (grid.getChildren().isEmpty()) {
	        iniciarGridPane();
	    }
	}
	
	/**
	 * Establece el vehículo seleccionado y actualiza los elementos visuales correspondientes.
	 * @param vehiculo El vehículo seleccionado.
	 */
	private void setChosenVehicle(Vehiculo vehiculo) {
		vehiculoElegido=vehiculo;
		nameVehicle.setText(vehiculo.getModelo());
		Integer price=vehiculo.getPrecio();
		String numeroFormateado = NumberFormat.getNumberInstance(Locale.getDefault()).format(price);
		priceVehicle.setText(numeroFormateado);
		try {
			Image image = new Image(getClass().getResourceAsStream(vehiculo.getFoto()));
			imageVehicle.setImage(image);
		}
		catch (Exception e){
			if (!vehiculo.getFoto().equals("")) {
				Image image = new Image(vehiculo.getFoto());
				imageVehicle.setImage(image);
			} else {
				imageVehicle.setImage(null);
			}
		}
		chosenVehicle.setStyle("-fx-background-color: #"+ vehiculo.getCodeColor() +";\n"
				+ "    -fx-background-radius:30;");
		
		textAreaDetalles.setText(obtenerDatosVehiculo(vehiculo).getText());
		//aqui reiniciar el valor de combobox cantidad y calcular otra vez el precio total
		comboBoxCantidad.setValue("1");
		accionComboCantidad();
	}
	
	/**
	 * Metodo para abrir los detalles del vehiculo seleccionado
	 */
	@FXML
	public void iniciarVentanaDetalles(){
		if (vehiculoElegido!=null) {
			aplicacion.mostrarVistaVehiculo(ventana, vehiculoElegido);

		}
	}
	
	/**
	 * Obtiene los datos de un vehículo y los muestra en un Label.
 	 * @param vehiculo El vehículo del cual se obtendrán los datos.
	 * @return Un Label que contiene los datos del vehículo.
	 */
	public Label obtenerDatosVehiculo(Vehiculo vehiculo) {
		Label labelContenedor = new Label();
		
		labelContenedor.setText("Tipo de Vehiculo: "+vehiculo.obtenerTipoVehiculoCadena()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Marca: "+vehiculo.getMarca()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Modelo: "+vehiculo.getModelo()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Enchufable: "+ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsEnchufable())+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Tiene revisión Tecnica: "+ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isTieneRevisionTecnica())+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Tipo de Combustible: "+vehiculo.obtenerTipoCombustibleCadena()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Nuevo: "+ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isNuevo())+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Tipo de Transmisión: "+vehiculo.obtenerTransmisionCadena()+"\n");
		
		labelContenedor.setText(labelContenedor.getText() + "Cantidad de cambios: "+vehiculo.getCambios()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Velocidad maxima: "+vehiculo.getVelocidadMaxima()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Cilindraje: "+vehiculo.getCilindraje()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Autonomia Carga Completa: "+vehiculo.getAutonomiaCargaCompleta()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Promedio de carga: "+vehiculo.getTiempoPromedioCarga()+"\n");
		labelContenedor.setText(labelContenedor.getText() + "Es Hibrido Ligero: "+ClaseUtilitaria.obtenerRespuestaCadena(vehiculo.isEsHibridoLigero())+"\n");
		
		
		
		return labelContenedor;
	}
	
	
	
	/**
	 * Establece la ventana actual.
	 * @param ventana La ventana actual.
	 */
	public void setVentana(Stage ventana) {
		this.ventana=ventana;
	}
	
	/**
	 * Establece la aplicación principal.
	 * @param aplicacion La aplicación principal.
	 */
	public void setAplicacionPrincipal(Aplicacion aplicacion) {
		this.aplicacion=aplicacion;
	}
	
	/**
	Devuelve el detalle de la transacción obtenido.
	@return El detalle de la transacción obtenido.
	*/
	public DetalleTransaccion detalleObtenido() {
		return detalleObtenido;
	}


	/**
	 * Establece la lista de vehículos temporales.
	 * @param vehiculosTemporales La lista de vehículos temporales.
	 */
	public void obtenerVehiculosTemporales(List<Vehiculo> vehiculosTemporales) {
		this.vehiculos=vehiculosTemporales;
		
		
	}

}
