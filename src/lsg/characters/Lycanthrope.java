package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {
	
	public Lycanthrope() {
		super("Lycanthrope");
		this.setSkinThickness(30);
		this.setWeapon(new Claw());
	}
	
}