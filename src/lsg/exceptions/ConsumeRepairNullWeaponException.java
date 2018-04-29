package lsg.exceptions;

import lsg.consumables.Consumable;

/**
* If a weapon is null and a hero tries to repair it, then a ConsumeRepairNullWeaponException will be thrown.
* @author jenni
*/
public class ConsumeRepairNullWeaponException extends ConsumeException {

	public ConsumeRepairNullWeaponException(Consumable consumable) {
		super("Trying to repair null weapon!", consumable);
	}
	
}
