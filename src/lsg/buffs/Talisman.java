package lsg.buffs;

/**
 * Classe Talisman de type BuffItem
 * @author jenni
 *
 */
public class Talisman extends BuffItem {
	
	/**
	 * cree un talisman avec un nom et un buff octroye
	 * @param name nom du talisman
	 * @param buff valeur du buff du talisman
	 */
	public Talisman(String name, float buff) {
		super(name, buff);
	}

	/**
	 * methode retournant la valeur de buff du talisman
	 * @return buff valeur de buff du talisman
	 */
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
