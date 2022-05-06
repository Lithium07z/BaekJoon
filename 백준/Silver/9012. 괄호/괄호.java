import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayStack<String> stack = new ArrayStack<String>();
		int loop = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < loop; i++) {
			stack.checkParentheses(bfr.readLine());
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

	public E peek() { // 스택 top 항목의 내용만을 리턴
		if (isEmpty()) {
			throw new EmptyStackException();
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
			throw new EmptyStackException();
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
		for (int i = 0; i < size(); i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}

	public void checkParentheses(String s) {
		Loop: for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // 괄호면
				push((E) "("); // 스택에 저장
			} else if (s.charAt(i) == ')') { // 닫는 괄호면
				String compare = null;
				if (s.charAt(i) == ')') { // 닫는 괄호의
					compare = "("; // 짝이되는 괄호를 compare에 넣고
				}
				for (int j = 0; j < size(); j++) {
					if (String.valueOf(pop()).equals(compare)) { // 같으면
						continue Loop; // 다음 검사로
					}
				}
				System.out.println("NO");
				return ; // 다르면 false 리턴
			} 
		}
		if (size() != 0) { // 검사 끝났는데 스택에 뭔가 있으면 개행된 괄호가 있다는 거니까
			int fixedSize = size();
			for (int i = 0; i < fixedSize; i++) { // 스택안에 남는 값이 없도록
				pop(); // 다 빼버림
			}
			System.out.println("NO");
			return ; // 그리고 false 리턴
		}
		System.out.println("YES");
		return ; // 아니면 true
	}
}