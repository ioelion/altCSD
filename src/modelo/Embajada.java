package modelo;

import java.util.ArrayList;
import excepciones.NoHayPistasException;

public class Embajada extends LugarDeInteres{
	
	@Override ArrayList<String> obtenerPistas() throws NoHayPistasException{
		ArrayList<String> pistas = null;
		Pais siguientePais = this.pais.villanoQuePaso.siguientePaisEnElPlan(this.pais);
		if(siguientePais != null) {
			pistas =  new ArrayList<String>();
			pistas.add(pais.obtenerCaracteristicaAleatoria());
			pistas.add(pais.obtenerCaracteristicaAleatoria());
		}
		else {
			throw new NoHayPistasException("No hay pistas");
		}
		return pistas;
	}
}
