package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.*;

public class Modelo {

	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;
	
	public Modelo(){
		
	}
	
	public void comenzar() throws Exception{
		
		clientes = new Clientes(); 
		alquileres = new Alquileres(); 
		turismos = new Turismos(); 
	}
	
	public void terminar() {
		
		System.out.println("El modelo ha terminado."); 
	}
	
	public void insertar(Cliente cliente) throws Exception {
		
		clientes.insertar(new Cliente(cliente));
	}
	
	public void insertar(Turismo turismo) throws Exception {

		turismos.insertar(new Turismo(turismo));
	}
	
	public void insertar(Alquiler alquiler) throws Exception  {
		
		if(alquiler == null) {
			
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		
		if(clientes.buscar(alquiler.getCliente()) == null) {
			
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		
		if(turismos.buscar(alquiler.getTurismo()) == null) {
			
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		} 
		
		alquileres.insertar(new Alquiler(alquiler));
	}
	
	public Cliente buscar(Cliente cliente) {
		
		return clientes.buscar(cliente); 
	}
	
	public Turismo buscar(Turismo turismo) {
		
		return turismos.buscar(turismo); 
	}

	public Alquiler buscar(Alquiler alquiler) {
	
		return alquileres.buscar(alquiler); 
	}
	
	public void modificar(Cliente cliente, String nombre, String Telefono) throws Exception {
		
		clientes.modificar(cliente, nombre, Telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception {
		
		if(alquileres.buscar(alquiler) == null) {
			
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
			
		}else {
			
			alquiler.devolver(fechaDevolucion);
			alquileres.devolver(alquiler, fechaDevolucion); 
		}
	}
	
	/* Se crean los diferentes métodos borrar, teniendo en cuenta que los borrados se realizarán 
	 * en cascada, es decir, si borramos un cliente también borraremos todos sus alquileres y lo 
	 * mismo pasará con los turismos */
	
	public void borrar(Cliente cliente) throws Exception {
		
		for (Alquiler alquiler : alquileres.get(cliente)) {
			alquileres.borrar(alquiler);
		}
		
		clientes.borrar(cliente);
	}
	
	public void borrar(Turismo turismo) throws Exception {
		
		for (Alquiler alquiler : alquileres.get(turismo)) {
			alquileres.borrar(alquiler);
		}
		
		turismos.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws Exception {
		
		alquileres.borrar(alquiler);
	}
	
	/* Se crean los diferentes métodos get, que deben devolver una nueva lista pero que 
	 * contenga nuevas instancias no una copia de los elementos: */
	
	public List<Cliente> getClientes() {
		
		return clientes.get();
	}
	
	public List<Turismo> getTurismos() {
		
		return turismos.get();
	}
	
	public List<Alquiler> getAlquileres() {
		
		return alquileres.get();
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente) {
		
		return alquileres.get(cliente);
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo) {
	
		return alquileres.get(turismo);
	}
}
