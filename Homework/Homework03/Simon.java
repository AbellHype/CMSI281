import java.util.*;
import java.util.Scanner;
public class Simon{
	
	int [] command;
    int size;
    Random ran = new Random();
    String input;

	public Simon(){
		size = 1;
	}

	public void setCommand(){
		command = new int [size];
        for (int i = 0; i < size; i++){
        	command[i] = ran.nextInt(4);
        }
	}

	public void displayCommand() throws InterruptedException{
		System.out.print(toLetter(command[0]));
		for (int i = 1; i < size; i++){
			Thread.sleep(333);
			System.out.print(toLetter(command[i]));
		}
	 	Thread.sleep(1000);
	 	for (int i = 0; i <= size; i++){
	 		System.out.print("\b");
	 	}
	 	for (int i = 0; i <= size; i++){
	 		System.out.print(" ");
	 	}
	 	for (int i = 0; i <= size; i++){
	 		System.out.print("\b");
	 	}
	}

	public boolean rightAnswer(){
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < size; i++){
			input = reader.nextLine();
			if (toNumber(input) != command[i]){
				return false;
			}
		}
        size++;
		return true;
	}

	public String toLetter(int select){
		if (select == 0){
			return "R";
		}
		else if (select == 1){
			return "G";
		}
		else if (select == 2){
			return "Y";
		}
		else if (select == 3){
			return "B";
		}
		else{
			return "Error";
		}
	}

	public int toNumber(String select){
		if (select.equals("R")){
			return 0;
		}
		else if (select.equals("G")){
			return 1;
		}
		else if (select.equals("Y")){
			return 2;
		}
		else if (select.equals("B")){
			return 3;
		}
		else{
			return -1;
		}
	}
	public static void main(String [] args) throws InterruptedException{
		boolean again = true;
		while(again){	
			System.out.println("Let's play simons says, repeat after me! Make sure to hit enter after every character input!");
			Simon ex = new Simon();
			boolean run = true;
			while (run == true){
				ex.setCommand();
				ex.displayCommand();
				run = ex.rightAnswer();
			}
			System.out.println("Sorry, you lost");
			System.out.println("Press Y to play again, press any other button to quit");
			Scanner reader = new Scanner(System.in);
			String answer = reader.nextLine();
			if(ex.toNumber(answer) != 2){
				again = false;
			}
		}
	} 
}
