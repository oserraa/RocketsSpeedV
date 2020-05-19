package CapaDomini;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
	
	private String name;
	private int maxTime;
	private int meters;
	private List<Rocket> rockets=new ArrayList<Rocket>();
	
	public Circuit(String name,int time,int meters, List rocket) {
		this.name=name;
		this.maxTime=time;
		this.meters=meters;
		this.rockets=rocket;
	}
	
	private void addRocket(Rocket rocket) {
		this.rockets.add(rocket);
	}
	
	

}
