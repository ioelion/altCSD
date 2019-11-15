package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

public class Biblioteca extends LugarDeInteres{
	private double probabilidadPistaExtra = 0.50;
	
	public Biblioteca() {
		super();
	}
	
	public Biblioteca(Villano villano) {
		super(villano);
	}

	@Override
	ArrayList<String> obtenerPistas(){
		ArrayList<String> pistas = new ArrayList<String>();
		Pais paisActual = this.obtenerPais();
		Pais siguientePais = paisActual.obtenerVillanoQuePaso().siguientePaisEnElPlan(paisActual);
		double numeroAleatorio = Aleatorio.generarNumeroAleatorio();
		Villano villano = paisActual.obtenerVillanoQuePaso();
		pistas.add(villano.obtenerSeniaParticularAleatoria());
		if(siguientePais != null) { pistas.add(siguientePais.obtenerCaracteristicaAleatoria()); }
		if(numeroAleatorio <= probabilidadPistaExtra) { pistas.add(villano.obtenerHobbieAleatorio()); }
		return pistas;
	}
}
