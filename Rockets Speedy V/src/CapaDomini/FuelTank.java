package CapaDomini;

public class FuelTank {

	public int currentFuel;
	public int maxFuel;
	
	public FuelTank(int maxFuel) {
		this.maxFuel=maxFuel;
		this.currentFuel=0;
	}

	public int getcurrentFuel() {
		return currentFuel;
	}
	public int getmaxFuel() {
		return maxFuel;
	}
	public void setcurrentFuel(int newfuel) {
		currentFuel=newfuel;
	}
	public void setmaxFuel(int maxcapacity) {
		currentFuel=maxcapacity;
	}
}
