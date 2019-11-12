package modelo;

import java.util.ArrayList;

import excepciones.PistasException;

public abstract class LugarDeInteres {
	Pais pais;
	boolean yaFueVisitado;
	boolean estaElVillano;
	
	public ArrayList<String> buscarPistas() throws PistasException{
		ArrayList<String> pistas = null;
		if (!yaFueVisitado && pais.estuvoElVillano()) {
			pistas = obtenerPistas();
			yaFueVisitado = true;
		} 
		else {
			throw new PistasException("No se encontraron pistas"); 
		}
		return pistas;
	}
	
	abstract ArrayList<String> obtenerPistas() throws PistasException;
}
