package lsg.exceptions;


/**
* If a character tries to attack and his stamina is null, then a StaminaEmptyException will be thrown.
* @author jenni
*/
public class StaminaEmptyException extends Exception {

	public StaminaEmptyException() {
		super("No stamina !");
	}
	
}
