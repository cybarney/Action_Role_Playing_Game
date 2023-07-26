//  Description: Subclass of PlayerEntity, creates fighter hero that is either ranged or melee, and has uniuqe toString method for fighter, and unique combat score computation. 
import java.text.NumberFormat;

public class Fighter extends PlayerEntity {//Fight is subclass of playerEntity
	private double armor;
	private int maxAttack;
	private boolean isRanged;

	public Fighter(double healthInput, String nameInput, int staminaInput, int attackInput, boolean isRangedInput) {//Constructor for fighter object
		super(healthInput,nameInput,staminaInput,attackInput);
		isRanged=isRangedInput;
			if(isRangedInput == true) {//Sets armor and max attack for ranged fighter.
				armor=0.25;
				maxAttack=125;
				}
			if(isRangedInput == false) {//Sets armor and max attack for non-ranged fighter. 
				armor=0.5;
				maxAttack=100;
				}
	}

	public void computCombatPower() {//Computes combat power for fighter
		if(maxAttack<=attack) {
			combatPoints=(int)((maxAttack+(int)health)*(1-armor));
			}else {
				combatPoints=(int)((attack+(int)health)*(1-armor));
			}
	}

	public String toString() {//Returns info for a fighter
		NumberFormat fmt1 = NumberFormat.getPercentInstance();//Changes decimal into percent
		String info ="";
		if (isRanged == true) {info= ("\nFighter Hero:\t\tRanged Type"+super.toString()+"\nArmor:\t\t\t"+fmt1.format(armor))+"\n\n\n";}
		if (isRanged ==false) {info = ("\nFighter Hero:\t\tMelee Type"+super.toString()+"\nArmor:\t\t\t"+fmt1.format(armor))+"\n\n\n";}
		return info;
	}
}
