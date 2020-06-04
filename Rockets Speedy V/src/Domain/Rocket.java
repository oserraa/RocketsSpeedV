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
	
	private double goodSpeed;

	private List<Propeller> propellers=new ArrayList<Propeller>();
	
	
	public Rocket(String name,List <Integer>propellers,int fuel) {
		//validar dades
		this.name=name;
		fuelTank=new FuelTank(fuel);
		for(Integer propeller: propellers) {
			this.propellers.add(new Propeller(propeller));
		}
	}
	
	
	public void askMovement(int meters, int time) {
		setAcceleration(Strategy.getInstance().getAcceleration(time));
		currentAcceleration=this.getAcceleration();		
		currentSpeed=calculateSpeed();
		metersTravelled();
		fuelTank.updateFuel(currentSpeed);	
		
	}
	public double calculateSpeed() {
		if(this.fuelTank.getCurrentFuel()==0)return 0;
		return currentSpeed+currentAcceleration;
	}
	public void setAcceleration(int acceleration) {
		for(Propeller propeller:propellers) {
			propeller.accelerate(acceleration);
		}
	}
	
	public void metersTravelled() {
		metersTravelled=metersTravelled+currentSpeed+(0.5)*currentAcceleration;

	}
	
	public void updateData(int time) {
		this.metersTravelled=(0+currentSpeed*time+0.5*currentAcceleration*(time^2));
		this.currentSpeed=currentSpeed+currentAcceleration*time;
	}
	
	/*
	public void accelerar(){
		
	}
	public void frenar(){
		
	}
	public void mantenir(){
	
	}*/
	public int getAcceleration() {
		int acceleration=0;
		for(Propeller propeller:propellers) {
			acceleration+=propeller.getCurrentAcceleration();
		}
		return acceleration;
	}
	public String getName() {return name;}
	public Double getSpeed() {return currentSpeed;}
	public int getCurrentAcceleration() {return currentAcceleration;}
	public Double getMetersTravelled() {return metersTravelled;}
	/*public void setPosition(int position) {
		circuitPosition=position;
	}*/
	public int getPosition() {return circuitPosition;}
	public int getCurrentFuel() {return fuelTank.getCurrentFuel();}
	public int getMaxFuel() {return fuelTank.getMaxFuel();}
	

}
