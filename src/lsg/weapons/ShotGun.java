package lsg.weapons;

/**
 * Classe ShotGun de type Weapon
 * @author jenni
 *
 */
public class ShotGun extends Weapon {

	/**
	 * cree un pistolet ShotGun avec 6 de dommages minimum, 20 de dommages maximum, 5 de cout de stamina et 100 de durabilite
	 */
	public ShotGun() {
		super("ShotGun", 6, 20, 5, 100);
	}
}
