package altCSD;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import excepciones.PistasException;
import modelo.Biblioteca;
import modelo.LugarDeInteres;
import modelo.Pais;
import modelo.Villano;

public class BibliotecaTest {
	@Test
	public void crearUnVillanoYPonerloEnUnaBibliotecaRealmenteLoHace() {
		Villano villano = Mockito.mock(Villano.class);
		Biblioteca banco = new Biblioteca(villano);
		assert(banco.estaElVillano(villano));
	}
	
	@Test
	public void crearUnaBibliotecaRealmenteLoCrea() {
		Biblioteca banco = new Biblioteca();
		assert(banco != null);
	}
	
	@Test
	public void obtenerPistasDeUnaBibliotecaDevuelveDosOMasPistas() throws PistasException {
		Villano villano = new Villano("Maria de los Campos Marquesíes", "Femenino");
		ArrayList<Pais> planEscapeVillano = new ArrayList<Pais>();
		Biblioteca bibliotecaBolivia = new Biblioteca(villano);
		ArrayList<String> cArgentina = new ArrayList<String>();
		ArrayList<String> cBolivia = new ArrayList<String>();
		ArrayList<LugarDeInteres> ldiArgentina = new ArrayList<LugarDeInteres>();
		ArrayList<LugarDeInteres> ldiBolivia = new ArrayList<LugarDeInteres>();
		
		cArgentina.add("Toman mate");
		cArgentina.add("Bandera tiene celeste y blanco");
		cArgentina.add("A Megadeth le encanta");
		ldiBolivia.add(bibliotecaBolivia);
		villano.agregarSeniaParticular("Chasquea los dedos frecuentemente");
		villano.agregarHobbie("Juega al golf");
		
		Pais argentina = new Pais("Argentina", cArgentina, ldiArgentina);
		Pais bolivia = new Pais("Bolivia", cBolivia, ldiBolivia);
		planEscapeVillano.add(bolivia);
		planEscapeVillano.add(argentina);
		villano.establecerPlanEscape(planEscapeVillano);
		
		ArrayList<String> pistas = bibliotecaBolivia.buscarPistas();
		assertTrue(pistas.size()>=2);
	}
}
