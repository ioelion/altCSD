package modelo;

import excepciones.CondicionFinJuegoException;

@SuppressWarnings("unused")

public class Caso {
	private Detective detectiveAsignado;
	private Villano villanoResponsable;
	private String objetoRobado;
	private Pais paisDondeOcurrio;
	
	public Pais obtenerPaisDondeOcurrio() {
		return paisDondeOcurrio;
	}
	
	public Caso(Detective detective, Villano villano, String objeto, Pais pais) {
		detectiveAsignado = detective;
		villanoResponsable = villano;
		objetoRobado = objeto;
		paisDondeOcurrio = pais;
	}
	
	public void cerrar() throws CondicionFinJuegoException {
		if(villanoResponsable.estaArrestado()) {
			throw new CondicionFinJuegoException("El villano está tras las rejas, ¡Felicitaciones!");
		}
		else {
			throw new CondicionFinJuegoException("¡Atrapaste al villano equivocado! ¡Suerte la próxima vez!");
		}
	}
}
