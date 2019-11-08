package modelo;

import java.util.ArrayList;
import calculo.Aleatorio;
import excepciones.NoHayPistasException;

public class Embajada extends LugarDeInteres{
	
	@Override ArrayList<String> obtenerPistas() throws NoHayPistasException{
		ArrayList<String> pistas = new ArrayList<String>();
		Pais siguientePais = pais.villanoQuePaso.siguientePaisEnElPlan(this.pais);
		if(siguientePais != null) {
			int tamanioArrayCaracteristicas = pais.caracteristicas.size();
			pistas.add(pais.caracteristicas.get(Aleatorio.generarNumeroDesde0Hasta(tamanioArrayCaracteristicas)));
			pistas.add(pais.caracteristicas.get(Aleatorio.generarNumeroDesde0Hasta(tamanioArrayCaracteristicas)));
		}
		else {
			throw new NoHayPistasException("No hay pistas");
		}
		return pistas;
	}
}
