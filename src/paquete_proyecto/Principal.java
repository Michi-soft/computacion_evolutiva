package paquete_proyecto;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		// Variables del problema
		String ruta_distancias = "C:\\Users\\Usuario\\Desktop\\Introduccion a la computacion evolutiva\\instancias-TSP\\br17.atsp";
		
		Matriz_costos matriz = new Matriz_costos(ruta_distancias);
		
		TSP problema = new TSP (ruta_distancias);
		Camino mas_corto = problema.getCaminoMasCorto();
		
		
		System.out.print("El camino mas corto es: ");
		mas_corto.imprimir_camino();
		System.out.println();
		System.out.println("El costo es: " + mas_corto.getCosto());
		
		matriz.imprimirMatrizCostos();
		
	}

}
