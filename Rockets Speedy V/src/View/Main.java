package View;
import java.util.*;
import Application.Controller;
import Application.RecordController;
import Application.RecordDTO;

public class Main {

	private static RecordController recordController=new RecordController();
	
	public static void main (String [] args) throws Exception{
		Controller controller= new Controller();
		String solution="";
		System.out.println("Starting the race. Make your bets while rockets are being prepared...");
		System.out.println(controller.play());
		solution=controller.competitionInProgress();
		int n=0;
		for(int x=0;x<solution.length();x++) {
			if(solution.charAt(x)==('\n')) {
				n++;
			}
			if(n==5) {
				n=0;
				Thread.sleep(1000);
			}
			System.out.print(solution.charAt(x));
		}	
		
		System.out.println();
		controller.registerRecord();
		RecordDTO record;
		try {
			record=getRecord(controller.getCircuitName());
		}catch(Exception e) {
			record=createRecord(controller.getNameWinner(),controller.getTimeWinner(),controller.getCircuitName());
			System.out.println("Winner has been saved to the Data Base");
		}
		if(controller.getTimeWinner()<record.getTime()) {
			updateRecord(controller.getNameWinner(),controller.getTimeWinner(),controller.getCircuitName());
			System.out.println("New RECORD!!!");
		}
		
	}
	
	private static void updateRecord(String RocketName,int RocketTime,String CircuitName) throws Exception {
		RecordDTO record = new RecordDTO(RocketName,RocketTime,CircuitName);
		record= recordController.updateRecord(CircuitName, record);
	}
	
	private static RecordDTO getRecord(String CircuitName) throws Exception{
		RecordDTO record= recordController.getRecord(CircuitName);
	    return record;
	}
	
	private static RecordDTO createRecord(String RocketName,int RocketTime,String CircuitName)throws Exception {
		RecordDTO record = new RecordDTO(RocketName,RocketTime,CircuitName);
		record=recordController.createRecord(record);
		return record;
	}
	

}
