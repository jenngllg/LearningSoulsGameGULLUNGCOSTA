package lsg.buffs;

public class Ring extends BuffItem {
	
	/**
	 * constructeur d'une Ring
	 * @param nom de la bague
	 * @param valeur du buff octroye
	 */
	public Ring(String name, float buff) {
		super(name, buff);
	}

	/**
	 * methode qui retourne la valeur de buff de la bague
	 * @return valeur de buff de la bague
	 */
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
