package Application;
import java.util.ArrayList;
import java.util.List;

import Domain.Circuit;
import Domain.Rocket;

public class CircuitDTO {
	
	private String name;
	private int meters;
	private int maxTime;
	private int currentTime;
	private List<Rocket> rockets= new ArrayList<Rocket>();
	private Rocket winner;
	
	public CircuitDTO(Circuit circuit) {
		//validar dades
		this.name=circuit.getName();
		this.meters=circuit.getMeters();
		this.maxTime=circuit.getTime();
		this.rockets=circuit.getRockets();
		this.currentTime=0;
	}
	
	public String getName() {
		return name;
	}
	public int getMeters() {
		return meters;
	}
	public int getTime() {
		return maxTime;
	}
	public List<Rocket> getRockets() {
		return rockets;
	}

}
