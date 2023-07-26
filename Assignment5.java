//  Description: Program creates heroes(mages and fighters) with different attributes and combat score. Has ability to add multiple heroes along with computing their combat scores. It has the ability to list out all heroes currently created. 

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5 {
    public static void main(String[] args){
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try{
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do{
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if(line.length() == 1){
                    switch (input){
                        case 'A': // add hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();
                            
                            PlayerEntity p1= PlayerParser.parseNewPlayer(inputInfo);//Creates new hero using parser method.
                            playerList.add(p1);
                           
        
                            break;

                        case 'C': // calculate combat points
                        	for(int i=0;i<playerList.size();i++) {
                        		playerList.get(i).computCombatPower();
                        	}
                        	
                        	
                            System.out.println("Combat points computed");
                            break;

                        case 'D': // how many heroes have combat points equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;
                            
                            if(playerList.size()==0) {//Reads no heroes in guild if list is empty.
                        		System.out.print("No heroes in guild yet.\n");
                        	}
                        	if(playerList.size()>0) {
                        		for(int i=0;i<playerList.size();i++) {
                        			if(playerList.get(i).getCombatPoints()>=min) {
                        				count++;
                        			}
                        		}
                        	}

                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);
                            break;

                        case 'L': // list heroes
                        	if(playerList.size()==0) {
                        		System.out.println("No heroes in guild yet.");
                        	}else {
                        		for(int i=0;i<playerList.size();i++) {
                        			System.out.print(playerList.get(i).toString());
                        		}
                        	}
                        

                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for playing!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }


    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
