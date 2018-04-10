package lsg.helpers;

import java.util.ArrayList;
import java.util.Collections;
import  java.util.Random;

//classe D�
public class Dice {
	
	/**
	 * nombre de faces du de
	 */
	private int faces; 
	/** 
	 * nombre aleatoire
	 */
	private Random random; 
	
	/**
	 * constructeur d'un de
	 * @param nombre de faces du de
	 */
	public Dice(int faces) {
		this.faces = faces;
	}
	
	
	/**
	 * methode permettant de lancer le de
	 * @return resultat du lancer de de
	 */
	public int roll() {
		random = new Random();
		return random.nextInt(faces);
	}
	
	//test du lancer de de
	public static void main (String[] args) {
		
		//creation du de a 50 faces
		Dice dice = new Dice(50); //50 exclu, donc de 0 a 49 
		
		//creation de l'arrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		//ajout des lancers a l'arrayList
		for (int i = 0; i < 500; i++) {
			arrayList.add(dice.roll());
		}
		
		//affichage des resultats en console
		System.out.println(arrayList);
		System.out.println("Max : " + Collections.max(arrayList));
		System.out.println("Min : " + Collections.min(arrayList));
	}
	
}
