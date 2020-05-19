package CapaDomini;

public class FuelTank {


	private double currentFuel;
	private double maxFuel;
	public FuelTank(int fuel) {
		currentFuel=fuel;
		this.maxFuel=fuel;
	}

	public double getcurrentFuel() {
		return currentFuel;
	}
	
	public void setcurrentFuel(double speed) {
		currentFuel=0.02*(speed*speed);
	}
	public void setmaxFuel(int maxcapacity) {
		currentFuel=maxcapacity;
	}

	public double getMaxFuel() {
		return maxFuel;
	}
}
