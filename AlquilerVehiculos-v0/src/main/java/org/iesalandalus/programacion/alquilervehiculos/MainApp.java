package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.*; 

public class MainApp {
	
	/* En el método main se crea una instancia del modelo, otra de la vista y, una vez
	 * creadas ambas, creamos un objeto de tipo controlador. Invocamos el método comenzar
	 * del objeto controlador para que se ejecute el programa */
	
	  public static void main(String[] args) throws Exception {
		
		  Modelo modelo = new Modelo();
		  Vista vista = new Vista();
		  
		  Controlador controlador = new Controlador(modelo, vista);
		  controlador.comenzar();  
	}
}
