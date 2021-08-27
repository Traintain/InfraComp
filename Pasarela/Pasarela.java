
public class Pasarela {
	private int numPersonas;
	private boolean haciaDerecha;
	
	public Pasarela(){
		numPersonas=0;
	}
	
	public synchronized void entrar(boolean p){
		if(haciaDerecha!=p){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(numPersonas==0){
			haciaDerecha=p;
		}
		numPersonas++;
	}
	
	public void caminar(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salir(){
		synchronized (this) {
			numPersonas--;
			if(numPersonas==0){
				notifyAll();
			}
		System.out.println("Hay "+numPersonas+" personas en la pasarela");
		}
	}
}
