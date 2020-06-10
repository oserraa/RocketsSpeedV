package Domain;
import java.util.ArrayList;
import java.util.List;

public class Strategy {
	
	private static Strategy instance;
	private int[]numbers=new int[28];
	private int meters=1700;
	private Rocket rocket;
	private double metersbefore;
	private double speedbefore;
	private int fuelbefore;
	private List<Integer> bestWay=new ArrayList<Integer>();
	
	public static Strategy getInstance(Rocket r) {
		if(instance==null) {
			instance= new Strategy(r);
		}
		return instance;
	}
	
	private Strategy(Rocket rocket) {
		this.rocket=new Rocket(rocket.getName(),rocket.getMaxPropellers(),rocket.getMaxFuel());
		metersbefore=0;
		speedbefore=0;
		fuelbefore=0;
		List<Integer> sol=new ArrayList<Integer>();
		backBestRoute(sol,1,bestWay);
	}
	
	public int accelerationOnTime(int time) {
		return bestWay.get(time-1);
	}
	
	public void backBestRoute(List<Integer> solution, int k, List<Integer> best) {
		int i=maxAcceleration();
		while(i>=0) {
			if(acceptable(k,i)) {
				solution.add(i);
				rocket.askMovement(i);
				if(esSolucio()) {
					if(millorSolucio(solution,best)) {
						best.clear();
						for(int newAcceleration:solution) {
							best.add(newAcceleration);
						}
					}
				}else if(!esSolucio()) {
					backBestRoute(solution,k++,best);
				}
				solution.remove(i);
				desfer();
			}
			i--;
		}	
	}
	
	private boolean acceptable(int k,int acceleration) {
		if(k<=numbers.length) {
			if(calcularGasolina(k,acceleration)>=0) {
				return true;
			}
		}
		return false;
	}
	
	private int maxAcceleration() {
		int maxAcceleration=0;
		for(Propeller propeller: rocket.getPropellers()) {
			if(maxAcceleration<propeller.getMaxAcceleration()) {
				maxAcceleration=propeller.getMaxAcceleration();
			}
		}
		return maxAcceleration;			
	}
	private int calcularGasolina(int k,int acceleration) {
		//per poder fer desfer
		metersbefore=rocket.getMetersTravelled();
		speedbefore=rocket.getSpeed();
		fuelbefore=rocket.getCurrentFuel();
		
		//fer calcularAcc
		double speed=rocket.getSpeed()+calcularAcceleration(acceleration);
		int fuel=rocket.getCurrentFuel()-(int) Math.round(0.02*(speed*speed));
		return fuel;
	}
	private int calcularAcceleration(int i) {
		int acc=0;
		for(int j=0;j<rocket.getPropellers().size();j++) {
			if(i>rocket.getPropellers().get(j).getMaxAcceleration()) {
				acc+=rocket.getPropellers().get(j).getMaxAcceleration();
			}
			else {
				acc+=i;
			}	
		}
		return acc;		
	}
	
	private boolean esSolucio() {
		return rocket.getMetersTravelled()>=this.meters;
	}
	private boolean millorSolucio(List<Integer> sol,List<Integer> best) {
		//tmb mirar gasolina per dspres meta
		return sol.size()<best.size();
	}
	private void desfer() {
		rocket.setSpeed(speedbefore);
		rocket.setMetersTravelled(metersbefore);
		rocket.setCurrentFuel(fuelbefore);
	}
	
	

}
