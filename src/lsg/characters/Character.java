package lsg.characters;

import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {

	protected String name; //nom du personnage
	protected int life; //points de vie restants
	protected int maxLife; //nombre maximal de points de vie
	protected int stamina; //force restante
	protected int maxStamina; //force maximale
	protected Dice dice; //dé
	protected Weapon weapon; //référence vers l'arme équipée
	protected Consumable consumable; // référence vers le consommable équipé

	protected static final String LIFE_STAT_STRING = "life";
	protected static final String STAM_STAT_STRING = "stamina";
	protected static final String PROTECT_STAT_STRING = "protection";
	protected static final String ARMOR_STAT_STRING = "armor";
	protected static final String BUFF_STAT_STRING = "buff";
	protected static final String ALIVE_STAT_STRING = "ALIVE";
	protected static final String DEAD_STAT_STRING = "DEAD";
	protected static final String TOTAL_STAT_STRING = "TOTAL";


	//getters et setters générés automatiquement
	public int getLife() {
		return life;
	}

	protected void setLife(int life) {
		this.life = life;
	}

	public int getMaxLife() {
		return maxLife;
	}

	protected void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public int getStamina() {
		return stamina;
	}

	protected void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	protected void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Consumable getConsumable() {
		return consumable;
	}

	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}
	
	//constructeur par défaut
	public Character() {
		this.name = "Ynovator";
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 50;
		this.maxStamina = 50;
		this.dice = new Dice(101);
	}
	
	
	//constructeur à un paramètre
	public Character(String name) {
		this(); //appel au constructeur
		this.name = name; //rename
	}
	
	/**
	 * méthode retournant les statistiques d'un personnage
	 * @return String
	 */
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s", "[" + this.getClass().getSimpleName() + "]", this.getName(),  Character.LIFE_STAT_STRING + ":" + this.getLife(), Character.STAM_STAT_STRING + ":" + this.getStamina(), Character.PROTECT_STAT_STRING + ":" + this.computeProtection(), Character.BUFF_STAT_STRING + ":" + this.getTotalBuff(), "(" + (isAlive()? Character.ALIVE_STAT_STRING : Character.DEAD_STAT_STRING) + ")");
	}
	
	/**
	 *  méthode affichant les statistiques d'un héros en console
	 */
	public void printStats() {
		System.out.println(this.toString());
	}
	
	
	/**
	 * méthode permettant de savoir si le personnage est vivant
	 * @return boolean
	 */
	protected boolean isAlive() {
		return this.getLife() > 0; 
	}
	
	public abstract float getTotalBuff();
	
	/**
	 * méthode représentant la protection du personnage
	 * @return float
	 */
	abstract protected float computeProtection();
	
	/**
	 * méthode permettant d'attaquer avec une arme
	 * @return int
	 */
	private int attackWith(Weapon weapon) {
		int damage;
		if (weapon.isBroken()) {
			return 0;
		}
		int precision = this.dice.roll();
		if (precision == 0) {
			damage = weapon.getMinDamage();
		}
		else if (precision == 100) {
			damage = weapon.getMaxDamage();
		}
		else {
			damage = Math.round(((precision/100f) * (weapon.getMaxDamage() - weapon.getMinDamage())) + weapon.getMinDamage());
		}
		if (this.stamina >= weapon.getStamCost()) {
			this.stamina -= weapon.getStamCost(); //si le perso donne un coup en ayant la stamina n�cessaire, la stamina d�croit du cout de la stamina de l'arme
		}
		else {
			float pourcentage = this.stamina/weapon.getStamCost()*100; //on calcule le pourcentage de stamina possédé
			this.stamina = 0; 
			damage = Math.round(pourcentage * damage); //les dégats sont proportionnels au pourcentage de stamina possédé
		}
		weapon.use();
		return Math.round(damage*(1+this.getTotalBuff()/100));//augmentation des dégats grâce aux buffs
	}
	
	/**
	 * méthode permettant d'attaquer 
	 * @return int (degats r�alis�s)
	 */
	public int attack() {
		if (this.isAlive()) {
			return this.attackWith(this.getWeapon());
		}
		return 0;
	}
	
	/**
	 * méthode permettant d'attaquer avec une arme
	 * @return int (dégats reçus)
	 */
	public int getHitWith(int value) {
		if (computeProtection() >= 100) {
			return 0;
		}
		int calculateDamages = Math.round(value*(1-computeProtection()/100));
		int realDamages = this.getLife() > calculateDamages ? calculateDamages : this.getLife();
		this.setLife(this.getLife() - realDamages);
		return realDamages;
	}
	
	/**
	 * méthode permettant de boire une boisson, ce qui remonte le niveau de stamina
	 */
	private void drink(Drink boisson) {
		System.out.println(this.getName() + " drinks " + boisson.toString());
		int sommeStamina = this.getStamina() + boisson.use();
		System.out.println("Après utilisation : " + boisson.toString());
		if (sommeStamina > this.getMaxStamina()) {
			this.setStamina(this.getMaxStamina());
		}
		else {
			this.setStamina(sommeStamina);
		}
	}
	
	/**
	 * méthode permettant de manger de la nourriture, ce qui remonte le niveau de vie
	 */
	private void eat(Food nourriture) {
		System.out.println(this.getName() + " eats " + nourriture.toString());
		int sommeVie = this.getLife() + nourriture.use();
		System.out.println("Après utilisation : " + nourriture.toString());
		if (sommeVie > this.getMaxLife()) {
			this.setLife(this.getMaxLife());
		}
		else {
			this.setLife(sommeVie);
		}
	}

	/**
	 * méthode faisant appel à drink() ou eat() en fonction du type de consommable
	 */
	public void use(Consumable consumable) {
		if (consumable instanceof Food) {
			this.eat((Food)consumable);
		}
		else if (consumable instanceof Drink)  {
			this.drink((Drink)consumable);
		}
		else if (consumable instanceof RepairKit)
			this.repairWeaponWith((RepairKit)consumable);
	}
	
	/**
	 * méthode permettant de réparer son arme, ce qui augmente sa durability
	 */
	public void repairWeaponWith(RepairKit kit) {
		System.out.println(this.getName() + " repairs " + this.weapon.toString() + " with " + kit.toString());
		int sommeDurability = this.weapon.getDurability() + kit.use();
		System.out.println("Après utilisation : " + kit.toString());
		this.weapon.setDurability(sommeDurability);
	}
	
	/**
	 * méthode permettant de consommer le consommable équipé
	 */
	public void consume() {
		this.use(this.getConsumable());
	}
	
}
