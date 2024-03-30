package es.unican.is2.franquiciasUCGUI;

import static org.junit.jupiter.api.Assertions.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;
import java.util.Arrays;

import es.unican.is2.franquiciasUCBusiness.GestionEmpleados;
import es.unican.is2.franquiciasUCBusiness.GestionTiendas;
import es.unican.is2.franquiciasUCDAO.EmpleadosDAO;
import es.unican.is2.franquiciasUCDAO.TiendasDAO;


class VistaGerenteITest {
	private FrameFixture demo;

	private TiendasDAO tiendasDAO = new TiendasDAO();
	private EmpleadosDAO empleadosDAO = new EmpleadosDAO();
	private GestionTiendas gTiendas = new GestionTiendas(tiendasDAO);
	private GestionEmpleados gEmpleados = new GestionEmpleados(tiendasDAO, empleadosDAO);

	@BeforeEach
	public void setUp(){
		VistaGerente vista = new VistaGerente(gTiendas, gEmpleados);
		demo = new FrameFixture(vista);
		vista.setVisible(true);
	}

	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		//Comprobar que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");

		//Casos no válidos
		demo.textBox("txtNombreTienda").enterText("Tienda1");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Tienda no existe");
		demo.textBox("txtNombreTienda").deleteText();
		demo.textBox("txtTotalContribuyente").requireText("");
		String[] contenidoLista = {};
		assertTrue(Arrays.equals(demo.list("listNombreEmpleados").contents(),contenidoLista));
		
		demo.textBox("txtNombreTienda").enterText("");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Tienda no existe");
		demo.textBox("txtNombreTienda").deleteText();
		demo.textBox("txtTotalContribuyente").requireText("");
		assertTrue(Arrays.equals(demo.list("listNombreEmpleados").contents(),contenidoLista));

		
		//Casos válidos
		demo.textBox("txtNombreTienda").enterText("Tienda A");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Direcci�n A");
		demo.textBox("txtTotalContribuyente").requireText("4362.5");
		String[] contenidoLista1 = {"Juan Perez","Maria Rodriguez","Luis Mart�nez"};
		assertTrue(Arrays.equals(demo.list("listNombreEmpleados").contents(),contenidoLista1));
		demo.textBox("txtNombreTienda").deleteText();
		
		demo.textBox("txtNombreTienda").enterText("Tienda B");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Direcci�n B");
		demo.textBox("txtTotalContribuyente").requireText("2100.0");
		String[] contenidoLista2 = {"Luc�a Ib��ez"};
		assertTrue(Arrays.equals(demo.list("listNombreEmpleados").contents(),contenidoLista2));		
		demo.textBox("txtNombreTienda").deleteText();
		
		demo.textBox("txtNombreTienda").enterText("Tienda C");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Direcci�n C");
		demo.textBox("txtTotalContribuyente").requireText("0.0");
		assertTrue(Arrays.equals(demo.list("listNombreEmpleados").contents(),contenidoLista));
		demo.textBox("txtNombreTienda").deleteText();
		
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}