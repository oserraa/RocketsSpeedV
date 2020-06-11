package Domain;
import java.util.ArrayList;
import java.util.List;

public class Strategy {
	
	//private static Strategy instance;
	private int time;
	private int meters;
	private Rocket rocket;
	
	private List<Integer> bestWay=new ArrayList<Integer>();
	
	/*public synchronized static Strategy getInstance(Rocket r) {
		if(instance==null) {
			instance= new Strategy(r);
		}
		return instance;
	}*/
	
	public Strategy(Rocket rocket) {
		this.rocket=rocket;
		meters=rocket.meters;
		time=rocket.time;
		List<Integer> sol=new ArrayList<Integer>();
		backBestRoute(sol,1);
		System.out.println("He fet stratgey");
		
	}
	
	public int accelerationOnTime(int time) {
		try {
			return bestWay.get(time-1);
		}catch(Exception e) {
			return 0;
		}	
	}
	
	public void backBestRoute(List<Integer> solution, int k) {//List<Integer> best
		//int i=maxAcceleration();
		int i=15;
		double speedbefore=0;
		double metersbefore=0;
		int fuelbefore=0;
		while(i>=0) {
			if(acceptable(k,i)) {
				metersbefore=rocket.getMetersTravelled();
				speedbefore=rocket.getSpeed();
				fuelbefore=rocket.getCurrentFuel();
				solution.add(i);
				rocket.askMovement1(i);
				
				if(esSolucio()) {
					System.out.println(rocket.getMetersTravelled());
					if(millorSolucio(solution)) {
						bestWay.clear();
						for(int newAcceleration:solution) {
							bestWay.add(newAcceleration);
						}
					}
				}else if(!esSolucio()) {
					backBestRoute(solution,k+1);
				}
				solution.remove(k-1);
				rocket.setSpeed(speedbefore);
				rocket.setMetersTravelled(metersbefore);
				rocket.setCurrentFuel(fuelbefore);
			}
			i--;
		}
	}
	/*public void backBestRoute(List<Integer> solution, int k) {//List<Integer> best
		int i=maxAcceleration();
		double speedbefore=0;
		double metersbefore=0;
		int fuelbefore=0;
		while(i>=0) {
			if(acceptable(k,i)) {
				metersbefore=rocket.getMetersTravelled();
				speedbefore=rocket.getSpeed();
				fuelbefore=rocket.getCurrentFuel();
				solution.add(i);
				rocket.askMovement1(i);
				if(esSolucio()) {
					if(millorSolucio(solution,bestWay)) {
						bestWay.clear();
						for(int newAcceleration:solution) {
							bestWay.add(newAcceleration);
						}
					}
				}else if(!esSolucio()) {
					backBestRoute(solution,k+1);
				}
				solution.remove(k-1);
				rocket.setSpeed(speedbefore);
				rocket.setMetersTravelled(metersbefore);
				rocket.setCurrentFuel(fuelbefore);
			}
			i--;
		}
	}*/
	
	private boolean acceptable(int k,int acceleration) {
		if(k<=time) {
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
	private boolean millorSolucio(List<Integer> sol) {
		if(bestWay.size()==0)return true;
		return sol.size()<bestWay.size();
	}
	

}
