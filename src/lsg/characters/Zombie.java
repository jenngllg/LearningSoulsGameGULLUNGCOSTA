package lsg.characters;

import lsg.buffs.Talisman;
import lsg.weapons.ZombiesHand;

/**
 * Classe Zombie de type Character
 * @author jenni
 *
 */
public class Zombie extends Monster {
	
	
	public Zombie() {
		Zombie.INSTANCE_COUNT++; 
		this.name = "Zombie";
		this.talismans = new Talisman[MAX_TALISMAN];
		setLife(10);
		setMaxLife(10);
		setStamina(10);
		setMaxStamina(10);
		this.skinThickness = 10;
		this.weapon = new ZombiesHand();
	}

}
