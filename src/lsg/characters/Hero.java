package lsg.characters;

import java.util.ArrayList;
import java.util.List;

import lsg.armor.ArmorItem;
import lsg.bags.Collectible;
import lsg.buffs.Ring;
import lsg.exceptions.NoBagException;

/**
 * Classe Hero de type Character
 * @author jenni
 *
 */
public class Hero extends Character {

	/**
	 * pieces d'armures equipees
	 */
	public ArmorItem[] armor;
	
	/**
	 * bagues equipees
	 */
	public Ring[] rings;
	
	/**
	 * static car commun a toutes les instances
	 */
	private static final int MAX_ARMOR_PIECES = 3; 
	private static final int MAX_RINGS = 2; 

	/**
	 * cree un Hero avec 3 slots d'armure, 2 slot de bagues, le nom "Ynovator", 100 de vie, 100 de vie maximum, 100 de stamina max, 50 de stamina
	 */
	public Hero() {
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
		this.rings = new Ring[MAX_RINGS];
		this.name = "Ynovator";
		setLife(100);
		setMaxLife(100);
		setStamina(50);
		setMaxStamina(100);
	}

	/**
	 * @return rings bagues portees par le heros
	 */
	protected Ring[] getRings() {
		return rings;
	}

	/**
	 * @param rings bagues 
	 */
	protected void setRings(Ring[] rings) {
		this.rings = rings;
	}

	/**
	 * cree un Hero avec un nom
	 * @param name nom du heros
	 */
	public Hero(String name) {
		this(); // appel au constructeur
		this.name = name; // rename
	}

	/**
	 * methode qui equipe le heros d'une piece d'armure a une position (slot) donnee
	 * @param piece piece d'armure a equiper
	 * @param slot position a laquelle equiper l'armure 
	 */
	public void setArmorItem(ArmorItem piece, int slot) {
		if (slot < MAX_ARMOR_PIECES || slot > 0) {
			this.armor[slot - 1] = piece; // l'index du tableau commence a 0 donc on doit enlever 1
		}
	}

	/**
	 * methode retournant le total d'armure du heros
	 * @return sommeArmures somme des valeurs de pieces d'armures portees par le heros
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
	 * renvoie une chaine contenant la description de l'armure totale portee par le
	 * heros
	 * @return String de type "ARMOR 1:armure1(valeur1) 2:armor2(valeur2) 3:armor3(valeur3) TOTAL:total"
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
		return String.format("%-15s %-15s", Character.ARMOR_STAT_STRING.toUpperCase(), armureComplete + Character.TOTAL_STAT_STRING + ":" + this.getTotalArmor());
	}

	/**
	 * methode affichant les statistiques d'une armure en console
	 */
	public void printArmorStats() {
		System.out.println(this.armorToString());
	}

	/**
	 * renvoie toutes les pieces d'armure portees par le heros
	 * @return piecesPortees pieces portees par le heros
	 */
	protected ArmorItem[] getArmorItem() {
		List<ArmorItem> piecesPorteesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 1; i <= this.armor.length; i++) {
			if (this.armor[i] != null) {
				piecesPorteesArrayList.add(this.armor[i]);
			}
		}
		// convert de l'arraylist en array d'armoritem de la taille de l'arraylist
		ArmorItem[] piecesPortees = piecesPorteesArrayList.toArray(new ArmorItem[piecesPorteesArrayList.size()]);
		return piecesPortees;
	}

	/**
	 * methode qui renvoie une valeur permettant de calculer l'amoindrissement des degats subis par le heros
	 * @return totalArmor protection du personnage
	 */
	@Override
	protected float computeProtection() {
		return this.getTotalArmor();
	}

	/**
	 * @param ring bague a equiper
	 * @param slot endroit auquel placer la bague
	 */
	public void setRing(Ring ring, int slot) {
		if (slot < MAX_RINGS || slot > 0) {
			this.rings[slot - 1] = ring; // l'index du tableau commence a 0 donc on doit enlever 1
		}
	}
	
	/**
	 * methode qui retourne le total de buff du heros
	 * @return sommeBagues total des valeurs de buff du heros
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
	 * renvoie une chaine contenant la description des bagues portees par le heros
	 * @return String de type "BUFF: buff TOTAL: valeur totale des buffs"
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
		return String.format("%-15s", Character.BUFF_STAT_STRING.toUpperCase() + buffComplet + Character.TOTAL_STAT_STRING + this.getTotalBuff());
	}

	/**
	 * methode affichant les statistiques d'une bague en console
	 */
	public void printRingStats() {
		System.out.println(this.buffToString());
	}

	/**
	 * renvoie toutes les bagues portees
	 * @return piecesPortees bagues portees
	 */
	protected Ring[] getRing() {
		List<Ring> baguesPorteesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 0; i < this.rings.length; i++) {
			if (this.rings[i] != null) {
				baguesPorteesArrayList.add(this.rings[i]);
			}
		}
		// conversion de l'arraylist en array de ring de la taille de l'arraylist
		Ring[] piecesPortees = baguesPorteesArrayList.toArray(new Ring[baguesPorteesArrayList.size()]);
		return piecesPortees;
	}
	
	/**
	 * methode permettant d'equiper l'armure passee en parametre dans le sac et l'equipe (donc la retire du sac)
	 * ne fait rien si l'armure n'est pas dans le sac
	 * @param item de type ArmorItem a equiper
	 * @param slot emplacement auquel equiper l'item
	 * @throws NoBagException 
	 */
	public void equip(ArmorItem item, int slot) throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		Collectible c = this.bag.pop(item);
		if (c != null) {
			this.armor[slot] = (ArmorItem)c;
			System.out.println(this.getName() + " pulls out " + this.armor[slot].toString() + " and equips it !");
		}
	}
	
	/**
	 * methode permettant d'equiper la bague passee en parametre dans le sac et l'equipe (donc la retire du sac)
	 * ne fait rien si bague n'est pas dans le sac
	 * @param ring de type Ring a equiper
	 * @param slot emplacement auquel equiper la bague
	 * @throws NoBagException 
	 */
	public void equip(Ring ring, int slot) throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		Collectible c = this.bag.pop(ring);
		if (c != null) {
			this.rings[slot] = (Ring)c;
			System.out.println(this.getName() + " pulls out " + this.rings[slot].toString() + " and equips it !");
		}
	}
	
	/**
	 * renvoie une chaine contenant la description des bagues totale portees par le
	 * heros
	 * @return String de type "RINGS 1:[bague1, valeur1] 2:[bague2, valeur2]"
	 */
	public String ringToString() {
		String bagueComplete = "";
		String ring = "";
		for (int i = 0; i < this.rings.length; i++) {
			if (this.rings[i] != null) {
				ring = this.rings[i].toString();
			} else {
				ring = "empty";
			}
			bagueComplete += String.format("%-20s", i+1 + ":" + ring);
		}
		return String.format("%-15s %-15s", Character.RING_STAT_STRING.toUpperCase(), bagueComplete);
	}
	
	/**
	 * methode affichant les statistiques des bagues portees en console
	 */
	public void printRings() {
		System.out.println(this.ringToString());
	}
	
}