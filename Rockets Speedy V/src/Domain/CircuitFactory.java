package Domain;
import java.util.List;

import Utilities.CircuitType;
public class CircuitFactory {
	
	public static Circuit getCircuit(int ct) {
		switch(ct) {
		case 0: return new Circuit("MadMax",1300,22,rockets);
		case 1: return new Circuit("SpeedTrack",800,10,rockets);
		case 2: return new Circuit("FreeWorld",1200,18,rockets);
		case 3: return new Circuit("RisingLab",900,15,rockets);
		default: return null;
		}
		
	
	}

}
