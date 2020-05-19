package CapaDomini;

public class FuelTank {


	private int currentFuel;
	private int maxFuel;
	public FuelTank(int fuel) {
		currentFuel=fuel;
		this.maxFuel=fuel;
	}

	public int getCurrentFuel() {
		return currentFuel;
	}
	
	public void setCurrentFuel(double speed) {
		currentFuel=(int) Math.round(0.02*(speed*speed));
	}
	public void setMaxFuel(int maxcapacity) {
		currentFuel=maxcapacity;
	}

	public int getMaxFuel() {
		return maxFuel;
	}
}
