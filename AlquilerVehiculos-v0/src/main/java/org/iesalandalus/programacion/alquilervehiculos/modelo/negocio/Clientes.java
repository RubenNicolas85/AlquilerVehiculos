package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Clientes {
	
	private List<Cliente> coleccionClientes;
	
	/* Se crea el constructor por defecto que simplemente creará la lista */
	
	public Clientes() {
		
		coleccionClientes=new ArrayList<>();
	}
	
	/* Se crea el método get que devolverá una nueva lista con los mismos elementos (no debe crear nuevas 
	 * instancias) */
	
	public List<Cliente> get(){
		
		ArrayList<Cliente> copiaClientes = new ArrayList<>(); 
		copiaClientes.addAll(coleccionClientes);
		
		return copiaClientes; 
	}
	
	/* Se crea el método getCantidad que devolverá la cantidad de elementos que contiene la lista */
	
	public int getCantidad() {
		
		return coleccionClientes.size();
	}
	
	/* Se crea el método insertar que añadirá un cliente a la lista si éste no es nulo y no existe aún 
	 * en la lista */
	
	public void insertar(Cliente cliente) throws Exception{
		
		if(cliente==null) {
			
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo."); 
			
		}else if(coleccionClientes.contains(cliente)){
				
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI."); 
		}
		
		getCantidad(); 
			
		if(buscar(cliente)==null) {
				
				coleccionClientes.add(cliente);
		}
	}
	
	/* Se crea el método buscar que devolverá el cliente si éste se encuentra en la lista y null en caso 
	 * contrario */
	
	public Cliente buscar(Cliente cliente) {
		
		if(coleccionClientes.contains(cliente)) {
			
			return cliente;  
		}

		if(cliente==null) {
			
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo."); 
		}
		
		return null;
	}
	
	/* Se crea el método borrar que borrará el cliente si éste existe en la lista o lanzará una excepción 
	 * en caso contrario */
	
	public void borrar(Cliente cliente) throws Exception {
		
		if(cliente==null) {
			
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo."); 
		}
		
		int indice = coleccionClientes.indexOf(cliente);
		
		if (indice == -1) {
			
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}else {
			
			coleccionClientes.remove(cliente);
		}
	}
	
	/* se crea el método modificar que permitirá cambiar el nombre o el teléfono (si estos parámetros no 
	 * son nulos) de un cliente existente y si no lanzará la correspondiente excepción */
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws Exception {
		
		if(cliente==null) {
			
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		
		if(!coleccionClientes.contains(cliente)) {
			
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI."); 
		}
		
		if(nombre==null && telefono!=null) {
			
			cliente.setTelefono(telefono);	
		}
		
		if(telefono==null && nombre!=null) {
			
			System.out.println("El teléfono introducido es nulo, no se puede modificar"); 
			cliente.setNombre(nombre);
		}
		
		if(nombre!=null && telefono!=null) {
			
			cliente.setNombre(nombre);
			cliente.setTelefono(telefono);	
		}
	}
}
