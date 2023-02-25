package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	
	protected static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20; 
	
	private Cliente cliente; 
	private Turismo turismo; 
	private LocalDate fechaAlquiler; 
	private LocalDate fechaDevolucion; 
	
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		
		setCliente(cliente); 
		setTurismo(turismo); 
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler(Alquiler alquiler) {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo."); 
			
		}else {
			
			setCliente(new Cliente(alquiler.getCliente())); 
			setTurismo(new Turismo(alquiler.getTurismo())); 
			setFechaAlquiler(alquiler.getFechaAlquiler()); 
		
			boolean error=false; 
			
			try {

				error = false;
				setFechaDevolucion(alquiler.getFechaDevolucion());

			} catch (Exception e) {

				System.out.println(e.getMessage());
				error = true;
			} 
		} 
	}

	public Cliente getCliente() {
		
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		
		if(cliente==null) {
			
			throw new NullPointerException("ERROR: El cliente no puede ser nulo."); 
		}else {
			
			this.cliente = cliente;
		}
	}

	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		
		if(turismo==null) {
			
			throw new NullPointerException("ERROR: El turismo no puede ser nulo."); 
		}else {
			
			this.turismo = turismo;
		}
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		
		if(fechaAlquiler==null) {
			
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula."); 
			
		}else if(fechaAlquiler.isAfter(LocalDate.now())) {
			
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura."); 
			
		}else if(fechaAlquiler.isBefore(LocalDate.now()) || fechaAlquiler.isEqual(LocalDate.now())){
			
			this.fechaAlquiler = fechaAlquiler;
		}
	}

	public LocalDate getFechaDevolucion() {
		
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) throws Exception {

		if (fechaDevolucion == null) {
			
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		
		if (!fechaDevolucion.isAfter(fechaAlquiler)) {
			
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		
		if (fechaDevolucion == getFechaDevolucion()) {
			
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		
		this.fechaDevolucion=fechaDevolucion; 
	}
	
	public void devolver(LocalDate fechaDevolucion) throws Exception {
		
		setFechaDevolucion(fechaDevolucion); 
	}
	
	/* El precio que cobra por alquiler un turismo es el siguiente: 
	 * (precioDia + factorCilindrada) * numDias. El precioDia es 20, el factorCilindrada 
	 * depende de la cilindrada del turismo alquilada y es igual a la cilindrada del turismo / 10, 
	 * y numDias son los días transcurridos entre la fecha de alquiler y la de devolución */
	
	public int getPrecio() {
		
		if(fechaDevolucion == null){
            
			return 0;
        }
        
        int factorCilindrada = turismo.getCilindrada() / 10;
        int numDias = (int) ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
        
        return (PRECIO_DIA + factorCilindrada) * numDias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		return String.format("%s <---> %s, %s - %s ("+getPrecio()+"€)",
                getCliente(), getTurismo(), getFechaAlquiler().format(FORMATO_FECHA), 
                (getFechaDevolucion() == null) ? "Aún no devuelto" : fechaDevolucion.format(FORMATO_FECHA), 
                (getFechaDevolucion() == null) ? LocalDate.now().format(FORMATO_FECHA) : "",
                getPrecio());
	}
}
