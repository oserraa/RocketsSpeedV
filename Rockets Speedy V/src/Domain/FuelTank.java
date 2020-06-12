package Domain;

public class FuelTank {
	private int currentFuel;
	private int maxFuel;

	public FuelTank(int fuel) {
		// validar dades
		this.currentFuel = fuel;
		this.maxFuel = fuel;
	}

	public int getCurrentFuel() {
		return currentFuel;
	}

	public void updateFuel(double speed) {
		
		if ((currentFuel -  (0.02 * (speed * speed))) <= 0 || currentFuel -  (0.02 * (speed * speed)) <= 0.99) {
			currentFuel = 0;
		} else {
			currentFuel = currentFuel - ((int) (0.02 * (speed * speed)));
		}
	}

	public void setMaxFuel(int maxcapacity) {
		currentFuel = maxcapacity;
	}

	public int getMaxFuel() {
		return maxFuel;
	}

	public void setCurrentFuel(int fuel) {
		this.currentFuel = fuel;
	}
}
