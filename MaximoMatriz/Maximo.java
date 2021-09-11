public class Maximo {

	private int maximo;
	private int numFilas;
	private int numColumnas;
	int actual;
	
	public Maximo(int filas, int columnas) {
		maximo=0;
		numFilas=filas;
		numColumnas=columnas;
		actual=0;
	}
	
	public synchronized boolean anotar (int n) {
		if(n>maximo)
			maximo=n;
		actual++;
		return (actual == numFilas*numColumnas) ? true:false;
		
	}
	
	public synchronized int darMaximo() {
		return maximo;
	}
	
}
