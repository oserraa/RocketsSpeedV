package Domain;
import java.util.*;

public class Circuit {
	private String name;
	private int meters;
	private int maxTime;
	private int currentTime;
	private List<Rocket> rockets= new ArrayList<Rocket>();
	private Rocket winner;
	private int timeWinner;

	public Circuit(String name,int meters, int maxTime,List<Rocket>rockets) {
		//validar dades
		this.name=name;
		this.meters=meters;
		this.maxTime=maxTime;
		this.rockets=rockets;
		this.currentTime=0;
	}
	
	public String rocketsInformation(Rocket who) {
		String sentence="";
			sentence+=" Name "+who.getName()+" Current Time: "+this.currentTime+" Acceleration: "+who.getAcceleration()+
					" Speed: "+who.getSpeed()+" Distance: "+who.getMetersTravelled()+" Circuit: "+this.meters+
					" Fuel: "+who.getCurrentFuel()+" / "+who.getMaxFuel();
		return sentence;
	}

	public String competitionProgress() throws InterruptedException {
		String solution="";
		this.currentTime++;
		for (Rocket rocket : rockets) {
			rocket.askMovement(currentTime);
			solution+=rocketsInformation(rocket);
			solution+="\n";
		}
		if(this.winner==null) {
			theresAWinner();
		}
		return solution;
	}
	public boolean competitionEnds() {
		return (currentTime>=maxTime);
	}
	public String endSentence() {
		if(this.winner!=null)return "And the winner is: "+this.winner.getName()+" with a time of "+this.timeWinner;
		return "There is no winner";
	}
	public void theresAWinner() {
			for(Rocket rocket:rockets) {
				if(rocket.getMetersTravelled()>=this.meters) {
					this.winner=rocket;
					this.timeWinner=this.currentTime;
					}
			}
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
	public List<Rocket> getRockets() {
		return rockets;
	}
	public Rocket getWinner() {
		return winner;
	}
	public int getTimeWinner() {
		return timeWinner;
	}
	

}
