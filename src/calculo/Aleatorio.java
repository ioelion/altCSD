package calculo;

public class Aleatorio {

	public static int generarEnteroDesde0Hasta(int maximo) {
		
		return (int)(Math.random()*maximo);
	}
	
	public static double generarNumeroAleatorio() {
		return Math.random();
	}
}
