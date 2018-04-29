package lsg.exceptions;

import lsg.consumables.Consumable;

/**
* If a consumable is empty, then a ConsumeEmptyException will be thrown.
* @author jenni
*/
public class ConsumeEmptyException extends ConsumeException {

	public ConsumeEmptyException(Consumable consumable) {
		super("Consumable is empty !", consumable);
	}
	
}
