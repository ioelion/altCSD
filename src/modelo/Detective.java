package modelo;

import java.util.ArrayList;

import excepciones.CondicionFinJuegoException;
import excepciones.OrdenDeArrestoException;
import excepciones.PistasException;
import excepciones.VisitarException;

@SuppressWarnings("unused")

public class Detective {
	private String nombre;
	private Caso casoAsignado;
	private Pais paisActual;
	private LugarDeInteres lugarDeInteresActual;
	private ArrayList<String> pistasVillano;
	private Villano villanoPorArrestar;
	private boolean ordenArrestoSolicitada;
	
	public Detective(String nombre, Caso caso) {
		this.nombre = nombre;
		casoAsignado = caso;
		paisActual = caso.obtenerPaisDondeOcurrio();
		ordenArrestoSolicitada = false;
	}
	
	public void visitarPais(Pais paisAVisitar) throws VisitarException{
		if(paisActual.estaConectadoCon(paisAVisitar)) {
			paisActual = paisAVisitar;
			lugarDeInteresActual = null;
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
		if(!ordenArrestoSolicitada) {
			this.villanoPorArrestar = villano;
			ordenArrestoSolicitada = true;
		}
		else {
			throw new OrdenDeArrestoException("Ya se solicitó una orden de arresto.");
		}
	}
	
	public void utilizarOrdenDeArresto() throws OrdenDeArrestoException, CondicionFinJuegoException {
		if(ordenArrestoSolicitada) {
			if(lugarDeInteresActual.estaElVillano(villanoPorArrestar)) {
				villanoPorArrestar.serArrestado();
				casoAsignado.cerrar();
			}
			else {
				throw new OrdenDeArrestoException("El villano no se encuentra en el lugar.");
			}
		}
		else {
			throw new OrdenDeArrestoException("No se solicitó una orden de arresto.");
		}
	}

}
