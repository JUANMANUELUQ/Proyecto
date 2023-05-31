package co.uniquindio.proyecto.controllers;

import java.util.List;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.util.ArrayList;

import co.uniquindio.proyecto.application.Aplicacion;
import co.uniquindio.proyecto.exceptions.EmpleadoException;
import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.util.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
/**
 * 
 * Clase que sirve como conector de los controladores con el model de acuerdo a patron modelo vista controlador
 *
 */
public class ModelFactoryController {

	Concesionario concesionario = null;
	private Aplicacion aplicacion;
	private Stage ventana;
	private List <Vehiculo> listaVehiculosPosibles;
	
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	/**
	 * Metodo constructor
	 */
	public ModelFactoryController() {
		Concesionario datosObtenidos;
		datosObtenidos=Persistencia.realizarCarga("src/archivo.dat") ;
		if(datosObtenidos!=null)
        {
			concesionario=datosObtenidos;
        } else {
        	inicializarDatos();
        }
	}

	/**
	 * Metodo que inicializa los datos
	 */
	private void inicializarDatos() {
		
		this.concesionario = new Concesionario();
		concesionario=new Concesionario("Concesionario UQ");
		Administrador administrador=new Administrador("Juan Manuel","1090272239","12345678","juanmanuel200413@gmail.com");
		Empleado empleado=new Empleado("Mary","476299","12345678","miluskasaire512@gmail.com");
		Cliente cliente=new Cliente("Miguel","1095550864");
		try {
			concesionario.agregarAdministrador(administrador);
			concesionario.agregarEmpleado(empleado);
			concesionario.agregarCliente(cliente);
			quemarDatos(empleado,cliente);
			
		} catch(Exception e) {}
	}
	
