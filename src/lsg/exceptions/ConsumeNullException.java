package lsg.exceptions;

/**
* If a consumable is null, then a ConsumeNullException will be thrown.
* @author jenni
*/
public class ConsumeNullException extends ConsumeException {
	
	public ConsumeNullException() {
		super("Consumable is null !", null);
	}
	
}
