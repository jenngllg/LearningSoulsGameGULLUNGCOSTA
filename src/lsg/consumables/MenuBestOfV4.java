package lsg.consumables;

import java.util.Iterator;
import java.util.LinkedHashSet;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {
	
	public void init() {
		Hamburger burger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffee coffee = new Coffee();
		Whisky whisky = new Whisky();
		RepairKit kit = new RepairKit();
		this.add(burger);
		this.add(wine);
		this.add(americain);
		this.add(coffee);
		this.add(whisky);
		this.add(kit);
	}
	
	public String toString() {
		int number = 1;
		String string = "MenuBestOfV4 :" + System.lineSeparator();
		Iterator<Consumable> i = this.iterator();
		while (i.hasNext()) {
			Consumable consumable = i.next();
			string += number + " : " + consumable + System.lineSeparator();
			number++;
		}
		return string;
	}
	
	
	public static void main (String[] args) {

		MenuBestOfV4 bestOf = new MenuBestOfV4();
		bestOf.init();
		System.out.println(bestOf.toString());
		
	}
}
