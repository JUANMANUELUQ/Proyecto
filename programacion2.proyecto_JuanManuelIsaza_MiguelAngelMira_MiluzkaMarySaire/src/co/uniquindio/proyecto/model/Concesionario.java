package co.uniquindio.proyecto.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.exceptions.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;

import java.time.temporal.ChronoUnit;
import java.io.Serializable;

/**
 * 
 * Clase que representa al concesionario y todas sus funciones
 *
 */
public class Concesionario implements Serializable{
	

    public static Concesionario conce = null;

	private String nombre;
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Transaccion> listaTransacciones;
	private List<Vehiculo> listaVehiculos;
	
	/**
     * Constructor por defecto de Concesionario.
     */
	public Concesionario (){
		listaUsuarios=new ArrayList<Usuario>();
		listaClientes=new ArrayList<Cliente>();
		listaTransacciones=new ArrayList<Transaccion>();
		listaVehiculos=new ArrayList<Vehiculo>();
	}
	
	/**
     * Constructor de Concesionario que establece el nombre y crea listas vacías para usuarios, clientes, transacciones y vehículos.
     * @param nombre El nombre del concesionario.
     */
	public Concesionario (String nombre){
		this.nombre = nombre;
		listaUsuarios=new ArrayList<Usuario>();
		listaClientes=new ArrayList<Cliente>();
		listaTransacciones=new ArrayList<Transaccion>();
		listaVehiculos=new ArrayList<Vehiculo>();
	}
	
	
    /**
     * Obtiene el nombre del concesionario.
     * @return El nombre del concesionario.
     */
	public String getNombre() {
		return nombre;
	}

    /**
     * Establece el nombre del concesionario.
     * @param nombre El nombre del concesionario.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Obtiene la lista de usuarios del concesionario.
     * @return La lista de usuarios del concesionario.
     */
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

    /**
     * Establece la lista de usuarios del concesionario.
     * @param listaUsuarios La lista de usuarios del concesionario.
     */
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

    /**
     * Obtiene la lista de clientes del concesionario.
     * @return La lista de clientes del concesionario.
     */
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

    /**
     * Establece la lista de clientes del concesionario.
     * @param listaClientes La lista de clientes del concesionario.
     */
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
    /**
     * Obtiene la lista de transacciones del concesionario.
     * @return La lista de transacciones del concesionario.
     */
	public ArrayList<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	
    /**
     * Establece la lista de transacciones del concesionario.
     * @param listaTransacciones La lista de transacciones del concesionario.
     */
	public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	
    /**
     * Obtiene la lista de vehículos del concesionario.
     * @return La lista de vehículos del concesionario.
     */
	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

