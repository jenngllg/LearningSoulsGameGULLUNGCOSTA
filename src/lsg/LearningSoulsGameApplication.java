package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.characters.Hero;
import lsg.characters.Zombie;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.HUDPane;
import lsg.graphics.panes.MessagePane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.characters.renderers.HeroRenderer;
import lsg.graphics.widgets.characters.renderers.ZombieRenderer;
import lsg.graphics.widgets.characters.statbars.StatBar;
import lsg.graphics.widgets.texts.GameLabel;
import lsg.weapons.Sword;
import lsg.weapons.ZombiesHand;

/**
 * Classe de run Learning Souls Game
 * @author jenni
 *
 */
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
	 * hero
	 */
	private Hero hero;
	
	/**
	 * heroRenderer
	 */
	private HeroRenderer heroRenderer;
	
	/**
	 * zombie
	 */
	private Zombie zombie;
	
	/**
	 * zombieRenderer
	 */
	private ZombieRenderer zombieRenderer;
	
	/**
	 * hudPane
	 */
	private HUDPane hudPane;
	
	
	/**
	 * methode permettant de creer le jeu en graphique
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
		
		hudPane = new HUDPane();
		AnchorPane.setTopAnchor(hudPane, 0.0);
		AnchorPane.setLeftAnchor(hudPane, 0.0);
		AnchorPane.setRightAnchor(hudPane, 0.0);
		AnchorPane.setBottomAnchor(hudPane, 0.0);
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
	
	/**
	 * methode permettant de lancer la demo du jeu
	 */
	private void play() {
		root.getChildren().add(animationPane);
		root.getChildren().add(hudPane);
		createHero();
		createMonster(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				hudPane.buildTop();
				hudPane.buildCenter();
				hudPane.getMessagePane().showMessage("FIGHT !");

				try {
					for (int i = 0; i < 2; ++i) {
						zombie.getHitWith(hero.attack());
						hero.getHitWith(zombie.attack());
					}
				} catch (WeaponNullException | WeaponBrokenException | StaminaEmptyException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * methode instanciant un Hero avec le nom donne par le joueur et lui donnant une instance de Sword
	 */
	private void createHero() {
		hero = new Hero(heroName);
		hero.setWeapon(new Sword());
		heroRenderer = animationPane.createHeroRenderer();
		animationPane.startDemo(heroRenderer);
		hudPane.setHeroSB(new StatBar(ImageFactory.SPRITES_ID.HERO_HEAD, hero.getName()));
		hudPane.getHeroSB().getLifeBar().progressProperty().bind(hero.lifeRateProperty());
		hudPane.getHeroSB().getStamBar().progressProperty().bind(hero.staminaRateProperty());

	}
	
	/**
	 * methode instanciant un Zombie et lui donnant une instance de main de zombie
	 * @param finishedHandler appele lorsque l'execution de createMonster sera terminee (lorsqu'il arrive au milieu de l'ecran)
	 */
	private void createMonster(EventHandler<ActionEvent> finishedHandler) {
		zombie = new Zombie();
		zombie.setWeapon(new ZombiesHand());
		zombieRenderer = animationPane.createZombieRenderer();
		animationPane.startDemo(zombieRenderer, finishedHandler);
		hudPane.setZombieSB(new StatBar(ImageFactory.SPRITES_ID.ZOMBIE_HEAD, zombie.getName()));
		hudPane.getZombieSB().getLifeBar().progressProperty().bind(zombie.lifeRateProperty());
		hudPane.getZombieSB().getStamBar().progressProperty().bind(zombie.staminaRateProperty());	
	}

	
	/**
	 * methode permettant de lancer le jeu
	 * @param args arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
