package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.*; 

public class MainApp {

	  public static void main(String[] args) {
		
		  Modelo modelo = new Modelo();
		  Vista vista = new Vista();
		  
		  Controlador controlador = new Controlador(modelo, vista);
		  controlador.comenzar();  
	}
}
