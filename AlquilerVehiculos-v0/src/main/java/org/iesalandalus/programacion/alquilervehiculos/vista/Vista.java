package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {
	
	private Controlador controlador; 
	
	public void setControlador(Controlador controlador) {
		
		if(!(controlador==null)) {
			
			this.controlador=controlador; 
		}
	}
	
	public void comenzar() throws Exception {
		
		boolean acabar=false; 
		
			do{
				acabar=false; 
				
				Consola.mostrarMenu();
				System.out.println(); 
				ejecutar(Consola.elegirOpcion()); 
				
			}while(acabar); 
	}
	
	public void terminar() {
		
		System.out.println("La aplicación de alquiler de vehículos va a finalizar, hasta pronto..."); 
	}

	private void ejecutar(Opcion opcion) throws Exception {
		
		switch(opcion) {
		
		case SALIR: 
		
			terminar(); 
			break; 
		
		case INSERTAR_CLIENTE: 
			
			insertarCliente(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case INSERTAR_TURISMO: 
			
			insertarTurismo(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case INSERTAR_ALQUILER: 
			
			insertarAlquiler();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BUSCAR_CLIENTE: 
			
			buscarCliente(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BUSCAR_TURISMO: 
			
			buscarTurismo(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BUSCAR_ALQUILER: 
			
			buscarAlquiler();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case MODIFICAR_CLIENTE: 
			
			modificarCliente();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case DEVOLVER_ALQUILER: 
			
			devolverAlquiler();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BORRAR_CLIENTE: 
			
			borrarCliente(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BORRAR_TURISMO: 
			
			borrarTurismo();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case BORRAR_ALQUILER: 
			
			borrarAlquiler();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case LISTAR_CLIENTES: 
			
			listarClientes(); 
			System.out.println(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			
			break; 
			
		case LISTAR_TURISMOS: 
			
			listarTurismos(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case LISTAR_ALQUILERES: 
			
			listarAlquileres();
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case LISTAR_ALQUILERES_CLIENTE: 
			
			listarAlquileresCliente(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
			
		case LISTAR_ALQUILERES_TURISMO: 
			
			listarAlquileresTurismo(); 
			System.out.println(); 
			Consola.mostrarMenu();
			System.out.println(); 
			ejecutar(Consola.elegirOpcion()); 
			break; 
		}
	}
	
	private void insertarCliente() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.INSERTAR_CLIENTE);
		Cliente cliente = new Cliente(Consola.leerCliente());
		controlador.insertar(cliente);
	}
		
	private void insertarTurismo() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.INSERTAR_TURISMO);
		Turismo turismo = new Turismo(Consola.leerTurismo());
		controlador.insertar(turismo);
	}
	
	private void insertarAlquiler() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.INSERTAR_ALQUILER);
		Alquiler alquiler = new Alquiler(Consola.leerAlquiler());
		controlador.insertar(alquiler);
	}
	
	private void buscarCliente() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_CLIENTE);
		controlador.buscar(Consola.leerClienteDni());
	}
	
	private void buscarTurismo() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_TURISMO);
		controlador.buscar(Consola.leerTurismoMatricula());
	}
	
	private void buscarAlquiler() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_ALQUILER);
		controlador.buscar(Consola.leerAlquiler());
	}
	
	private void modificarCliente() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.MODIFICAR_CLIENTE);
		controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
	}
	
	private void devolverAlquiler() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.DEVOLVER_ALQUILER);
		controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
	}
	
	private void borrarCliente() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_CLIENTE);
		controlador.buscar(Consola.leerCliente());
	}
	
	private void borrarTurismo() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_TURISMO);
		controlador.borrar(Consola.leerTurismo());
	}
	
	private void borrarAlquiler() throws Exception {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_ALQUILER);
		controlador.borrar(Consola.leerAlquiler());
	}
	
	private void listarClientes() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_CLIENTES);
		
		for(int i = 0; i< controlador.getClientes().size(); i++) {
			System.out.println(controlador.getClientes().get(i));
		}
	}
	
	private void listarTurismos() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_TURISMOS);
		
		for(int i = 0; i< controlador.getTurismos().size(); i++) {
			System.out.println(controlador.getTurismos().get(i));
		}
	}
	
	private void listarAlquileres() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES);
		
		for(int i = 0; i< controlador.getAlquileres().size(); i++) {
			
			System.out.println(controlador.getAlquileres().get(i));
		}
	}
	
	private void listarAlquileresCliente() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES_CLIENTE);
		controlador.getAlquileres(Consola.leerClienteDni());
		
	}
	
	private void listarAlquileresTurismo() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES_TURISMO);
		controlador.getAlquileres(Consola.leerTurismoMatricula());
	}
}
