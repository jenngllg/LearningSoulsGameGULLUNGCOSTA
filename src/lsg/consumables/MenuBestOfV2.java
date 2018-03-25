package lsg.consumables;

import java.util.HashSet;
import java.util.Iterator;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV2 {

	protected HashSet<Consumable> menu;
	
	public void init() {
		this.menu = new HashSet<Consumable>(); //liste de valeurs uniques (on ne peut pas mettre 2 fois le même objet dedans)
		Hamburger burger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffee coffee = new Coffee();
		Whisky whisky = new Whisky();
		this.menu.add(burger);
		this.menu.add(wine);
		this.menu.add(americain);
		this.menu.add(coffee);
		this.menu.add(whisky);
	}
	
	public String toString() {
		int number = 1;
		String string = "MenuBestOfV2 :" + System.lineSeparator();
		Iterator<Consumable> i = this.menu.iterator();
		while (i.hasNext()) {
			Consumable consumable = i.next();
			string += number + " : " + consumable + System.lineSeparator();
			number++;
		}
		return string;
	}
	
	
	public static void main (String[] args) {

		MenuBestOfV2 bestOf = new MenuBestOfV2();
		bestOf.init();
		System.out.println(bestOf.toString());
		
	}
}
