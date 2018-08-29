import java.util.Scanner;

public class SayHello{
	
	public SayHello() {;}

	public static void main(String args[]){
		System.out.println("Hello, World!");
		System.out.println("Please enter your name");
		Scanner myInput = new Scanner( System.in );
   		String inputName = myInput.nextLine();
   		if(inputName.length() > 0){
   			System.out.println("Hello, " + inputName + "!");
   		}
   		else{
   			System.out.println("No name was entered. Please try again.");
   			System.exit(1);
   		}
	}
}
