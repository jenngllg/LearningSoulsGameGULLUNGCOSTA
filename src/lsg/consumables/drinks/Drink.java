package lsg.consumables.drinks;

import lsg.consumables.Consumable;

public class Drink extends Consumable {

	/**
	 * constructeur d'une boisson
	 * @param nom de la boisson
	 * @param capacite de la boisson
	 * @param statistique de la boisson
	 */
	public Drink(String name, int capacity, String stat) {
		super(name, capacity, stat);
	}
}
