package lsg.armor;

public class ArmorItem {

	protected String name; //nom de la pièce
	protected float armorValue; //valeur d'armure de l'item 

//constructeur à 2 paramètres permettant de nommer et fixer la valeur d'armure d'une pièce lors de son instanciation
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
	
}
