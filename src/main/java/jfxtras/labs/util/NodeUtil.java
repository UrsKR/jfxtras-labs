package jfxtras.labs.util;

import javafx.scene.Node;

public class NodeUtil
{
	/**
	 * 
	 * @param node
	 * @return The X screen coordinate of the node.
	 */
	static public double screenX(Node node)
	{
		return node.getLayoutX() + node.getScene().getX() + node.getScene().getWindow().getX();
	}
	
	/**
	 * 
	 * @param node
	 * @return The Y screen coordinate of the node.
	 */
	static public double screenY(Node node)
	{
		return node.getLayoutY() + node.getScene().getY() + node.getScene().getWindow().getY();
	}
}
