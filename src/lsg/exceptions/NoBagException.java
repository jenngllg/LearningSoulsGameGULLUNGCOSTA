package lsg.exceptions;

/**
* If a bag is null, then a NoBagException will be thrown.
* @author jenni
*/
public class NoBagException extends Exception {
	
	public NoBagException() {
		super("No bag !");
	}
	
}
