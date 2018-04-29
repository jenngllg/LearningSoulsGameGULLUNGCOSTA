package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

/** 
 * Classe consumable de type collectible qui regenere des statistiques
 * @author jenni
 *
 */
public class Consumable implements Collectible{

	/**
	 * nom du collectible
	 */
	private String name;
	
	/**
	 * capacite du collectible
	 */
	private int capacity;
	
	/**
	 * statistique du collectible
	 */
	private String stat;
	

	/**
	 * cree un consumable avec un nom, une capacite et des stats a regenerer
	 * @param name nom du collectible
	 * @param capacity capacite du collectible
	 * @param stat statistique du collectible
	 */
	public Consumable(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

	/**
	 * @return name nom du collectible
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return capacity capacite du collectible
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return stat statistique du collectible
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * @param capacity capacite du collectible
	 */
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * methode qui fait passer la capacite a 0
	 * @return capacity montant total de la capacite
	 * @throws ConsumeEmptyException 
	 */
	public int use() throws ConsumeEmptyException {
		if (this.capacity == 0) { throw new ConsumeEmptyException(this); }
		int capacity = this.getCapacity();
		this.setCapacity(0);
		return capacity;
	}
	
	/**
	 * retourne une chaine de la forme "nom [capacite statistique point(s)]"
	 * @return string
	 */
		public String toString() {
		return this.getName() + " [" + this.getCapacity() + " " + this.getStat() + " point(s)] ";
	}

	/**
	 * @return 1 poids du consommable (1 kg)
	 */
	@Override
	public int getWeight() {
		return 1;
	}
}
