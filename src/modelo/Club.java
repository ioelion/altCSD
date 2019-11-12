package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

public class Club extends LugarDeInteres{
	double probabilidadPistaExtra = 0.70;
	
	@Override
	ArrayList<String> obtenerPistas() {
		ArrayList<String> pistas = new ArrayList<String>();
		Villano villano = this.pais.villanoQuePaso();
		double numeroAleatorio = Aleatorio.generarNumeroAleatorio();
		
		pistas.add(villano.obtenerSeniaParticularAleatoria());
		if(numeroAleatorio <= probabilidadPistaExtra) {
			pistas.add(villano.obtenerHobbieAleatorio());
		}
		return pistas;
	}
	
}
