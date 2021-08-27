import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int totalPersonas;
	private static Persona[] p;
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el número de personas que quiere que intenten cruzar");
		
		totalPersonas=scan.nextInt();
		Pasarela pasarela=new Pasarela();
		p=new Persona[totalPersonas];
		for(int i =0; i<totalPersonas;i++){
			p[i]=new Persona(pasarela);
			p[i].start();
		}
		
		for(int i =0; i<totalPersonas;i++){
			try {
				p[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Terminarn de cruzar todos");
	}
}
