package Application;
import java.util.ArrayList;
import java.util.List;

import Domain.Circuit;
import Domain.Rocket;
public class RocketFactory {
	
	
	public static List <Rocket> getRockets(int m, int t) {
		List <Rocket> rockets=new ArrayList<Rocket>();
		List<Integer> propellers= new ArrayList<Integer>();
		Rocket rocket;
		propellers.add(40);
		propellers.add(50);
		propellers.add(20);
		propellers.add(38);
		rocket=new Rocket("Viper X", propellers, 2500,m,t);
		rockets.add(rocket);
		propellers.clear();
		
		propellers.add(30);
		propellers.add(18);
		propellers.add(24);
		propellers.add(38);
		rocket=new Rocket("Star V", propellers, 2800,m,t);
		rockets.add(rocket);
		propellers.clear();
		
		propellers.add(40);
		propellers.add(29);
		propellers.add(60);
		rocket=new Rocket("FalconIX", propellers, 1900,m,t);
		rockets.add(rocket);
		propellers.clear();
		
		propellers.add(10);
		propellers.add(3);
		propellers.add(20);
		propellers.add(82);
		rocket=new Rocket("Speedy V", propellers, 2200,m,t);
		rockets.add(rocket);
		propellers.clear(); 
		
		return rockets;
		
	}
	
}