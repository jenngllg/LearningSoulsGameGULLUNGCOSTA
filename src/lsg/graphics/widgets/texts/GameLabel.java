package lsg.graphics.widgets.texts;

import javafx.scene.Node;
import javafx.scene.control.Label;
import lsg.graphics.CSSFactory;

public class GameLabel extends Label {

	//constructeurs generes automatiquement (source => generate from superclass)
	public GameLabel(String text, Node graphic) {
		super(text, graphic);
		initCSS();
	}

	public GameLabel(String text) {
		super(text);
		initCSS();
	}

	public GameLabel() {
		super();
		initCSS(); 
	}
	
	/** 
	 * methode permettant de surcharger les constructeurs
	 */
	private void initCSS() {
		this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
		this.getStyleClass().addAll("game-font");
		this.getStyleClass().addAll("game-font-fx");
	}
	
}
