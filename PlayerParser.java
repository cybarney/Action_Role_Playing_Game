//  Description: Takes in string, splits it and then creates new hero using the input string. 
public class PlayerParser {

	public static PlayerEntity parseNewPlayer(String lineToParse) {//Splits string into string array that gives the attributes for a player.
		
		String [] parts = lineToParse.split("/");
			//Setting split string into different variables.
			String parserEntityType=parts[0];
			Double parserHealth=Double.parseDouble(parts[1]);
			String parserName=parts[2];
			int parserStamina=Integer.parseInt(parts[3]);
			int parserAttack=Integer.parseInt(parts[4]);
			String parserManaorFighterType=parts[5];
		
			if(parts[5].equals("Melee")||parts[5].equals("melee")) {//Checks if the string inputted is for a melee fighter, if so created melee fighter.
				boolean isRanged = false;
				Fighter F1 =new Fighter(parserHealth, parserName, parserStamina, parserAttack,isRanged);
				return F1;
				}
			else if(parts[5].equals("Range")) {//Checks if string inputted is for ranged fighter, if so creates ranged fighter.
				boolean isRanged=true;
				Fighter F1 = new Fighter(parserHealth, parserName, parserStamina, parserAttack,isRanged);
				return 	F1;	}
			else{//if both above cases are false then it must be a mage inputted, then creates new mage. 
				double mana = Double.parseDouble(parts[5]);
				Mage M1 = new Mage(parserHealth,parserName,parserStamina,parserAttack,mana);
				return M1;
				
			}
	}
	
}
