package modelo;

import java.util.ArrayList;

import excepciones.NoHayPistasException;

public abstract class LugarDeInteres {
	Pais pais;
	boolean yaFueVisitado;
	boolean estaElVillano;
	
	public ArrayList<String> buscarPistas() throws NoHayPistasException{
		ArrayList<String> pistas = null;
		if (!yaFueVisitado && pais.estuvoElVillano()) {
			pistas = obtenerPistas();
			yaFueVisitado = true;
		} 
		else {
			throw new NoHayPistasException("No se encontraron pistas"); 
		}
		return pistas;
	}
	
	abstract ArrayList<String> obtenerPistas() throws NoHayPistasException;
}
