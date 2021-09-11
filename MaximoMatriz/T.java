import java.util.concurrent.ThreadLocalRandom;

public class T extends Thread{
	private static Maximo aMax;
	private static int[][] matriz;
	private int fila;
	
	public T(int nFila) {
		fila=nFila;
	}
	
	public void run() {
		boolean print=false;
		for (int i=0; i<matriz[fila].length;i++) {
			print=aMax.anotar(matriz[fila][i]);
		}
		if(print) {
			System.out.println ("Max: " + aMax.darMaximo()) ;
		}
	}
	
	public static void main(String[] args) {
		int n=10;
		int m=20;
		matriz=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matriz[i][j]=ThreadLocalRandom.current().nextInt(0, 10);
			}
		}
		matriz[n-1][m-1]=20;
		String a="";
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a=a.concat(matriz[i][j]+" ");
			}
			a=a.concat("\n");
		}
		System.out.print(a) ;
		aMax= new Maximo(n,m);
		for(int i=0;i<n;i++) {
			new T(i).start();
		}
		
	}
	
}
