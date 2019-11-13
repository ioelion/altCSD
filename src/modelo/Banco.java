package modelo;

import java.util.ArrayList;

public class Banco extends LugarDeInteres{
	
	public Banco() {
		super();
	}
	
	public Banco(Villano villano) {
		super(villano);
	}

	@Override
	ArrayList<String> obtenerPistas(){
		ArrayList<String> pistas = new ArrayList<String>();
		Pais paisActual = this.obtenerPais();
		Pais siguientePais = paisActual.obtenerVillanoQuePaso().siguientePaisEnElPlan(paisActual);
		if(siguientePais != null) {
			pistas.add(siguientePais.obtenerCaracteristicaAleatoria());
		}
		pistas.add(siguientePais.obtenerVillanoQuePaso().obtenerSeniaParticularAleatoria());
		return pistas;
	}
}
