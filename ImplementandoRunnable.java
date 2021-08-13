import java.util.Scanner;

public class ImplementandoRunnable implements Runnable {
	private static int tope;
	private int inicio;
	private int fin;
	private int millis=1000;
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el tope que desea (debe ser mayor o igual a 1)");
		try{
			tope=scan.nextInt();
			Thread threadImpar = new Thread(new ImplementandoRunnable(1, tope));
			Thread threadPar = new Thread(new ImplementandoRunnable(2, tope));
			
			threadImpar.start();
			threadPar.start();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ImplementandoRunnable(int inicio, int fin){
		this.inicio=inicio;
		this.fin=fin;
	}
	
	public void run(){
		for(int i=inicio;i<=fin;i=i+2){
			System.out.println(i);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
