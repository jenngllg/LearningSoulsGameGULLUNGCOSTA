package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class MessagePane extends VBox {

	public MessagePane() {
		this.setAlignment(Pos.CENTER);
	}
	
	/**
	 * methode qui ajoute une instance de GameLabel contenant le message aux children du pane
	 * @param msg message contenu dans le GameLabel
	 */
	public void showMessage(String msg) {
		GameLabel label = new GameLabel(msg);
		label.setMinHeight(Region.USE_PREF_SIZE);
        label.setMinWidth(Region.USE_PREF_SIZE);
		this.getChildren().addAll(label);
		
		TranslateTransition tt = new TranslateTransition(Duration.millis(3000));
		tt.setNode(this);
		tt.setToY(-200);
		
		FadeTransition ft = new FadeTransition(Duration.millis(3000));
		ft.setNode(this);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);

		ParallelTransition pt = new ParallelTransition(tt, ft);
		
		pt.setNode(this);
		pt.setCycleCount(1); //nb de repetitions de l'effet
		VBox that = this;
		pt.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				that.getChildren().remove(label);
			}
		});
		
		pt.play();
		

	}
	
}
