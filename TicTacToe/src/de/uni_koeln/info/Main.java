package de.uni_koeln.info;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane root = new GridPane();
		Scene scene = new Scene(root, 384, 384);

		primaryStage.setMaxHeight(406);
		primaryStage.setMaxWidth(384);

		Random r = new Random();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				Button button = new Button();

				int next = r.nextInt(3);

				switch (next) {
				case 0:
					button.setGraphic(new ImageView(new Image(
							"https://cdn3.iconfinder.com/data/icons/virtual-notebook/16/button_close-128.png")));
					break;
				case 1:
					button.setGraphic(new ImageView(new Image(
							"https://cdn2.iconfinder.com/data/icons/font-awesome/1792/circle-o-128.png")));
					break;
				case 2:
					button.setText("");
					break;
				default:
					break;
				}

				button.setMinWidth(128D);
				button.setMaxWidth(128D);
				button.setMinHeight(128D);
				button.setMaxHeight(128D);

				button.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						Button button = (Button) event.getTarget();
						System.out.println(
								"i=[" + GridPane.getRowIndex(button) + "] j=[" + GridPane.getColumnIndex(button) + "]");
					}

				});

				root.add(button, i, j);
			}
		}
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
