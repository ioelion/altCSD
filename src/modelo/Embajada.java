package modelo;

import java.util.ArrayList;
import excepciones.PistasException;

public class Embajada extends LugarDeInteres{
	
	@Override ArrayList<String> obtenerPistas() throws PistasException{
		ArrayList<String> pistas = null;
		Pais siguientePais = this.pais.villanoQuePaso.siguientePaisEnElPlan(this.pais);
		if(siguientePais != null) {
			pistas =  new ArrayList<String>();
			pistas.add(pais.obtenerCaracteristicaAleatoria());
			pistas.add(pais.obtenerCaracteristicaAleatoria());
		}
		else {
			throw new PistasException("No hay pistas");
		}
		return pistas;
	}
}
