package modelo;

import java.util.ArrayList;

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
		//no le pongo un throw porque al hacerlo se revela informacion sobre el juego (deberia ser FinDelPlanException("Fin del Plan");
		return siguientePais;
	}

	
	
}

