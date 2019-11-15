package altCSD;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import excepciones.PistasException;
import modelo.Banco;
import modelo.LugarDeInteres;
import modelo.Pais;
import modelo.Villano;

public class BancoTest { 
	@Test
	public void crearUnVillanoYPonerloEnUnBancoRealmenteLoHace() {
		Villano villano = Mockito.mock(Villano.class);
		Banco banco = new Banco(villano);
		
		assert(banco.estaElVillano(villano));
	}
	
	@Test
	public void crearUnBancoRealmenteLoCrea() {
		Banco banco = new Banco();
		
		assert(banco != null);
	}
	
	@Test
	public void obtenerPistasDeUnBancoDevuelveDosPistas() throws PistasException {
		Villano villano = new Villano("Maria de los Campos Marquesíes", "Femenino");
		ArrayList<Pais> planEscapeVillano = new ArrayList<Pais>();
		Banco bancoBolivia = new Banco(villano);
		ArrayList<String> cArgentina = new ArrayList<String>();
		ArrayList<String> cBolivia = new ArrayList<String>();
		ArrayList<LugarDeInteres> ldiArgentina = new ArrayList<LugarDeInteres>();
		ArrayList<LugarDeInteres> ldiBolivia = new ArrayList<LugarDeInteres>();
		
		cArgentina.add("Toman mate");
		cArgentina.add("Bandera tiene celeste y blanco");
		cArgentina.add("A Megadeth le encanta");
		ldiBolivia.add(bancoBolivia);
		villano.agregarSeniaParticular("Chasquea los dedos frecuentemente");
		
		Pais argentina = new Pais("Argentina", cArgentina, ldiArgentina);
		Pais bolivia = new Pais("Bolivia", cBolivia, ldiBolivia);
		planEscapeVillano.add(bolivia);
		planEscapeVillano.add(argentina);
		villano.establecerPlanEscape(planEscapeVillano);
		
		ArrayList<String> pistas = bancoBolivia.buscarPistas();
		assertEquals(2, pistas.size());
	}
	
	/*@Test
	public void lanzaUnaExcepcionCuandoNoPaisParaDarPistas () throws PistasException {
		Villano villano = new Villano("Maria de los Campos Marquesíes", "Femenino");
		ArrayList<Pais> planEscapeVillano = new ArrayList<Pais>();
		Banco bancoBolivia = new Banco(villano);
		ArrayList<String> cBolivia = new ArrayList<String>();
		ArrayList<LugarDeInteres> ldiBolivia = new ArrayList<LugarDeInteres>();
		ldiBolivia.add(bancoBolivia);	
		
		Pais bolivia = new Pais("bolivia", cBolivia, ldiBolivia);
		planEscapeVillano.add(bolivia);
		villano.establecerPlanEscape(planEscapeVillano);
		
		assertThrows(PistasException.class, () -> {bancoBolivia.buscarPistas();});
	}*/
}
