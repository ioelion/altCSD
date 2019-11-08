package modelo;

import java.util.ArrayList;

public class Pais {
	String nombre;
	Villano villanoQuePaso;
	ArrayList<String> caracteristicas;
	ArrayList<LugarDeInteres> lugaresDeInteres;
	ArrayList<Pais> conexionesAereas;
	
	public boolean estaConectadoCon(Pais pais) {
		return this.conexionesAereas.contains(pais) && pais.conexionesAereas.contains(this);
	}
	
	public void conectarCon(Pais pais) {
		this.conexionesAereas.add(pais);
		pais.conexionesAereas.add(pais);
	}
	
	public boolean estuvoElVillano() {
		return villanoQuePaso != null;
	}
	
	public Villano villanoQuePaso() {
		return villanoQuePaso;
	}
}
