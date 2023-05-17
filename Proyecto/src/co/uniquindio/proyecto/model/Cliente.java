package co.uniquindio.proyecto.model;

public class Cliente extends Persona{
	
	/**
	 * Metodo constructor
	 */
	public Cliente() {
		
	}
	
	/**
	 * Metodo constructor
	 * @param nombre
	 * @param documento
	 */
	public Cliente(String nombre, String documento) {
		super(nombre, documento);
	}

	public boolean verificarDocumento(String documento) {
        boolean respuesta=false;
        if (this.getDocumento().equals(documento)) {
            respuesta=true;
        }
        return respuesta;
    }
	
}
