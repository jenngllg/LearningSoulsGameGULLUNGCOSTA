package lsg.buffs;

import lsg.bags.Collectible;

/**
 * Classe BuffItem de type Collectible
 * @author jenni
 *
 */
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
	 * construit un buffItem 
	 * @param name nom du buffitem
	 * @param buff valeur du buff
	 */
	public BuffItem(String name, float buff) {
		this.name = name;
		this.buff = buff;
	}
	
	/**
	 * @return buff buff octroye par le collectible
	 */
	public float getBuff() {
		return buff;
	}

	/**
	 * @param buff buff a octroyer au collectible
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
	 * @return 1  poids du buffitem (1kg)
	 */
	@Override
	public int getWeight() {
		return 1;
	}

	/**
	 * methode affichant les statistiques d'un buff en console
	 * @return String de type "nom du buff (valeur du buff)"
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getBuff() + ")";
	}
	
	
}
