package es.unican.is2.franquiciasUCCommon.clases;


import java.time.LocalDate;
/**
 * Clase que representa un empleado de la franquicia, 
 * con sus datos personales 
 * y su estado en la franquicia (baja y categoria)
 */
public class Empleado {
	
	private String DNI;
	private String nombre;
	private Categoria categoria;
	private LocalDate fechaContratacion;
	private boolean baja;

	
	/**
	 * Lanzada si se trata de anhadir un dato no valido.
	 */
	@SuppressWarnings("serial")
	public static class DatoNoValidoException extends RuntimeException {
	}
	
	
	
	public Empleado() {	}
	
	/**
	 * Constructor del empleado con DNI, nombre, categoria y fecha de contratacion.
	 * Por defecto, baja se inicializa a false. 
	 * @param DNI
	 * @param nombre
	 * @param categoria
	 * @param fechaContratacion
	 */
	public Empleado(String DNI, String nombre, Categoria categoria, LocalDate fechaContratacion) {
		this.nombre = nombre;
		this.DNI=DNI;
		this.categoria=categoria;
		this.fechaContratacion=fechaContratacion;
		this.baja = false;
	}
	
	/**
	 * Retorna el sueldo bruto del empleado
	 */
	public double sueldoBruto() throws DatoNoValidoException, NullPointerException {
		double sueldo = 0;
		
		if (categoria == null || fechaContratacion == null) {
			throw new NullPointerException();
		}
		
		//Calcula el sueldo base dependiendo de la categoria
		switch (categoria) {
		case ENCARGADO:
			sueldo = 2000;
			break;
		case VENDEDOR:
			sueldo = 1500;
			break;
		case AUXILIAR:
			sueldo = 1000;
			break;
		default: 
			break;
		}
		
		//Calcula el complemento por antiguedad
		LocalDate hoy = LocalDate.now();
		
		if (fechaContratacion.plusYears(20).isBefore(hoy)) {
			sueldo = sueldo + 200;
		} else if (fechaContratacion.plusYears(10).isBefore(hoy)) {
			sueldo = sueldo + 100;
		} else if (fechaContratacion.plusYears(5).isBefore(hoy)){
			sueldo = sueldo + 50;
		}
		
		else if (fechaContratacion.isAfter(hoy)){
			throw new DatoNoValidoException();
		}
		
		
		//Comprueba si esta de baja
		if (baja) {
			sueldo = 0.75*sueldo;
		}
		return sueldo;
	}
	
	/** 
	 * Dar de baja al empleado
	 */
	public void darDeBaja() {
		this.baja=true;
	}
	
	/**
	 * Dar de alta al empleado
	 */
	public void darDeAlta() {
		this.baja=false;
	}
	
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDNI() {
		return DNI;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna la categoria del empleado
	 *  @return categoria
	 */
	public Categoria getCategoria () {
		return categoria;
	}
	
	/**
	 * Retorna la fecha de contrato
	 * @return Fecha de contratacion
	 */
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	
	/**
	 * Retorna si el empleado est� de baja
	 * @return true si esta de baja
	 *         false si no lo esta
	 */
	public boolean getBaja() {
		return baja;
	}
		
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
