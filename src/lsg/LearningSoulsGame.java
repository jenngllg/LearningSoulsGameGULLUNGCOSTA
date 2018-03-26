package lsg;
import java.util.Iterator;
import java.util.Scanner;

import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.DragonSlayerRing;
import lsg.buffs.MoonStone;
import lsg.buffs.RingOfDeath;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.food.Hamburger;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class LearningSoulsGame {
	
	private Hero maxiHeros;
	private Monster jennyMonster;
	private Scanner scanner;
	public static String BULLET_POINT = "\u2219";
	
	public LearningSoulsGame() {
		maxiHeros = new Hero("MaxiHeros");
		jennyMonster = new Monster("JennyMonstre");
		scanner = new Scanner(System.in);
	}
	
	/**
	 * méthode permettant d'afficher le titre du jeu dans la console 
	 */
	public void title() {
		System.out.println("################################");
		System.out.println("#    THE LEARNING SOULS GAME     # ");
		System.out.println("################################");
	}
	
	/**
	 * méthode permettant d'initialiser les armes 
	 */
	public void init_v1() {
		maxiHeros.setWeapon(new Sword());
		jennyMonster.setWeapon(new Claw());
	}
	
	/**
	 * méthode permettant d'initialiser l'armure
	 */
	public void init_v2() {
		init_v1();
		maxiHeros.setArmorItem(new DragonSlayerLeggings(), 1);
	}
	
	/**
	 * méthode permettant d'initialiser les armes 
	 */
	public void init_v3() {
		init_v2();
		jennyMonster = new Lycanthrope();
	}
	
	/**
	 * méthode permettant d'initialiser les buffs 
	 */
	public void init_v4() {
		init_v2();
		maxiHeros.setRing(new RingOfDeath(), 1);
		maxiHeros.setRing(new DragonSlayerRing(), 2);
		jennyMonster.setTalisman(new MoonStone(), 1);
	}
	
	/**
	 * méthode permettant d'initialiser un consommable
	 */
	public void init_v5() {
		title();
		init_v2();
		maxiHeros.setConsumable(new Hamburger());
	}
	
	/**
	 * méthode permettant d'afficher les statistiques de chaque personnage
	 */
	private void refresh() {
		maxiHeros.printStats();
		System.out.println(LearningSoulsGame.BULLET_POINT + maxiHeros.getWeapon().toString());
		System.out.println(LearningSoulsGame.BULLET_POINT + maxiHeros.getConsumable().toString());
		jennyMonster.printStats();
	}
	
	/**
	 * méthode permettant d'afficher les statistiques de l'attaque
	 */
	private void attack(lsg.characters.Character attaquant, lsg.characters.Character victime) {
		int attaque = attaquant.attack();
		int damages = victime.getHitWith(attaque);
		System.out.println("!!! " + attaquant.getName() + " attack " + victime.getName() +  " with " + attaquant.getWeapon().getName() + " (ATTACK :" + attaque + " | DMG:" + damages + ")"); 
	}
	
	/**
	 * méthode permettant d'afficher le gagnant du combat
	 */
	private void getWinner(lsg.characters.Character heros, lsg.characters.Character monstre) {
		System.out.println("---" + (heros.getLife() > 0 && heros.getStamina() > 0 ? heros.getName() : monstre.getName()) + " WINS !!! ---");
	}
	
	/**
	 * méthode initialisant la partie & lançant le combat
	 */
	public void play_v1() {
		init_v1();
		fight1v1();
	}
	
	/**
	 * méthode équipant le héros avec une armure & lançant le combat
	 */
	public void play_v2() {
		init_v2();
		fight1v1();
	}
	
	/**
	 * méthode équipant le héros avec une armure & lançant le combat
	 */
	public void play_v3() {
		init_v3();
		fight1v1();
	}
	
	/**
	 * méthode équipant les personnages avec des buffs & lançant le combat
	 */
	public void play_v4() {
		init_v4();
		fight1v1();
	}
	
	/**
	 * méthode équipant les personnages avec des buffs & lançant le combat
	 */
	public void play_v5() {
		init_v5();
		fight1v1();
	}
	
	/**
	 * méthode permettant de lancer le combat
	 */
	private void fight1v1() {
		refresh();
		while((jennyMonster.getLife() > 0 && maxiHeros.getLife() > 0) && (jennyMonster.getStamina() > 0  && maxiHeros.getStamina() > 0)) {
			System.out.println("Veuillez appuyer sur 1 pour attaquer ou sur 2 pour consommer.");
			int action = scanner.nextInt();
			if (action == 1) {
				attack(maxiHeros, jennyMonster);
			}
			else if (action == 2) {
				maxiHeros.consume();
			}
			else {
				continue;
			}
				attack(jennyMonster, maxiHeros);
 				refresh();
		}
		getWinner(maxiHeros, jennyMonster);
	}
	
	/**
	 * méthode permettant de créer un Héros épuisé
	 */
	private void createExhaustedHero() {
		maxiHeros = new Hero("Fatigué");
		maxiHeros.getHitWith(99);
		maxiHeros.setWeapon(new Weapon("Grosse Epée", 0, 0, 1000, 100));
		maxiHeros.attack();
		maxiHeros.printStats();
	}
	
	/**
	 * méthode permettant de consommer
	 */
	private void aTable() {
		MenuBestOfV4 menu = new MenuBestOfV4();
		menu.init();
		Iterator<Consumable> i = menu.iterator();
		while (i.hasNext()) {
			maxiHeros.use(i.next());
			maxiHeros.printStats();
			System.out.println("");
		}
		System.out.println(maxiHeros.getWeapon().toString());
	}
	
	/**
	 * méthode permettant de tester les méthodes créées dans Bag
	 */
	private void testBag_v1() {
		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
		maxiHeros.pickUp(dragonSlayerLeggings);
		maxiHeros.printBag();
		maxiHeros.pullOut(dragonSlayerLeggings);
		maxiHeros.printBag();
	}
	
	
	/**
	 * méthode permettant de tester les méthodes créées dans Bag
	 */
	private void testBag_v2() {
		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
		RingOfDeath ringOfDeath = new RingOfDeath();
		maxiHeros.pickUp(dragonSlayerLeggings);
		maxiHeros.pickUp(ringOfDeath);
		maxiHeros.equip(dragonSlayerLeggings, 1);
		maxiHeros.printBag();
		maxiHeros.equip(ringOfDeath, 0);
		maxiHeros.printBag();
	}
	
	public static void main (String[] args) {
		
		LearningSoulsGame learningSoulsGame = new LearningSoulsGame();
		learningSoulsGame.testBag_v2();
	}
}
