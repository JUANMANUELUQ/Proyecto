package co.uniquindio.proyecto.model;

public abstract class Usuario extends Persona {
	
	private String contrasenia;
	private String correo;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String documento, String contrasenia, String correo) {
		super(nombre, documento);
		this.contrasenia = contrasenia;
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean verificarDatos(String nombre, String correo, String contrasenia) {
		boolean respuesta=false;
		if (getNombre().equals(nombre) && this.correo.equals(correo) && this.contrasenia.equals(contrasenia)) {
			respuesta=true;
		}
		return respuesta;
	}

	public boolean tieneDocumento(String documento) {
		boolean tieneDocumento=false;
		if (documento.equals(this.getDocumento())) {
			tieneDocumento=true;
		}
		return tieneDocumento;
	}

	public boolean esEmpleado() {
		boolean esEmpleado=false;
		if (this instanceof Empleado) {
			esEmpleado=true;
		}
		return esEmpleado;
	}
	
}
