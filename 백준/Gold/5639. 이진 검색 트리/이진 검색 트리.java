import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int root = Integer.parseInt(bfr.readLine());
		
		BST bst = new BST(root, root);
		
		while (true) {
			String temp = bfr.readLine();
			
			if (temp == null || temp.length() <= 0) {
				break;
			} else {
				bst.put(Integer.parseInt(temp), Integer.parseInt(temp));
			}
		}
		bst.print();
	}
}

class BST<Key extends Comparable<Key>, Value> {
	public Node root;

	public Node getRoot() {
		return root;
	}

	public BST(Key newId, Value newName) {
		root = new Node(newId, newName);
	}

	public Value get(Key k) {
		return get(root, k);
	}

	public Value get(Node n, Key k) {
		if (n == null) {  // k를 발견 못하는 경우
			return null;
		}
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < 노드n의 id) 왼쪽 서브트리 탐색
			return get(n.getLeft(), k);
		} 
		else if (t < 0) { // if (k > 노드n의 id) 오른쪽 서브트리 탐색
			return get(n.getRight(), k);
		} 
		else { // k를 가진 노드 발견
			return (Value) n.getValue();
		} 
	}

	public void put(Key k, Value v) {
		root = put(root, k, v);
	}

	public Node put(Node n, Key k, Value v) {
		if (n == null) {
			return new Node(k, v);
		}
		int t = n.getKey().compareTo(k);
		if (t > 0) { // if (k < 노드n의 id) 왼쪽 서브트리에 삽입
			n.setLeft(put(n.getLeft(), k, v));
		} 
		else if (t < 0) { // if (k > 노드n의 id) 오른쪽 서브트리에 삽입
			n.setRight(put(n.getRight(), k, v));
		} 
		else { // 노드 n의 name을 v로 갱신
			n.setValue(v);
		} 
		return n;
	}

	public void print() {
		print(root);
	}

	public void print(Node n) {
		if (n != null) {
			print(n.getLeft());
			print(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}
}


class Node<Key extends Comparable<Key>, Value> {
	// Key와 Value는 generic 타입이고 Key는 비교 연산을 위해 자바의 Comparable 인터페이스를 상속받음
	// 키를 비교할 때 Comparable에 선언되어 있는 compareTo 메소드를 사용해서 비교 연산을 수행
	private Key id;
	private Value name;
	private Node left, right;

	public Node(Key newId, Value newName) {
		id = newId;
		name = newName;
		left = right = null; // 왼, 오른쪽 자식 레퍼런스는 null로 초기화
	}

	public Key getKey() {
		return id;
	}

	public Value getValue() {
		return name;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setKey(Key newId) {
		id = newId;
	}

	public void setValue(Value newName) {
		name = newName;
	}

	public void setLeft(Node newLeft) {
		left = newLeft;
	}

	public void setRight(Node newRight) {
		right = newRight;
	}
}
