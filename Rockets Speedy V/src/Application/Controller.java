package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Domain.*;

public class Controller {
	
	Circuit circuit;
	
	public String play() {
		Random num= new Random();
		int numCircuit= num.nextInt(4)+1;
		this.circuit=CircuitFactory.getCircuit(numCircuit);
		System.out.println("Randomly chosen circuit: "+this.circuit.getName());
		System.out.println("Starting competition. Circuit length: "+this.meters+" Max Time: "+this.maxTime);
	}
	
	public void addCircuit(String name,int meters, int maxTime,List<Rocket>rockets) {
		circuit.addRocket(rocket);
	}
	
	public void addRocket(Rocket rocket) {
		circuit.addRocket(rocket);
	}

}
