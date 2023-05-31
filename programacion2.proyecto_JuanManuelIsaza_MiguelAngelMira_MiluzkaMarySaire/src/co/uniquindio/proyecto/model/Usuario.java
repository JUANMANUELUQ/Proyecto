package co.uniquindio.proyecto.model;

/**
 * La clase abstracta Usuario es una subclase de Persona. 
 * Representa un tipo genérico de Usuario  y proporciona atributos y métodos comunes a los usuarios.
 */
public abstract class Usuario extends Persona {
	
	private String contrasenia;
	private String correo;
	private EstadoUsuario estado;
	
	/**
	 * Constructor por defecto de Usuario.
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor de Usuario que recibe los datos del usuario.
	 * 
	 * @param nombre El nombre del usuario.
	 * @param documento El documento del usuario.
	 * @param contrasenia La contraseña del usuario.
	 * @param correo El correo electrónico del usuario.
	 */
	public Usuario(String nombre, String documento, String contrasenia, String correo) {
		super(nombre, documento);
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.estado=EstadoUsuario.ACTIVO;
	}


	/**
	 * Obtiene la contraseña del usuario.
	 * @return La contraseña del usuario.
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	
	/**
	 * Establece la contraseña del usuario.
	 * @param contrasenia La nueva contraseña del usuario.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	/**
	 * Obtiene la contraseña del usuario.
	 * @return La contraseña del usuario.
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Establece el correo electrónico del usuario.
	 * @param correo El nuevo correo electrónico del usuario.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene el estado del usuario.
	 * @return El estado del usuario.
	 */
	public EstadoUsuario getEstado() {
		return estado;
	}

	/**
	 * Establece el estado del usuario.
	 * @param estado El nuevo estado del usuario.
	 */
	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}
	
	/**
	 * Metodo que obtiene la representación en cadena del estado del usuario.
	 * @return La representación en cadena del estado del usuario.
	 */
	public String obtenerEstadoCadena() {
		String estado="";
		switch(this.estado) {
			case ACTIVO: estado="Activo"; break;
			case BLOQUEADO: estado="Bloqueado"; break;
		}
		return estado;
	}
	
	/**
	 * Metodo que verifica si los datos proporcionados corresponden al usuario.
	 * @param nombre El nombre a verificar.
	 * @param correo El correo electrónico a verificar.
	 * @return true si los datos corresponden al usuario, false de lo contrario.
	 */
	public boolean verificarDatos(String nombre, String correo) {
		boolean respuesta=false;
		if (getNombre().equals(nombre) && this.correo.equals(correo)) {
			respuesta=true;
		}
		return respuesta;
	}

	/**
	 * Metodo que verifica si los datos proporcionados corresponden al usuario.
	 * @param nombre El nombre a verificar.
	 * @param correo El correo electrónico a verificar.
	 * @param contrasenia La contraseña a verificar.
	 * @return true si los datos corresponden al usuario, false de lo contrario.
	 */
	public boolean verificarDatos(String nombre, String correo, String contrasenia) {
		boolean respuesta=false;
		if (getNombre().equals(nombre) && this.correo.equals(correo) && this.contrasenia.equals(contrasenia)) {
			respuesta=true;
		}
		return respuesta;
	}

	/**
	 * Metodo que verifica si el usuario tiene el documento especificado.
	 * @param documento El documento a verificar.
	 * @return true si el usuario tiene el documento, false de lo contrario.
	 */
	public boolean tieneDocumento(String documento) {
		boolean tieneDocumento=false;
		if (documento.equals(this.getDocumento())) {
			tieneDocumento=true;
		}
		return tieneDocumento;
	}

	/**
	 * Metodo que verifica si el usuario es un empleado.
	 * @return true si el usuario es un empleado, false de lo contrario.
	 */
	public boolean esEmpleado() {
		boolean esEmpleado=false;
		if (this instanceof Empleado) {
			esEmpleado=true;
		}
		return esEmpleado;
	}

	/**
	 * Metodo que verifica si el usuario está bloqueado.
	 * @return true si el usuario está bloqueado, false de lo contrario.
	 */
	public boolean estaBloqueado() {
		boolean estaBloqueado=false;
		if (this.estado==EstadoUsuario.BLOQUEADO) {
			estaBloqueado=true;
		}
		return estaBloqueado;
	}

	/**
	 * Metodo que verifica si el documento del usuario es el ingresado
	 * @param documento el documento a verificar
	 * @return true si el documento ingresado es igual al del usuario, false de lo contrario
	 */
	public boolean verificarDocumento(String documento) {
		boolean respuesta=false;
		if (this.getDocumento().equals(documento)) {
			respuesta=true;
		}
		return respuesta;
	}
	
}