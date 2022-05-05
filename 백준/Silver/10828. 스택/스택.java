import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		ArrayStack<String> stack = new ArrayStack<String>();
		int loop = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < loop; i++) {
			String input = bfr.readLine();
			if (input.contains("push")) {
				stack.push(input.split(" ")[1]);
			} else if (input.contains("pop")) {
				System.out.println(stack.pop());
			} else if (input.contains("size")) {
				System.out.println(stack.size());
			} else if (input.contains("empty")) {
				if (stack.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if (input.contains("top")) {
				System.out.println(stack.top());
			}	
		}
	}
}

class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스
	
	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1]; // 처음엔 크기가 1인 배열 생성
		top = -1;
	}
	
	public int size() {
		return top + 1; // 스택에 있는 항목의 수를 리턴
	}
	
	public boolean isEmpty() { // 스택이 empty면 true 리턴
		return top == -1;
	}
	
	public E top() { // 스택 top 항목의 내용만을 리턴
		if (isEmpty()) {
			return (E)("-1");
		}
		return s[top];
	}
	
	public void push(E newItem) { // push 연산
		if (size() == s.length) {
			resize(2 * s.length); // 스택을 2배의 크기로 확장
		}
		s[++top] = newItem; // 새 항목 push
	}
	
	public E pop() {
		if (isEmpty()) {
			return (E)("-1");
		}
		E item = s[top];
		s[top--] = null; // null로 초기화
		if (size() > 0 && size() == s.length / 4) { // 저장된 값이 배열의 1/4 크기면
			resize(s.length / 2); // 스택을 반으로 축소
		}
		return item;
	}
	
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 0; i < top + 1; i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}
}