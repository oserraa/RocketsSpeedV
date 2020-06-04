package Domain;

import java.util.ArrayList;
import java.util.List;

public class Strategy {
	
	private static Strategy instance;
	private int[]numbers=new int[28];
	private int meters;
	private List<Propeller> propellers=new ArrayList<Propeller>();
	
	public static Strategy getInstance(List<Propeller> p) {
		if(instance==null) {
			instance= new Strategy(p);
		}
		return instance;
	}
	
	private Strategy(List<Propeller> p) {
		numbers[0]=43;
		for(int i=1;i<numbers.length;i++) {
			numbers[i]=0;
		}
		propellers=p;
		meters=0;
	}
	
	public int getAcceleration(int time) {
		return numbers[time-1];
	}
	
	public void backBestRoute(List<Integer> solution, int k, List<Integer> best) {
		int i=maxAcceleration();
		while(i>=0) {
			if(acceptable(k,i)) {
				solution.add(i);
				if(esSolucio()) {
					if(millorSolucio()) {
						
					}
				}else if() {
					backBestRoute(solution,k++,best);
				}
				solution.remove(i);
				
			}
			
			
			i++;
		}
		
		
	}
	
	private boolean acceptable(int k,int acceleration) {
		if(k<=numbers.length) {
			if(i<=) {
				return true;
			}
		}
		return false;
	}
	
	private int maxAcceleration() {
		int maxAcceleration=0;
		for(Propeller propeller: propellers) {
			if(maxAcceleration<propeller.getMaxAcceleration()) {
				maxAcceleration=propeller.getMaxAcceleration();
			}
		}
		return maxAcceleration;			
	}
	private int calcularGasolina(int acceleration) {
		calcularAcceleration(int i)
		//hacer velocidad actual
		this.currentSpeed=currentSpeed+currentAcceleration*time;
	}
	
	private int calcularAcceleration(int i) {
		int acc=0;
		for(int j=0;j<propellers.size();j++) {
			if(i>propellers.get(j).getMaxAcceleration()) {
				acc+=propellers.get(j).getMaxAcceleration();
			}
			else {
				acc+=i;
			}	
		}
		return acc;		
	}
	
	
	

}
