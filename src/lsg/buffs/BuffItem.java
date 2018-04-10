package lsg.buffs;

import lsg.bags.Collectible;

public abstract class BuffItem implements Collectible {

	/**
	 * nom du buff
	 */
	protected String name;
	/**
	 * valeur du buff
	 */
	protected float buff;

	/**
	 * constructeur d'un buffitem
	 * @param nom du buffitem
	 * @param valeur du buff
	 */
	public BuffItem(String name, float buff) {
		this.name = name;
		this.buff = buff;
	}
	
	/**
	 * accesseur
	 * @return buff octroye par le collectible
	 */
	public float getBuff() {
		return buff;
	}

	/**
	 * mutateur
	 * @param buff a octroyer au collectible
	 */
	protected void setBuff(int buff) {
		this.buff = buff;
	}
	
	/**
	 * methode renvoyant la valeur de buff de l'item
	 * @return valeur de buff de l'item
	 */
	public abstract float computeBuffValue();
	
	/**
	 * accesseur
	 * @return le poids du buffitem
	 */
	@Override
	public int getWeight() {
		return 1;
	}

	/**
	 * methode affichant les statistiques d'un buff en console
	 * @return nom du buff (valeur du buff)
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getBuff() + ")";
	}
	
	
}
