package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Domain.*;

public class Controller {
	
	Circuit circuit;
	Record record;
	
	public String play() {
		Random num = new Random();
		int numCircuit = num.nextInt(4);
		System.out.println("Preparing rockets for circuit... ");
		this.circuit = CircuitFactory.getCircuit(numCircuit);
		String start = "Randomly chosen circuit: " + this.circuit.getName() + "\n"
				+ "Starting competition. Circuit length: " + this.circuit.getMeters() + " Max Time: "
				+ this.circuit.getTime();
		return start;
	}
	
	public String competitionInProgress() throws InterruptedException {
		String solution="";
		while (!circuit.competitionEnds()) {
			solution+=circuit.competitionProgress();
			solution+="\n";
			//Thread.sleep(1000);
		}
		solution+=circuit.endSentence();
		return solution;
	}
	public void registerRecord() {
		if(circuit.getWinner()!=null) {
			this.record=new Record(circuit.getWinner().getName(),circuit.getTimeWinner(),circuit.getName());
		}
	}
	
	public String getCircuitName() {return circuit.getName();}
	public int getTimeWinner() {return circuit.getTimeWinner();}
	public String getNameWinner() {return circuit.getWinner().getName();}
	

}
