package singletonPattern;

public class Singleton {
	
	private Singleton() {
		System.out.println("Singleton is create");
	}
	
	private static Singleton instance = null;
	
	public Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public void singletonOperation(){
		System.out.println("singletonOperation");
	}

}
