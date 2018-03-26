package lsg.consumables;

import lsg.bags.Collectible;

public class Consumable implements Collectible{

	private String name;
	private int capacity;
	private String stat;

	public Consumable(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getStat() {
		return stat;
	}

	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * fait passer la capacit� � 0
	 * @return int montant total de la capacit�
	 */
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(0);
		return capacity;
	}
	
	/**
	 * retourne une chaine de la forme "nom [capacit� statistique point(s)]"
	 * @return string
	 */
		public String toString() {
		return this.getName() + " [" + this.getCapacity() + " " + this.getStat() + " point(s)] ";
	}

	@Override
	public int getWeight() {
		return 1;
	}
}
