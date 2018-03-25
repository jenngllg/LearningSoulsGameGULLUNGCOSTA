package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV1 {

	protected Consumable[] menu;
	
	public void init() {
		this.menu = new Consumable[5];
		Hamburger burger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffee coffee = new Coffee();
		Whisky whisky = new Whisky();
		this.menu[0] = burger;
		this.menu[1] = wine;
		this.menu[2] = americain;
		this.menu[3] = coffee;
		this.menu[4] = whisky;
	}
	
	public String toString() {
		String string = "MenuBestOfV1 :" + System.lineSeparator();
		for (int i = 0; i < this.menu.length; i++) {
			string += i+1 + " : " + this.menu[i] + System.lineSeparator(); 
		}
		return string;
	}
	
	
	public static void main (String[] args) {

		MenuBestOfV1 bestOf = new MenuBestOfV1();
		bestOf.init();
		System.out.println(bestOf.toString());
		
	}
}
