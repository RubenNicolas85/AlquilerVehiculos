package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Alquileres {
	
	private List<Alquiler> coleccionAlquileres; 
	
	public Alquileres() {
		
		coleccionAlquileres = new ArrayList<>(); 
	}
	
	public ArrayList<Alquiler> get() {
		
		ArrayList<Alquiler> copiaAlquileres = new ArrayList<>(); 
		copiaAlquileres.addAll(coleccionAlquileres);
		
		return copiaAlquileres; 
	}
	
	/* Se crea el método get para un cliente dado, que devolverá una nueva lista con los alquileres para 
	 * dicho cliente (no debe crear nuevas instancias) */
	
	public ArrayList<Alquiler> get(Cliente cliente) {
		
		ArrayList<Alquiler> alquileresCliente = new ArrayList<>(); 
		
		for (Alquiler alquiler : coleccionAlquileres) {
			
			if(alquiler.getCliente().equals(cliente)){
				
                alquileresCliente.add(alquiler);
            }
        } 
		
		return alquileresCliente;
    }
	
	public ArrayList<Alquiler> get(Turismo turismo) {
		
		ArrayList<Alquiler> alquileresTurismo = new ArrayList<>(); 
		
		for (Alquiler alquiler : coleccionAlquileres) {
			
			if(alquiler.getTurismo().equals(turismo)){
				alquileresTurismo.add(alquiler);
            }
        } 
		
		return alquileresTurismo;
	}
	
	public int getCantidad() {
		
		return coleccionAlquileres.size(); 
	}
	
	public void insertar(Alquiler alquiler) throws Exception {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo."); 
		}

		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
        
		coleccionAlquileres.add(alquiler);
	}
	
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws Exception {

		for (Alquiler alquiler : coleccionAlquileres) {
			
			/* Si la fecha de devolución es nula y si el cliente es nuestro cliente, quiere decir que el cliente 
			 * tiene otro alquiler aún sin devolver. Si la fecha de devolución es nula y si el turismo es el mismo,
			 * quiere decir que el turismo sigue alquilado aún: */
			
			if (alquiler.getFechaDevolucion() == null) {
				
				if (alquiler.getCliente().equals(cliente)) {
					
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
					
				} else if (alquiler.getTurismo().equals(turismo)) {
					
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}
			} else {
			
			/* Si la fecha de alquiler es igual a la fecha de devolución y si tanto el cliente como el turismo son
			 * los mismos, se lanzará la excepción de que el cliente y el turismo tienen un alquiler posterior: */
				
				if (fechaAlquiler.isEqual(alquiler.getFechaDevolucion())) {
					
					if (alquiler.getCliente().equals(cliente)) {
						
						throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
						
					} else if (alquiler.getTurismo().equals(turismo) && !alquiler.getFechaAlquiler().isAfter(fechaAlquiler)){
						
						throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
					}
				}
			}
		}
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo."); 
		}
		
		if(!coleccionAlquileres.contains(alquiler)) {
			
			return null; 
		}
			
		return alquiler;
	}
	
	public void borrar(Alquiler alquiler) throws Exception {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo."); 
			
		}else if(!coleccionAlquileres.contains(alquiler)){
			
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual."); 
			
		}else if(coleccionAlquileres.contains(alquiler)){
		
			coleccionAlquileres.remove(alquiler);
		}
	}

	public Alquiler devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo."); 
			
		}else if(!coleccionAlquileres.contains(alquiler)) {
			
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual."); 
		}
		return alquiler;
	}
}
