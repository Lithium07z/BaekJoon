import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayQueue q = new ArrayQueue();
		int loop = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < loop; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			String menu = st.nextToken();
			
			if (menu.equals("push")) {
				int value = Integer.parseInt(st.nextToken()); 
				q.push(value);
			} else if (menu.equals("pop")) {
				bfw.write(String.valueOf(q.pop()) + "\n");
			} else if (menu.equals("size")) {
				bfw.write(String.valueOf(q.size()) + "\n");
			} else if (menu.equals("empty")) {
				if (q.empty() == true) {
					bfw.write("1\n");
				} else {
					bfw.write("0\n");
				}
			} else if (menu.equals("front")) {
				bfw.write(String.valueOf(q.front()) + "\n");
			} else if (menu.equals("back")) {
				bfw.write(String.valueOf(q.back()) + "\n");
			} 
		}
		bfw.flush();
		bfw.close();
	}
}

class ArrayQueue {
	private int[] q; // 큐를 위한 배열
	private int front, rear, size;

	public ArrayQueue() { // 큐 생성자
		q = new int[2]; // 초기에 크기가 2인 배열 공간 하나는 비워야 하니까
		front = rear = size = 0;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int newItem) { // 큐 삽입 연산
		if ((rear + 1) % q.length == front) { // 비어있는 원소가 1개 뿐인 경우(큐가 full인 경우 맨처음 비우는 한 칸을 제외한 모든칸이 꽉 찬)
			resize(2 * q.length);
		}
		rear = (rear + 1) % q.length;
		q[rear] = newItem;
		size++;
	}

	public int pop() {
		int item;
		if (empty()) {
			return -1;
		}
		front = (front + 1) % q.length;
		item = q[front];
		q[front] = 0;
		size--;
		if (size > 0 && size == q.length / 4) {
			resize(q.length / 2);
		}
		return item;
	}

	private void resize(int newSize) {
		int[] t = new int[newSize];
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j % q.length];
		}
		front = 0;
		rear = size;
		q = t;
	}
	
	public int front() {
		int item;
		if (empty()) {
			return -1;
		}
		return q[(front + 1) % q.length];
	}
	
	public int back() {
		int item;
		if (empty()) {
			return -1;
		}
		return q[rear];
	}
}