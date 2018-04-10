package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible {

	/** 
	 * nom de la piece
	 */
	protected String name; 
	/** 
	 * valeur d'armure de l'item 
	 */
	protected float armorValue;

   /**
    * constructeur a 2 parametres permettant de nommer et fixer la valeur d'armure d'une piece lors de son instanciation
    */
	public ArmorItem(String name, float armorValue) {
		this.name = name;
		this.armorValue = armorValue;
	}

	/**
	 * accesseur public en lecture
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * accesseur public en lecture
	 */
	public float getArmorValue() {
		return armorValue;
	}
	
	/**
	 * methode retournant les statistiques d'une armure
	 * @return String
	 */
	public String toString() {
		return this.getName() + "(" + this.getArmorValue() + ")";
	}
	
	/**
	 * methode affichant les statistiques d'une armure
	 */
	public void printStats() {
		System.out.println(this.toString());
	}

	
	/**
	 * methode affichant le poids d'une armure
	 */
	@Override
	public int getWeight() {
		return 4;
	}
	
}
