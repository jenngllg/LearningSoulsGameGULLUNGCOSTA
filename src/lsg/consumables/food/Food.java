package lsg.consumables.food;

import lsg.consumables.Consumable;

/**
 * Classe Nourriture de type consumable regenerant de la vie
 * @author jenni
 *
 */
public class Food extends Consumable {

	/** 
	 * constructeur d'une nourriture
	 * @param name nom de la nourriture
	 * @param capacity capacite de la nourriture
	 * @param stat statistique de la nourriture
	 */
	public Food(String name, int capacity, String stat) {
		super(name, capacity, stat);
	}
}
