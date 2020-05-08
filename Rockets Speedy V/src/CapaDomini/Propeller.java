
package CapaDomini;


public class Propeller {
	private int maxAcceleration;
	private int currentAcceleration;
	
	public Propeller(int maxAcceleration) {
		this.maxAcceleration=maxAcceleration;
		this.currentAcceleration=0;
	}
	
	public int getMaxAcceleration() {
		return this.maxAcceleration;
	}
	
	
	public int getCurrentAcceleration() {
		return this.currentAcceleration;
	}
	
	public void accelerate(int number) {
		//MIRAR COMO ACELERAR
	}
	
	public void brake() {
		this.currentAcceleration=0;
	}
	
	public void keepAcceleration() {
	}
}

