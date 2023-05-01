package co.uniquindio.proyecto.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.uniquindio.proyecto.model.*;
import co.uniquindio.proyecto.exceptions.*;
import co.uniquindio.proyecto.util.ClaseUtilitaria;

import java.time.temporal.ChronoUnit;
import java.io.Serializable;

public class Concesionario implements Serializable{
	
	////Acceso a las Variables de Entorno - Compartidas
    public static Concesionario conce = null;
    
//    static{
//		iniciarDatos();
//	}
    
    
    ////////////////

	
	private String nombre;
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Transaccion> listaTransacciones;
	
	public Concesionario (){
		
	}
	
	public Concesionario (String nombre){
		this.nombre = nombre;
		listaUsuarios=new ArrayList<Usuario>();
		listaClientes=new ArrayList<Cliente>();
		listaTransacciones=new ArrayList<Transaccion>();
	}
	
	//setter y getter
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	

	public ArrayList<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	
	

	public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	
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
	
	private void realizarTransaccion(Integer tipoTransaccion, LocalDate fecha, Double valor, Empleado empleado, Cliente cliente, Integer diasAlquiler){
		switch (tipoTransaccion){
			case 1 : //Alquiler
			Alquiler alquiler = new Alquiler (fecha, valor, empleado, cliente, diasAlquiler);
			listaTransacciones.add(alquiler);
			break;
			case 2 : //Compra
			Compra compra = new Compra (fecha, valor, empleado, cliente);
			listaTransacciones.add(compra);
			break;
			case 3 : //Venta
			Venta venta = new Venta (fecha, valor, empleado, cliente);
			listaTransacciones.add(venta);
			}
			
		}
		
	private void borraCuenta(String documento) {
		try {
			int indexU = buscarUsuario(documento);
			listaUsuarios.remove(indexU);
		} catch (UsuarioException e) {
			System.out.println(e);
		}
	}                                                      
	
	public static void iniciarDatos(){
		Concesionario SeriConce = ClaseUtilitaria.deserializarObjeto("EstadoProductos.dat", Concesionario.class);
		
		//revisa si el archivo esta vacio
		if (conce==null){
			Concesionario.conce= new Concesionario();
		} else{
			Concesionario.conce= SeriConce;
		}
	}
	
	public void guardar(){
	    ClaseUtilitaria.serializarObjeto("EstadoProductos.dat", this);
	}

	public void agregarAdministrador(Administrador administrador) throws AdministradorException {
		if (existeUsuario(administrador.getNombre(), administrador.getCorreo(), administrador.getContrasenia())) {
			throw new AdministradorException("Administrador ya registrado");
		}
		listaUsuarios.add(administrador);
	}
	
	public void agregarEmpleado(Empleado empleado) throws EmpleadoException {
		if (existeUsuario(empleado.getNombre(), empleado.getCorreo(), empleado.getContrasenia())) {
			throw new EmpleadoException("Empleado ya registrado");
		}
		listaUsuarios.add(empleado);
	}
	
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

	public List<Empleado> obtenerEmpleados() {
		List<Empleado> empleadoObtenidos=new ArrayList<Empleado>();
		for (Usuario usuario : listaUsuarios) {
			if (usuario.esEmpleado()) {
				empleadoObtenidos.add((Empleado)usuario);
			}
		}
		return empleadoObtenidos;
	}

}
