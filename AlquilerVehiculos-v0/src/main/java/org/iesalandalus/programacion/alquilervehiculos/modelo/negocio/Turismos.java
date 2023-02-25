package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
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
		
		getCantidad(); 
			
		if(buscar(turismo)==null) {
			
			coleccionTurismos.add(turismo);
		}
	}
	
	public Turismo buscar(Turismo turismo) {
		
		if(turismo==null) {
			
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo."); 
		}
		
		if(!coleccionTurismos.contains(turismo)) {
			
			return turismo=null;
		}
					
		return turismo;
	}
	
	public void borrar(Turismo turismo) throws Exception {
		
		if(turismo==null) {
			
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo."); 
			
		}else if(!coleccionTurismos.contains(turismo)) {
			
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula."); 
			
		}else if(coleccionTurismos.contains(turismo)){
			
			coleccionTurismos.remove(turismo);
		}
	}
}
