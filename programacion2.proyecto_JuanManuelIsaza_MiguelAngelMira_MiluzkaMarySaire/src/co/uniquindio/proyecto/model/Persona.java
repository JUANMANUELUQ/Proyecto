package co.uniquindio.proyecto.model;
import java.io.Serializable;

/**
 * La clase abstracta Persona implementa la interfaz Serializable. 
 * Representa un tipo genérico de persona y proporciona atributos y métodos comunes a las personas.
 */
public abstract class Persona implements Serializable {
	
	private String nombre;
	private String documento;
	
    /**
     * Constructor por defecto de la clase Persona.
     */
	public Persona() {
		
	}
	
    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre el nombre de la persona
     * @param documento el documento de la persona
     */
	public Persona(String nombre, String documento) {
		this.nombre=nombre;
		this.documento=documento;
	}

    /**
     * Obtiene el nombre de la persona.
     * @return el nombre de la persona
     */
	public String getNombre() {
		return nombre;
	}

    /**
     * Establece el nombre de la persona.
     * @param nombre el nombre de la persona
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Obtiene el documento de la persona.
     * @return el documento de la persona
     */
	public String getDocumento() {
		return documento;
	}

    /**
     * Establece el documento de la persona.
     * @param documento el documento de la persona
     */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
    /**
     * Verifica si el documento proporcionado coincide con el documento de la persona.
     * @param documento el documento a verificar
     * @return true si el documento coincide, false de lo contrario
     */
	public boolean verificarPersona (String documento){
		boolean verificar=false;
		if (documento.equals(getDocumento())){
			verificar=true;
		}
		return verificar;
	}
	
}
