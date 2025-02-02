package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Turismos {
	
	private List<Turismo> coleccionTurismos; 
	
	public Turismos() {
		
		coleccionTurismos = new ArrayList<>(); 
	}
	
	public List<Turismo> get() {
		
		ArrayList<Turismo> copiaTurismos = new ArrayList<>(); 
		copiaTurismos.addAll(coleccionTurismos);
		
		return copiaTurismos; 
	}
	
	public int getCantidad() {
		
		return coleccionTurismos.size(); 
	}
	
	public void insertar(Turismo turismo) throws Exception {
		
		if(turismo==null) {
			
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo."); 
			
		}else if((coleccionTurismos.contains(turismo))){
			
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula."); 
			
		}
		
		coleccionTurismos.add(turismo);
	}
	
	public Turismo buscar(Turismo turismo) {
		
		//Se cambia el bucle for:each por un Iterador para recorrer la lista 
		Turismo turismo2 = null; 
		
		Iterator <Turismo> iterador=coleccionTurismos.iterator(); 
		
		while (iterador.hasNext()) { // Mientras que haya un siguiente elemento, seguiremos en el bucle
			
			turismo2=iterador.next(); // Escogemos el siguiente elemento
			
			if(turismo2.getMatricula().equals(turismo.getMatricula())) {
				
				return turismo2; 
			} 
		}
		
		/* for(Turismo turismo2: coleccionTurismos) {
			
			if(turismo2.getMatricula().equals(turismo.getMatricula())) {
				
				return turismo2; 
			}
		} */
		
		if(turismo==null) {
			
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo."); 
		}
		
		return null;
	}
	
	public void borrar(Turismo turismo) throws Exception {
		
		Turismo turismo2 = buscar(turismo); 
		
		if(turismo2==null) {
			
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo."); 
			
		}else if(!coleccionTurismos.contains(turismo2)) {
			
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula."); 
			
		}else if(coleccionTurismos.contains(turismo2)){
			
			coleccionTurismos.remove(turismo);
		}
	}
}
