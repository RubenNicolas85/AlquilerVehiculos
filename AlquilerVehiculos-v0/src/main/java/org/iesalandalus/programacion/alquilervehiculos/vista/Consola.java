package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private static final String PATRON_FECHA="dd/MM/yyyy"; 
	private static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern(PATRON_FECHA);
	
	private Consola() {
		
	}
	
	public static void mostrarMenu() {
		
		System.out.println(); 
		mostrarCabecera("MENÚ PRINCIPAL - APLICACIÓN DE ALQUILER DE VEHÍCULOS"); 
		
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	/* Para que este método funcione definimos el String str como un guión, después, definimos
	 * otro String repeated, que será igual a str repetido el número de veces del tamaño del 
	 * mensaje introducido como parámetro. Por último, se imprime el mensaje concatenado con
	 * salto de línea y concatenado con el String repeated */
	
	public static void mostrarCabecera(String mensaje) {
		
		String str = "-"; 
		String repeated = str.repeat(mensaje.length()); 
		
		System.out.println(mensaje + "\n" + repeated); 
	}
	
	/* Se crea el método elegirOpcion que leerá un entero (utilizando el método anteriormente 
	 * creado) asociado a la opción y devolverá la opción correspondiente. Si el entero 
	 * introducido no se corresponde con ninguna opción deberá volver a leerlo hasta que éste 
	 * sea válido */
	
	public static Opcion elegirOpcion() {
		
		int ordinalOpcion = 0;
		boolean error=false; 
		
		do {
			
			try {
			
				error=false; 
				ordinalOpcion=leerEntero("Elige una opción: "); 
				
				Opcion.esOrdinalValido(ordinalOpcion);
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				error = true;
			}
			
		} while (error);
		
		return Opcion.get(ordinalOpcion);
	}
	
	public static Cliente leerCliente() {
		
		Cliente cliente = new Cliente(leerNombre(), 
				leerCadena("Introduzca el DNI del cliente"),
				leerTelefono()); 
		
		return cliente;
	}
	
	public static Cliente leerClienteDni() {
		
		String dni = leerCadena("Introduzca el DNI del cliente");
		
		Cliente cliente = new Cliente("Cliente", 
				dni,"900900900"); 
		
		return cliente; 
	}
	
	public static String leerNombre() {
		
		return leerCadena("Introduzca el nombre del cliente"); 
	}
	
	public static String leerTelefono() {
		
		return leerCadena("Introduzca el teléfono del cliente"); 
	}
	
	public static Turismo leerTurismo() {
		
		Turismo turismo = new Turismo(leerCadena("Introduzca la marca del turismo: "
				+ "Seat | Land Rover | KIA | Rolls-Royce | SsangYong"), 
				leerCadena("Introduzca el modelo del turismo: "),
				leerEntero("Introduzca la cilindrada del turismo (Entre 0 y 5000): "),
				leerCadena("Introduzca la matrícula del turismo en formato: 1111BBB")); 
		
		return turismo; 
	}
	
	public static Turismo leerTurismoMatricula() {
		
		String matricula = leerCadena("Introduzca la matrícula del turismo en formato: 1111BBB");
		
		Turismo turismo = new Turismo("Seat", "León", 1500, matricula); 
		
		return turismo; 
	}
	
	public static Alquiler leerAlquiler() {
		
		Alquiler alquiler = new Alquiler(leerCliente(), leerTurismo(), 
				leerFecha("Por favor, introduzca la fecha del alquiler: Día / Mes / Año: ")); 
		
		return alquiler;
	}
	
	public static LocalDate leerFechaAlquiler() {
		
		LocalDate fechaAlquiler = leerFecha("Por favor, introduzca la fecha de alquiler del turismo: Día / Mes / Año: "); 
	
		return fechaAlquiler; 
	}

	public static LocalDate leerFechaDevolucion() {
		
		LocalDate fechaDevolucion = leerFecha("Por favor, introduzca la fecha de devolución del turismo: Día / Mes / Año: "); 
	
		return fechaDevolucion; 
	}
	
	private static String leerCadena(String mensaje) {
		
		System.out.println(mensaje); 
		String cadena=Entrada.cadena(); 
		
		return cadena; 
	}
	
	private static Integer leerEntero(String mensaje) {
		
		System.out.println(mensaje); 
		int entero=Entrada.entero(); 
		
		return entero; 
	}
	
	private static LocalDate leerFecha(String mensaje) {
		
		int dia=0; 
		int mes=0; 
		int year=0; 
		
		LocalDate fecha=null; 
		
		do {
			
			fecha=null; 
			System.out.println(mensaje);
			
			dia=leerEntero("Por favor, indique el día: "); 
			mes=leerEntero("Por favor, indique el mes: ");
			year=leerEntero("Por favor, indique el año: ");
			
			fecha = LocalDate.of(year, mes, dia);
			
		}while(fecha==null); 
		
		return fecha;
	}
}
