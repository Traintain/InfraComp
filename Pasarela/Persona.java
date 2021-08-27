import java.util.concurrent.ThreadLocalRandom;

public class Persona extends Thread{
	
	private boolean haciaDerecha;
	private Pasarela pasarela;
	
	public Persona(Pasarela p){
		pasarela=p;
		haciaDerecha = (ThreadLocalRandom.current().nextInt(2) == 0);
	}
	
	public boolean getHaciaDerecha(){
		return haciaDerecha;
	}
	
	public void run(){
		pasarela.entrar(haciaDerecha);
		if(haciaDerecha==true){
			System.out.println("Entro una persona hacia la derecha");
		}else{
			System.out.println("Entro una persona hacia la izquierda");
		}
		
		pasarela.caminar();
		
		pasarela.salir();
		if(haciaDerecha==true){
			System.out.println("Salió una persona hacia la derecha");
		}else{
			System.out.println("Salió una persona hacia la izquierda");
		}
	}
}
