package lsg.bags;

import java.util.HashSet;
import java.util.Iterator;

import lsg.LearningSoulsGame;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.BagFullException;
import lsg.weapons.Sword;

public class Bag {

	/**
	 * capacite du sac
	 */
	private int capacity;
	/**
	 * nombre de kg utilises
	 */
	private int weight;
	/**
	 * items presents dans le sac
	 */
	private HashSet<Collectible> items; 
	
	/**
	 * constructeur d'un sac
	 * @param capacite du sac
	 */
	public Bag(int capacity) {
		this.items = new HashSet<>();
		this.capacity = capacity;
	}

	/**
	 * accesseur
	 * @return capacite du sac
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * accesseur
	 * @return poids du sac
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * mutateur
	 */
	private void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	/**
	 * methode ajoutant un Collectible au sac si la place restante est suffisante
	 * @throws BagFullException 
	 */
	public void push(Collectible item) throws BagFullException {
		if (this.getWeight() >= this.getCapacity()) { throw new BagFullException(this); }
		if (item.getWeight() <= this.getCapacity() - this.getWeight()) {
			this.items.add(item);
			int sommePoids = this.getWeight() + item.getWeight();
			this.setWeight(sommePoids);
		}	
	}
	
	/**
	 * methode qui retire un item du sac
	 * @return item enleve
	 */
	public Collectible pop(Collectible item) {
		if (items.contains(item)) {
			items.remove(item);
			this.setWeight(this.getWeight() - item.getWeight());
			return item;
		}
		return null;
	}
		
	/**
	 * methode qui indique si l'item passe en parametre se trouve bien dans le sac
	 * @return true si l'item est present, false sinon 
	 */
	public boolean contains(Collectible item) {
		if (items.contains(item)) {
			return true;
		}
		return false;
	}
	
	/**
	 * methode retournant les items du sac
	 * @return items presents dans le sac
	 */
	public Collectible[] getItems() {
		return items.toArray(new Collectible[items.size()]);
	}
	
	/**
	 * methode affichant le contenu d'un sac
	 * @return contenu du sac
	 */
	public String toString() {
		String affichage = "";
		if (this.getWeight() != 0) { //si le sac n'est pas vide
			affichage = String.format("%s [ %d items | %d/%d kg ]%s", this.getClass().getSimpleName(), this.items.size(), this.getWeight(), this.getCapacity(), System.lineSeparator());
			Iterator<Collectible> i = this.items.iterator();
			while(i.hasNext()) {
				Collectible collectible = i.next();
				affichage += String.format("%s %s [%d kg]%s", LearningSoulsGame.BULLET_POINT, collectible.toString(), collectible.getWeight(), System.lineSeparator());
			}
		}
		else {
			affichage = String.format("%s [ %d items | %d/%d kg ]%s %-15s", this.getClass().getSimpleName(), this.items.size(), this.getWeight(), this.getCapacity(), " [empty]", System.lineSeparator());
		}
		return affichage;
	}
	
	/**
	 * methode transferant le contenu du sac source vers le sac de destination (dans la limite de capacite de ce dernier)
	 * @throws BagFullException 
	 */
	public static void transfer(Bag from, Bag into) throws BagFullException {
		if (from == null ||into == null) { return; }
		for(Collectible collectible : from.getItems()) {
			if (into.getCapacity() - into.getWeight() <= collectible.getWeight()) {
				throw new BagFullException(into); 
			}
			into.push(collectible);
			from.pop(collectible);
		}
	}
	
	public static void main (String[] args) {
		
		SmallBag pochetteChanel = new SmallBag();
		MediumBag sacMichaelKors = new MediumBag();
		BlackWitchVeil blackWitchVeil = new BlackWitchVeil();
		Hamburger hamburger = new Hamburger();
		Sword basicSword = new Sword();
		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
		RingedKnightArmor ringedKnightArmor1 = new RingedKnightArmor();
		RingedKnightArmor ringedKnightArmor2 = new RingedKnightArmor();
		
		try {
			sacMichaelKors.push(blackWitchVeil);
			sacMichaelKors.push(hamburger);
			sacMichaelKors.push(basicSword);
			sacMichaelKors.push(dragonSlayerLeggings);
			sacMichaelKors.push(ringedKnightArmor1);
			sacMichaelKors.push(ringedKnightArmor2);
		}
		catch (BagFullException e) {
			e.printStackTrace();
		}

		
		
//		System.out.println(pochetteChanel.toString());
//		
//		System.out.println("Pop sur " + dragonSlayerLeggings.toString());
//		pochetteChanel.pop(dragonSlayerLeggings);
//		
//		System.out.println(pochetteChanel.toString());
//		
//		System.out.println("Push sur " + dragonSlayerLeggings.toString());
//		pochetteChanel.push(dragonSlayerLeggings);
//		
//		System.out.println(pochetteChanel.toString());
//		
//		System.out.println("getItems sur " + dragonSlayerLeggings.toString());
//		
//		System.out.println(pochetteChanel.getItems().length);
//		
//		System.out.println("Contains sur " + dragonSlayerLeggings.toString());
//		
//		System.out.println(pochetteChanel.contains(basicSword));
//		pochetteChanel.pop(dragonSlayerLeggings);
//		System.out.println(pochetteChanel.contains(dragonSlayerLeggings));
		
		System.out.println(sacMichaelKors.toString());
		System.out.println(pochetteChanel.toString());
		
		try {
			transfer(sacMichaelKors, pochetteChanel);
		} catch (BagFullException e) {
			e.printStackTrace();
		}
		
		System.out.println("Après transfert :" + System.lineSeparator()); 
		System.out.println(pochetteChanel.toString());
		System.out.println(sacMichaelKors.toString());
	}
}
