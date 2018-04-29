package lsg.buffs;

/**
 * Classe Ring de type BuffItem
 * @author jenni
 *
 */
public class Ring extends BuffItem {
	
	/**
	 * cree une Ring avec son nom et le buff octroye
	 * @param name nom de la bague
	 * @param buff valeur du buff octroye
	 */
	public Ring(String name, float buff) {
		super(name, buff);
	}

	/**
	 * methode qui retourne la valeur de buff de la bague
	 * @return buff valeur de buff de la bague
	 */
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
