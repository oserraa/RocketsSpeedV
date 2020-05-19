package CapaDomini;
import java.util.*;

public class Circuit {
	
	String name;
	int meters;
	int maxTime;
	int currentTime;
	List<Rocket> rockets= new ArrayList<Rocket>();
	Rocket winner;

	public Circuit(String name,int meters, int maxTime,List<Rocket>rockets) {
		this.name=name;
		this.meters=meters;
		this.maxTime=maxTime;
		this.rockets=rockets;
	}
	
	public void rocketActionAll() {
		for(Rocket rocket: rockets){
			rocket.decideAction(meters,currentTime);
		}
	}
	public String startCompetition() {
		String sentence="Starting competition. Circuit length: "+this.meters+" Max Time: "+this.maxTime;
		while(!CompetitionEnds()) {
			sentence+="\n Current Time: "+this.currentTime+"Acceleration: "+winner.getAcceleration()+
					" Speed: "+winner.getSpeed()+" Distance: "+winner.getMetersTravelled()+" Circuit: "+this.meters+
					" Fuel: "+this.winner.getCurrentFuel()+" / "+this.winner.getMaxFuel();
		}
		sentence+="\n"+EndSentence(CompetitionEnds());
		return sentence;
	}
	public boolean CompetitionEnds() {
		if(currentTime==maxTime||this.winner!=null) {return true;}
		return false;
	}
	public String EndSentence(boolean winner) {
		if(winner)return "And the winner is: "+theresAwinner()+" with a time of "+this.currentTime;
		return "There is no winner";
	}
	public String theresAwinner() {
		Rocket rocket=rockets.get(0);
		if(rocket.getMetersTravelled()==this.meters) {
			this.winner=rocket;
			return rocket.getName();
			}
		return "";
		
	}
	

}
