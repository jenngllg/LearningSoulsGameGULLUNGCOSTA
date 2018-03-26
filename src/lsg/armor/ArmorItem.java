package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible {

	protected String name; //nom de la pi�ce
	protected float armorValue; //valeur d'armure de l'item 

//constructeur � 2 param�tres permettant de nommer et fixer la valeur d'armure d'une pi�ce lors de son instanciation
	public ArmorItem(String name, float armorValue) {
		this.name = name;
		this.armorValue = armorValue;
	}

	//accesseur public en lecture
	public String getName() {
		return name;
	}
	
	//accesseur public en lecture
	public float getArmorValue() {
		return armorValue;
	}
	
	/**
	 * méthode retournant les statistiques d'une armure
	 * @return String
	 */
	public String toString() {
		return this.getName() + "(" + this.getArmorValue() + ")";
	}
	
	/**
	 * méthode affichant les statistiques d'une armure
	 */
	public void printStats() {
		System.out.println(this.toString());
	}

	@Override
	public int getWeight() {
		return 4;
	}
	
}
