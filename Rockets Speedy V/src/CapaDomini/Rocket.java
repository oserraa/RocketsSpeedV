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
		
		if(currentSpeed==0) {
			currentAcceleration=150;//50,127,150
			//currentAcceleration=(int)Math.round((meters/28-metersTravelled)*2);
			currentSpeed=currentSpeed+currentAcceleration;
			metersTravelled();
			fuelTank.setCurrentFuel(currentSpeed);
			setAcceleration(currentAcceleration);
			//return currentAcceleration;
		}
		else {
			currentAcceleration=0;
			metersTravelled();
			fuelTank.setCurrentFuel(currentSpeed);
			setAcceleration(currentAcceleration);
			//return currentAcceleration;
		}
		
		
		
	}
	public void setAcceleration(double acceleration) {
		double accelerationGoal=0;
		for(Propeller propeller:propellers) {
			if(accelerationGoal+propeller.getMaxAcceleration()<=acceleration) {
				accelerationGoal+=propeller.getMaxAcceleration();
				propeller.setMaxAcceleration();
			}
			else {
				propeller.accelerate((int)(acceleration-accelerationGoal));
				
			}
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
	public int getAcceleration() {return currentAcceleration;}
	public Double getMetersTravelled() {return metersTravelled;}
	
	public void setPosition(int position) {
		circuitPosition=position;
	}
	public int getPosition() {return circuitPosition;}
	public int getCurrentFuel() {return fuelTank.getCurrentFuel();}
	public int getMaxFuel() {return fuelTank.getMaxFuel();}
	

}
