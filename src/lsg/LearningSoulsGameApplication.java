package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Learning Souls Game");
		this.root = new AnchorPane();
		// liaison de la scene au root et fixation des dimensions
		this.scene = new Scene(root, 1200, 800);
		// liaison du stage a la scene
		stage.setScene(scene);
		stage.setResizable(false);
		this.buildUI();
		addListeners();
		stage.show();
		
		startGame();
	}
	
	
	/**
	 * va recevoir une reference vers la scene de l'application
	 */
	private Scene scene;
	
	/**
	 * layout
	 */
	private AnchorPane root;
	
	/**
	 * titre du jeu
	 */
	private TitlePane gameTitle;
	
	
	/**
	 * VBox creationPane
	 */
	private CreationPane creationPane;
	
	/**
	 * nom du heros
	 */
	private String heroName;
	
	/**
	 * animation
	 */
	private AnimationPane animationPane;
	
	
	/**
	 * 
	 */
	private void buildUI() {
		//association de la feuille de style a la fenetre de l'application (stage)
		//rebuilder le projet et rafraichir l'arborescence pour qu'il soit pris en compte
		this.scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
		//root.getChildren().addAll(new GameLabel("Learning Souls Game"));
		gameTitle = new TitlePane(scene, "Learning Souls Game");
		
		root.getChildren().addAll(gameTitle);
		AnchorPane.setRightAnchor(gameTitle, 0.0);
		AnchorPane.setTopAnchor(gameTitle, 10.0);
		AnchorPane.setLeftAnchor(gameTitle, 360.0);
		
		creationPane = new CreationPane();
//		creationPane.setOpacity(0.0); 
		AnchorPane.setTopAnchor(creationPane, 375.0);
		AnchorPane.setLeftAnchor(creationPane, 462.5);
		AnchorPane.setBottomAnchor(creationPane, 0.0);
		root.getChildren().addAll(creationPane);
		
		animationPane = new AnimationPane(root);
	}
	
	/**
	 * intialisation du jeu
	 */
	private void startGame() {
		
		gameTitle.zoomIn((event -> {
			System.out.println("ZOOM terminé !");
			creationPane.fadeIn((eventBis -> {
				System.out.println("FADE terminé !");
				ImageFactory.preloadAll((() -> {
					System.out.println("Pré-chargement des images terminé !");
				}));
			}));
		}));
		

		System.out.println("Animation lancée !");
	}
	
	
	/**
	 * methode qui recupere le nom du heros dans le Pane
	 */
	private void addListeners() {
		creationPane.getNameField().setOnAction((event -> {
			heroName = creationPane.getNameField().getText();
			System.out.println("Nom du héros : " + heroName);
			if (!heroName.isEmpty()) {
				root.getChildren().remove(creationPane);
				gameTitle.zoomOut((eventBis -> {
					System.out.println("DEZOOM terminé !");
					play();
				}));
			}
		}));
	}
	
	private void play() {
		root.getChildren().add(animationPane);
		animationPane.startDemo();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
