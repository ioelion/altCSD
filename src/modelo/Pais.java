package modelo;

import java.util.ArrayList;

import calculo.Aleatorio;

@SuppressWarnings("unused")

public class Pais {
	private String nombre;
	private ArrayList<String> caracteristicas;
	private ArrayList<LugarDeInteres> lugaresDeInteres;
	private ArrayList<Pais> conexionesAereas;
	private Villano villanoQuePaso;
	
	public Pais(String nombrePais, ArrayList<String> caracteristicasPais, ArrayList<LugarDeInteres> lugaresDeInteresPais) {
		nombre = nombrePais;
		caracteristicas = caracteristicasPais;
		lugaresDeInteres = lugaresDeInteresPais;
		for(int nroLDI = 0; nroLDI < lugaresDeInteres.size(); nroLDI++) {
			lugaresDeInteres.get(nroLDI).establecerPais(this);
		}
	}
	
	public Villano obtenerVillanoQuePaso() {
		return villanoQuePaso;
	}


	public void establecerVillanoQuePaso(Villano villanoQuePaso) {
		this.villanoQuePaso = villanoQuePaso;
	}

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
	
	public String obtenerCaracteristicaAleatoria() {
		int tamanioArrayCaracteristicas = caracteristicas.size();
		return caracteristicas.get(Aleatorio.generarEnteroDesde0Hasta(tamanioArrayCaracteristicas));
	}
}
