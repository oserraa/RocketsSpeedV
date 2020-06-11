package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Domain.*;

public class Controller {
	
	Circuit circuit;
	
	public String play() {
		Random num = new Random();
		int numCircuit = num.nextInt(4);
		System.out.println(numCircuit);
		this.circuit = CircuitFactory.getCircuit(numCircuit);
		String start = "Randomly chosen circuit: " + this.circuit.getName() + "\n"
				+ "Starting competition. Circuit length: " + this.circuit.getMeters() + " Max Time: "
				+ this.circuit.getTime();
		return start;
	}
	
	public void competitionInProgress() {
		//Thread.sleep(1000);
		circuit.competitionProgress();
	}
	
	/*public String competitionInProgress() {
		String sentence="";
		while(!circuit.competitionEnds()) {
			circuit.competitionProgress();
			sentence=circuit.rocketsInformation();
		}
		return sentence;
	}*/
	
	
	

}
