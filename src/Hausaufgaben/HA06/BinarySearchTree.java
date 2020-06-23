package Hausaufgaben.HA06;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree {
	private TreeNode root;

	public boolean contains(int data) {
		TreeNode temp = root;
		while (temp != null) {
			if (temp.value == data) {
				return true;
			}
			if (temp.value > data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;

	}

	/**
	 * 
	 * @param Einzufuegender Datensatz
	 * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon
	 *         vorhanden.
	 */
	public boolean insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return true;
		}

		TreeNode temp = root;
		while (temp.value != data) {
			if (temp.value > data) {
				if (temp.left == null) {
					temp.left = new TreeNode(data);
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = new TreeNode(data);
					return true;
				}
				temp = temp.right;
			}
		}
		return false;

	}

	public void printPreorder() {
		this.printPreorder(this.root);
		System.out.println();
	}

	private void printPreorder(TreeNode t) {
		if (t == null) {
			return;
		}
		System.out.print(t.value + ", ");
		printPreorder(t.left);
		printPreorder(t.right);
	}

	public ArrayList<Integer> getLeaves() {
		ArrayList<Integer> bucket = new ArrayList<Integer>();
		getLeaves(this.root, bucket);
		return bucket;
	}

	private void getLeaves(TreeNode t, ArrayList<Integer> bucket) {
		if (t == null) {
			return;
		}
		if (t.left == null && t.right == null) {
			bucket.add(t.value);
		}
		getLeaves(t.left, bucket);
		getLeaves(t.right, bucket);
	}

	public ArrayList<Integer> getElementsInLevel(int level) {
		ArrayList<Integer> bucket = new ArrayList<Integer>();
		getElementsInLevel(level, this.root, bucket);
		return bucket;
	}

	private void getElementsInLevel(int level, TreeNode t, ArrayList<Integer> bucket) {
		if (t == null) {
			return;
		}
		if (level == 0) {
			bucket.add(t.value);
		} else {
			getElementsInLevel(level - 1, t.left, bucket);
			getElementsInLevel(level - 1, t.right, bucket);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 50);
			System.out.println(x);
			tree.insert(x);
		}
		
		for (int i = 0; i < 50; i++) {
			System.out.println(i + ": " + tree.contains(i));
		}

		// for (int i = 0; i < 10; i++) {
		// 	int x = (int) (Math.random() * 10);
		// 	System.out.println(x);
		// 	tree.insert(x);
		// }
		
		// for (int i = 0; i < 10; i++) {
		// 	System.out.println(i + ": " + tree.contains(i));
		// }

		tree.printPreorder();
		System.out.println(Arrays.toString(tree.getLeaves().toArray()));
		System.out.println(Arrays.toString(tree.getElementsInLevel(2).toArray()));

	}

}
