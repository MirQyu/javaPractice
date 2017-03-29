package chapter31;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentClient extends Application {
	private TextField tfName = new TextField();
	private TextField tfStreet = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfZip = new TextField();

	private Button btRegister = new Button("Register to the Server");
	
	String host = "localhost";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.add(new Label("Name"), 0, 0);
		pane.add(tfName, 1, 0);
		pane.add(new Label("Street"), 0, 1);
		pane.add(tfStreet, 1, 1);
		pane.add(new Label("City"), 0, 2);
		HBox hbox = new HBox(2);
		pane.add(hbox, 1, 2);
		hbox.getChildren().addAll(tfCity, new Label("State"), tfState, new Label("Zip"), tfZip);
		pane.add(btRegister, 1, 3);
		GridPane.setHalignment(btRegister, HPos.RIGHT);
		
		pane.setAlignment(Pos.CENTER);
		tfName.setPrefColumnCount(15);
		tfStreet.setPrefColumnCount(15);
		tfCity.setPrefColumnCount(10);
		tfState.setPrefColumnCount(2);
		tfZip.setPrefColumnCount(3);
		
		btRegister.setOnAction(new ButtonListener());
		
		Scene scene = new Scene(pane, 500, 250);
		primaryStage.setTitle("StudentClient");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				Socket socket = new Socket(host, 8000);
				
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
				
				String name = tfName.getText().trim();
				String street = tfStreet.getText().trim();
				String city = tfCity.getText().trim();
				String state = tfState.getText().trim();
				String zip = tfZip.getText().trim();
				
				StudentAddress s = new StudentAddress(name, street, city, state, zip);
				toServer.writeObject(s);
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
