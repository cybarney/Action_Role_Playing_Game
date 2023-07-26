//  Description: parent class for mage and fighter, has base attributes that are in both, has method to compute combat score and return it. 
public abstract class PlayerEntity {
	//Instantiate variables that will be used in all classes.
	protected double health;
	protected int stamina;
	protected String entityName;
	protected int attack;
	protected int combatPoints;

	public PlayerEntity(double healthInput,String nameInput,int staminaInput, int attackInput ){//Constructor for playerentity object.
		combatPoints=0;
		health=healthInput;
		stamina=staminaInput;
		attack=attackInput;
		entityName=nameInput;		
	}

	public int getCombatPoints() {//Returns the combat points of the player
		return combatPoints;
	}

	public abstract void computCombatPower();
		
	public String toString() {//To String method for player, returns info on the player.
		String info = ("\nHero name:\t\t"+ entityName +"\nCurrent Health:\t\t"+health+"\nStamina:\t\t"+stamina+"\nAttack Damage:\t\t"+attack+"\nCurrent Combat Points:\t"+combatPoints+"\n");
		return info;
	}
}