    /**
     * Establece la lista de vehículos del concesionario.
     * @param listaVehiculos La lista de vehículos del concesionario.
     */
	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	/**
	 * Metodo que verifica si ya existe un usuario dentro del sistema con los datos ingresados en el momento del registro a la aplicacion
	 * @param nombre Nombre del usuario que se quiere registrar en la aplicacion
	 * @param correo Correo del usuario que quiere registrar en la aplicacion
	 * @return True si el usuario ya se encuentra dentro del sistema, false en caso contrario
	 */
	public boolean existeUsuario(String nombre,String correo) {
		boolean existe=false;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo)) {
				existe=true;
				break;
			}
		}
		return existe;
	}
	
	/**
	 * Metodo que verifica si ya existe un usuario dentro del sistema con los datos ingresados en el momento del ingreso o login a la aplicacion
	 * @param nombre Nombre del empleado que quiere ingresar a la aplicacion
	 * @param correo Correo del empleado que quiere ingresar a la aplicacion
	 * @param contrasenia Contrasenia del empleado que quiere ingresar a la aplicacion
	 * @return True si el empleado ya se encuentra dentro del sistema, false en caso contrario
	 */
	public boolean existeUsuario(String nombre,String correo,String contrasenia) {
		boolean existe=false;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo,contrasenia)) {
				existe=true;
				break;
			}
		}
		return existe;
	}
	
	/**
	 * Metodo que busca y retorna a un usuario al cual le corresponden los datos ingresados
	 * @param nombre Nombre del usuario
	 * @param correo Correo del usuario 
	 * @param contrasenia Contrasenia del usuario 
	 * @return Usuario al cual le corresponden los datos ingresados
	 */
	public Usuario obtenerUsuarioDatos(String nombre,String correo,String contrasenia) {
		Usuario usuarioObtenido=null;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo,contrasenia)) {
				usuarioObtenido=usuario;
				break;
			}
		}
		return usuarioObtenido;
	}
	
	/**
	 * Metodo que busca y retorna a un usuario al cual le corresponden los datos ingresados
	 * @param nombre Nombre del usuario
	 * @param correo Correo del usuario 
	 * @return Usuario al cual le corresponden los datos ingresados
	 */
	public Usuario obtenerUsuarioDatos(String nombre,String correo) {
		Usuario usuarioObtenido=null;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo)) {
				usuarioObtenido=usuario;
				break;
			}
		}
		return usuarioObtenido;
	}
	
	/**
	 * Metodo que basado en los datos ingresados determina a que tipo de cuenta(Administrador, Empleado)le corresponden
	 * @param nombre Nombre de usuario ingresado
	 * @param correo Correo de usuario ingresado
	 * @param contrasenia Contrasenia de usuario ingresado
	 * @return Tipo de cuenta a la cual le corresponden los datos ingresados
	 */
	public String obtenerTipoCuenta(String nombre,String correo,String contrasenia) {
		String tipoCuenta="";
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo,contrasenia)) {
				if (usuario instanceof Administrador) {
					tipoCuenta="Administrador";
				} else {
					tipoCuenta="Empleado";
				}
				break;
			}
		}
		return tipoCuenta;
	}
	
	/**
	 * Metodo que verifica si los datos ingresados le corresponden a un empleado en estado de Bloqueado
	 * @param nombre Nombre del empleado a verificar estado
	 * @param correo Correo del empleado a verificar estado
	 * @param contrasenia Contrasenia del empleado a verificar estado
	 * @return True se se encuentra bloqueado, false en caso contrario
	 */
	public boolean estaEmpleadoBloqueado(String nombre, String correo, String contrasenia) {
		boolean respuesta=false;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo,contrasenia)) {
				if (usuario.estaBloqueado()) {
					respuesta=true;
				}
				break;
			}
		}
		return respuesta;
	}
	
	/**
	 * Metodo que verifica si los datos ingresados le corresponden a un empleado en estado de Bloqueado
	 * @param nombre Nombre del empleado a verificar estado
	 * @param correo Correo del empleado a verificar estado
	 * @return True se se encuentra bloqueado, false en caso contrario
	 */
	public boolean estaEmpleadoBloqueado(String nombre, String correo) {
		boolean respuesta=false;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.verificarDatos(nombre,correo)) {
				if (usuario.estaBloqueado()) {
					respuesta=true;
				}
				break;
			}
		}
		return respuesta;
	}

	/**
	 * Metodo que verifica si la contraseña ingresada le corresponde a un usuario que se encuentra registrado en el sistema 
	 * @param contrasenia Contrasenia del usuario a evaluar 
	 * @return True si la contraseña le corresponde a un usuario previamente registrado, false en caso contrario
	 */
	private boolean verificarUsuario(String contrasenia){
		boolean verificado= false;
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getContrasenia().equals(contrasenia)){
				verificado = true;
				return verificado;
			}
		}
	return verificado;
		
	}
	
	/**
	 * Metodo que retorna la contrasenia de un usuario con un correo especifico
	 * @param correo Correo al cual esta vinculado la contrasenia a retornar
	 * @return Contrasenia vinculada a correo ingresado
	 * @throws UsuarioException
	 */
	private String recuperarContrasenia (String correo) throws UsuarioException{
		String contra;
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getCorreo().equals(correo)){
				contra= usuario.getContrasenia(); //Se usaria .getContraseña del constructor de usuarios directamente
				//o se crea en la clase usuario un metodo que devuelva la contraseña de dicho usuario???
				//
				return contra;
			}
		}
		throw new UsuarioException("El usuario ingresado NO existe");
    }
	
	/**
	 * Metodo que obtiene el reporte (Lista de transacciones) realizado en un rengo de fechas y por un empleado especifico
	 * @param documentoEmpleado Documento del empleado que realizo las transacciones
	 * @param fechaMin Fecha a partir de donde se quiere ver las transacciones realizadas
	 * @param fechaMax Fecha maxima hasta donde se quiere ver las transacciones realizadas
	 * @return Lista de transacciones(Reporte) que complen las condiciones
	 * @throws ReporteException
	 */
	private ArrayList<Transaccion> obtenerReporte (String documentoEmpleado, LocalDate fechaMin, LocalDate fechaMax) throws ReporteException{
		ArrayList<Transaccion> reporte = new ArrayList<Transaccion>();
		for (Transaccion registroTransacc : listaTransacciones) {
			if (registroTransacc.estaFechaRango(fechaMin,fechaMax)) {
				if (registroTransacc.tieneEmpleado(documentoEmpleado)) {
					reporte.add(registroTransacc);
				}
			}
		}
		if (reporte.isEmpty()){
			throw new ReporteException ("El empleado ingresado no ha realizado transacciones en las fechas establecidas");
		}
		else{
			return reporte;
		}
		
	}
	
	/**
	 * Metodo que registra a un usuario dentro del sistema del concesionario
	 * @param nombre Nombre del usuario a registrar 
	 * @param documento Documento del usuario a registrar
	 * @param correo Correo del usuario a registrar 
	 * @param contrasenia Contrasenia del usuario a regitrar
	 * @param tipoUsuario Tipo de usuario que se quiere registrar (Empleado, Administrador)
	 */
	private void registrarUsuario(String nombre, String documento, String correo, String contrasenia, String tipoUsuario){
		switch (tipoUsuario){
			case "Empleado" :
			Empleado empleado = new Empleado (nombre, documento, contrasenia, correo);
			listaUsuarios.add(empleado);
			break;
			case "Administrador" :
			Administrador administrador = new Administrador(nombre, documento, contrasenia, correo);
			listaUsuarios.add(administrador);
		} 
	}
	
	/**
	 * Metodo que busca a un usuario mediante su documento dentro del sistema del concesionario
	 * @param documento Documento del usuario que se quiere buscar
	 * @return Posicion dentro de la lista de usurios del sistema en la que se encuentr el usuario al cual le corresponde el documento ingresado
	 * @throws UsuarioException
	 */
	private int buscarUsuario(String documento) throws UsuarioException{
		String doc;
		Usuario usuario;
		for (int i=0; i<listaUsuarios.size(); i++){
			usuario=listaUsuarios.get(i);
			doc=usuario.getDocumento();
			if (doc.equals(documento));
			{
				return i;
			}
		}
		throw new UsuarioException("El usuario no existe");
		
	}
	
	/**
	 * Metodo actualiza los datos de un usuario ya existente 
	 * @param nombre Nuevo nombre del usuario
	 * @param documento Nuevo documento del usuario
	 * @param correo Nuevo correo del usuario
	 * @param contrasenia Nueva contrasenia del usuario
	 */
	private void actualizarDatos(String nombre, String documento, String correo, String contrasenia) {
		try {
  			int indexU = buscarUsuario(documento);
  			Usuario usuarioActualizar = listaUsuarios.get(indexU);
  			usuarioActualizar.setNombre(nombre);
  			usuarioActualizar.setDocumento(documento);
  			usuarioActualizar.setCorreo(correo);
  			usuarioActualizar.setContrasenia(contrasenia);
  			listaUsuarios.set(indexU, usuarioActualizar);
		} catch (UsuarioException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo en el cual se registran los distintos tipos de transaccion
	 * @param tipoTransaccion Tipo de transaccion a realizar (Alquiler, Compra, Venta0)
	 * @param fecha Fecha en la que se esta realizando la transaccion
	 * @param valor Valor neto correspondiente a la transaccion
	 * @param empleado Empleado encargado de concretar la transaccion
	 * @param cliente Cliente el cual esta realizando la transaccion
	 * @param diasAlquiler Dias durante los cuales se realizara el alquiler de un vehiculo en el caso de que este sea el tipo de transaccion a registrar
	 */
	private void realizarTransaccion(Integer tipoTransaccion, LocalDate fecha, Double valor, Empleado empleado, Cliente cliente, Integer diasAlquiler,
			List<DetalleTransaccion> detallesTransaccion){
		switch (tipoTransaccion){
			case 1 : //Alquiler
			Alquiler alquiler = new Alquiler (valor, empleado, cliente, fecha,detallesTransaccion,diasAlquiler);
			listaTransacciones.add(alquiler);
			break;
			case 2 : //Compra
			Compra compra = new Compra (valor, empleado, cliente, fecha,detallesTransaccion);
			listaTransacciones.add(compra);
			break;
			case 3 : //Venta
			Venta venta = new Venta (valor, empleado, cliente, fecha,detallesTransaccion);
			listaTransacciones.add(venta);
			}
			
		}
	
	/**
	 * Metodo que borra la cuenta de un usuario que se encuentran dentro del sistema de concesionario
	 * @param documento
	 */
	private void borraCuenta(String documento) {
		try {
			int indexU = buscarUsuario(documento);
			listaUsuarios.remove(indexU);
		} catch (UsuarioException e) {
			System.out.println(e);
		}
	}                                                      
	

	/**
	 * Metodo encargado de agregar un nuevo administrador dentro del sistema del concesionario
	 * @param administrador Nuevo administrador a registrar
	 * @throws AdministradorException
	 */
	public void agregarAdministrador(Administrador administrador) throws AdministradorException {
		if (existeUsuario(administrador.getNombre(), administrador.getCorreo(), administrador.getContrasenia())) {
			throw new AdministradorException("Administrador ya registrado");
		}
		listaUsuarios.add(administrador);
	}
	
	/**
	 * Metodo encargado de agregar un nuevo administrador dentro del sistema del concesionario
	 * @param empleado Nuevo empleado a agregar
	 * @throws EmpleadoException
	 */
	public void agregarEmpleado(Empleado empleado) throws EmpleadoException {
		if (existeUsuario(empleado.getNombre(), empleado.getCorreo())) {
			throw new EmpleadoException("Empleado ya registrado");
		}
		listaUsuarios.add(empleado);
	}
	
	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un usuario previamente registrado
	 * @param documento Ducumento a evaluar
	 * @return True si el documento esta vinculado a un empledo registrado, false en caso contrario
	 */
	public boolean existeDocumentoRegistrado(String documento) {
		boolean existe=false;
		for (Usuario usuario : listaUsuarios) {
			if (usuario.tieneDocumento(documento)) {
				existe=true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Metodo que obtiene todos los usuarios de tipo empleados registrados dentro del sistema del concesionario
	 * @return Empleados registrados dentro del concesionario
	 */
	public List<Empleado> obtenerEmpleados() {
		List<Empleado> empleadoObtenidos=new ArrayList<Empleado>();
		for (Usuario usuario : listaUsuarios) {
			if (usuario.esEmpleado()) {
				empleadoObtenidos.add((Empleado)usuario);
			}
		}
		return empleadoObtenidos;
	}
	
	/**
	 * Metodo que verifica si un documento ingresado le corresponde a un cliente previamente registrado
	 * @param documento Documento del cliente a evaluar
	 * @return True si el documento le pertenece a un cliente ya registrado, false en caso contrario
	 */
	public boolean existeDocumentoCliente(String documento){
        boolean existe=false;
        for (Cliente cliente : listaClientes) {
            if (cliente.verificarDocumento(documento)) {
                existe=true;
                break;
            }
        }
        return existe;
    }
	
	/**
	 * Metodo que agrega clientes a la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	/**
	 * Metodo que elimina clientes de la lista de clientes del concesionario
	 * @param cliente Cliente a eliminar
	 */
	public void eliminarCliente(Cliente cliente) {
		listaClientes.remove(cliente);
	}
	
	/**
	 * Agrega una transacción a la lista de transacciones y actualiza la lista de vehículos según el tipo de transacción.
	 * @param transaccion La transacción a agregar.
	 * @param listaVehiculos La lista de vehículos para actualizar la lista de vehiculos
	 */
	public void agregarTransaccion(Transaccion transaccion,List<Vehiculo> listaVehiculos) {
		listaTransacciones.add(transaccion);
		switch(transaccion.obtenerTipoTransaccion()) {
			case ALQUILER:
			case VENTA: this.listaVehiculos=listaVehiculos; break;
			case COMPRA: agregarVehiculosTransaccion(transaccion); break;
		}
	}
	
	/**
	 * Agrega los vehículos de una transacción de compra a la lista de vehículos.
	 * @param transaccion La transacción de compra que contiene los vehículos a agregar.
	 */
	public void agregarVehiculosTransaccion(Transaccion transaccion) {
		for (DetalleTransaccion detalle : transaccion.getListaDetalleTransacciones()) {
			agregarVehiculoDetalleTransaccion(detalle);
		}
	}
	
	/**
	 * Agrega un vehículo a la lista de vehículos basado en un detalle de transacción.
	 * @param detalle El detalle de transacción que contiene el vehículo a agregar.
	 */
	public void agregarVehiculoDetalleTransaccion(DetalleTransaccion detalle) {
		for (int i = 0; i < detalle.getCantidad(); i++) {
			listaVehiculos.add(detalle.getVehiculo());
		}
	}
	
	/**
	 * Obtiene una lista de transacciones filtradas por tipo de transacción y rango de fechas.
	 * @param tipoTransaccion El tipo de transacción utilizado como filtro.
	 * @param fechaInicial La fecha inicial del rango.
	 * @param fechaFinal La fecha final del rango.
	 * @return Una lista de transacciones que cumplen con los criterios de filtro.
	 */
	public List<Transaccion> obtenerTransaccionesFiltradas(TipoTransaccion tipoTransaccion, LocalDate fechaInicial,LocalDate fechaFinal) {
		List<Transaccion> listaFiltrada=new ArrayList<Transaccion>();
		for (Transaccion transaccion : listaTransacciones) {
			if (transaccion.esTipoTransaccion(tipoTransaccion) && transaccion.estaFechaRango(fechaInicial, fechaFinal)) {
				listaFiltrada.add(transaccion);
			}
		}
		return listaFiltrada;
	}

}
