package lsg.characters;

import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.BagFullException;
import lsg.exceptions.ConsumeEmptyException;
import lsg.exceptions.ConsumeNullException;
import lsg.exceptions.ConsumeRepairNullWeaponException;
import lsg.exceptions.NoBagException;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {

	/**
	 * nom du personnage
	 */
	protected String name; 
	/**
	 * points de vie restants
	 */
	protected int life; 
	/**
	 * nombre maximal de points de vie
	 */
	protected int maxLife;
	/**
	 * force restante
	 */
	protected int stamina; 
	/**
	 * force maximale
	 */
	protected int maxStamina;
	/**
	 * de
	 */
	protected Dice dice; 
	/**
	 * reference vers l'arme equipee
	 */
	protected Weapon weapon;
	/**
	 * reference vers le consommable equipe
	 */
	protected Consumable consumable;
	/**
	 * reference vers le sac equipe
	 */
	protected Bag bag;

	
	protected static final String LIFE_STAT_STRING = "life";
	protected static final String STAM_STAT_STRING = "stamina";
	protected static final String PROTECT_STAT_STRING = "protection";
	protected static final String ARMOR_STAT_STRING = "armor";
	protected static final String RING_STAT_STRING = "rings";
	protected static final String BUFF_STAT_STRING = "buff";
	protected static final String ALIVE_STAT_STRING = "ALIVE";
	protected static final String DEAD_STAT_STRING = "DEAD";
	protected static final String TOTAL_STAT_STRING = "TOTAL";
	protected static final String WEAPON_STAT_STRING = "WEAPON";


	/**
	 * accesseur
	 * @return vie du personnage
	 */
	public int getLife() {
		return life;
	}

	/**
	 * mutateur
	 * @param vie du personnage
	 */
	protected void setLife(int life) {
		this.life = life;
	}

	/**
	 * accesseur
	 * @return maximum de vie du personnage
	 */
	public int getMaxLife() {
		return maxLife;
	}

	/**
	 * mutateur
	 * @param maximum de vie du personnage
	 */
	protected void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	/**
	 * accesseur
	 * @return stamina du personnage
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * mutateur
	 * @param stamina du personnage
	 */
	protected void setStamina(int stamina) {
		this.stamina = stamina;
	}

	/**
	 * accesseur
	 * @return maximum de stamina du personnage
	 */
	public int getMaxStamina() {
		return maxStamina;
	}

	/**
	 * mutateur
	 * @param maximum de stamina du personnage
	 */
	protected void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	/**
	 * accesseur
	 * @return nom du personnage
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * mutateur
	 * @param nom du personnage
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * accesseur
	 * @return arme du personnage
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * mutateur
	 * @param arme du personnage
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	/**
	 * accesseur
	 * @return consommable du personnage
	 */
	public Consumable getConsumable() {
		return consumable;
	}

	/**
	 * mutateur
	 * @param consommable du personnage
	 */
	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}
	
	/**
	 * constructeur par défaut
	 */
	public Character() {
		this.name = "Ynovator";
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 50;
		this.maxStamina = 50;
		this.dice = new Dice(101);
		this.bag = new SmallBag(); 
	}
	
	
	/**
	 * constructeur à un paramètre
	 * @param nom du personnage
	 */
	public Character(String name) {
		/**
		 * appel au constructeur
		 */
		this(); 
		this.name = name; 
	}
	
	/**
	 * methode retournant les statistiques d'un personnage
	 * @return chaine de la forme [Personnage] Nom LIFE:x STAMINA:x PROTECTION:x BUFF:x (ALIVE/DEAD)
	 */
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s", "[" + this.getClass().getSimpleName() + "]", this.getName(),  Character.LIFE_STAT_STRING + ":" + this.getLife(), Character.STAM_STAT_STRING + ":" + this.getStamina(), Character.PROTECT_STAT_STRING + ":" + this.computeProtection(), Character.BUFF_STAT_STRING + ":" + this.getTotalBuff(), "(" + (isAlive()? Character.ALIVE_STAT_STRING : Character.DEAD_STAT_STRING) + ")");
	}
	
	/**
	 *  methode affichant les statistiques d'un heros en console
	 */
	public void printStats() {
		System.out.println(this.toString());
	}
	
	
	/**
	 * methode permettant de savoir si le personnage est vivant
	 * @return true si il est vivant, false sinon
	 */
	protected boolean isAlive() {
		return this.getLife() > 0; 
	}
	
	/**
	 * methode renvoyant le total de la valeur des buffs d'un personnage
	 * @return total de la valeur des buffs
	 */
	public abstract float getTotalBuff();
	
	/**
	 * methode representant la protection du personnage
	 * @return protection du personnage
	 */
	abstract protected float computeProtection();
	
	/**
	 * methode permettant d'attaquer avec une arme
	 * @return degats portes par le personnage 
	 * @throws WeaponNullException 
	 * @throws WeaponBrokenException 
	 * @throws StaminaEmptyException 
	 */
	private int attackWith(Weapon weapon) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		int damage;
		if (weapon == null) { throw new WeaponNullException(); }
		if (weapon.isBroken()) { throw new WeaponBrokenException(weapon); 		}
		if (this.stamina == 0) { throw new StaminaEmptyException(); }
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
			this.stamina -= weapon.getStamCost(); //si le perso donne un coup en ayant la stamina nécessaire, la stamina d�croit du cout de la stamina de l'arme
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
	 * methode permettant d'attaquer 
	 * @return degats realises
	 * @throws WeaponNullException 
	 * @throws WeaponBrokenException 
	 * @throws StaminaEmptyException 
	 */
	public int attack() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		if (this.isAlive()) {
			return this.attackWith(this.getWeapon());
		}
		return 0;
	}
	
	/**
	 * methode calculant le nb de points de vie retires au personnage en fonction des degats recus
	 * @return degats recus
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
	 * methode permettant de boire une boisson, ce qui remonte le niveau de stamina
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 */
	private void drink(Drink boisson) throws ConsumeNullException, ConsumeEmptyException {
		if (boisson == null) {
			throw new ConsumeNullException();
		}
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
	 * methode permettant de manger de la nourriture, ce qui remonte le niveau de vie
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 */
	private void eat(Food nourriture) throws ConsumeNullException, ConsumeEmptyException {
		if (nourriture == null) {
			throw new ConsumeNullException();
		}
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
	 * methode faisant appel à drink() ou eat() en fonction du type de consommable
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws ConsumeRepairNullWeaponException 
	 */
	public void use(Consumable consumable) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
		if (consumable == null) {
			throw new ConsumeNullException();
		}
		if (consumable instanceof Food) {
			this.eat((Food)consumable);
		}
		else if (consumable instanceof Drink)  {
			this.drink((Drink)consumable);
		}
		else if (consumable instanceof RepairKit)
			try {
				this.repairWeaponWith((RepairKit)consumable);
			} catch (WeaponNullException e) {
				throw new ConsumeRepairNullWeaponException(consumable);
			}
	}
	
	/**
	 * methode permettant de réparer son arme, ce qui augmente sa durability
	 * @throws WeaponNullException 
	 */
	public void repairWeaponWith(RepairKit kit) throws WeaponNullException {
		if (this.weapon == null) { throw new WeaponNullException(); }
		System.out.println(this.getName() + " repairs " + this.weapon.toString() + " with " + kit.toString());
		int sommeDurability = this.weapon.getDurability() + kit.use();
		System.out.println("Après utilisation : " + kit.toString());
		this.weapon.setDurability(sommeDurability);
	}
	
	/**
	 * methode permettant de consommer le consommable équipé
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws ConsumeRepairNullWeaponException 
	 */
	public void consume() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
		this.use(this.getConsumable());
	}
	
	/**
	 * methode permettant d'ajouter un item dans le sac du personnage
	 * @throws NoBagException 
	 * @throws BagFullException 
	 */
	public void pickUp(Collectible item) throws NoBagException, BagFullException {
		if (this.bag == null) { throw new NoBagException(); }
		if (this.bag.getCapacity() - item.getWeight() >= item.getWeight()) {
			this.bag.push(item);
			System.out.println(this.getName() + " picks up " + item.toString());
		}
	}
	
	/**
	 * methode permettant de supprimer un item du sac du personnage
	 * @return item supprime
	 * @throws NoBagException 
	 */
	public Collectible pullOut(Collectible item) throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		if (this.bag.contains(item)) {
			this.bag.pop(item);
			System.out.println(this.getName() + " pulls out " + item.toString());
			return item;
		}
		return null;
	}

	/**
	 * accesseur
	 * @return sac du character
	 */
	public Bag getBag() {
		return bag;
	}

	/**
	 * methode permettant d'afficher le contenu du sac
	 */
	public void printBag() {
		if (this.bag != null) {
			System.out.println("BAG : " + this.bag.toString()); 
		}
		else {
			System.out.println("BAG : null");
		}
	}
	
	/**
	 * methode permettant de retourner la taille du sac du personnage
	 * @return capacite totale du sac
	 * @throws NoBagException 
	 */
	public int getBagCapacity() throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		return this.bag.getCapacity();
	}
	
	/**
	 * methode permettant de retourner le nombre de slots encore disponibles dans le sac du personnage
	 * @return capacite restante
	 * @throws NoBagException 
	 */
	public int getBagWeight() throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		return this.bag.getCapacity() - this.bag.getWeight();
	}
	
	/**
	 * methode permettant de retourner un tableau contenant les items contenus dans le sac du personnage
	 * @return items contenus dans le sac
	 * @throws NoBagException 
	 */
	public Collectible[] getBagItems() throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		return this.bag.getItems();
	}
	
	/**
	 * methode permettant de remplacer le sac du personnage par le sac passe en parametre
	 * les items sont deplaces dans le nouveau dans la limite de sa capacite
	 * @return l'ancien sac
	 * @throws BagFullException 
	 */
	public Bag setBag(Bag bag) throws BagFullException {
		
		Bag oldBag = this.bag;
		String oldBagName;
		String bagName;
		
		if (oldBag == null) {
			oldBagName = "null";
		}
		else {
			oldBagName = oldBag.getClass().getSimpleName();
		}
		if (bag == null) {
			bagName = "null";
		}
		else {
			bagName = this.bag.getClass().getSimpleName();
		}
		
		Bag.transfer(oldBag, bag);
		this.bag = bag;
		System.out.println(this.getName() + " changes  " + oldBagName + " for " + bagName);
		return oldBag;
	}
	
	/**
	 * methode permettant d'equiper l'arme passee en parametre dans le sac et l'equipe (donc la retire du sac)
	 * ne fait rien si l'arme n'est pas dans le sac
	 * @throws NoBagException 
	 */
	public void equip(Weapon weapon) throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		Collectible c = this.bag.pop(weapon);
		if (c != null) {
			this.weapon = (Weapon)c;
			System.out.println(this.getName() + " pulls out " + this.weapon.toString());
		}
	}
	
	/**
	 * methode permettant d'equiper le consumable passe en parametre dans le sac et l'equipe (donc le retire du sac)
	 * ne fait rien si le consumable n'est pas dans le sac
	 * @throws NoBagException 
	 */
	public void equip(Consumable consumable) throws NoBagException {
		if (this.bag == null) { throw new NoBagException(); }
		Collectible c = this.bag.pop(consumable);
		if (c != null) {
			this.consumable = (Consumable)c;
			System.out.println(this.getName() + " pulls out " + this.consumable.toString());
		}
	}
	
	//on aurait aussi pu utiliser une seule méthode pour les 2 méthodes au dessus (equip(Collectible collectible) avec des instanceof) 
	
	/**
	 * methode permettant de consommer instantanement et sans choisir le premier consommable du bon type trouve
	 * @param type de consommable voulu
	 * @return consommable utilise, ou null si aucun consommable du type n'a ete trouve
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws ConsumeRepairNullWeaponException 
	 * @throws NoBagException 
	 */
	private Consumable fastUseFirst(Consumable type) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
		String action = "";
		Consumable item = null; //initialisation du consommable
		for (int i = 0; i < this.bag.getItems().length && item == null; i++) { //cette boucle s'arrete quand elle trouve le consommable approprie
			if (!(this.bag.getItems()[i] instanceof Consumable)) {  //si l'objet trouve n'est pas un consommable (arme, par ex)
				continue; //continue la boucle jusqu'a trouver
			}
			
			item = (Consumable)this.bag.getItems()[i];	
			
			if (type instanceof Drink && item instanceof Drink) {
				action = " drinks ";
			}
			else if (type instanceof Food  && item instanceof Food) {
				action = " eats ";
			}
			else if (type instanceof RepairKit  && item instanceof RepairKit) {
				action = " uses ";
			}
			else {
				item = null; //si nous avons un consommable non Drink, non Food et non RepairKit => continue la boucle pour trouver l'item voulu
			}
		}
		
		//if (item == null) return null; //si dans le sac aucun element ne convient, ne fait pas ce qu'il y a en dessous
		
		//fouille le sac et prend le premier item du type voulu
		System.out.println(this.getName() + action + "FAST :");
		
		//consomme l'item
		this.use(item);
		
		if (item.getCapacity() == 0) {
			//enleve le consumable du sac
			this.pullOut(item);
		}			
		
		return item; 
	}
	
	/**
	 * consomme la premiere boisson trouvee dans le sac
	 * @param boisson
	 * @return boisson 
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws NoBagException 
	 */
	public Drink fastDrink() throws ConsumeNullException, ConsumeEmptyException, NoBagException {
		try {
			return (Drink)this.fastUseFirst(new Drink("triche", 1, "1"));
			//on fait ceci pour recuperer la classe de l'objet cree
		} catch (ConsumeRepairNullWeaponException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * consomme la premiere nourriture trouvee dans le sac
	 * @param nourriture
	 * @return nourriture 
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws NoBagException 
	 */
	public Food fastEat() throws ConsumeNullException, ConsumeEmptyException, NoBagException {
		try {
			return (Food)this.fastUseFirst(new Food("triche", 1, "1"));
			//on fait ceci pour recuperer la classe de l'objet cree
		} catch (ConsumeRepairNullWeaponException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * consomme la premiere charge du kit trouve dans le sac
	 * @param kit
	 * @return kit 
	 * @throws ConsumeNullException 
	 * @throws ConsumeEmptyException 
	 * @throws ConsumeRepairNullWeaponException 
	 * @throws NoBagException 
	 */
	public RepairKit fastRepair() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
		return (RepairKit)this.fastUseFirst(new RepairKit());
		//on fait ceci pour recuperer la classe de l'objet cree
	}
	
	/**
	 * methode permettant d'afficher l'arme equipee
	 */
	public void printWeapon() {
		String affichage;
		if (this.weapon != null) {
			affichage = this.weapon.toString();
		}
		else {
			affichage = "null";
		}
		System.out.println(Character.WEAPON_STAT_STRING + " : " + affichage);
	}
	
	/**
	 * methode permettant d'afficher le consumable
	 */
	public void printConsumable() {
		if (this.consumable == null) {
			System.out.println("CONSUMABLE : null"); 
		}
		else {
			System.out.println("CONSUMABLE : " + this.consumable.toString()); 
		}
	}
	

	
	
}
