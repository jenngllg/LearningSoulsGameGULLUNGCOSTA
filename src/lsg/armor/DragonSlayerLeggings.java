package lsg.armor;

/**
 * Classe DragonSlayerLeggings de type ArmorItem qui donne de l'armure
 * @author jenni
 *
 */
public class DragonSlayerLeggings extends ArmorItem {

	public DragonSlayerLeggings() {
		super("Dragon Slayer Leggings", (float)10.2);
	}

	/**
	 * @return 3 poids de l'armure (3 kg)
	 */
	@Override
	public int getWeight() {
		return 3;
	}
	
	
}
