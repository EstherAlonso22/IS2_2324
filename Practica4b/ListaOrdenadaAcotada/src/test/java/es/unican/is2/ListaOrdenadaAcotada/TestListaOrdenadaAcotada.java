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
	void testGet() {

		//Casos válidos
		assertDoesNotThrow(() -> {
			assertEquals(lista1.get(0), 1);
			assertEquals(lista2.get(1), 4);
			assertEquals(lista2.get(3), 6);
		});
		
		//Casos no válidos
		assertThrows (IndexOutOfBoundsException.class, () -> lista1.get(-1));
		assertThrows (IndexOutOfBoundsException.class, () -> lista2.get(4));
		assertThrows (IndexOutOfBoundsException.class, () -> lista3.get(0));
	}


	@Test
	void testAddValidos() {

		//Casos válidos
		assertDoesNotThrow(() -> {
			lista3.add(4);
			assertEquals(lista3.size(),1);
			assertEquals(lista3.get(0),4);
			
			lista1.add(4);
			assertEquals(lista1.size(), 2);
			assertEquals(lista1.get(0), 1);
			assertEquals(lista1.get(1), 4);
			
			lista2.add(4);
			assertEquals(lista2.size(), 5);
			assertEquals(lista2.get(0), 1);
			assertEquals(lista2.get(1), 4);
			assertEquals(lista2.get(2), 4);
			assertEquals(lista2.get(3), 5);
			assertEquals(lista2.get(4), 6);
		});
	}
	
	@Test
	void testAddNoValidos() {
		//Casos no válidos
		assertThrows (NullPointerException.class, () -> lista1.add(null));
		assertThrows (IllegalStateException.class, () -> lista4.add(4));
	}
	
	@Test
	void testSize() {
		
		//Casos validos
		assertDoesNotThrow(() -> {
			assertEquals(0, lista3.size());
			assertEquals(1, lista1.size());
			assertEquals(4, lista2.size());
			assertEquals(5, lista4.size());
		});

	}
	
	@Test
	void testClear() {
		
		//Casos validos
		assertDoesNotThrow(() -> {
			lista3.clear();
			assertEquals(0, lista3.size());
			
			lista1.clear();
			assertEquals(0, lista1.size());
			
			lista2.clear();
			assertEquals(0, lista2.size());
			
		});

	}
	
	@Test
	void testRemove() {
		
		assertDoesNotThrow(() -> {
			//Casos validos
			// 1º Caso
			assertEquals(1, lista1.remove(0));
			assertEquals(0, lista1.size());
			
			// 2º Caso
			assertEquals(4, lista2.remove(1));
			assertEquals(3, lista2.size());
			assertEquals(lista2.get(0), 1);
			assertEquals(lista2.get(1), 5);
			assertEquals(lista2.get(2), 6);
			
			// 3º Caso
			assertEquals(6, lista2.remove(3));
			assertEquals(3, lista2.size());
			assertEquals(lista2.get(0), 1);
			assertEquals(lista2.get(1), 4);
			assertEquals(lista2.get(2), 5);
			
		});

		// Casos no válidos
		assertThrows (IndexOutOfBoundsException.class, () -> lista1.remove(-1));
		assertThrows (IndexOutOfBoundsException.class, () -> lista2.remove(4));
		assertThrows (IndexOutOfBoundsException.class, () -> lista3.remove(0));
	}

	@Test
	void testConstructor() {
		//Casos válidos
		ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<Integer>(4);
		assertDoesNotThrow(() -> {
			lista.add(1);
			lista.add(2);
			lista.add(3);
			lista.add(4);
		});
		assertThrows(IllegalStateException.class, () -> lista.add(5));
		
		//Casos no válidos
		assertThrows(NegativeArraySizeException.class, () -> new ListaOrdenadaAcotada<Integer>(-1));

	}
	
	
}
