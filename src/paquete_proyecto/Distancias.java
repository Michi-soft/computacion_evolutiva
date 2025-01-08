package paquete_proyecto;

public class Distancias {
	private int [][] distancia;
	private int dimension;
	
	public Distancias (int dimension) {
		this.dimension=dimension;
		distancia = new int[dimension][dimension];
		int k=1;
		for (int i=0;i<dimension;i++)
			for (int j=0; j<dimension; j++) {
				distancia[i][j]=k;
				k++;
			}
	}
	
	public void imprimirDistancias() {
		System.out.println();
		for(int i=0; i<this.dimension; i++) {
			for (int j=0; j<this.dimension; j++)
				System.out.print(this.distancia[i][j] + "  ");
			System.out.println();
		}
	}
}
