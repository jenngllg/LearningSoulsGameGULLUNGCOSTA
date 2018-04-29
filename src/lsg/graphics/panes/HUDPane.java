package lsg.graphics.panes;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lsg.graphics.ImageFactory;
import lsg.graphics.widgets.characters.statbars.StatBar;

public class HUDPane extends BorderPane {

	/**
	 * message du jeu
	 */
	private MessagePane messagePane;
	
	private StatBar heroSB;
	private StatBar zombieSB;

	/**
	 * @return messagePane message du jeu
	 */
	public MessagePane getMessagePane() {
		return messagePane;
	}

	public HUDPane() {
		super();
		heroSB = new StatBar(ImageFactory.SPRITES_ID.HERO_HEAD, "name");
		zombieSB = new StatBar(ImageFactory.SPRITES_ID.ZOMBIE_HEAD, "name");
	}
	
	/**
	 * instancie messagePane et l'ajoute au centre du pane
	 */
	public void buildCenter() {
		messagePane = new MessagePane();
		
		this.setCenter(messagePane);
		BorderPane.setAlignment(messagePane, Pos.CENTER);
	}
	
	/**
	 * place borderpane au top de hudpane, instancie et ajoute heroStatBar a gauche, et monsterStatBar a droite
	 */
	public void buildTop() {
		BorderPane pane = new BorderPane();
		pane.setLeft(heroSB);
		zombieSB.flip();
		pane.setRight(zombieSB);
		BorderPane.setAlignment(zombieSB, Pos.TOP_RIGHT);

		this.setTop(pane);
		this.setPadding(new Insets(50, 0, 0, 0));
	}

	public StatBar getHeroSB() {
		return heroSB;
	}

	public void setHeroSB(StatBar heroSB) {
		this.heroSB = heroSB;
	}

	public StatBar getZombieSB() {
		return zombieSB;
	}

	public void setZombieSB(StatBar zombieSB) {
		this.zombieSB = zombieSB;
	}
	
}
