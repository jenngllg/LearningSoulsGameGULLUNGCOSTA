package lsg.characters;

import java.util.ArrayList;
import java.util.List;

import lsg.armor.ArmorItem;
import lsg.bags.Collectible;
import lsg.buffs.Ring;
import lsg.consumables.Consumable;

//class Hero
//toutes les variables sont priv�es
public class Hero extends Character {

	public ArmorItem[] armor;
	public Ring[] rings;
	private static final int MAX_ARMOR_PIECES = 3; //static car commun � toutes les instances
	private static final int MAX_RINGS = 2; 

	// constructeur par d�faut
	public Hero() {
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
		this.rings = new Ring[MAX_RINGS];
		this.name = "Ynovator";
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 100;
		this.maxStamina = 50;
	}

	protected Ring[] getRings() {
		return rings;
	}

	protected void setRings(Ring[] rings) {
		this.rings = rings;
	}

	// constructeur � un param�tre
	public Hero(String name) {
		this(); // appel au constructeur
		this.name = name; // rename
	}

	/**
	 * �quiper le h�ros d'une pi�ce d'armure
	 */
	public void setArmorItem(ArmorItem piece, int slot) {
		if (slot < MAX_ARMOR_PIECES || slot > 0) {
			this.armor[slot - 1] = piece; // l'index du tableau commence � 0 donc on doit enlever 1
		}
	}

	/**
	 * retourne le total d'armure du h�ros
	 * @return float
	 */
	public float getTotalArmor() {
		float sommeArmures = 0;
		for (int i = 0; i < this.armor.length; i++) {
			if (armor[i] != null) {
				sommeArmures += armor[i].getArmorValue();
			}
		}
		return sommeArmures;
	}

	/**
	 * renvoie une chaine contenant la description de l'armure totale port�e par le
	 * h�ros
	 * 
	 * @return String
	 */
	public String armorToString() {
		String armureComplete = "";
		String piece = "";
		for (int i = 0; i < this.armor.length; i++) {
			if (this.armor[i] != null) {
				piece = this.armor[i].toString();
			} else {
				piece = "empty";
			}
			armureComplete += String.format("%-20s", i+1 + ":" + piece);
		}
		return Character.ARMOR_STAT_STRING + armureComplete + Character.TOTAL_STAT_STRING + this.getTotalArmor();
	}

	/**
	 * m�thode affichant les statistiques d'une armure en console
	 */
	public void printArmorStats() {
		System.out.println(this.armorToString());
	}

	/**
	 * renvoie toutes les pi�ces d'armure port�es
	 * @return ArmorItem[]
	 */
	protected ArmorItem[] getArmorItem() {
		List<ArmorItem> piecesPorteesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 1; i <= this.armor.length; i++) {
			if (this.armor[i] != null) {
				piecesPorteesArrayList.add(this.armor[i]);
			}
		}
		// convertion de l'arraylist en array d'armoritem de la taille de l'arraylist
		ArmorItem[] piecesPortees = piecesPorteesArrayList.toArray(new ArmorItem[piecesPorteesArrayList.size()]);
		return piecesPortees;
	}

	@Override
	protected float computeProtection() {
		return this.getTotalArmor();
	}

	/**
	 * �quiper le h�ros d'une bague
	 */
	public void setRing(Ring ring, int slot) {
		if (slot < MAX_RINGS || slot > 0) {
			this.rings[slot - 1] = ring; // l'index du tableau commence � 0 donc on doit enlever 1
		}
	}
	
	/**
	 * retourne le total de buff du h�ros
	 * 
	 * @return float
	 */
	@Override
	public float getTotalBuff() {
		float sommeBagues = 0;
		for (int i = 0; i < this.rings.length; i++) {
			if (rings[i] != null) {
				sommeBagues += rings[i].computeBuffValue();
			}
		}
		return sommeBagues;
	}
	
	/**
	 * renvoie une chaine contenant la description des bagues port�es par le
	 * h�ros
	 * 
	 * @return String
	 */
	public String buffToString() {
		String buffComplet = "";
		String ring = "";
		for (int i = 0; i < this.rings.length; i++) {
			if (this.rings[i] != null) {
				ring = this.rings[i].toString();
			} else {
				ring = "empty";
			}
			buffComplet += String.format("%-20s", i+1 + ":" + ring);
		}
		return Character.BUFF_STAT_STRING + buffComplet + Character.TOTAL_STAT_STRING + this.getTotalBuff();
	}

	/**
	 * m�thode affichant les statistiques d'une bague en console
	 */
	public void printRingStats() {
		System.out.println(this.buffToString());
	}

	/**
	 * renvoie toutes les bagues port�es
	 * @return Ring[]
	 */
	protected Ring[] getRing() {
		List<Ring> baguesPorteesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 1; i <= this.rings.length; i++) {
			if (this.rings[i] != null) {
				baguesPorteesArrayList.add(this.rings[i]);
			}
		}
		// conversion de l'arraylist en array de ring de la taille de l'arraylist
		Ring[] piecesPortees = baguesPorteesArrayList.toArray(new Ring[baguesPorteesArrayList.size()]);
		return piecesPortees;
	}
	
	/**
	 * méthode permettant d'équiper l'armure passée en paramètre dans le sac et l'équipe (donc la retire du sac)
	 * ne fait rien si l'armure n'est pas dans le sac
	 */
	public void equip(ArmorItem item, int slot) {
		Collectible c = this.bag.pop(item);
		if (c != null) {
			this.armor[slot] = (ArmorItem)c;
			System.out.println(this.getName() + " pulls out " + this.armor[slot].toString() + " and equips it !");
		}
	}
	
	/**
	 * méthode permettant d'équiper la bague passée en paramètre dans le sac et l'équipe (donc la retire du sac)
	 * ne fait rien si bague n'est pas dans le sac
	 */
	public void equip(Ring ring, int slot) {
		Collectible c = this.bag.pop(ring);
		if (c != null) {
			this.rings[slot] = (Ring)c;
			System.out.println(this.getName() + " pulls out " + this.rings[slot].toString() + " and equips it !");
		}
	}
	
}