package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

public class Biblioteca extends LugarDeInteres{
	double probabilidadPistaExtra = 0.50;
	
	@Override
	ArrayList<String> obtenerPistas(){
		ArrayList<String> pistas = new ArrayList<String>();
		Villano villano = this.pais.villanoQuePaso();
		double numeroAleatorio = Aleatorio.generarNumeroAleatorio();		
		Pais siguientePais = this.pais.villanoQuePaso.siguientePaisEnElPlan(this.pais);
		
		pistas.add(villano.obtenerSeniaParticularAleatoria());
		
		if(siguientePais != null) {
			pistas.add(siguientePais.obtenerCaracteristicaAleatoria());
		}
		
		if(numeroAleatorio <= probabilidadPistaExtra) {
			pistas.add(villano.obtenerHobbieAleatorio());
		}
		
		return pistas;
	}
}
