package es.unican.is2.ListaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

class TestListaOrdenadaAcotada {
	public ListaOrdenadaAcotada<Integer> lista1;
	public ListaOrdenadaAcotada<Integer> lista2;
	public ListaOrdenadaAcotada<Integer> lista3;

	@BeforeEach
	public void setUp() throws Exception {
		lista1 = new ListaOrdenadaAcotada<Integer> (5);
		lista2 = new ListaOrdenadaAcotada<Integer> (5);
		lista3 = new ListaOrdenadaAcotada<Integer> (5);
		
		//si falla el add fallan todos los demas
		//Lista1 = [1]
		lista1.add(1);
		//Lista2 = [1,4,5,6]
		lista2.add(1);
		lista2.add(4);
		lista2.add(5);
		lista2.add(6);
		//Lista3 = []
	}
	
	@Test
	void getTest() {
		lista1.get(0);
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
