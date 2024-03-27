package es.unican.is2.franquiciasUCCommon.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiendaITest {
	private Tienda tienda;

	@BeforeEach
	public void setUp() throws Exception {
		tienda = new Tienda();
	}
	@Test
	void testTienda() {
		assertDoesNotThrow(() -> {
			tienda = new Tienda("Tienda1", "Santander");
			assertEquals("Tienda1", tienda.getNombre());
		});
		assertThrows(NullPointerException.class, () -> new Tienda(null, "Santander"));
		assertThrows(NullPointerException.class, () -> new Tienda("Tienda1", null));
	}

	@Test
	void testGastoMensualSueldos() {
		LocalDate hoy = LocalDate.now();
		assertDoesNotThrow(() -> {
			Empleado empleado1 = new Empleado("12345678K", "Pepe", Categoria.VENDEDOR, hoy);
			Empleado empleado2 = new Empleado("12345678K", "Marcos", Categoria.ENCARGADO, hoy);
			empleado2.darDeBaja();
			Empleado empleado3 = new Empleado("12345678K", "Paco", Categoria.VENDEDOR, hoy);

			assertEquals(0.0, tienda.gastoMensualSueldos());

			tienda.getEmpleados().add(empleado1);
			assertEquals(1500.0, tienda.gastoMensualSueldos());

			tienda.getEmpleados().add(empleado2);
			tienda.getEmpleados().add(empleado3);
			assertEquals(4500.0, tienda.gastoMensualSueldos());
		});
	}

}
