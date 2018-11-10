/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File name     :  Simon.java
*  Purpose       :  This class contains the methods to create a simons says game
*  Author        :  M. McPartlan & M. Abell
*  Date          :  2018-11-10
*  Description   :  Game is implemented through while loops in the main method
*  Exceptions    :  InterruptedException - Thrown when clock timing is interuppted
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.*;
import java.util.Scanner;
public class Simon{
    
    int [] command;
    int size;
    Random ran = new Random();
    String input;

    //Constructor method
    public Simon(){
        size = 1;
    }

    //Creates the command array
    public void setCommand(){
        command = new int [size];
        for (int i = 0; i < size; i++){
            command[i] = ran.nextInt(4);
        }
    }

    //Displays the command array
    //Throws InterruptedException - Thrown when clock timing is interuppted
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

    //Checks if input is correct (matches to commmand array)
    //@return boolean: true is the answers are right
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

    //Changes a number to its corresponding String
    //@param int: number to be converted
    //@return String: string corresponding to the input
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

    //Changes a String to its corresponding int
    //@param String: string to be converted
    //@return int: int corresponding to the input
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
    
    //Creates the simon says game
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
