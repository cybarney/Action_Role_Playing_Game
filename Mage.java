//  Description: Subclass of playerEntity, creates mage with its unique toString, and unique combat power computation. 
import java.text.NumberFormat;
public class Mage extends PlayerEntity {//Subclass of playerEntity.java
	private double mana;
	
	public Mage(double healthInput, String nameInput, int staminaInput, int attackInput, double manaInput) {//Constructor for mage using info from playerEntity
		super(healthInput,nameInput,staminaInput,attackInput);
		mana=manaInput;
	}
	public void computCombatPower() {//Compute combat power of mage
		combatPoints=(int)((attack+(int)health)*(1+mana));
	}
	public String toString() {//returns info for a mage
		NumberFormat fmt1 = NumberFormat.getPercentInstance();//Changes decimal into percent. 
		String info=("\nMage Hero:\n"+super.toString()+"Mana:\t\t\t"+fmt1.format(mana)+"\n");
		return info;
	}
}
