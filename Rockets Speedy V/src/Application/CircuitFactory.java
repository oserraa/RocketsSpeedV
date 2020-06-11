package Application;
import java.util.List;
import Domain.Circuit;
public class CircuitFactory {
	
	public static Circuit getCircuit(int ct) {
		switch(ct) {
		case 0: return new Circuit("MadMax",1300,22,RocketFactory.getRockets(1300,22));
		case 1: return new Circuit("SpeedTrack",800,10,RocketFactory.getRockets(800,10));
		case 2: return new Circuit("FreeWorld",1200,18,RocketFactory.getRockets(1200,18));
		case 3: return new Circuit("RisingLab",900,15,RocketFactory.getRockets(900,15));
		default: return null;
		}
		
	
	}

}
