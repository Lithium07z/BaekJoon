import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = bfr.readLine();
		Stack<String> stk = new Stack<String>();
		
		String value = ""; // 후위표기법을 적을 String 선언
		int count = 0; // 식에 소괄호만 들어온다고 가정했을 때, 식의 괄호가 완전한지 검사하는 변수
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // 연산자면
				count++; // 괄호가 추가되면 +1
				stk.push("("); // 스택에 저장 
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				int fixedSize = stk.size();
				for (int j = 0; j < fixedSize; j++) { // 안에 있는거 다 팝
					if (stk.peek().equals("(") || stk.peek().equals("+") || stk.peek().equals("-")) { // 단, 여는 괄호가 있으면 pop하지 않음
						break; // 탈출
					} else {
						value += stk.pop(); // pop한거 value에 추가
					}
				}
				stk.push(String.valueOf(s.charAt(i)));
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				// 더하기, 빼기면 자신의 우선순위보다 낮은 연산자가 top에 올때까지 pop해야 함
				int fixedSize = stk.size();
				for (int j = 0; j < fixedSize; j++) { // 안에 있는거 다 팝
					if (stk.peek().equals("(")) { // 단, 여는 괄호가 있으면 pop하지 않음
						break; // 탈출
					} else {
						value += stk.pop(); // pop한거 value에 추가
					}
				}
				stk.push(String.valueOf(s.charAt(i))); // 여는 괄호가 있어서 pop을 못하면 스택에 추가
			} else if (s.charAt(i) == ')') { // 닫는 괄호면
				int fixedSize = stk.size(); // 지금사이즈 기억하고
				for (int j = 0; j < fixedSize; j++) { // 지금 사이즈만큼 반복해서 pop
					String add = stk.pop(); // pop한 값 add에 저장해놓고 검사
					if (add.equals("(")) { // pop하다가 닫는 괄호 나오면
						break; // 거기까지
					} else {
						value += add; // 아니면 저장해놨던 add, value에 추가
					}
				}
			} else {
				value += String.valueOf(s.charAt(i)); // 피연산자인 경우 value에 추가
			}
		}
		int fixedSize = stk.size();
		for (int i = 0; i < fixedSize; i++) {
			value += stk.pop();
		} // 마지막에 스택에 남아있는 값들 전부 value에 추가
		bfw.write(value);
		bfw.flush();
		bfw.close();
	}
}