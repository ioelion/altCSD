package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

public class Villano {
	String nombre;
	String sexo;
	ArrayList<String> seniasParticulares;
	ArrayList<String> hobbies;
	ArrayList<Pais> planEscape;
	
	public Pais siguientePaisEnElPlan(Pais paisDeReferencia) {
		int indicePaisDeReferencia = planEscape.indexOf(paisDeReferencia);
		int indiceUltimoPais = planEscape.size()-1;
		Pais siguientePais = null;
		if (indicePaisDeReferencia != indiceUltimoPais) {
			siguientePais = planEscape.get(indicePaisDeReferencia+1);
		}
		return siguientePais;
	}

	public String obtenerSeniaParticularAleatoria() {
		int tamanioArraySeniasParticulares = seniasParticulares.size();
		return seniasParticulares.get(Aleatorio.generarEnteroDesde0Hasta(tamanioArraySeniasParticulares));
	}
	
	public String obtenerHobbieAleatorio() {
		int tamanioArrayHobbies = hobbies.size();
		return hobbies.get(Aleatorio.generarEnteroDesde0Hasta(tamanioArrayHobbies));
	}
}

