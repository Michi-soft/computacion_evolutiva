package paquete_proyecto;

public class NumeroRandom {
	
	public static double randomDouble() {
		return Math.random();
	}
	
	public static int randomInt(int limite_superior) {
		return (int) (Math.random()*limite_superior);
	}
}