	/**
	 * Metodo para la quema de datos en la aplicacion enfocada a la demostracion del funcionamiento de la misma
	 */
	public void quemarDatos(Empleado empleado,Cliente cliente) {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		Vehiculo vehiculo;
		
		ArrayList<Transaccion> listaTransacciones=new ArrayList<Transaccion>();
		
		List<DetalleTransaccion> listaDetallesTransaccion=new ArrayList<DetalleTransaccion>();
	    
	    vehiculo = new Sedan();
	    vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setMarca("Chevrolet");
	    vehiculo.setNuevo(true);
    	vehiculo.setModelo("Chevrolet Joy Sedan");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setPrecio(66000000);
    	vehiculo.setFoto("/imagenes/renault.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculos.add(vehiculo);
    	listaDetallesTransaccion.add(new DetalleTransaccion(66000000.0,1,vehiculo));
    	Transaccion transaccion=new Venta(66000000.0,empleado,cliente,LocalDate.of(2023,5,3),listaDetallesTransaccion);
    	listaTransacciones.add(transaccion);
    	
    	vehiculo = new Sedan();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setMarca("Chevrolet");
	    vehiculo.setNuevo(true);
    	vehiculo.setModelo("Chevrolet Malibu Sedan");
    	vehiculo.setPrecio(77900000);
    	vehiculo.setFoto("/imagenes/sedan azul.png");
    	vehiculo.setCodeColor("244273");
    	vehiculos.add(vehiculo);
    	listaDetallesTransaccion.set(0, new DetalleTransaccion(77900000.0,1,vehiculo));
    	transaccion=new Alquiler(77900000.0,empleado,cliente,LocalDate.of(2022,3,15),listaDetallesTransaccion,10);
    	concesionario.agregarTransaccion(transaccion, vehiculos);
    	listaTransacciones.add(transaccion);
    
    	vehiculo = new Sedan();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Volkswagen");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Volkswagen Jetta Sedan");
    	vehiculo.setPrecio(49000000);
    	vehiculo.setFoto("/imagenes/sedanTRES.png");
    	vehiculo.setCodeColor("5981B1");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Sedan();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Subaru");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Subaru Impreza Sedan");
    	vehiculo.setPrecio(22890000);
    	vehiculo.setFoto("/imagenes/sedanCuatro.png");
    	vehiculo.setCodeColor("9DADDF");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Sedan();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Mazda");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Mazda3 Sedan");
    	vehiculo.setPrecio(35500000);
    	vehiculo.setFoto("/imagenes/sedanCinco.png");
    	vehiculo.setCodeColor("FCA311");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Deportivo();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
    	vehiculo.setNuevo(true);
    	vehiculo.setMarca("Chevrolet");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.0);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Chevrolet Corvette ZR1");
    	vehiculo.setPrecio(490000000);
    	vehiculo.setFoto("/imagenes/deportivoUno.png");
    	vehiculo.setCodeColor("ffb700");

    	// Atributos específicos de la clase Deportivo
    	((Deportivo) vehiculo).setNumeroCaballosFuerza(500);
    	((Deportivo) vehiculo).setTiempoAlcanza100Kmh(3);

    	vehiculos.add(vehiculo);

    	
    	vehiculo = new Deportivo();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Audi");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Audi R8 V10 Plus");
    	vehiculo.setPrecio(990000000);
    	vehiculo.setFoto("/imagenes/deportivoTres.png");
    	vehiculo.setCodeColor("363030");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Deportivo();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Ferrari");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Ferrari 812 Superfast");
    	vehiculo.setPrecio(32000000);
    	vehiculo.setFoto("/imagenes/deportivoDos.png");
    	vehiculo.setCodeColor("f44336");
    	vehiculos.add(vehiculo);
    	
    	//FFF
    	vehiculo = new Deportivo();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Mercedes-Benz");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.DIESEL);
    	vehiculo.setModelo("Volvo XC90");
    	vehiculo.setPrecio(20900000);
    	vehiculo.setFoto("/imagenes/deportivoCUatro.png");
    	vehiculo.setCodeColor("363030");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Kia");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.ELECTRICO);
    	vehiculo.setModelo("Kia Sportage");
    	vehiculo.setPrecio(29900000);
    	vehiculo.setFoto("/imagenes/suvUno.png");
    	vehiculo.setCodeColor("C70039");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Audi");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.ELECTRICO);
    	vehiculo.setModelo("Jeep Wrangler");
    	vehiculo.setPrecio(59000000);
    	vehiculo.setFoto("/imagenes/SuvDos.png");
    	vehiculo.setCodeColor("C70039");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Ford");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Land Rover Range Rover");
    	vehiculo.setPrecio(69000000);
    	vehiculo.setFoto("/imagenes/suvTres.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Seat");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(false);
    	vehiculo.setTipoCombustible(TipoCombustible.HIBRIDO);
    	vehiculo.setModelo("Subaru Forester");
    	vehiculo.setPrecio(180000000);
    	vehiculo.setFoto("/imagenes/suvCuatro.png");
    	vehiculo.setCodeColor("B3C100");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Suzuki");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Porsche 911");
    	vehiculo.setPrecio(130000000);
    	vehiculo.setFoto("/imagenes/suvCinco.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camioneta();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Hyundai");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(false);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Hyundai Elantra");
    	vehiculo.setPrecio(149000000);
    	vehiculo.setFoto("/imagenes/suvSeis.png");
    	vehiculo.setCodeColor("1C4E80");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new PickUp();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Nissan");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.DIESEL);
    	vehiculo.setModelo("Nissan Frontier");
    	vehiculo.setPrecio(119000000);
    	vehiculo.setFoto("/imagenes/pickUpOne.png");
    	vehiculo.setCodeColor("20283E");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new PickUp();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Canyon");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.ELECTRICO);
    	vehiculo.setModelo("GMC Canyon AT4 OVRLANDX");
    	vehiculo.setPrecio(59800000);
    	vehiculo.setFoto("/imagenes/pickUpDos.png");
    	vehiculo.setCodeColor("B3C100");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new PickUp();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Honda");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Honda Ridgeline");
    	vehiculo.setPrecio(98000000);
    	vehiculo.setFoto("/imagenes/pickUpTres.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);


    	vehiculo = new PickUp();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Toyota");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Toyota Tacoma");
    	vehiculo.setPrecio(76900000);
    	vehiculo.setFoto("/imagenes/pickUpCuatro.png");
    	vehiculo.setCodeColor("6AB187");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new PickUp();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("GMC");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.HIBRIDO);
    	vehiculo.setModelo("GMC Sierra 1500");
    	vehiculo.setPrecio(49000000);
    	vehiculo.setFoto("/imagenes/pickUpCinco.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Van();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Mercedes");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Mercedes-Benz Sprinter Passenger Van");
    	vehiculo.setPrecio(78900000);
    	vehiculo.setFoto("/imagenes/vansUNO.png");
    	vehiculo.setCodeColor("B3C100");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Van();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Toyota");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Toyota Sienna Limited Premium");
    	vehiculo.setPrecio(100900000);
    	vehiculo.setFoto("/imagenes/vansDOS.png");
    	vehiculo.setCodeColor("20283E");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Van();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Ram");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Ram ProMaster City Passenger Wagon");
    	vehiculo.setPrecio(67900000);
    	vehiculo.setFoto("/imagenes/vansTRES.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Bus();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Optare Versa");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(true);
    	vehiculo.setEsHibridoLigero(false);
    	vehiculo.setTieneRevisionTecnica(false);
    	vehiculo.setTipoCombustible(TipoCombustible.DIESEL);
    	vehiculo.setModelo("Optare Versa EV Electric City Bus");
    	vehiculo.setPrecio(189000000);
    	vehiculo.setFoto("/imagenes/busesUNO.png");
    	vehiculo.setCodeColor("20283E");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Bus();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Mercedes");
    	vehiculo.setCambios(4);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Mercedes-Benz Tourismo ");
    	vehiculo.setPrecio(35900000);
    	vehiculo.setFoto("/imagenes/busesDos.png");
    	vehiculo.setCodeColor("6A7324");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Bus();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Irizar");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.ELECTRICO);
    	vehiculo.setModelo("Irizar i6S Ultimate Intercity Coach");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/busesTres.png");
    	vehiculo.setCodeColor("6AB187");
    	vehiculos.add(vehiculo);
    	
    	
    	vehiculo = new Bus();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Volvo");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Volvo Grand Touring Luxury Coach");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/busesCuatro.png");
    	vehiculo.setCodeColor("FF5733");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camion();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Scania");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(false);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Scania Highline Long-Haul Truck");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/camionUNO.png");
    	vehiculo.setCodeColor("FF5733");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camion();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("DAF XF");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("DAF XF Long-Distance Truck");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/camionDOS.png");
    	vehiculo.setCodeColor("6AB187");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camion();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Iveco Stralis");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.DIESEL);
    	vehiculo.setModelo("Iveco Stralis Heavy-Duty Truck");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/camionTRES.png");
    	vehiculo.setCodeColor("FF5733");
    	vehiculos.add(vehiculo);
    	
    	vehiculo = new Camion();
    	vehiculo.setTransmision(Transmision.AUTOMATICA);
	    vehiculo.setNuevo(true);
    	vehiculo.setMarca("Mack");
    	vehiculo.setCambios(6);
    	vehiculo.setVelocidadMaxima(250.000);
    	vehiculo.setCilindraje(1999.5);
    	vehiculo.setAutonomiaCargaCompleta(1);
    	vehiculo.setTiempoPromedioCarga(60);
    	vehiculo.setEsEnchufable(false);
    	vehiculo.setEsHibridoLigero(true);
    	vehiculo.setTieneRevisionTecnica(true);
    	vehiculo.setTipoCombustible(TipoCombustible.GASOLINA);
    	vehiculo.setModelo("Mack Anthem Highway Truck");
    	vehiculo.setPrecio(989000000);
    	vehiculo.setFoto("/imagenes/camionCuatro.png");
    	vehiculo.setCodeColor("000B4F");
    	vehiculos.add(vehiculo);
    	
    	
    	concesionario.setListaVehiculos(vehiculos);
    	concesionario.setListaTransacciones(listaTransacciones);
    	

		
	}

	/**
	 * Metodo que obtiene el concesionario
	 * @return Biblioteca
	 */
	public Concesionario getConcesionario() {
		return concesionario;
	}

	/**
	 * Metodo que cambia el concesionario
	 * @param biblioteca Nuevo concesionario
	 */
	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}
	
	/**
	 * Obtiene la ventana 
	 * @return ventana 
	 */
	public Stage getVentana() {
		return ventana;
	}
	
	/**
	 * Establece la ventana n.
	 * @param ventana La ventana .
	 */
	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}
	
	/**
	 * Obtiene la direccion de la aplicacion principal
	 * @return Aplicacion principal
	 */
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	/**
	 * Establece la direccion de la aplicaion principal
	 * @param aplicacion Nueva aplicacion principal
	 */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * Metodo que verifica si ya existe un usuario dentro del sistema con los datos ingresados 
	 * @param nombre Nombre del empleado que quiere ingresar a la aplicacion
	 * @param correo Correo del empleado que quiere ingresar a la aplicacion
	 * @param contrasenia Contrasenia del empleado que quiere ingresar a la aplicacion
	 * @return True si el empleado ya se encuentra dentro del sistema, false en caso contrario
	 */
	public boolean existeUsuario(String nombre, String correo, String contrasenia) {
		return concesionario.existeUsuario(nombre, correo, contrasenia);
	}
	
	/**
	 * Metodo que verifica si ya existe un usuario dentro del sistema con los datos ingresados 
	 * @param nombre Nombre del empleado que quiere ingresar a la aplicacion
	 * @param correo Correo del empleado que quiere ingresar a la aplicacion
	 * @return True si el empleado ya se encuentra dentro del sistema, false en caso contrario
	 */
	public boolean existeUsuario(String nombre, String correo) {
		return concesionario.existeUsuario(nombre, correo);
	}

	/**
	 * Metodo que verifica si los datos ingresados le corresponden a un empleado en estado de Bloqueado
	 * @param nombre Nombre del empleado a verificar estado
	 * @param correo Correo del empleado a verificar estado
	 * @param contrasenia Contrasenia del empleado a verificar estado
	 * @return True se se encuentra bloqueado, false en caso contrario
	 */
	public boolean estaEmpleadoBloqueado(String nombre, String correo, String contrasenia) {
		return concesionario.estaEmpleadoBloqueado(nombre, correo, contrasenia);
	}
	
	/**
	 * Metodo que verifica si los datos ingresados le corresponden a un empleado en estado de Bloqueado
	 * @param nombre Nombre del empleado a verificar estado
	 * @param correo Correo del empleado a verificar estado
	 * @return True se se encuentra bloqueado, false en caso contrario
	 */
	public boolean estaEmpleadoBloqueado(String nombre, String correo) {
		return concesionario.estaEmpleadoBloqueado(nombre, correo);
	}

	/**
	 * Metodo que basado en los datos ingresados determina a que tipo de cuenta(Administrador, Empleado)le corresponden
	 * @param nombre Nombre de usuario ingresado
	 * @param correo Correo de usuario ingresado
	 * @param contrasenia Contrasenia de usuario ingresado
	 * @return Tipo de cuenta a la cual le corresponden los datos ingresados
	 */
	public String obtenerTipoCuenta(String nombre, String correo, String contrasenia) {
		return concesionario.obtenerTipoCuenta(nombre, correo, contrasenia);
	}

	/**
	 * Metodo que busca y retorna a un usuario al cual le corresponden los datos ingresados
	 * @param nombre Nombre del usuario
	 * @param correo Correo del usuario 
	 * @param contrasenia Contrasenia del usuario 
	 * @return Usuario al cual le corresponden los datos ingresados
	 */
	public Usuario obtenerUsuarioDatos(String nombre, String correo, String contrasenia) {
		return concesionario.obtenerUsuarioDatos(nombre, correo, contrasenia);
	}
	
	/**
	 * Metodo que busca y retorna a un usuario al cual le corresponden los datos ingresados
	 * @param nombre Nombre del usuario
	 * @param correo Correo del usuario 
	 * @return Usuario al cual le corresponden los datos ingresados
	 */
	public Usuario obtenerUsuarioDatos(String nombre, String correo) {
		return concesionario.obtenerUsuarioDatos(nombre, correo);
	}

	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un usuario previamente registrado
	 * @param documento Ducumento a evaluar
	 * @return True si el documento esta vinculado a un empledo registrado, false en caso contrario
	 */
	public boolean existeDocumentoRegistrado(String documento) {
		return concesionario.existeDocumentoRegistrado(documento);
	}

	/**
	 * Metodo encargado de agregar un nuevo administrador dentro del sistema del concesionario
	 * @param empleado Nuevo empleado a agregar
	 * @throws EmpleadoException
	 */
	public void agregarEmpleado(Empleado empleado) throws EmpleadoException {
		concesionario.agregarEmpleado(empleado);
	}

	/**
	 * Metodo que obtiene todos los usuarios de tipo empleados registrados dentro del sistema del concesionario
	 * @return Emplados registrados dentro del concesionario
	 */
	public List<Empleado> obtenerEmpleados() {
		return concesionario.obtenerEmpleados();
	}

	/**
	 * Metodo que obtiene todos clientes registrados dentro del sistema del concesionario
	 * @return Clientes registrados dentro del concesionario
	 */
	public  List<Cliente> obtenerClientes() {
		return concesionario.getListaClientes();
	}
	
	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un cliente previamente registrado
	 * @param documento Documento del cliente a evaluar
	 * @return True si el documento le pertenece a un cliente ya registrado, false en caso contrario
	 */	
	public boolean existeDocumentoCliente(String documento){
        return concesionario.existeDocumentoCliente(documento);
    }

	/**
	 * Metodo que agrega clientes a la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void agregarCliente(Cliente cliente) {
		concesionario.agregarCliente(cliente);
	}
	
	/**
	 * Metodo que elimina clientes de la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void eliminarCliente(Cliente cliente) {
		concesionario.eliminarCliente(cliente);
	}
	
	/**
	 * Metodo que agrega transacciones a la lista de transacciones del concesionario
	 * @param transaccion transaccion a agregar
	 * @param listaVehiculosTemporales lista con los vehiculos actualmente en el inventario
	 */
	public void agregarTransaccion(Transaccion transaccion,List<Vehiculo> listaVehiculosTemporales) {
		concesionario.agregarTransaccion(transaccion,listaVehiculosTemporales);
	}

	/**
	 * Metodo para obtener una copia de la lista actual de vehiculos registrados 
	 * @return lista de vehiculos
	 */
	public List<Vehiculo> obtenerCopiaVehiculos() {
		List<Vehiculo> listaVehiculos=concesionario.getListaVehiculos();

		List<Vehiculo> copiaVehiculos=new ArrayList<Vehiculo>();
		for (Vehiculo vehiculo : listaVehiculos) {
			copiaVehiculos.add(vehiculo);
		}
		return copiaVehiculos;
	}

	/**
	 * Metodo que obtiene la lista de transacciones filtradas por tipo y rango de fecha
	 * @param tipoTransaccion tipo de transacciones a filtrar
	 * @param fechaInicial fecha a partir de la cual se tomaran las transacciones a filtrar
	 * @param fechaFinal fecha hasta la cual se tomaran las transacciones a filtrar
	 * @return lista de transacciones filtradas
	 */
	public List<Transaccion> obtenerTransaccionesFiltradas(TipoTransaccion tipoTransaccion,LocalDate fechaInicial,LocalDate fechaFinal) {
		return concesionario.obtenerTransaccionesFiltradas(tipoTransaccion,fechaInicial,fechaFinal);
	}
	
	/**
	 * Lista temporal de vehiculos para los posbible vehiculos comprados previo a la confirmacion de una transaccion
	 * @param listaTemporalVehiculosVentana
	 */
	public void listaPosibles(List<Vehiculo> listaTemporalVehiculosVentana) {
		this.listaVehiculosPosibles=listaTemporalVehiculosVentana;
		
	}
	
	/**
	 * Obtiene la lista temporar de vehiculos previos a la confimacion de una compra
	 * @return lista de vehiculos comprados
	 */
	public List<Vehiculo> retornarPosiblesVehiculos(){
		return this.listaVehiculosPosibles;
	}
	
	/**
	 * Reemplaza la lista de vehiculos del concesionarion con otra en cuanto se confirme una compra de un nuevo vehiculo
	 * @param listaTemporalVehiculosVentana
	 */
	public void actualizarListaVehiculos(List<Vehiculo> listaTemporalVehiculosVentana) {
		concesionario.setListaVehiculos(listaTemporalVehiculosVentana);
		
	}
	
}

