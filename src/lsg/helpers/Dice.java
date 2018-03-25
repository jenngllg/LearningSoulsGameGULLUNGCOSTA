package lsg.helpers;

import java.util.ArrayList;
import java.util.Collections;
import  java.util.Random;

//classe Dé
public class Dice {
	
	private int faces; //nombre de faces du dé
	private Random random; //nombre aléatoire
	
	//constructeur permettant de choisir le nombre de faces du dé
	public Dice(int faces) {
		this.faces = faces;
	}
	
	
	//résultat du lancer de dé
	public int roll() {
		random = new Random();
		return random.nextInt(faces);
	}
	
	
	public static void main (String[] args) {
		
		//création du dé à 50 faces
		Dice dice = new Dice(50); //50 exclu, donc de 0 à 49 
		
		//création de l'arrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		//ajout des lancers à l'arrayList
		for (int i = 0; i < 500; i++) {
			arrayList.add(dice.roll());
		}
		
		//résultats
		System.out.println(arrayList);
		System.out.println("Max : " + Collections.max(arrayList));
		System.out.println("Min : " + Collections.min(arrayList));
	}
	
}
