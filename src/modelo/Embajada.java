package modelo;

import java.util.ArrayList;
import excepciones.PistasException;

public class Embajada extends LugarDeInteres{
	
	public Embajada() {
		super();
	}
	
	public Embajada(Villano villano) {
		super(villano);
	}
	
	@Override ArrayList<String> obtenerPistas() throws PistasException{
		ArrayList<String> pistas = null;
		Pais paisActual = this.obtenerPais();
		Pais siguientePais = paisActual.obtenerVillanoQuePaso().siguientePaisEnElPlan(paisActual);
		if(siguientePais != null) {
			pistas =  new ArrayList<String>();
			pistas.add(siguientePais.obtenerCaracteristicaAleatoria());
			pistas.add(siguientePais.obtenerCaracteristicaAleatoria());
		}
		else {
			throw new PistasException("No hay pistas");
		}
		return pistas;
	}
}
