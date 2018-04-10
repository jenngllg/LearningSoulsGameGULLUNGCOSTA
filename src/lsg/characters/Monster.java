package lsg.characters;

import java.util.ArrayList;
import java.util.List;
import lsg.buffs.Talisman;

public class Monster extends Character {
	
	/**
	 * talismans portes par le monstre
	 */
	public Talisman[] talismans;
	/**
	 * nombre de monstres instancies
	 */
	private static int INSTANCE_COUNT;
	/**
	 * epaisseur de la peau (protection)
	 */
	private float skinThickness; 
	/**
	 * nombre de talismans pouvant etre portes par le monstre
	 */
	private static final int MAX_TALISMAN = 1; 
	
	/**
	 * constructeur par defaut
	 */
	public Monster() {
		/**
		 * ajout de 1 au nombre de monstres lors de l'instanciation d'un monstre
		 */
		Monster.INSTANCE_COUNT++; 
		this.name = "Monster_" + INSTANCE_COUNT;
		this.talismans = new Talisman[MAX_TALISMAN];
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 100;
		this.maxStamina = 100;
		this.skinThickness = 20;
	}
	
	/**
	 * accesseur
	 * @return epaisseur de la peau
	 */
	public float getSkinThickness() {
		return skinThickness;
	}

	/**
	 * mutateur
	 * @param epaisseur de la peau
	 */
	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}

	/** 
	 * constructeur a un parametre
	 * @param nom du monstre
	 */
	public Monster(String name) {
		/**
		 * appel au constructeur
		 */
		this(); 
		this.name = name;
	}

	@Override //securite et information en cas de suppression de la methode abstraite
	protected float computeProtection() {
		return this.getSkinThickness();
	}
	
	/**
	 * mutateur
	 * @param talisman a equiper
	 * @param endroit ou equiper le talisman
	 */
	public void setTalisman(Talisman talisman, int slot) {
		if (slot < MAX_TALISMAN || slot > 0) {
			this.talismans[slot - 1] = talisman; // l'index du tableau commence a 0 donc on doit enlever 1
		}
	}
	
	/**
	 * retourne le total de buff du monstre
	 * @return total de buff du monstre
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
	 * renvoie une chaine contenant la description des talismans portes par le
	 * heros
	 * @return String de la forme BUFF 1:talisman1(valeur1) TOTAL:total
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
	 * methode affichant les statistiques d'un talisman en console
	 */
	public void printTalismanStats() {
		System.out.println(this.buffToString());
	}

	/**
	 * renvoie tous les talismans portes par le monstre
	 * @return talismans portes par le monstre
	 */
	protected Talisman[] getTalisman() {
		List<Talisman> talismansPortesArrayList = new ArrayList<>(); // initialisation d'une arraylist (taille
																			// dynamique)
		for (int i = 1; i <= this.talismans.length; i++) {
			if (this.talismans[i] != null) {
				talismansPortesArrayList.add(this.talismans[i]);
			}
		}
		// convert de l'arraylist en array de talismans de la taille de l'arraylist
		Talisman[] talismansPortes = talismansPortesArrayList.toArray(new Talisman[talismansPortesArrayList.size()]);
		return talismansPortes;
	}
	
	
}