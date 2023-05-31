package co.uniquindio.proyecto.model;

/**
 * Esta clase representa a un cliente que extiende la clase Persona.
 */
public class Cliente extends Persona{
	
	/**
	 * Metodo constructor
	 */
	public Cliente() {
		
	}
	
    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre el nombre del cliente
     * @param documento el documento del cliente
     */
	public Cliente(String nombre, String documento) {
		super(nombre, documento);
	}

    /**
     * Verifica si el documento proporcionado coincide con el documento del cliente.
     * 
     * @param documento el documento a verificar
     * @return true si el documento coincide, false de lo contrario
     */
	public boolean verificarDocumento(String documento) {
        boolean respuesta=false;
        if (this.getDocumento().equals(documento)) {
            respuesta=true;
        }
        return respuesta;
    }
	
}