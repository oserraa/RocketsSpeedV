package Domain;
import java.util.*;


public class Circuit {
	private String name;
	private int meters;
	private int maxTime;
	private int currentTime;
	private List<Rocket> rockets= new ArrayList<Rocket>();
	private Rocket winner;

	public Circuit(String name,int meters, int maxTime,List<Rocket>rockets) {
		//validar dades
		this.name=name;
		this.meters=meters;
		this.maxTime=maxTime;
		this.rockets=rockets;
		this.currentTime=0;
	}
	
	/*public void rocketActionAll() {
		for(Rocket rocket: rockets){
			
		}
	}*/
	public String startCompetition() {
		String sentence="Starting competition. Circuit length: "+this.meters+" Max Time: "+this.maxTime;
		while(!competitionEnds()) {
			for(Rocket rocket:rockets) {
				this.currentTime++;
				rocket.askMovement(currentTime);
				sentence+="\n Current Time: "+this.currentTime+" Acceleration: "+rocket.getAcceleration()+
						" Speed: "+rocket.getSpeed()+" Distance: "+rocket.getMetersTravelled()+" Circuit: "+this.meters+
						" Fuel: "+rocket.getCurrentFuel()+" / "+rocket.getMaxFuel();
			}
			theresAWinner();
		}
		sentence+="\n"+endSentence();
		return sentence;
	}
	public boolean competitionEnds() {
		return (currentTime==maxTime||this.winner!=null);
	}
	public String endSentence() {
		if(this.winner!=null)return "And the winner is: "+theresAWinner()+" with a time of "+this.currentTime;
		return "There is no winner";
	}
	public String theresAWinner() {
		for(Rocket rocket:rockets) {
			if(rocket.getMetersTravelled()>=this.meters) {
				this.winner=rocket;
				return rocket.getName();
				}
		}
		return "";
	}
	public void addRocket(Rocket rocket) {
		rockets.add(rocket);
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
	

}
