package co.uniquindio.proyecto.model;

/**
 * Esta clase representa a un empleado que extiende la clase Usuario.
 */
public class Empleado extends Usuario {

    /**
     * Constructor por defecto de la clase Empleado.
     */
	public Empleado() {
		
	}

	 /**
	  * Constructor de la clase Empleado.
      * 
      * @param nombre el nombre del empleado
      * @param documento el documento del empleado
      * @param contrasenia la contraseña del empleado
      * @param correo el correo del empleado
      */ 
	public Empleado(String nombre, String documento, String contrasenia, String correo) {
		super(nombre, documento, contrasenia, correo);
	}

}
