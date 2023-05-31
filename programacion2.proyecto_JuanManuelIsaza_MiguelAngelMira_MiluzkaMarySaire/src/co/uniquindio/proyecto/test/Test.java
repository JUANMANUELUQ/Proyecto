package co.uniquindio.proyecto.test;

import static org.junit.Assert.*;

import co.uniquindio.proyecto.model.*;

public class Test {

	//assertEquals(listaPrestamosEsperado,listaPrestamos);
	//fail("Not yet implemented");
	
	
	/**
	 * Verifica el correcto funcionamiento de la obtencion de los tipos de los vehiculos
	 */
	@org.junit.Test
	public void pruebaTiposVehiculos() {
		int coincidencias=0;
		Vehiculo vehiculo1=new Moto();
		Vehiculo vehiculo2=new Deportivo();
		Vehiculo vehiculo3=new Sedan();
		Vehiculo vehiculo4=new Camioneta();
		Vehiculo vehiculo5=new Bus();
		Vehiculo vehiculo6=new PickUp();
		Vehiculo vehiculo7=new Van();
		Vehiculo vehiculo8=new Camion();
		if (vehiculo1.obtenerTipoVehiculo()==TipoVehiculo.MOTO) {
			coincidencias++;
		}
		if (vehiculo2.obtenerTipoVehiculo()==TipoVehiculo.DEPORTIVO) {
			coincidencias++;
		}
		if (vehiculo3.obtenerTipoVehiculo()==TipoVehiculo.SEDAN) {
			coincidencias++;
		}
		if (vehiculo4.obtenerTipoVehiculo()==TipoVehiculo.CAMIONETA) {
			coincidencias++;
		}
		if (vehiculo5.obtenerTipoVehiculo()==TipoVehiculo.BUS) {
			coincidencias++;
		}
		if (vehiculo6.obtenerTipoVehiculo()==TipoVehiculo.PICK_UP) {
			coincidencias++;
		}
		if (vehiculo7.obtenerTipoVehiculo()==TipoVehiculo.VAN) {
			coincidencias++;
		}
		if (vehiculo8.obtenerTipoVehiculo()==TipoVehiculo.CAMION) {
			coincidencias++;
		}
		assertEquals(coincidencias,8);
	}
	
	/**
	 * Verifica el correcto funcionamiento de la obtencion de los tipos de los vehiculos en forma de cadena
	 */
	@org.junit.Test
	public void pruebaTiposVehiculosCadenas() {
		int coincidencias=0;
		Vehiculo vehiculo1=new Moto();
		Vehiculo vehiculo2=new Deportivo();
		Vehiculo vehiculo3=new Sedan();
		Vehiculo vehiculo4=new Camioneta();
		Vehiculo vehiculo5=new Bus();
		Vehiculo vehiculo6=new PickUp();
		Vehiculo vehiculo7=new Van();
		Vehiculo vehiculo8=new Camion();
		if (vehiculo1.obtenerTipoVehiculoCadena().equals("Moto")) {
			coincidencias++;
		}
		if (vehiculo2.obtenerTipoVehiculoCadena().equals("Deportivo")) {
			coincidencias++;
		}
		if (vehiculo3.obtenerTipoVehiculoCadena().equals("Sedan")) {
			coincidencias++;
		}
		if (vehiculo4.obtenerTipoVehiculoCadena().equals("Camioneta")) {
			coincidencias++;
		}
		if (vehiculo5.obtenerTipoVehiculoCadena().equals("Bus")) {
			coincidencias++;
		}
		if (vehiculo6.obtenerTipoVehiculoCadena().equals("Pick up")) {
			coincidencias++;
		}
		if (vehiculo7.obtenerTipoVehiculoCadena().equals("Van")) {
			coincidencias++;
		}
		if (vehiculo8.obtenerTipoVehiculoCadena().equals("Camion")) {
			coincidencias++;
		}
		assertEquals(coincidencias,8);
	}
	
	/**
	 * Verifica el correcto funcionamiento del la filtracion por tipo de transaccion
	 */
	@org.junit.Test
	public void text() {
		boolean cantidadesCorrectas;
		Concesionario concesionario=new Concesionario();
		concesionario.agregarTransaccion(new Alquiler(), concesionario.getListaVehiculos());
		concesionario.agregarTransaccion(new Alquiler(), concesionario.getListaVehiculos());
		concesionario.agregarTransaccion(new Alquiler(), concesionario.getListaVehiculos());
		concesionario.agregarTransaccion(new Venta(), concesionario.getListaVehiculos());
		concesionario.agregarTransaccion(new Venta(), concesionario.getListaVehiculos());
		if (concesionario.obtenerTransaccionesFiltradas(null, null, null).size()!=5) {
			fail("Cantidad de transacciones no esperada");
		}
		if (concesionario.obtenerTransaccionesFiltradas(TipoTransaccion.ALQUILER, null, null).size()!=3) {
			fail("Cantidad de alquileres no esperada");
		}
		if (concesionario.obtenerTransaccionesFiltradas(TipoTransaccion.VENTA, null, null).size()!=2) {
			fail("Cantidad de ventas no esperada");
		}
		if (concesionario.obtenerTransaccionesFiltradas(TipoTransaccion.COMPRA, null, null).size()!=0) {
			fail("Cantidad de compras no esperada");
		}
	}

}
