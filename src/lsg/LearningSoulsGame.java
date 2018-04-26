package lsg;

import java.util.Iterator;
import java.util.Scanner;

import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.bags.Bag;
import lsg.bags.MediumBag;
import lsg.bags.SmallBag;
import lsg.buffs.DragonSlayerRing;
import lsg.buffs.MoonStone;
import lsg.buffs.RingOfDeath;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.BagFullException;
import lsg.exceptions.ConsumeEmptyException;
import lsg.exceptions.ConsumeNullException;
import lsg.exceptions.ConsumeRepairNullWeaponException;
import lsg.exceptions.NoBagException;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

	private Hero maxiHeros;
	private Monster jennyMonster;
	private Scanner scanner;
	public static String BULLET_POINT = "\u2219";

	/**
	 * constructeur permettant de creer un heros, un monstre et d'instancier un
	 * scanner
	 */
	public LearningSoulsGame() {
		maxiHeros = new Hero("MaxiHeros");
		jennyMonster = new Monster("JennyMonstre");
		scanner = new Scanner(System.in);
	}

	/**
	 * methode permettant d'afficher le titre du jeu dans la console
	 */
	public void title() {
		System.out.println("################################");
		System.out.println("#    THE LEARNING SOULS GAME     # ");
		System.out.println("################################");
		System.out.println(); 
	}

	/**
	 * methode permettant d'initialiser les armes
	 */
	public void init_v1() {
		maxiHeros.setWeapon(new Sword());
		jennyMonster.setWeapon(new Claw());
	}

	/**
	 * methode permettant d'initialiser l'armure
	 */
	public void init_v2() {
		init_v1();
		maxiHeros.setArmorItem(new DragonSlayerLeggings(), 1);
	}

	/**
	 * methode permettant d'initialiser les armes
	 */
	public void init_v3() {
		init_v2();
		jennyMonster = new Lycanthrope();
	}

	/**
	 * methode permettant d'initialiser les buffs
	 */
	public void init_v4() {
		init_v2();
		maxiHeros.setRing(new RingOfDeath(), 1);
		maxiHeros.setRing(new DragonSlayerRing(), 2);
		jennyMonster.setTalisman(new MoonStone(), 1);
	}

	/**
	 * methode permettant d'initialiser un consommable
	 */
	public void init_v5() {
		title();
		init_v2();
		maxiHeros.setConsumable(new Hamburger());
	}
	
	/**
	 * methode permettant d'afficher les statistiques de chaque personnage
	 */
	private void refresh() {
		maxiHeros.printStats();
		maxiHeros.printArmorStats();
		maxiHeros.printRings();
		maxiHeros.printConsumable();
		maxiHeros.printWeapon();
		maxiHeros.printBag();
		jennyMonster.printStats();
		jennyMonster.printWeapon();
	}

	/**
	 * methode permettant d'afficher les statistiques de l'attaque
	 * @throws WeaponNullException 
	 * @throws WeaponBrokenException 
	 * @throws StaminaEmptyException 
	 */
	private void attack(lsg.characters.Character attaquant, lsg.characters.Character victime) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException { //on veut la classe character
		int attaque = attaquant.attack();
		int damages = victime.getHitWith(attaque);
		System.out.println("!!! " + attaquant.getName() + " attack " + victime.getName() + " with "
				+ attaquant.getWeapon() + " (ATTACK :" + attaque + " | DMG:" + damages + ")");
	}

	/**
	 * methode permettant d'afficher le gagnant du combat
	 */
	private void getWinner(lsg.characters.Character heros, lsg.characters.Character monstre) {
		System.out.println("---" + (heros.getLife() > 0 && heros.getStamina() > 0 ? heros.getName() : monstre.getName())
				+ " WINS !!! ---");
	}

	/**
	 * methode initialisant la partie & lancant le combat
	 */
	public void play_v1() {
		init_v1();
		fight1v1();
	}

	/**
	 * methode equipant le heros avec une armure & lancant le combat
	 */
	public void play_v2() {
		init_v2();
		fight1v1();
	}

	/**
	 * methode equipant le heros avec une armure & lancant le combat
	 */
	public void play_v3() {
		init_v3();
		fight1v1();
	}

	/**
	 * methode equipant les personnages avec des buffs & lancant le combat
	 */
	public void play_v4() {
		init_v4();
		fight1v1();
	}

	/**
	 * methode equipant les personnages avec des buffs & lancant le combat
	 */
	public void play_v5() {
		init_v5();
		fight1v1();
	}

	/**
	 * methode permettant de lancer le combat
	 */
	private void fight1v1() {
		//refresh();
		while ((jennyMonster.getLife() > 0 && maxiHeros.getLife() > 0)
				&& (jennyMonster.getStamina() > 0 && maxiHeros.getStamina() > 0)) {
			System.out.println();
			System.out.println("Veuillez appuyer sur 1 pour attaquer ou sur 2 pour consommer.");
			int action = scanner.nextInt();
			if (action == 1) {
				try {
					attack(maxiHeros, jennyMonster);
				}
				catch (WeaponNullException e) {
					//attaque = 0
					System.out.println("No weapon has been equipped !!");
					System.out.println("!!! " + maxiHeros.getName() + " attack " + jennyMonster.getName() + " with "
							+ maxiHeros.getWeapon() + " (ATTACK : 0 | DMG : 0)");
				}
				catch (WeaponBrokenException e) {
					//attaque = 0
					System.out.println(maxiHeros.getWeapon() + " is broken !!");
					System.out.println("!!! " + maxiHeros.getName() + " attack " + jennyMonster.getName() + " with "
							+ maxiHeros.getWeapon() + " (ATTACK : 0 | DMG : 0)");
				}
				catch (StaminaEmptyException e) {
					//attaque = 0
					System.out.println("ACTION HAS NO EFFECT : no more stamina !");
				}
			}
			else if (action == 2) {
				try {
					maxiHeros.consume();
				} catch (ConsumeNullException e) {
					System.out.println("IMPOSSIBLE ACTION : no consumable has been equiped !");
				} catch (ConsumeEmptyException e) {
					System.out.println("ACTION HAS NO EFFECT : " + maxiHeros.getConsumable().getName() + " is empty !");
				} catch (ConsumeRepairNullWeaponException e) {
					System.out.println("IMPOSSIBLE ACTION : no weapon has been equiped !");
				}
			}
			else {
				continue;
			}
			try {
				attack(jennyMonster, maxiHeros);
			} catch (WeaponNullException | WeaponBrokenException | StaminaEmptyException e) {
				e.printStackTrace();
			}
			
			refresh();
		}
		getWinner(maxiHeros, jennyMonster);
	}

	/**
	 * methode permettant de creer un Heros epuise
	 */
	private void createExhaustedHero() {
		System.out.println("Create exhausted hero :");
		maxiHeros = new Hero("Fatigué");
		maxiHeros.getHitWith(99);
		maxiHeros.setWeapon(new Weapon("Grosse Epée", 0, 0, 1000, 100));
		
		try {
			maxiHeros.attack();
		} catch (WeaponNullException | WeaponBrokenException | StaminaEmptyException e) {
			e.printStackTrace();
		}
		maxiHeros.printStats();
	}

	/**
	 * methode permettant de consommer
	 */
	private void aTable() {
		MenuBestOfV4 menu = new MenuBestOfV4();
		menu.init();
		Iterator<Consumable> i = menu.iterator();
		while (i.hasNext()) {
			try {
				maxiHeros.use(i.next());
			} catch (ConsumeNullException e) {
				e.printStackTrace();
			} catch (ConsumeEmptyException e) {
				e.printStackTrace();
			} catch (ConsumeRepairNullWeaponException e) {
				e.printStackTrace();
			}
			maxiHeros.printStats();
			System.out.println("");
		}
		System.out.println(maxiHeros.getWeapon().toString());
	}

	/**
	 * methode permettant de tester les methodes creees dans Bag
	 */
