package Domain;

public class Propeller {
	private int maxAcceleration;
	private int currentAcceleration;
	
	public Propeller(int maxAcceleration) {
		//validar dades
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
		if (number > maxAcceleration) {
			this.currentAcceleration = maxAcceleration;
		} else {
			this.currentAcceleration = number;
		}
	}
	
	public void brake() {
		this.currentAcceleration=0;
	}
	
	public void setMaxAcceleration() {
		currentAcceleration=maxAcceleration;
	}
}

