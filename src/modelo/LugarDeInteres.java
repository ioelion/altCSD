package modelo;

import java.util.ArrayList;

import excepciones.PistasException;

public abstract class LugarDeInteres {
	Pais pais;
	boolean yaFueInvestigado;
	ArrayList<Villano> villanosDentro;
	
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
	
	abstract ArrayList<String> obtenerPistas() throws PistasException;

	public boolean estaElVillano(Villano villano) {
		return villanosDentro.contains(villano);
	}
}
