package CapaDomini;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Rocket {


	String name;
	double currentSpeed=0;
	int currentAcceleration=0;
	double metersTravelled=0;
	int circuitPosition;
	FuelTank fuelTank;
	
	double goodSpeed;

	private List<Propeller> propellers=new ArrayList<Propeller>();
	
	
	public Rocket(String name,List <Integer>propellers,int fuel) {
		this.name=name;
		fuelTank=new FuelTank(fuel);
		for(Integer propeller: propellers) {
			this.propellers.add(new Propeller(propeller));
		}
	}
	
	
	public void askMovement(int meters, int time) {
		
			setAcceleration(Strategy.getInstance().getAcceleration(time));
			currentAcceleration=this.getAcceleration();
			//currentAcceleration=(int)Math.round((meters/28-metersTravelled)*2);
			currentSpeed=controlSpeed();
			metersTravelled();
			fuelTank.setCurrentFuel(currentSpeed);
			//return currentAcceleration;
		
		
	}
	public double controlSpeed() {
		if(this.fuelTank.getCurrentFuel()==0)return 0;
		return currentSpeed+currentAcceleration;
	}
	public void setAcceleration(int acceleration) {
		//double accelerationGoal=0;
		for(Propeller propeller:propellers) {
			propeller.accelerate(acceleration);
			/*if(accelerationGoal+propeller.getMaxAcceleration()<=acceleration) {
				accelerationGoal+=propeller.getMaxAcceleration();
				propeller.setMaxAcceleration();
			}
			else {
				propeller.accelerate((int)(acceleration-accelerationGoal));
				
			}*/
		}
	}
	
	public void metersTravelled() {
		metersTravelled=metersTravelled+currentSpeed+(0.5)*currentAcceleration;

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
	public int getcurrentAcceleration() {return currentAcceleration;}
	public int getAcceleration() {
		int acceleration=0;
		for(Propeller propeller:propellers) {
			acceleration+=propeller.getCurrentAcceleration();
		}
		return acceleration;
	}
	public Double getMetersTravelled() {return metersTravelled;}
	
	public void setPosition(int position) {
		circuitPosition=position;
	}
	public int getPosition() {return circuitPosition;}
	public int getCurrentFuel() {return fuelTank.getCurrentFuel();}
	public int getMaxFuel() {return fuelTank.getMaxFuel();}
	

}
