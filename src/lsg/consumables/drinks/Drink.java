package lsg.consumables.drinks;

import lsg.consumables.Consumable;

/**
 * Classe Drink de type Consumable
 * @author jenni
 *
 */
public class Drink extends Consumable {

	/**
	 * cree une boisson avec un nom, une capacite et le stat a regenerer
	 * @param name nom de la boisson
	 * @param capacity capacite de la boisson
	 * @param stat statistique de la boisson
	 */
	public Drink(String name, int capacity, String stat) {
		super(name, capacity, stat);
	}
	

}
