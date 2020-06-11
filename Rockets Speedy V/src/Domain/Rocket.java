package Domain;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	private String name;
	private double currentSpeed=0;
	private int currentAcceleration=0;
	private double metersTravelled=0;
	private int circuitPosition;
	private FuelTank fuelTank;
	private Strategy strategy;
	
	int meters;
	int time;

	private List<Propeller> propellers=new ArrayList<Propeller>();
	
	public Rocket(String name,List<Integer>propellers,int fuel,int m,int t) {
		//validar dades
		this.name=name;
		fuelTank=new FuelTank(fuel);
		for(Integer propeller: propellers) {
			this.propellers.add(new Propeller(propeller));
		}
		meters=m;
		time=t;
		strategy=new Strategy(this);
	}
	
	public void askMovement1(int acce) {
		setAcceleration(acce);
		currentAcceleration=this.getAcceleration();		
		updateData(1);
		fuelTank.updateFuel(currentSpeed);	
		
	}
	public void askMovement2(int time) {
		//setAcceleration(Strategy.getInstance(this).accelerationOnTime(time));
		setAcceleration(strategy.accelerationOnTime(time));
		currentAcceleration=this.getAcceleration();		
		updateData(1);
		fuelTank.updateFuel(currentSpeed);	
		
	}
	public void setAcceleration(int acceleration) {
		for(Propeller propeller:propellers) {
			propeller.accelerate(acceleration);
		}
	}
	public int getAcceleration() {
		int acceleration=0;
		for(Propeller propeller:propellers) {
			acceleration+=propeller.getCurrentAcceleration();
		}
		return acceleration;
	}
	public void updateData(int time) {
		this.metersTravelled+=(0+currentSpeed*time+0.5*currentAcceleration*(time^2));
		if(this.fuelTank.getCurrentFuel()==0) {
			this.currentSpeed=0;
		}
		else {
			this.currentSpeed=currentSpeed+currentAcceleration*time;
		}
	}
	
	public String getName() {return name;}
	public Double getSpeed() {return currentSpeed;}
	public int getCurrentAcceleration() {return currentAcceleration;}
	public Double getMetersTravelled() {return metersTravelled;}
	public int getMeters() {return meters;}
	public int getTime() {return time;}
	/*public void setPosition(int position) {
		circuitPosition=position;
	}*/
	public int getPosition() {return circuitPosition;}
	public int getCurrentFuel() {return fuelTank.getCurrentFuel();}
	public int getMaxFuel() {return fuelTank.getMaxFuel();}
	public List<Propeller> getPropellers(){return propellers;}
	
	public void setSpeed(double speed) {this.currentSpeed=speed;}
	public void setMetersTravelled(double meters) {this.metersTravelled=meters;}
	public void setCurrentFuel(int fuel) {
		this.fuelTank.setCurrentFuel(fuel);
	}

}
