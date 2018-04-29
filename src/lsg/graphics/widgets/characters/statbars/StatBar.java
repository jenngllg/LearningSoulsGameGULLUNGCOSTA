package lsg.graphics.widgets.characters.statbars;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import lsg.graphics.ImageFactory;
import lsg.graphics.ImageFactory.SPRITES_ID;
import lsg.graphics.widgets.texts.GameLabel;

public class StatBar extends BorderPane {
	
	public StatBar(SPRITES_ID sprite, String name) {
		this.setPrefHeight(100);
		this.setPrefWidth(350);
				
		this.avatar = new ImageView(ImageFactory.getSprites(sprite)[0]);
		this.avatar.setFitHeight(this.getPrefHeight());
		this.avatar.setPreserveRatio(true);
		this.setLeft(this.avatar);
		
		this.name = new GameLabel(name);
		this.name.setStyle("-fx-font-siz: 33px;");
		
		this.lifeBar = new ProgressBar();
		this.stamBar = new ProgressBar();
		this.lifeBar.setMaxWidth(Double.MAX_VALUE); //pour que le composant prenne toute la largeur de son parent
		this.stamBar.setMaxWidth(Double.MAX_VALUE);
		this.lifeBar.setStyle("-fx-accent: red"); //colorie la barre de progression
		this.stamBar.setStyle("-fx-accent: yellow");
		
		VBox layout = new VBox();
		layout.getChildren().addAll(this.name, this.lifeBar, this.stamBar);
		this.setCenter(layout);
	}
	
	private ImageView avatar;
	
	private GameLabel name;
	
	private ProgressBar lifeBar;
	
	private ProgressBar stamBar;
	
	public void flip() {
		this.setScaleX(-this.getScaleX());
		this.name.setScaleX(-this.name.getScaleX());
	}
	
	/**
	 * 
	 * @return avatar image par defaut
	 */
	public ImageView getAvatar() {
		return avatar;
	}
	
	/**
	 * 
	 * @return name nom du character
	 */
	public GameLabel getName() {
		return name;
	}

	/**
	 * 
	 * @return lifeBar barre de vie
	 */
	public ProgressBar getLifeBar() {
		return lifeBar;
	}

	/**
	 * 
	 * @return stamBar barre de stamina
	 */
	public ProgressBar getStamBar() {
		return stamBar;
	}


	
}
