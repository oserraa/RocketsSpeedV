package Domain;
import java.util.ArrayList;
import java.util.List;

public class Strategy {

	private int time;
	private int meters;
	private Rocket rocket;
	private List<Integer> bestWay=new ArrayList<Integer>();
	
	public Strategy(Rocket rocket) {
		this.rocket = rocket;
		meters = rocket.getCircuitMeters();
		time = rocket.getCircuitTime();
		List<Integer> sol = new ArrayList<Integer>();
		backBestRoute(sol, 1);
	}
	
	public int accelerationOnTime(int time) {
		try {
			return bestWay.get(time-1);
		}catch(Exception e) {
			return 0;
		}	
	}
	
	public boolean backBestRoute(List<Integer> solution, int k) {
		int i=maxAcceleration();
		boolean trobat=false;
		double speedbefore=0;
		double metersbefore=0;
		int fuelbefore=0;
		while(i>=0&&!trobat) {
			if(acceptable(k,i)) {
				metersbefore=rocket.getMetersTravelled();
				speedbefore=rocket.getSpeed();
				fuelbefore=rocket.getCurrentFuel();
				solution.add(i);
				rocket.updateBackMovement(i);
				if(isSolution()) {
					if(bestSolution(solution)) {
						bestWay.clear();
						for(int newAcceleration:solution) {
							bestWay.add(newAcceleration);
						}
					}
					trobat=true;
				}else if(!isSolution()) {
					trobat=backBestRoute(solution,k+1);
				}
				solution.remove(k-1);
				rocket.setSpeed(speedbefore);
				rocket.setMetersTravelled(metersbefore);
				rocket.setCurrentFuel(fuelbefore);
			}
			i--;
		}
		return trobat;
	}
	
	private boolean acceptable(int k,int acceleration) {
		if(k<=time) {
			if(calculateFuel(k,acceleration)>=0) {
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
	private int calculateFuel(int k,int acceleration) {
		double speed=rocket.getSpeed()+calculateAcceleration(acceleration);
		int fuel=rocket.getCurrentFuel()-(int) Math.round(0.02*(speed*speed));
		return fuel;
	}
	private int calculateAcceleration(int i) {
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
	
	private boolean isSolution() {
		return rocket.getMetersTravelled()>=this.meters;
	}
	private boolean bestSolution(List<Integer> solution) {
		return (bestWay.size()==0||solution.size()<bestWay.size());
	}
	

}