//	private void testBag_v1() {
//		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
//		maxiHeros.pickUp(dragonSlayerLeggings);
//		maxiHeros.printBag();
//		maxiHeros.pullOut(dragonSlayerLeggings);
//		maxiHeros.printBag();
//	}

	/**
	 * methode permettant de tester les methodes creees dans Bag
	 */
//	private void testBag_v2() {
//		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
//		RingOfDeath ringOfDeath = new RingOfDeath();
//		maxiHeros.pickUp(dragonSlayerLeggings);
//		maxiHeros.pickUp(ringOfDeath);
//		maxiHeros.equip(dragonSlayerLeggings, 1);
//		maxiHeros.printBag();
//		maxiHeros.equip(ringOfDeath, 0);
//		maxiHeros.printBag();
//	}

	/**
	 * methode permettant de tester les methodes creees dans Bag
	 */
	private void testBag_v3() {
		Whisky whisky = new Whisky();
		Hamburger hamburger = new Hamburger();
		RepairKit repairKit = new RepairKit();
		try {
			maxiHeros.pickUp(whisky);
			maxiHeros.pickUp(hamburger);
			maxiHeros.pickUp(repairKit);
		}
		catch (BagFullException | NoBagException e) {
			e.printStackTrace();
		}
		maxiHeros.printBag();
		System.out.println("");

		try {
			maxiHeros.fastDrink();
		} catch (ConsumeEmptyException | ConsumeNullException | NoBagException e) {
			e.printStackTrace();
		}
		maxiHeros.printBag();
		try {
			maxiHeros.fastEat();
		} catch (ConsumeNullException | ConsumeEmptyException | NoBagException e) {
			e.printStackTrace();
		}
		maxiHeros.printBag();

		for (int i = 0; i < 10; i++) {
			try {
				maxiHeros.fastRepair();
			} catch (ConsumeNullException | ConsumeEmptyException | ConsumeRepairNullWeaponException | NoBagException e) {
				e.printStackTrace();
			}
			maxiHeros.printBag();
		}

	}

	private void testFinTP5() {
		
		title();
		
		//initialisation du personnage
		createExhaustedHero();

		//creation des items
		SmallBag smallBag = new SmallBag();
		MediumBag mediumBag = new MediumBag();
		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
		RingedKnightArmor ringedKnightArmor = new RingedKnightArmor();
		ShotGun shotGun = new ShotGun();
		System.out.println();
		try {
			maxiHeros.setBag(smallBag);
		} catch (BagFullException e1) {
			e1.printStackTrace();
		}
		
		//le heros ramasse les items
		try {
			maxiHeros.pickUp(shotGun);
			maxiHeros.pickUp(dragonSlayerLeggings);
			maxiHeros.pickUp(ringedKnightArmor);
		} catch (NoBagException e1) {
			e1.printStackTrace();
		} catch (BagFullException e1) {
			e1.printStackTrace();
		}

		System.out.println();
		
		//affichage de ce qu'il y a dans le sac
		maxiHeros.printBag();
		
		//changement de sac
		try {
			maxiHeros.setBag(mediumBag);
		} catch (BagFullException e1) {
			e1.printStackTrace();
		}
		System.out.println();

		//affichage de ce qu'il y a dans le sac
		maxiHeros.printBag();
		
		//creation des items
		Coffee coffee = new Coffee();
		Hamburger hamburger = new Hamburger();
		Whisky whisky = new Whisky();
		RepairKit repairKit1 = new RepairKit();
		RepairKit repairKit2 = new RepairKit();
		
		
		//le heros ramasse les items
		try {
			maxiHeros.pickUp(coffee);
			maxiHeros.pickUp(hamburger);
			maxiHeros.pickUp(whisky);
			maxiHeros.pickUp(repairKit1);
			maxiHeros.pickUp(repairKit2);
		} catch (NoBagException e1) {
			e1.printStackTrace();
		} catch (BagFullException e1) {
			e1.printStackTrace();
		}

		System.out.println();

		//affichage de ce qu'il y a dans le sac
		maxiHeros.printBag();
		
		System.out.println();
		System.out.println("--- AVANT ---");
		maxiHeros.printStats();
		maxiHeros.printArmorStats();
		maxiHeros.printWeapon();
		maxiHeros.printBag();
		
		System.out.println();
		System.out.println("--- ACTION ---");
		try {
			maxiHeros.fastDrink();
		} catch (ConsumeEmptyException | ConsumeNullException | NoBagException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			maxiHeros.fastEat();
		} catch (ConsumeEmptyException | ConsumeNullException | NoBagException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		try {
			maxiHeros.equip(shotGun);
		} catch (NoBagException e1) {
			e1.printStackTrace();
		}
		System.out.println();
		
		try {
			maxiHeros.equip(dragonSlayerLeggings, 0);
		} catch (NoBagException e1) {
			e1.printStackTrace();
		}
		System.out.println();

		try {
			maxiHeros.fastRepair();
		} catch (ConsumeRepairNullWeaponException | ConsumeEmptyException | ConsumeNullException | NoBagException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("--- APRES ---");
		maxiHeros.printStats();
		maxiHeros.printArmorStats();
		maxiHeros.printWeapon();
		maxiHeros.printBag();
	}
	
	/**
	 * methode permettant d'initialiser plein de choses (TP6)
	 */
	public void init_v6() {
		title();
		maxiHeros.setWeapon(new Sword());
		jennyMonster.setWeapon(new Claw());
		maxiHeros.setArmorItem(new DragonSlayerLeggings(), 1);
		maxiHeros.setRing(new RingOfDeath(), 1);
		maxiHeros.setRing(new DragonSlayerRing(), 2);
		jennyMonster.setTalisman(new MoonStone(), 1);
		maxiHeros.setConsumable(new RepairKit());
		

	}
	
	public void testExceptions() {
		//maxiHeros.setWeapon(null);
		//maxiHeros.setWeapon(new Weapon("Pelle cassee", 0, 100, 2, 0));
		//fight1v1();
		//maxiHeros.setBag(null);
		
		try {
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
			maxiHeros.pickUp(new Hamburger());
		} catch (BagFullException | NoBagException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		LearningSoulsGame learningSoulsGame = new LearningSoulsGame();
		learningSoulsGame.refresh();
		learningSoulsGame.testExceptions();
		learningSoulsGame.refresh();
	}
}
