package paquete_proyecto;

import java.util.Collections;
import java.util.Vector;

public class Camino implements Comparable<Camino>{
	private Vector<Integer> ciudades;
	private int numero_ciudades;
	private double costo;
	
	public Camino(Matriz_costos matriz) {
		// Creo el camino que incluya tantas ciudades como la dimension de la matriz de costos
		this.numero_ciudades = matriz.getDimension();
		ciudades = new Vector<Integer>();
		for (int i=0;i<this.numero_ciudades;i++)
    		ciudades.add(i);
    	
		// Permuto las ciudades
		Collections.shuffle(ciudades);
		
		// Calculo el costo del camino
		costo = this.calcularCosto(matriz);
	}
	
	public Camino (Vector<Integer> ciudades, int numero_ciudades, double costo) {
		this.ciudades = ciudades;
		this.numero_ciudades = numero_ciudades;
		this.costo = costo;
	}
	
	public void imprimir_camino() {
		System.out.println();
		System.out.print("< ");
		for (int i=0;i<this.ciudades.size();i++) {
			System.out.print(this.ciudades.elementAt(i));
			if (i != this.ciudades.size()-1)
				System.out.print(" - ");
		}
		System.out.print(" >");
	}
	
	private double calcularCosto(Matriz_costos matriz) {
		double costo = 0;
		for (int i=0; i<3; i++) 
			costo += matriz.getCostoCamino(this.ciudades.elementAt(i).intValue(), this.ciudades.elementAt(i+1).intValue());
		
		// Sumo el costo desde la ultima ciudad a la primera
		costo += matriz.getCostoCamino(this.ciudades.elementAt(ciudades.size()-1).intValue(), this.ciudades.elementAt(0).intValue());
		
		return 1/costo;
	}
	
	private Vector<Integer> getVectorCiudades() {
		return (Vector<Integer>) this.ciudades.clone();
	}
	
	private int getNumeroCiudades() {
		return this.numero_ciudades;
	}
	
	private double getCosto() {
		return this.costo;
	}
	
	private Camino clonarCamino() {
		return new Camino(this.getVectorCiudades(), this.getNumeroCiudades(), this.getCosto());
	}
	
	// MUTACION
	
	// INVERSION
	public void mutacionInversion() {
		int i = NumeroRandom.randomInt(this.numero_ciudades);
		int j = NumeroRandom.randomInt(this.numero_ciudades);
		if (j<i) {
			int temp = j;
			j = i;
			i = temp;
		}
		while (i<j) {
			Integer temporal = ciudades.elementAt(i);
			ciudades.setElementAt(ciudades.elementAt(j), i);
			ciudades.setElementAt(temporal, j);
			i++;
			j--;
		}		
	}
	
	// INSERCION
	public void mutacionInsercion() {
		int i = NumeroRandom.randomInt(this.numero_ciudades);
		int j = NumeroRandom.randomInt(this.numero_ciudades);
		if (j<i) {
			int temp = j;
			j = i;
			i = temp;
		}
		Integer elemento = ciudades.elementAt(j);
		ciudades.removeElementAt(j);
		ciudades.insertElementAt(elemento, i+1);
	}
	

	@Override
	public int compareTo(Camino o) {
		if (this.getCosto()-o.getCosto()>0)
			return 1;
		else
			return -1;	  
	}
}
