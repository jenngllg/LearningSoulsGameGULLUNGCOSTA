package lsg.consumables.food;

import lsg.consumables.Consumable;

public class Food extends Consumable {

	/** 
	 * constructeur d'une nourriture
	 * @param nom de la nourriture
	 * @param capacite de la nourriture
	 * @param statistique de la nourriture
	 */
	public Food(String name, int capacity, String stat) {
		super(name, capacity, stat);
	}
}
