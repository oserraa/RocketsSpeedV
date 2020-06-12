package View;
import java.util.*;
import Application.Controller;
import Application.RecordController;
import Application.RecordDTO;

public class Main {

	private static RecordController controller=new RecordController();
	
	public static void main (String [] args) throws Exception{
		Controller controller= new Controller();
		
		System.out.println(controller.play());
		controller.competitionInProgress();
		
		
		RecordDTO record=createRecord();
	   updateRecord(record.getCircuit());
		getRecord(record.getCircuit());
	}
	
	private static void updateRecord(String circuit) throws Exception {
	    
		RecordDTO record = new RecordDTO("Guille",15,"Speedy");
		record= controller.updateRecord(circuit, record);
		System.out.print(record);
	}
	
	private static void getRecord(String circuit) throws Exception{
		RecordDTO record= controller.getRecord(circuit);
	    System.out.println(record);
	}
	
	private static RecordDTO createRecord()throws Exception {
		RecordDTO record = new RecordDTO("William",16,"Monza");
		record=controller.createRecord(record);
		System.out.print(record);
	return record;
	}
	

}
