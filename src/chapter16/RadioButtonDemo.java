package chapter16;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo{

	protected BorderPane getPane() {
		BorderPane pane = super.getPane();
		
		VBox paneForRadioButtons = new VBox(20);
		paneForRadioButtons.setPadding(new Insets(5));
		paneForRadioButtons.setStyle("-fx-border-color: green; -fx-border-width: 2px");
		
		RadioButton rbRed = new RadioButton("Red");
		
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("Blue");
		paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
		//paneForRadioButtons.setAlignment(Pos.CENTER);
		pane.setLeft(paneForRadioButtons);
		
		ToggleGroup group = new ToggleGroup();
		
		rbRed.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		
		rbGreen.setOnAction(e -> {
			text.setFill(Color.GREEN);
		});
		
		rbBlue.setOnAction(e -> {
			text.setFill(Color.BLUE);
		});
		
		return pane;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
