package lsg.buffs;

public class Talisman extends BuffItem {
	
	/**
	 * constructeur d'un talisman
	 * @param nom du talisman
	 * @param valeur du buff du talisman
	 */
	public Talisman(String name, float buff) {
		super(name, buff);
	}

	/**
	 * methode retournant la valeur de buff du talisman
	 * @return valeur de buff du talisman
	 */
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
