package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

@SuppressWarnings("unused")

public class Villano {
	
	private String nombre;
	private String sexo;
	private boolean arrestado;
	private ArrayList<String> seniasParticulares;
	private ArrayList<String> hobbies;
	private ArrayList<Pais> planEscape;
	
	public Villano(String nombreVillano, String sexoVillano) {
		nombre = nombreVillano;
		sexo = sexoVillano;
		seniasParticulares = new ArrayList<String>();
		hobbies = new ArrayList<String>();
	}
	
	public void agregarSeniaParticular(String seniaParticular) {
		seniasParticulares.add(seniaParticular);
	}
	
	public void agregarHobbie(String hobbie) {
		hobbies.add(hobbie);
	}
	
	public void establecerPlanEscape(ArrayList<Pais> planEscapeVillano) {
		planEscape = planEscapeVillano;
		for(int i = 0; i < planEscape.size(); i++){
			planEscape.get(i).establecerVillanoQuePaso(this);
		}
	}
	
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

	public void serArrestado() {
		arrestado = true;
	}
	
	public boolean estaArrestado() {
		return arrestado;
	}
}

