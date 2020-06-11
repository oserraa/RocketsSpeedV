package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Domain.*;

public class Controller {
	
	Circuit circuit;
	
	public String play() {
		Random num = new Random();
		int numCircuit = num.nextInt(4) + 1;
		this.circuit = CircuitFactory.getCircuit(numCircuit);
		String start = "Randomly chosen circuit: " + this.circuit.getName() + "\n"
				+ "Starting competition. Circuit length: " + this.circuit.getMeters() + " Max Time: "
				+ this.circuit.getTime();
		return start;
	}
	
	public String CompetitionInProgress() {
		return null;
		//Thread.sleep(1000);
	}
	
	
	

}
