package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Vista {
	
	private Controlador controlador; 
	
	public void setControlador(Controlador controlador) {
		
		if(!(controlador==null)) {
			
			this.controlador=controlador; 
		}
	}
	
	public void comenzar() throws Exception {
		
		boolean error=false; 
		
		do {
			try {
			
				error = false;
				
				Consola.mostrarMenu();
				System.out.println();
				ejecutar(Consola.elegirOpcion());
			
			}catch(Exception e) {
			
				System.out.println(e.getMessage());
				error = true;
			}
			
		}while(error); 
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

		try {
			Cliente cliente = new Cliente(Consola.leerCliente());
			controlador.insertar(cliente);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		
	private void insertarTurismo() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.INSERTAR_TURISMO);

		try {
			Turismo turismo = new Turismo(Consola.leerTurismo());
			controlador.insertar(turismo);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private void insertarAlquiler() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.INSERTAR_ALQUILER);

		System.out.println("1. Insertar alquiler de nuevo cliente y turismo:"
				+ " \n2. Insertar alquiler de cliente y turismo ya existentes: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:
			try {
				Alquiler alquiler = new Alquiler(Consola.leerAlquiler());
				controlador.insertar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
			
			break;

		case 2:
			try {
				Cliente cliente = controlador.buscar(Consola.leerClienteDni());
				Turismo turismo = controlador.buscar(Consola.leerTurismoMatricula());

				Alquiler alquiler = new Alquiler(cliente, turismo, Consola.leerFechaAlquiler());
				controlador.insertar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
			
			break;
		}
	}
	
	private void buscarCliente() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_CLIENTE);

		try {
			System.out.println(controlador.buscar(Consola.leerClienteDni()));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private void buscarTurismo() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_TURISMO);

		try {

			System.out.println(controlador.buscar(Consola.leerTurismoMatricula()));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private void buscarAlquiler() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BUSCAR_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente :\n2. Buscar por matrícula de turismo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = new Cliente(Consola.leerClienteDni());
				Turismo turismo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				System.out.println(controlador.buscar(alquiler));

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Turismo turismo = new Turismo(Consola.leerTurismoMatricula());
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				System.out.println(controlador.buscar(alquiler));

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}
		
	private void modificarCliente() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.MODIFICAR_CLIENTE);

		try {

			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private void devolverAlquiler() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.DEVOLVER_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente :\n2. Buscar por matrícula de turismo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = new Cliente(Consola.leerClienteDni());
				Turismo turismo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				controlador.devolver(alquiler, Consola.leerFechaDevolucion());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Turismo turismo = new Turismo(Consola.leerTurismoMatricula());
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				controlador.devolver(alquiler, Consola.leerFechaDevolucion());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}
	
	private void borrarCliente() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_CLIENTE);

		try {

			controlador.borrar(Consola.leerClienteDni());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	private void borrarTurismo() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_TURISMO);

		try {

			controlador.borrar(Consola.leerTurismoMatricula());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private void borrarAlquiler() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.BORRAR_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente: \n2. Buscar por matrícula de turismo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = new Cliente(Consola.leerClienteDni());
				Turismo turismo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				controlador.borrar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Turismo turismo = new Turismo(Consola.leerTurismoMatricula());
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, turismo, fechaAlquiler);

				controlador.borrar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		}
	}
	
	private void listarClientes() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_CLIENTES);
		System.out.println(controlador.getClientes()); 
	}
	
	private void listarTurismos() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_TURISMOS);
		System.out.println(controlador.getTurismos()); 
	}
	
	private void listarAlquileres() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES);
		System.out.println(controlador.getAlquileres()); 
	}
	
	private void listarAlquileresCliente() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES_CLIENTE);
		System.out.println(controlador.getAlquileres(Consola.leerClienteDni()));
	}
	
	private void listarAlquileresTurismo() {
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Opcion.LISTAR_ALQUILERES_TURISMO);
		System.out.println(controlador.getAlquileres(Consola.leerTurismoMatricula()));
	}
}
