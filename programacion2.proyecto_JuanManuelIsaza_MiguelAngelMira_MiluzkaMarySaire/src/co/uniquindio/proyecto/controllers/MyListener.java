package co.uniquindio.proyecto.controllers;

import co.uniquindio.proyecto.model.Vehiculo;
/**
 * La interfaz MyListener representa un listener para eventos de clic en vehículos.
 * Las clases que implementan esta interfaz pueden registrarse como listeners
 * para recibir notificaciones cuando se hace clic en un vehículo.
 */
public interface MyListener {
	
	/**
	 * Se llama cuando se produce un evento de clic en un vehículo.
	 * @param vehiculo El vehículo en el que se ha hecho clic.
	 */
	public void onClickListener (Vehiculo vehiculo);

}
