package es.unican.is2.ListaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

class TestListaOrdenadaAcotada {

	@BeforeEach
	public void setUp() throws Exception {
		ListaOrdenadaAcotada<Integer> lista1 = new ListaOrdenadaAcotada<Integer> (5);
		ListaOrdenadaAcotada<Integer> lista2 = new ListaOrdenadaAcotada<Integer> (5);
		ListaOrdenadaAcotada<Integer> lista3 = new ListaOrdenadaAcotada<Integer> (5);
		
		//si falla el add fallan todos los demas
		lista1.add(1);
		lista2.add(1);
		lista2.add(4);
		lista2.add(5);
		lista2.add(6);
	}
	
	@Test
	void getTest() {
		
	}

	
	@Test
	void testAdd() {
		
		assertDoesNotThrow(() -> {
			//Casos validos
			// 1º Caso
			
			
		});

		//Casos no válidos
		

	}
}
