package es.unican.is2.franquiciasUCCommon.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.franquiciasUCCommon.clases.Empleado.DatoNoValidoException;


public class EmpleadoTest {
	private Empleado empleado;

	@BeforeEach
	public void setUp() throws Exception {
		empleado = new Empleado();
	}

	@Test
	void testEmpleado() {
		LocalDate hoy = LocalDate.now();

		assertDoesNotThrow(() -> {
			//Casos validos
			empleado = new Empleado("12345678K", "Pepa", Categoria.ENCARGADO, hoy.minusYears(1));
			assertEquals("12345678K", empleado.getDNI());
			assertEquals("Pepa", empleado.getNombre());
			assertEquals(Categoria.ENCARGADO, empleado.getCategoria());
			assertEquals(hoy.minusYears(1), empleado.getFechaContratacion());

			empleado = new Empleado("12345678K", "Pepa", Categoria.VENDEDOR, hoy);
			assertEquals(Categoria.VENDEDOR, empleado.getCategoria());
			assertEquals(hoy, empleado.getFechaContratacion());

			empleado = new Empleado("12345678K", "Pepa", Categoria.AUXILIAR, hoy);
			assertEquals(Categoria.AUXILIAR, empleado.getCategoria());
		});

		//Casos no válidos
		assertThrows (NullPointerException.class, () -> new Empleado("12345678K", "Pepa", null, hoy));
		assertThrows (DatoNoValidoException.class, () -> new Empleado("12345678K", "Pepa", Categoria.ENCARGADO, hoy.plusDays(1)));
		assertThrows (NullPointerException.class, () -> new Empleado("12345678K", "Pepa", Categoria.ENCARGADO, null));


	}

	@Test
	void testSueldoBruto() {


		LocalDate hoy = LocalDate.now();

		// Casos válidos
		assertDoesNotThrow(() -> {
			// 1º caso
			empleado.setCategoria(Categoria.ENCARGADO);
			empleado.setFechaContratacion(hoy);
			empleado.setBaja(true);
			assertEquals(1500, empleado.sueldoBruto());

			// 2º caso
			empleado.setCategoria(Categoria.VENDEDOR);
			empleado.setFechaContratacion(hoy.minusYears(2));
			empleado.setBaja(false);
			assertEquals(1500, empleado.sueldoBruto());

			// 3º caso
			empleado.setCategoria(Categoria.AUXILIAR);
			empleado.setFechaContratacion(hoy.minusYears(5));
			empleado.setBaja(false);
			assertEquals(1000, empleado.sueldoBruto());

			// 4º caso
			empleado.setCategoria(Categoria.ENCARGADO);
			empleado.setFechaContratacion(hoy.minusYears(5).minusDays(1));
			empleado.setBaja(false);
			assertEquals(2050, empleado.sueldoBruto());

			// 5º caso
			empleado.setCategoria(Categoria.VENDEDOR);
			empleado.setFechaContratacion(hoy.minusYears(7));
			empleado.setBaja(true);
			assertEquals(1162.5, empleado.sueldoBruto());

			// 6º caso
			empleado.setCategoria(Categoria.AUXILIAR);
			empleado.setFechaContratacion(hoy.minusYears(10));
			empleado.setBaja(false);
			assertEquals(1050, empleado.sueldoBruto());

			// 7º caso
			empleado.setCategoria(Categoria.ENCARGADO);
			empleado.setFechaContratacion(hoy.minusYears(10).minusDays(1));
			empleado.setBaja(false);
			assertEquals(2100, empleado.sueldoBruto());

			// 8º caso
			empleado.setCategoria(Categoria.VENDEDOR);
			empleado.setFechaContratacion(hoy.minusYears(15));
			empleado.setBaja(false);
			assertEquals(1600, empleado.sueldoBruto());

			// 9º caso
			empleado.setCategoria(Categoria.AUXILIAR);
			empleado.setFechaContratacion(hoy.minusYears(20));
			empleado.setBaja(true);
			assertEquals(825, empleado.sueldoBruto());

			// 10º caso
			empleado.setCategoria(Categoria.ENCARGADO);
			empleado.setFechaContratacion(hoy.minusYears(20).minusDays(1));
			empleado.setBaja(false);
			assertEquals(2200, empleado.sueldoBruto());

			// 11º caso
			empleado.setCategoria(Categoria.VENDEDOR);
			empleado.setFechaContratacion(hoy.minusYears(50));
			empleado.setBaja(false);
			assertEquals(1700, empleado.sueldoBruto());
		});

		// Casos no válidos
		// 1º caso
		empleado.setCategoria(null);
		empleado.setFechaContratacion(hoy.minusYears(2));
		empleado.setBaja(false);
		assertThrows(NullPointerException.class, () -> empleado.sueldoBruto());

		// 2º caso
		empleado.setCategoria(Categoria.ENCARGADO);
		empleado.setFechaContratacion(hoy.plusDays(1));
		empleado.setBaja(false);
		assertThrows(DatoNoValidoException.class, () -> empleado.sueldoBruto());

		// 3º caso
		empleado.setCategoria(Categoria.VENDEDOR);
		empleado.setFechaContratacion(null);
		empleado.setBaja(true);
		assertThrows(NullPointerException.class, () -> empleado.sueldoBruto());

	}

	@Test
	void testBajaAlta() {
		assertDoesNotThrow(() -> {
			empleado.darDeBaja();
			assertEquals(true, empleado.getBaja());
			empleado.darDeBaja();
			assertEquals(true, empleado.getBaja());
			empleado.darDeAlta();
			assertEquals(false, empleado.getBaja());
			empleado.darDeAlta();
			assertEquals(false, empleado.getBaja());

			empleado.setBaja(true);
			assertEquals(true, empleado.getBaja());
			empleado.setBaja(false);
			assertEquals(false, empleado.getBaja());
		});
	}

	@Test
	void testSetters() {
		empleado.setDNI("12345678K");

	}


}
