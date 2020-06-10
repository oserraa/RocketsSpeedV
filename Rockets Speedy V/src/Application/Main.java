package Application;
import java.util.*;

import Domain.*;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> propellers= new ArrayList<Integer>();
		propellers.add(10);
		propellers.add(30);
		propellers.add(50);
		propellers.add(82);
		Rocket rocket= new Rocket("Speedy V",propellers,4200);
		List<Rocket> rockets= new ArrayList<Rocket>();
		rockets.add(rocket);
		Circuit circuit= new Circuit("SeaFly",1700,28,rockets);
		
		System.out.println(circuit.startCompetition());

	}

}
