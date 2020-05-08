package CapaDomini;

public class Rocket {

	String Name;
	Double currentSpeed;
	int currentAcceleration;
	Double metersTravelled;
	int circuitPosition;
	
	public Rocket(String name,int propellers) {
		Name=name;
	}
	
	public void updateData(int time) {
		this.metersTravelled=(0+currentSpeed*time+0.5*currentAcceleration*(time^2));
		this.currentSpeed=currentSpeed+currentAcceleration*time;
	}
	public Double getSpeed() {return currentSpeed;}
	public Double getMetersTravelled() {return metersTravelled;}
	//public getFuel() {}
	public void setPosition(int position) {
		circuitPosition=position;
	}
	public int getPosition() {return circuitPosition;}
		
		

	

}
