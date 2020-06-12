package View;
import java.util.*;
import Application.Controller;
import Application.RecordController;
import Application.RecordDTO;

public class Main {

	private static RecordController recordController=new RecordController();
	
	public static void main (String [] args) throws Exception{
		Controller controller= new Controller();
		System.out.println("Starting the race. Make your bets while rockets are being prepared...");
		System.out.println(controller.play());
		System.out.println(controller.competitionInProgress());
		controller.registerRecord();
		RecordDTO record;
		try {
			record=getRecord(controller.getCircuitName());
		}catch(Exception e) {
			record=createRecord(controller.getNameWinner(),controller.getTimeWinner(),controller.getCircuitName());
		}
		if(controller.getTimeWinner()<record.getTime()) {
			updateRecord(controller.getNameWinner(),controller.getTimeWinner(),controller.getCircuitName());
		}
	}
	
	private static void updateRecord(String RocketName,int RocketTime,String CircuitName) throws Exception {
		RecordDTO record = new RecordDTO(RocketName,RocketTime,CircuitName);
		record= recordController.updateRecord(CircuitName, record);
		System.out.print(record);
	}
	
	private static RecordDTO getRecord(String CircuitName) throws Exception{
		RecordDTO record= recordController.getRecord(CircuitName);
	    System.out.println(record);
	    return record;
	}
	
	private static RecordDTO createRecord(String RocketName,int RocketTime,String CircuitName)throws Exception {
		RecordDTO record = new RecordDTO(RocketName,RocketTime,CircuitName);
		record=recordController.createRecord(record);
		System.out.print(record);
		return record;
	}
	

}
