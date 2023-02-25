package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.*; 

public class Controlador {
	
	private Modelo modelo; 
	private Vista vista; 
	
	public Controlador(Modelo modelo, Vista vista) {
		
		if (modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
		}
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}
	
	public void comenzar() {
		
		boolean error=false; 
		
		do {
			try {
				
				error = false;
				
				modelo.comenzar();
				vista.comenzar();
			
			}catch(Exception e) {
			
				System.out.println(e.getMessage());
				error = true;
			}
		}while(error); 
	}
	
	public void terminar() {
		
		vista.terminar();
	}
	
	public void insertar(Cliente cliente) throws Exception{
		
		modelo.insertar(cliente);
	}
	
	public void insertar(Turismo turismo) throws Exception {
		
		modelo.insertar(turismo);
	}
	
	public void insertar(Alquiler alquiler) throws Exception {
		
		modelo.insertar(alquiler);
	}
	
	public Cliente buscar(Cliente cliente) {
		
		return modelo.buscar(cliente); 
	}
	
	public Turismo buscar(Turismo turismo) {
		
		return modelo.buscar(turismo); 
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		
		return modelo.buscar(alquiler); 
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws Exception {
		
		modelo.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception{
		
		modelo.devolver(alquiler, fechaDevolucion);
	}
	
	public void borrar(Cliente cliente) throws Exception {
		
		modelo.borrar(cliente);
	}
	
	public void borrar(Turismo turismo) throws Exception{
		
		modelo.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws Exception{
	
		modelo.borrar(alquiler);
	}
	
	public List<Cliente> getClientes() {
		
		return modelo.getClientes();
	}
	
	public List<Turismo> getTurismos() {
		
		return modelo.getTurismos(); 
	}
	
	public List<Alquiler> getAlquileres() {
		
		return modelo.getAlquileres(); 
	}	
	
	public List<Alquiler> getAlquileres(Cliente cliente) {
		
		return modelo.getAlquileres(cliente); 
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
	
		return modelo.getAlquileres(turismo); 
	}
}
