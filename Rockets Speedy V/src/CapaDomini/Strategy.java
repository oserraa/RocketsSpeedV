package CapaDomini;

public class Strategy {
	
	private static Strategy instance;
	private int[]numbers=new int[28];
	
	public static Strategy getInstance() {
		if(instance==null) {
			instance= new Strategy();
		}
		return instance;
	}
	
	private Strategy() {
		numbers[0]=43;
		for(int i=1;i<28;i++) {
			numbers[i]=0;
		}
	}
	
	public int getAcceleration(int time) {
		return numbers[time-1];
	}

}
