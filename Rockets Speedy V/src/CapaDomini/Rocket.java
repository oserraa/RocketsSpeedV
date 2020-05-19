package CapaDomini;
import java.util.*;

public class Rocket {
	
	//hola nois 2

	private String name;
	private Double currentSpeed;
	private int currentAcceleration;
	private Double metersTravelled;
	private int circuitPosition;
	List<Propeller> propellers= new ArrayList<Propeller>();
	FuelTank fuelTank;
	
	public Rocket(String name,List<Integer> propellers, int Fuel) {
		this.name=name;
		this.currentSpeed=0.0;
		this.currentAcceleration=0;
		this.metersTravelled=0.0;
		circuitPosition=0;
		
		Propeller copyPropeller;
		for(int acceleration:propellers) {
			copyPropeller= new Propeller(acceleration);
			this.propellers.add(copyPropeller);
		}
		this.fuelTank= new FuelTank(Fuel);
		
	}
	
	
	public void decideAction(int meters,int currentTime) {
		int circuitfases=meters/currentTime;//metres fer cada fase
		currentAcceleration=(int) Math.round(circuitfases/0.5);
		currentAcceleration=(int) Math.round(circuitfases/(0.5*(currentTime^2)));
		updateData(1);
		
		
		
	}
	
	public void updateData(int time) {
		this.metersTravelled=(0+currentSpeed*time+0.5*currentAcceleration*(time^2));
		this.currentSpeed=currentSpeed+currentAcceleration*time;
	}
	
	public void accelerar(){
		
	}
	public void frenar(){
		
	}
	public void mantenir(){
	
	}
	
	public String getName() {return name;}
	public Double getSpeed() {return currentSpeed;}
	public int getAcceleration() {return currentAcceleration;}
	public Double getMetersTravelled() {return metersTravelled;}
	
	public void setPosition(int position) {
		circuitPosition=position;
	}
	public int getPosition() {return circuitPosition;}
	public int getCurrentFuel() {return fuelTank.getcurrentFuel();}
	public int getMaxFuel() {return fuelTank.getmaxFuel();}
	

}
