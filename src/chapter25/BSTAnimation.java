package chapter25;

import chapter30.AVLTree;
import chapter30.BST;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class BSTAnimation<E extends Comparable<E>> extends Application {

	protected BTView<E> view;
	private BST<E> tree;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		tree = new AVLTree<>();
		
		BorderPane pane = new BorderPane();
		view = new BTView<>(tree);
		pane.setCenter(view);
		
		TextField tfKey = new TextField();
		tfKey.setPrefColumnCount(3);
		tfKey.setAlignment(Pos.BASELINE_RIGHT);
		Button btInsert = new Button("Insert");
		Button btDelete = new Button("Delete");
		Button updateTree = new Button("Update");
		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete, updateTree);
		hbox.setAlignment(Pos.CENTER);
		pane.setBottom(hbox);
		
		updateTree.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				view.setTree(TestBST.getTree());
				view.displayTree();
				tree = view.tree;
			}
		});
		
		btInsert.setOnAction(e -> {
			E key = (E) Integer.valueOf(tfKey.getText());
			System.out.println("btInsert = " + key);
			
			if (tree.search(key)) {
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			}
			else {
				view.tree.insert(key);
				view.displayTree();
				view.setStatus(key + " is inserted in the tree");
			}
		});
		
		btDelete.setOnAction(e -> {
			E key = (E) Integer.valueOf(tfKey.getText());
			if (!tree.search(key)) {	// key is not in the tree
				view.displayTree();
				view.setStatus(key + " is not in the tree");
			}
			else {
				tree.delete(key);
				view.displayTree();
				view.setStatus(key + " is deleted from the tree");
			}
		});
		
		Scene scene = new Scene(pane, 450, 250);
		primaryStage.setTitle("BSTAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
