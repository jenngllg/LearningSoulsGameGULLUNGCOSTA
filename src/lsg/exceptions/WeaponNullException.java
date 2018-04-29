package lsg.exceptions;

/**
* If a weapon is null, then a WeaponNullException will be thrown.
* @author jenni
*/
public class WeaponNullException extends Exception {

	public WeaponNullException() {
		super("No Weapon !");
	}
	
}
