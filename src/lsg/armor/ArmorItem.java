package lsg.armor;

import lsg.bags.Collectible;

/** 
 * Classe ArmorItem de type COllectible qui donne de l'armure
 * @author jenni
 *
 */
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
    * permet de nommer et fixer la valeur d'armure d'une piece lors de son instanciation
    * @param name nom de l'armure
    * @param armorValue valeur de l'armure
    */
	public ArmorItem(String name, float armorValue) {
		this.name = name;
		this.armorValue = armorValue;
	}

	/**
	 * @return name nom de l'armure
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return armorValue valeur de l'armure
	 */
	public float getArmorValue() {
		return armorValue;
	}
	
	/**
	 * methode retournant les statistiques d'une armure
	 * @return String de type "nom de l'armure (valeur de l'armure)"
	 */
	public String toString() {
		return this.getName() + "(" + this.getArmorValue() + ")";
	}
	
	/**
	 * methode affichant les statistiques d'une armure en console
	 */
	public void printStats() {
		System.out.println(this.toString());
	}

	
	/**
	 * @return 4 poids de l'armure (4kg)
	 */
	@Override
	public int getWeight() {
		return 4;
	}
	
}
