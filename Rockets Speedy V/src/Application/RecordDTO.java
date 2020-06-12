package Application;

import Domain.Record;
import java.security.InvalidParameterException;

public class RecordDTO {

	private String rocket;
	private int time;
	private String circuit;

	public RecordDTO(String rocket, int time, String circuit) throws InvalidParameterException {//
		this.rocket = rocket;
		this.time = time;
		this.circuit=circuit;
	}

	public RecordDTO(Record record) throws InvalidParameterException {
		if (record == null) 
			throw new InvalidParameterException();
		this.rocket=record.getRocket();
		this.time=record.getTime();
		this.circuit=record.getCircuit();
		
	}

	public String getRocket() throws InvalidParameterException{
		if(rocket==null|| rocket.equals("")) {
			throw new InvalidParameterException();
		}
		return rocket;
	}
	public int getTime() throws InvalidParameterException{
		if(time<=0) {
			throw new InvalidParameterException();
		}
		return time;
	}
	public String getCircuit() throws InvalidParameterException{
		if(circuit==null|| circuit.equals("")) {
			throw new InvalidParameterException();
		}
		return circuit;
	}
	
	public String toString() {
		return " Rocket: " + rocket + " time: " + time + " circuit: " + circuit;
	}
}
