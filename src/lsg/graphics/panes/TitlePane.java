package lsg.graphics.panes;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class TitlePane extends VBox {

	/**
	 * scene
	 */
	private Scene scene;
	
	/**
	 * titre
	 */
	private GameLabel titleLabel;
	
	/**
	 * duree de l'animation
	 */
	private static final Duration ANIMATION_DURATION = Duration.millis(1500);
	
	/**
	 * taille du zoom
	 */
	private static final double ZOOM_SCALE = 1.5;
	
	/**
	 * taille du zoom en Y
	 */
	private static final double ZOOM_Y = 0.25;
	
	/**
	 * constructeur
	 * @param scene
	 * @param title
	 */
	public TitlePane(Scene scene, String title) {
		this.scene = scene;
		this.titleLabel = new GameLabel(title);
		this.getChildren().add(titleLabel);
	}
	
	/**
	 * effet de zoom sur le titre + deplacement du texte
	 *  @param finishedHandler
	 */
	public void zoomIn(EventHandler<ActionEvent> finishedHandler) {
		ScaleTransition st = new ScaleTransition(ANIMATION_DURATION);
		st.setNode(titleLabel);
		st.setToX(ZOOM_SCALE);
		st.setToY(ZOOM_SCALE);
		
		TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION);
		tt.setToY(scene.getHeight()*ZOOM_Y);
		
		ParallelTransition pt = new ParallelTransition(tt, st);
		
		pt.setNode(titleLabel);
		pt.setCycleCount(1); //nb de repetitions de l'effet
		pt.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//System.out.println("Animation terminée !");
				finishedHandler.handle(event);
			}
		});
		
		pt.play();
	}
	
	/**
	 * fait retourner le titre a sa place et sa taille initiale 
	 * @param finishedHandler
	 */
	public void zoomOut(EventHandler<ActionEvent> finishedHandler) {
		ScaleTransition st = new ScaleTransition(ANIMATION_DURATION);
		st.setNode(titleLabel);
		st.setToX(1/ZOOM_SCALE);
		st.setToY(1/ZOOM_SCALE);
		
		TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION);
		tt.setToY(scene.getHeight()*0.00000125);
		
		ParallelTransition pt = new ParallelTransition(tt, st);
		
		pt.setNode(titleLabel);
		pt.setCycleCount(1); //nb de repetitions de l'effet
		pt.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//System.out.println("Animation terminée !");
				finishedHandler.handle(event);
			}
		});
		
		pt.play();
	}
	
}
