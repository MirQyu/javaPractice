package chapter31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application{

	@Override
	public void start(Stage primaryStage) {
		TextArea ta = new TextArea();
		
		Scene scene = new Scene(new ScrollPane(ta), 540, 250);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ServerSocket serverSocket = new ServerSocket(8000);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							ta.appendText("Server started at " + new Date() + '\n');
						}
					});
					
					Socket socket = serverSocket.accept();
					
					System.out.println("客户端连接： " + socket.getInetAddress());
					ta.appendText("Server Class socket local port: " + socket.getLocalPort() + "\n");
					ta.appendText("Server Class socket remote port: " + socket.getPort() + "\n");
					
					DataInputStream inputFromClient = new DataInputStream(
							socket.getInputStream());
					
					DataOutputStream outputToClient = new DataOutputStream(
							socket.getOutputStream());
					
					while (true) {
						double radius = inputFromClient.readDouble();
						System.out.println("server: 这里有等待？？");
						double area = radius * radius * Math.PI;
						
						outputToClient.writeDouble(area);
						
						Platform.runLater(() -> {
							ta.appendText("Radius received from client: "
									+ radius + '\n');
							ta.appendText("Area is: " + area + '\n');
						});
					}
				} 
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
