package co.uniquindio.proyecto.model;
import java.io.Serializable;
public abstract class Persona implements Serializable{
	
	private String nombre;
	private String documento;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String documento) {
		this.nombre=nombre;
		this.documento=documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public boolean verificarPersona (String documento){
		boolean verificar=false;
		if (documento.equals(getDocumento())){
			verificar=true;
		}
		return verificar;
	}
	
}
