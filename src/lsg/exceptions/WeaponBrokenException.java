package lsg.exceptions;

import lsg.weapons.Weapon;


/**
* If a character tries to attack and his weapon is broken, then a WeaponBrokenException will be thrown.
* @author jenni
*/
public class WeaponBrokenException extends Exception {

	private Weapon weapon;
	
	public WeaponBrokenException(Weapon weapon) {
		super(weapon.getName() + " is broken !");
		this.weapon = weapon;
	}
	
	/**
	 * @return weapon arme liee a l'exception
	 */
	public Weapon getWeapon() {
		return this.weapon;
	}
	
}
