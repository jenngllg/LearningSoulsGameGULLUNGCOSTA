package lsg.consumables.repair;

import lsg.consumables.Consumable;
import lsg.weapons.Weapon;

public class RepairKit extends Consumable {

	/**
	 * constructeur par defaut d'un kit de reparation
	 */
	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
	}
	
	/**
	 * surcharge de la méthode use() de consumable
	 * enleve un point à la capacite
	 * @return montant total de la capacite
	 */
	@Override
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(capacity - 1);
		return 1;
	}
	
}
