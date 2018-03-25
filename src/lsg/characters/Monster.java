package lsg.characters;

import java.util.ArrayList;
import java.util.List;
import lsg.buffs.Talisman;

//class Monster
public class Monster extends Character {
	
	public Talisman[] talismans;
	private static int INSTANCE_COUNT;
	private float skinThickness; 
	private static final int MAX_TALISMAN = 1; 
	
	//constructeur par défaut
	public Monster() {
		Monster.INSTANCE_COUNT++; //on ajoute 1 au nombre de monstres
		this.name = "Monster_" + INSTANCE_COUNT;
		this.talismans = new Talisman[MAX_TALISMAN];
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 100;
		this.maxStamina = 100;
		this.skinThickness = 20;
	}
	
	
	public float getSkinThickness() {
		return skinThickness;
	}


	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}

	//constructeur à un paramètre
	public Monster(String name) {
		this(); //appel au constructeur
		this.name = name; //rename
	}

	@Override //sécurité et information en cas de suppression de la méthode abstraite
	protected float computeProtection() {
		return this.getSkinThickness();
	}
	
	/**
	 * équiper le héros d'un talisman
	 */
	public void setTalisman(Talisman talisman, int slot) {
		if (slot < MAX_TALISMAN || slot > 0) {
			this.talismans[slot - 1] = talisman; // l'index du tableau commence à 0 donc on doit enlever 1
		}
	}
	
	/**
	 * retourne le total de buff du héros
	 * 
	 * @return float
	 */
	@Override
	public float getTotalBuff() {
		float sommeTalismans = 0;
		for (int i = 0; i < this.talismans.length; i++) {
			if (talismans[i] != null) {
				sommeTalismans += talismans[i].computeBuffValue();
			}
		}
		return sommeTalismans;
	}
	
	/**
	 * renvoie une chaine contenant la description des talismans portées par le
	 * héros
	 * 
	 * @return String
	 */
	public String buffToString() {
		String buffComplet = "";
		String talisman = "";
		for (int i = 0; i < this.talismans.length; i++) {
			if (this.talismans[i] != null) {
				talisman = this.talismans[i].toString();
			} else {
				talisman = "empty";
			}
			buffComplet += String.format("%-20s", i+1 + ":" + talisman);
		}
		return Character.BUFF_STAT_STRING + buffComplet + Character.TOTAL_STAT_STRING + this.getTotalBuff();
	}

	/**
	 * méthode affichant les statistiques d'un talisman en console
	 */
	public void printTalismanStats() {
		System.out.println(this.buffToString());
	}

	/**
	 * renvoie tous les talismans portés
	 * @return Talisman[]
	 */
	protected Talisman[] getTalisman() {
		List<Talisman> talismansPortesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 1; i <= this.talismans.length; i++) {
			if (this.talismans[i] != null) {
				talismansPortesArrayList.add(this.talismans[i]);
			}
		}
		// convertion de l'arraylist en array de talismans de la taille de l'arraylist
		Talisman[] talismansPortes = talismansPortesArrayList.toArray(new Talisman[talismansPortesArrayList.size()]);
		return talismansPortes;
	}
	
	
}