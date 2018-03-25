package lsg.weapons;

import lsg.consumables.repair.RepairKit;

public class Weapon {
	
	protected String name; //nom humanis� de l'arme
	protected int minDamage; //dommages minimum pouvant être causés
	protected int maxDamage; //dommages maximums pouvant être causés avec une précision de 100%
	protected int stamCost; //coût en force pour frapper
	protected int durability; //nombre de coups pouvant être portés avant que l'arme ne se casse
	public static final String DURABILITY_STAT_STRING = "durability";
	protected static final String MIN_STAT_STRING = "min";
	protected static final String MAX_STAT_STRING = "max";
	protected static final String STAMINA_STAT_STRING = "stamina";
	
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability){
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;
		
	}

	public String getName() {
		return name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	
	/**
	 * méthode qui décrémente la durability de 1
	 */
	public void use() {
		this.durability--;
	}
	
	/**
	 * méthode indiquant si l'arme est cassée
	 * @return boolean
	 */
	public boolean isBroken() {
		return this.durability <= 0;
	}
	
	/**
	 * méthode affichant les statistiques d'un personnage en console
	 * @return String
	 */
	public String toString() {
		return String.format("%2s %2s %2s %2s", this.getName() + " (" + Weapon.MIN_STAT_STRING + ":" + this.getMinDamage(), Weapon.MAX_STAT_STRING + ":" + this.getMaxDamage(), Weapon.STAMINA_STAT_STRING + ":" + this.getStamCost(), Weapon.DURABILITY_STAT_STRING + ":" + this.getDurability() + ")");
	}
	
	public void repairWith(RepairKit kit) { 
		this.setDurability(this.getDurability() + kit.use());
	}
	
}
