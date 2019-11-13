package modelo;

import java.util.ArrayList;

import excepciones.PistasException;

public abstract class LugarDeInteres {
	private Pais pais;
	private boolean yaFueInvestigado;
	private ArrayList<Villano> villanosDentro;

	public LugarDeInteres() {
		yaFueInvestigado = false;
	}
	
	public LugarDeInteres(Villano villano) {
		yaFueInvestigado = false;
		villanosDentro = new ArrayList<Villano>();
		villanosDentro.add(villano);
	}
	
	public void establecerPais(Pais pais) { this.pais = pais; }
	
	public Pais obtenerPais() { return pais; }
	
	abstract ArrayList<String> obtenerPistas() throws PistasException;
	
	public ArrayList<String> buscarPistas() throws PistasException{
		ArrayList<String> pistas = null;
		if (!yaFueInvestigado && pais.estuvoElVillano()) {
			pistas = obtenerPistas();
			yaFueInvestigado = true;
		} 
		else {
			throw new PistasException("No se encontraron pistas"); 
		}
		return pistas;
	}
	
	public boolean estaElVillano(Villano villano) { return villanosDentro.contains(villano); }
}
