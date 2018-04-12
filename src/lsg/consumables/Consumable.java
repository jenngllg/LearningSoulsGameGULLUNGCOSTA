package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

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
	 * constructeur
	 * @param nom du collectible
	 * @param capacite du collectible
	 * @param statistique du collectible
	 */
	public Consumable(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

	/**
	 * accesseur
	 * @return nom du collectible
	 */
	public String getName() {
		return name;
	}

	/**
	 * accesseur
	 * @return capacite du collectible
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * accesseur
	 * @return statistique du collectible
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * mutateur
	 * @param capacite du collectible
	 */
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * methode qui fait passer la capacite a 0
	 * @return montant total de la capacite
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
	 * accesseur
	 * @return poids du consommable (1 kg)
	 */
	@Override
	public int getWeight() {
		return 1;
	}
}
