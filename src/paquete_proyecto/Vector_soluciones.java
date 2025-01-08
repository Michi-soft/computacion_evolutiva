package paquete_proyecto;

import java.util.Vector;

public class Vector_soluciones {
	private Vector<Camino> soluciones;
	private int total_soluciones;
	
	public Vector_soluciones (int total_soluciones, Matriz_costos matriz) {
		this.total_soluciones = total_soluciones;
		for (int i=0; i<this.total_soluciones; i++) {
			Camino aux = new Camino(matriz);
			soluciones.add(aux);
		}		
	}
	
	// SELECCION DE PADRES
	
	// RULETA
	private Camino seleccion_padre_ruleta() {
		
	}
	
	
	// TORNEO
	private Camino seleccion_padre_torneo () {
		Camino c1 = soluciones.elementAt(NumeroRandom.randomInt(this.total_soluciones-1));
		Camino c2 = soluciones.elementAt(NumeroRandom.randomInt(this.total_soluciones-1));
		if (c1.getCosto() > c2.getCosto())
			return c1;
		else
			return c2;
	}
	
}
