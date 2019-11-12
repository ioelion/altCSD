package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;
import excepciones.PistasException;

public class Banco extends LugarDeInteres{
	
	@Override
	ArrayList<String> obtenerPistas(){
		ArrayList<String> pistas = new ArrayList<String>();
		Pais siguientePais = this.pais.villanoQuePaso.siguientePaisEnElPlan(this.pais);
		if(siguientePais != null) {
			pistas.add(siguientePais.obtenerCaracteristicaAleatoria());
		}
		pistas.add(pais.villanoQuePaso.obtenerSeniaParticularAleatoria());
		return pistas;
	}
	
}
