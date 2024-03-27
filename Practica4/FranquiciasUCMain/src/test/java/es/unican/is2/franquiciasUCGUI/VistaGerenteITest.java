package es.unican.is2.franquiciasUCGUI;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;

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

		demo.textBox("txtNombreTienda").enterText("");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Tienda no existe");

		//Casos válidos
		demo.textBox("txtNombreTienda").enterText("Tienda A");
		demo.button("btnBuscar").click();
		demo.textBox("txtDireccionTienda").requireText("Direccion A");
		demo.textBox("txtTotalSueldos").requireText("2100");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}