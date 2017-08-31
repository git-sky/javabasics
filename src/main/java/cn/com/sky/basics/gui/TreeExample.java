package cn.com.sky.basics.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeExample {
	public static void main(String args[]) {
		JFrame myFrame = new JFrame("Tree Example");
		DefaultMutableTreeNode rootNode = createNodes();
		JTree tree = new JTree(rootNode);
		tree.setRootVisible(true);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(tree);
		myFrame.add("Center", pane);
		myFrame.setSize(400, 250);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

	public static DefaultMutableTreeNode createNodes() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
				"Java Stuff");
		DefaultMutableTreeNode resources = new DefaultMutableTreeNode(
				"Resources");
		DefaultMutableTreeNode tools = new DefaultMutableTreeNode("Tools");
		rootNode.add(resources);
		rootNode.add(tools);

		DefaultMutableTreeNode webSites = new DefaultMutableTreeNode(
				"Web Sites");
		DefaultMutableTreeNode books = new DefaultMutableTreeNode("Books");
		resources.add(webSites);
		resources.add(books);

		DefaultMutableTreeNode magazines = new DefaultMutableTreeNode(
				"Magazines");
		magazines.add(new DefaultMutableTreeNode("Javology"));
		magazines.add(new DefaultMutableTreeNode("JavaWorld"));

		webSites.add(new DefaultMutableTreeNode("JavaSoft"));
		webSites.add(new DefaultMutableTreeNode("Gamelan"));
		webSites.add(magazines);

		books.add(new DefaultMutableTreeNode("Special Edition Using Java 1.2"));
		tools.add(new DefaultMutableTreeNode("JBuilder"));
		tools.add(new DefaultMutableTreeNode("Visual J++"));
		tools.add(new DefaultMutableTreeNode("Visual Age for Java"));
		tools.add(new DefaultMutableTreeNode("Apptivity"));

		return rootNode;
	}
}
