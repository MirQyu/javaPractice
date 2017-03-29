package chapter25;


import chapter30.BST;
import chapter30.BST.TreeNode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView<E extends Comparable<E>> extends Pane{

	public BST<E> tree = new BST<>();
	public double radius = 15;
	public double vGap = 50;
	
	public BTView(BST<E> tree) {
		this.tree = tree;
		setStatus("Tree is empty");
	}
	
	public void setStatus(String msg) {
		getChildren().add(new Text(20, 20, msg));
	}
	
	public void setTree(BST<E> tree) {
		this.tree = tree;
	}
	
	public void displayTree() {
		this.getChildren().clear();
		if (tree.getRoot() != null) {
			displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
		}
	}

	/**
	 * display a subtree rooted at position (x, y)
	 * @param root
	 * @param d
	 * @param vGap2
	 * @param e
	 */
	private void displayTree(TreeNode<E> root, double x, double y, double hGap) {
		// TODO Auto-generated method stub
		if (root.getLeft() != null) {
			getChildren().add(new Line(x - hGap, y + vGap, x, y));
			displayTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
		}
		
		if (root.right != null) {
			getChildren().add(new Line(x + hGap, y + vGap, x, y));
			displayTree(root.right, x + hGap, y + vGap, vGap / 2);
		}
		
		Circle circle = new Circle(x, y, radius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + ""));
	}
}
