package es.unican.is2.Practica5aRefactorizado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class VendedorEnPlantillaTest {
	
	private static VendedorEnPlantilla sutJunior;
	private static VendedorEnPlantilla sutSenior;

	
	@BeforeEach
	public void setUp(){
		sutJunior = new VendedorJunior("Ana", "1", "11111111A");
		sutSenior = new VendedorSenior("Pepe", "2", "222222222A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutJunior.getId(), "1");
		assertEquals(sutJunior.getDni(), "11111111A");
		assertEquals(sutJunior.getNombre(), "Ana");
		assertTrue(sutJunior.getTotalVentas()==0.0);
		assertTrue(sutJunior.getC()==0.0);
		assertTrue(sutJunior instanceof VendedorJunior);
		assertTrue(sutSenior instanceof VendedorSenior);
		
	}

	@Test
	public void testAnhadeVenta() {
	
		sutJunior.anhade(200);
		assertEquals(sutJunior.getTotalVentas(), 200, 0);
		sutJunior.anhade(300);
		assertEquals(sutJunior.getTotalVentas(), 500, 0);
		sutJunior.anhade(0);
		assertEquals(sutJunior.getTotalVentas(), 500, 0);
		
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 300, 0);
		sutSenior.anhade(300);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
		sutSenior.anhade(0);
		assertEquals(sutSenior.getTotalVentas(), 600, 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setTotalVentas(2000);
		assertEquals(sutJunior.getTotalVentas(), 2000, 0);	
		sutJunior.setTotalVentas(4000);
		assertEquals(sutJunior.getTotalVentas(), 4000, 0);	
		sutJunior.setTotalVentas(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);
		
		sutSenior.setTotalVentas(4500);
		assertEquals(sutSenior.getTotalVentas(), 4500, 0);		
		sutSenior.setTotalVentas(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);
		sutJunior.setTotalVentas(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);	
		
	}
	
	@Test
	public void testSetComision() {
		
		sutJunior.setC(2000);
		assertEquals(sutJunior.getC(), 2000, 0);	
		sutJunior.setC(4000);
		assertEquals(sutJunior.getC(), 4000, 0);	
		sutJunior.setC(0);
		assertEquals(sutJunior.getC(), 0, 0);
		
		sutSenior.setC(4500);
		assertEquals(sutSenior.getC(), 4500, 0);		
		sutSenior.setC(4000);
		assertEquals(sutSenior.getC(), 4000, 0);
		sutJunior.setC(0);
		assertEquals(sutJunior.getC(), 0, 0);	
		
	}

	
	@Test
	public void testEquals() {
		VendedorJunior igualJunior = new VendedorJunior("Ana", "1", "11111111A");
		VendedorJunior distintoIdJunior = new VendedorJunior("Ana", "2", "11111111A");
		VendedorJunior distintoDNIJunior = new VendedorJunior("Ana", "1", "222222222A");
		
		assertTrue(sutJunior.equals(igualJunior));
		assertFalse(sutJunior.equals(distintoIdJunior));
		assertFalse(sutJunior.equals(distintoDNIJunior));
		
		
		VendedorSenior igualSenior = new VendedorSenior("Pepe", "2", "222222222A");
		VendedorSenior distintoIdSenior = new VendedorSenior("Pepe", "3", "222222222A");
		VendedorSenior distintoDNISenior = new VendedorSenior("Pepe", "2", "33333333A");
		
		assertTrue(sutSenior.equals(igualSenior));
		assertFalse(sutSenior.equals(distintoIdSenior));
		assertFalse(sutSenior.equals(distintoDNISenior));
		
		assertFalse(sutSenior.equals(new Object()));
	}
	
	
	
}
