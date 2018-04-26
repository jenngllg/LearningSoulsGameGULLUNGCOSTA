package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class CreationPane extends VBox {

	
	public CreationPane() {
		super();
		this.gameLabel = new GameLabel("Player Name");
		this.nameField = new TextField();
		this.getChildren().addAll(gameLabel, nameField);
	}

	/**
	 * champ nom
	 */
	private TextField nameField;
	
	/**
	 * label
	 */
	private GameLabel gameLabel;

	/**
	 * accesseur
	 * @return nameField
	 */
	public TextField getNameField() {
		return nameField;
	}
	
	
	/**
	 * duree de l'animation
	 */
	private static final Duration ANIMATION_DURATION = Duration.millis(2500);
	
	
	/**
	 * effet de zoom sur le titre + deplacement du texte
	 */
	public void fadeIn(EventHandler<ActionEvent> finishedHandler) {
		FadeTransition ft = new FadeTransition(ANIMATION_DURATION, gameLabel);
	     ft.setFromValue(0.0);
	     ft.setToValue(1.0);
	     ft.setCycleCount(1);

	     ft.playFromStart();
	     ft.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			     finishedHandler.handle(event);
			}
		});
	}
	
}
