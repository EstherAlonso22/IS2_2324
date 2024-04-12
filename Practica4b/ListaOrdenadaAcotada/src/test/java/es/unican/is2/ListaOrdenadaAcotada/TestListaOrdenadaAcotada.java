package es.unican.is2.ListaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

class TestListaOrdenadaAcotada {
	public ListaOrdenadaAcotada<Integer> lista1;
	public ListaOrdenadaAcotada<Integer> lista2;
	public ListaOrdenadaAcotada<Integer> lista3;
	public ListaOrdenadaAcotada<Integer> lista4;

	@BeforeEach
	public void setUp() throws Exception {
		lista1 = new ListaOrdenadaAcotada<Integer> (5);
		lista2 = new ListaOrdenadaAcotada<Integer> (5);
		lista3 = new ListaOrdenadaAcotada<Integer> (5);
		lista4 = new ListaOrdenadaAcotada<Integer> (5);

		//si falla el add fallan todos los demas
		//Lista1 = [1]
		lista1.add(1);
		//Lista2 = [1,4,5,6]
		lista2.add(1);
		lista2.add(4);
		lista2.add(5);
		lista2.add(6);
		//Lista3 = []
		//Lista4 = [1,4,5,6,7]
		lista4.add(1);
		lista4.add(4);
		lista4.add(5);
		lista4.add(6);
		lista4.add(7);
	}

	@Test
	void getTest() {

		//Casos válidos
		assertDoesNotThrow(() -> {
			assertEquals(lista1.get(0), 1);
			assertEquals(lista2.get(1), 4);
			assertEquals(lista2.get(3), 6);
		});
		
		//Casos no válidos
		
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
