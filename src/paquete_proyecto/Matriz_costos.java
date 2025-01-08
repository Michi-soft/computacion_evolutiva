package paquete_proyecto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Matriz_costos {
	private String ruta_archivo;
	private List<String> contenido;
	private int dimension;
	int[][] matriz_costos;
	
	
	public Matriz_costos (String path) throws IOException {
		this.ruta_archivo = path;
		contenido = Files.readAllLines(Paths.get(this.ruta_archivo));
		dimension = this.get_dimension();
		matriz_costos = this.getMatriz();
	}
	
	private int get_dimension () {
		boolean encontrado = false;
		int pos=0;
		for (int i=0; i<contenido.size()&&!encontrado;i++) {
			String aux = contenido.get(i);
			if (aux.toLowerCase().contains("dimension")) {
				encontrado = true;
				pos = i;
			}
		}
		String[] cadena_aux = contenido.get(pos).split(" ");
		return Integer.parseInt(cadena_aux[2]);
	}
	
	private int[][] getMatriz() {
		// Creo la matriz auxiliar
		int[][] matriz_costos = new int[this.dimension][this.dimension];
		
		// Busco la linea del archivo donde comienzan las distancias
		boolean encontrado = false;
		int pos = 0;
		String cadena_aux;
		for (int i=0; i<contenido.size()&&!encontrado; i++) {
			cadena_aux = contenido.get(i);
			if(cadena_aux.toLowerCase().contains("edge_weight_section")) {
				encontrado = true;
				pos = i;
			}
		}
		// Las distancias comienzan despues de la linea de texto "EDGE_WEIGHT_SECTION"
		pos++;	
		for (int j=0; j<this.dimension; j++) {
			String[] lineas = contenido.get(pos).split(" +"); 
		
			int z=1;
			for (int k=0; k<this.dimension; k++) {
				matriz_costos[j][k] = Integer.parseInt(lineas[z]);
				
				z++;
			}
			pos++;
			
			
		}
		return matriz_costos;
	}
	
	
	public int getDimension() {
		return this.dimension;
	}
	
	public void imprimirMatrizCostos() {
		for (int i=0; i<this.dimension; i++) {
			for(int j=0; j<this.dimension; j++)
				System.out.print(this.matriz_costos[i][j] + "  ");
			System.out.println();
		}
	}
	
	public int getCostoCamino (int i, int j) {
		return this.matriz_costos[i][j];
	}
	
}
