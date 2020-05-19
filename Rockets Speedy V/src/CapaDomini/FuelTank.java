package CapaDomini;

public class FuelTank {


	private int currentFuel;
	private int maxFuel;
	public FuelTank(int fuel) {
		this.currentFuel=fuel;
		this.maxFuel=fuel;
	}

	public int getCurrentFuel() {
		return currentFuel;
	}
	
	public void setCurrentFuel(double speed) {
		if((currentFuel-(int) Math.round(0.02*(speed*speed)))<=0) {
			currentFuel=0;
		}
		else {
		currentFuel=currentFuel-(int) Math.round(0.02*(speed*speed));
		}
	}
	public void setMaxFuel(int maxcapacity) {
		currentFuel=maxcapacity;
	}

	public int getMaxFuel() {
		return maxFuel;
	}
}
