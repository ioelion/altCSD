package modelo;

import excepciones.CondicionFinJuegoException;

public class Caso {
	Detective detective;
	Villano villanoResponsable;
	String objetoRobado;
	Pais paisDondeOcurrio;
	
	
	public void cerrar() throws CondicionFinJuegoException {
		if(villanoResponsable.arrestado) {
			throw new CondicionFinJuegoException("El villano est� tras las rejas, �Felicitaciones!");
		}
		else {
			throw new CondicionFinJuegoException("�Atrapaste al villano equivocado! �Suerte la pr�xima vez!");
		}
	}
}
