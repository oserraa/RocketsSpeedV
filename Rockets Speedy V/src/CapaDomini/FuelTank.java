package CapaDomini;

public class FuelTank {


	public double currentFuel;
	
	public FuelTank(int fuel) {
		currentFuel=fuel;

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
}
