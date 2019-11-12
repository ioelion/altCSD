package modelo;

import java.util.ArrayList;

import excepciones.OrdenDeArrestoException;
import excepciones.PistasException;
import excepciones.VisitarException;

public class Detective {
	String nombre;
	ArrayList<String> pistasVillano;
	Pais paisActual;
	LugarDeInteres lugarDeInteresActual;
	Villano villanoPorArrestar;
	
	public Detective(String nombre, Pais paisInicio) {
		this.nombre = nombre;
		this.paisActual = paisInicio;
	}
	
	public void visitarPais(Pais paisAVisitar) throws VisitarException{
		if(paisActual.estaConectadoCon(paisAVisitar)) {
			paisActual = paisAVisitar;
		}
		else {
			throw new VisitarException("No se puede llegar desde donde estoy.");
		}
	}
	
	public void visitarLugarDeInteres(LugarDeInteres lugarDeInteres) {
		this.lugarDeInteresActual = lugarDeInteres;
	}
	
	public void buscar() throws PistasException {
		pistasVillano.addAll(lugarDeInteresActual.buscarPistas());
	}
	
	public void pedirOrdenDeArresto(Villano villano) throws OrdenDeArrestoException {
		if(villanoPorArrestar == null) {
			this.villanoPorArrestar = villano;
		}
		else {
			throw new OrdenDeArrestoException("Ya se pidio una orden de arresto.");
		}
	}
}
