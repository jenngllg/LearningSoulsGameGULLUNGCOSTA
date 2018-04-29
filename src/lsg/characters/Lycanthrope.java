package lsg.characters;

import lsg.weapons.Claw;

/**
 * Classe Lycanthrope de type Monster
 * @author jenni
 *
 */
public class Lycanthrope extends Monster {
	
	/**
	 * cree un Lycanthrope, avec comme nom "Lycanthrope", 30 d'epaisseur de peau et comme arme des griffes
	 */
	public Lycanthrope() {
		super("Lycanthrope");
		this.setSkinThickness(30);
		this.setWeapon(new Claw());
	}
	
}