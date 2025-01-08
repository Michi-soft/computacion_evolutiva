package paquete_proyecto;

import java.io.IOException;
import java.util.Vector;

public class TSP {	
	private Matriz_costos matriz;
	private String ruta_archivo_distancias;
	private double prob_cruce;
	private double prob_mutacion;
	private int cant_ciudades; 
	private int tam_poblacion;
	private int cant_iteraciones;
	
	
	public TSP(String ruta, int tam_poblacion, int cant_iteraciones) throws IOException {
		// Extraigo la matriz de distancias del documento
		ruta_archivo_distancias = ruta;
		this.matriz = new Matriz_costos (this.ruta_archivo_distancias);
		
		// Inicializo un vector de caminos con el tamaño de poblacion pasada como parametro
		this.tam_poblacion = tam_poblacion;
		
		
		this.cant_iteraciones = cant_iteraciones;
		for (int i=0; i<this.cant_iteraciones; i++) {
			// Select parents
			
			// Recombine pairs of parents
			
			// Mutate the resulting offspring
			
			// Evaluate new candidates
			
			// Select individuals for the next generation
			
		}
		
	}
	
	public void algoritmoGenetico () {
		
	}
	
	
	Camino getCaminoMasCorto() {
		return new Camino(this.matriz);
	}
	

}
