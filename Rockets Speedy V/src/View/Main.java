package View;
import java.util.*;
import Application.Controller;

public class Main {

	public static void main(String[] args) {
		
		Controller controller= new Controller();
		
		System.out.println(controller.play());
		System.out.println(controller.CompetitionInProgress());

	}

}
