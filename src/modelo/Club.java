package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

public class Club extends LugarDeInteres{
	private double probabilidadPistaExtra = 0.70;
	
	public Club() {
		super();
	}
	
	public Club(Villano villano) {
		super(villano);
	}
	
	@Override
	ArrayList<String> obtenerPistas() {
		ArrayList<String> pistas = new ArrayList<String>();
		Villano villano = this.obtenerPais().villanoQuePaso();
		double numeroAleatorio = Aleatorio.generarNumeroAleatorio();
		
		pistas.add(villano.obtenerSeniaParticularAleatoria());
		if(numeroAleatorio <= probabilidadPistaExtra) {
			pistas.add(villano.obtenerHobbieAleatorio());
		}
		return pistas;
	}
	
}
