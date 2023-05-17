package co.uniquindio.proyecto.controllers;

import java.util.List;

import co.uniquindio.proyecto.exceptions.EmpleadoException;
import co.uniquindio.proyecto.model.*;
import javafx.stage.Stage;

public class ModelFactoryController {

	Concesionario concesionario = null;
	Stage ventana=null;
	
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	/**
	 * Metodo constructor
	 */
	public ModelFactoryController() {
		inicializarDatos();
	}

	/**
	 * Metodo que inicializa los datos
	 */
	private void inicializarDatos() {
		this.concesionario = new Concesionario();
		concesionario=new Concesionario("Concesionario UQ");
		Administrador administrador=new Administrador("1","1090272239","3","2");
		Empleado empleado=new Empleado("3","1090272238","1","2");
		try {
			concesionario.agregarAdministrador(administrador);
			concesionario.agregarEmpleado(empleado);
		} catch(Exception e) {}
	}

	/**
	 * Metodo que obtiene el concesionario
	 * @return Biblioteca
	 */
	public Concesionario getConcesionario() {
		return concesionario;
	}

	/**
	 * Metodo que cambia el concesionario
	 * @param biblioteca Nuevo concesionario
	 */
	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	public Stage getVentana() {
		return ventana;
	}

	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}
	
	/**
	 * Metodo que verifica si ya existe un usuario dentro del sistema con los datos ingresados 
	 * @param nombre Nombre del empleado que quiere ingresar a la aplicacion
	 * @param correo Correo del empleado que quiere ingresar a la aplicacion
	 * @param contrasenia Contrasenia del empleado que quiere ingresar a la aplicacion
	 * @return True si el empleado ya se encuentra dentro del sistema, false en caso contrario
	 */
	public boolean existeUsuario(String nombre, String correo, String contrasenia) {
		return concesionario.existeUsuario(nombre, correo, contrasenia);
	}

	/**
	 * Metodo que verifica si los datos ingresados le corresponden a un empleado en estado de Bloqueado
	 * @param nombre Nombre del empleado a verificar estado
	 * @param correo Correo del empleado a verificar estado
	 * @param contrasenia Contrasenia del empleado a verificar estado
	 * @return True se se encuentra bloqueado, false en caso contrario
	 */
	public boolean estaEmpleadoBloqueado(String nombre, String correo, String contrasenia) {
		return concesionario.estaEmpleadoBloqueado(nombre, correo, contrasenia);
	}

	/**
	 * Metodo que basado en los datos ingresados determina a que tipo de cuenta(Administrador, Empleado)le corresponden
	 * @param nombre Nombre de usuario ingresado
	 * @param correo Correo de usuario ingresado
	 * @param contrasenia Contrasenia de usuario ingresado
	 * @return Tipo de cuenta a la cual le corresponden los datos ingresados
	 */
	public String obtenerTipoCuenta(String nombre, String correo, String contrasenia) {
		return concesionario.obtenerTipoCuenta(nombre, correo, contrasenia);
	}

	/**
	 * Metodo que busca y retorna a un usuario al cual le corresponden los datos ingresados
	 * @param nombre Nombre del usuario
	 * @param correo Correo del usuario 
	 * @param contrasenia Contrasenia del usuario 
	 * @return Usuario al cual le corresponden los datos ingresados
	 */
	public Usuario obtenerUsuarioDatos(String nombre, String correo, String contrasenia) {
		return concesionario.obtenerUsuarioDatos(nombre, correo, contrasenia);
	}

	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un usuario previamente registrado
	 * @param documento Ducumento a evaluar
	 * @return True si el documento esta vinculado a un empledo registrado, false en caso contrario
	 */
	public boolean existeDocumentoRegistrado(String documento) {
		return concesionario.existeDocumentoRegistrado(documento);
	}

	/**
	 * Metodo encargado de agregar un nuevo administrador dentro del sistema del concesionario
	 * @param empleado Nuevo empleado a agregar
	 * @throws EmpleadoException
	 */
	public void agregarEmpleado(Empleado empleado) throws EmpleadoException {
		concesionario.agregarEmpleado(empleado);
	}

	/**
	 * Metodo que obtiene todos los usuarios de tipo empleados registrados dentro del sistema del concesionario
	 * @return Emplados registrados dentro del concesionario
	 */
	public List<Empleado> obtenerEmpleados() {
		return concesionario.obtenerEmpleados();
	}

	/**
	 * Metodo que obtiene todos clientes registrados dentro del sistema del concesionario
	 * @return Clientes registrados dentro del concesionario
	 */
	public  List<Cliente> obtenerClientes() {
		return concesionario.getListaClientes();
	}
	
	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un cliente previamente registrado
	 * @param documento Documento del cliente a evaluar
	 * @return True si el documento le pertenece a un cliente ya registrado, false en caso contrario
	 */	
	public boolean existeDocumentoCliente(String documento){
        return concesionario.existeDocumentoCliente(documento);
    }

	/**
	 * Metodo que agrega clientes a la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void agregarCliente(Cliente cliente) {
		concesionario.agregarCliente(cliente);
	}
	
	/**
	 * Metodo que elimina clientes de la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void eliminarCliente(Cliente cliente) {
		concesionario.eliminarCliente(cliente);
	}

	public void agregarTransaccion(Transaccion transaccion) {
		concesionario.agregarTransaccion(transaccion);
	}
	
	
}

