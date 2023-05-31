package co.uniquindio.proyecto.model;

import java.util.List;
import java.util.ArrayList;

/**
 * La clase Administrador representa a un administrador en el sistema.
 * Hereda los atributos y métodos de la clase Usuario.
 */
public class Administrador extends Usuario {
	
	
	/**
	 * Metodo constructor
	 */
	public Administrador() {
		
	}
	
    /**
     * Constructor de la clase Administrador.
     * Crea una instancia de Administrador con los atributos especificados.
     * @param nombre el nombre del administrador
     * @param documento el documento de identificación del administrador
     * @param contrasenia la contraseña del administrador
     * @param correo el correo electrónico del administrador
     */
	public Administrador(String nombre, String documento, String contrasenia, String correo) {
		super(nombre, documento, contrasenia, correo);
	}

	
}
