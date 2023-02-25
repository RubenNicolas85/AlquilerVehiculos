package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion { SALIR("Salir"), INSERTAR_CLIENTE("Insertar Cliente"), 
	INSERTAR_TURISMO("Insertar Turismo"), INSERTAR_ALQUILER("Insertar Alquiler"), 
	BUSCAR_CLIENTE("Buscar Cliente"), BUSCAR_TURISMO("Buscar Turismo"), 
	BUSCAR_ALQUILER("Buscar Alquiler"), MODIFICAR_CLIENTE("Modificar Cliente"), 
	DEVOLVER_ALQUILER("Devolver Alquiler"), BORRAR_CLIENTE("Borrar Cliente"), 
	BORRAR_TURISMO("Borrar Turismo"), BORRAR_ALQUILER("Borrar Alquiler"), 
	LISTAR_CLIENTES("Listar Clientes"), LISTAR_TURISMOS("Listar Turismos"), 
	LISTAR_ALQUILERES("Listar Alquileres"), 
	LISTAR_ALQUILERES_CLIENTE("Listar Alquileres Cliente"), 
	LISTAR_ALQUILERES_TURISMO("Listar Alquileres Turismo"); 
	
	private String texto; 
	
	private Opcion(String texto) {
		
		this.texto=texto; 		
	}
	
	static boolean esOrdinalValido(int ordinal) {
		
		return (ordinal >= 0 && ordinal <= Opcion.values().length - 1);
	}
	
	public static Opcion get(int ordinal) {
		
		if (esOrdinalValido(ordinal))
			
			return values()[ordinal];
		else
			throw new IllegalArgumentException("Ordinal de la opción no válido");
	}

	public String toString() {
		
		return String.format("%d.- %s", ordinal(), texto);
	}
}
