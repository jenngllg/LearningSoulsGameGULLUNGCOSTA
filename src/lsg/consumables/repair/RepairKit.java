package lsg.consumables.repair;

import lsg.consumables.Consumable;
import lsg.weapons.Weapon;

/**
 * Classe RepairKit de type Consumable
 * @author jenni
 *
 */
public class RepairKit extends Consumable {

	/**
	 * cree un kit de reparation Repair Kit qui regenere 10 de durabilite d'une arme
	 */
	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
	}
	
	/**
	 * surcharge de la méthode use() de consumable
	 * enleve un point à la capacite
	 * @return 1 montant total de la capacite
	 */
	@Override
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(capacity - 1);
		return 1;
	}
	
}
