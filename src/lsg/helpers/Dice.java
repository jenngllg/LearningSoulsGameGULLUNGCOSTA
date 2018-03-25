package lsg.helpers;

import java.util.ArrayList;
import java.util.Collections;
import  java.util.Random;

//classe D�
public class Dice {
	
	private int faces; //nombre de faces du d�
	private Random random; //nombre al�atoire
	
	//constructeur permettant de choisir le nombre de faces du d�
	public Dice(int faces) {
		this.faces = faces;
	}
	
	
	//r�sultat du lancer de d�
	public int roll() {
		random = new Random();
		return random.nextInt(faces);
	}
	
	
	public static void main (String[] args) {
		
		//cr�ation du d� � 50 faces
		Dice dice = new Dice(50); //50 exclu, donc de 0 � 49 
		
		//cr�ation de l'arrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		//ajout des lancers � l'arrayList
		for (int i = 0; i < 500; i++) {
			arrayList.add(dice.roll());
		}
		
		//r�sultats
		System.out.println(arrayList);
		System.out.println("Max : " + Collections.max(arrayList));
		System.out.println("Min : " + Collections.min(arrayList));
	}
	
}
