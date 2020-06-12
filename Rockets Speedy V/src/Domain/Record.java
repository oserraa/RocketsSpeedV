package Domain;

import Application.RecordDTO;
import java.security.InvalidParameterException;

public class Record {

	private String rocket;
	private int time;
	private String circuit;

	public Record() {// constructor buit
	}

	// creo de BBDD
	public Record(String rocket, int time, String circuit) throws InvalidParameterException {//
		if (rocket == null || rocket.equals("")) {
			throw new InvalidParameterException();
		}
		if (time <= 0) {
			throw new InvalidParameterException();
		}
		if (circuit == null || circuit.equals("")) {
			throw new InvalidParameterException();
		}
		this.rocket = rocket;
		this.time = time;
		this.circuit = circuit;
	}

	// JAVA
	public Record(RecordDTO recordDTO) throws InvalidParameterException {
		if (recordDTO == null)
			throw new InvalidParameterException();
		this.rocket = recordDTO.getRocket();
		this.time = recordDTO.getTime();
		this.circuit = recordDTO.getCircuit();

	}

	public String getRocket() {
		return rocket;
	}

	public int getTime() {
		return time;
	}

	public String getCircuit() {
		return circuit;
	}

	public void updateRecord(RecordDTO recordDTO) throws InvalidParameterException {
		if (recordDTO == null)
			throw new InvalidParameterException();
		this.rocket = recordDTO.getRocket();
		this.time = recordDTO.getTime();
		this.circuit = recordDTO.getCircuit();
	}
}
