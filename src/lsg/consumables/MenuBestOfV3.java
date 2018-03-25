package lsg.consumables;

import java.util.HashSet;
import java.util.Iterator;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV3 extends HashSet<Consumable> {
	
	public void init() {
		Hamburger burger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffee coffee = new Coffee();
		Whisky whisky = new Whisky();
		this.add(burger);
		this.add(wine);
		this.add(americain);
		this.add(coffee);
		this.add(whisky);
	}
	
	public String toString() {
		int number = 1;
		String string = "MenuBestOfV3 :" + System.lineSeparator();
		Iterator<Consumable> i = this.iterator();
		while (i.hasNext()) {
			Consumable consumable = i.next();
			string += number + " : " + consumable + System.lineSeparator();
			number++;
		}
		return string;
	}
	
	
	public static void main (String[] args) {

		MenuBestOfV3 bestOf = new MenuBestOfV3();
		bestOf.init();
		System.out.println(bestOf.toString());
		
	}
}
