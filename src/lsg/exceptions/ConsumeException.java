package lsg.exceptions;

import lsg.consumables.Consumable;

//impossible d'instancier ConsumeException sans passer par une sous classe
public abstract class ConsumeException extends Exception {

	private Consumable consumable;
	
	public ConsumeException(String message, Consumable consumable) {
		super(message);
		this.consumable = consumable;
	}

	/** 
	 * accesseur
	 * @return consommable associe a l'exception
	 */
	public Consumable getConsumable() {
		return consumable;
	}
	
}
