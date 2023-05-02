import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    static int result[][];
	static int idx = 0;
	public static int[][] solution(int[][] nodeinfo) {
		Node tree[] = new Node[nodeinfo.length];
		result = new int[2][nodeinfo.length];
		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
		}
		
		Arrays.sort(tree, new Comparator<Node>() { 
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.y != o2.y)? o2.y - o1.y : o1.x - o2.x;
			}
		});
		
		for (int i = 1; i < tree.length; i++) {
			insertNode(tree[0], tree[i]);
		}		
		
		preorder(tree[0]);
		postorder(tree[0]);
		
		return result;
    }
	
	public static void insertNode(Node root, Node child) {
		if (root.x > child.x) {
			if (root.left == null) {
				root.left = child;
			} else {
				insertNode(root.left, child);
			}
		} else {
			if (root.right == null) {
				root.right = child;
			} else {
				insertNode(root.right, child);
			}
		}
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			result[0][idx++] = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			result[1][idx++ - result[0].length] = root.value;
		}
	}
}

class Node {
	int x;
	int y;
	int value;
	Node left;
	Node right;
	
	Node (int x, int y, int value, Node left, Node right) {
		this.x = x; this.y = y; this.value = value; this.left = left; this.right = right;
	}
}