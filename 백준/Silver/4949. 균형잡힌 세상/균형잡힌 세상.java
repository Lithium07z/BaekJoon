import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stk = new Stack<String>();

		Loop : while(true) {
			String s = bfr.readLine();
			if (s.length() == 1 && s.equals(".")) {
				System.exit(0);
			}
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') { // 괄호면
					stk.push("("); // 스택에 저장
				} else if (s.charAt(i) == '[') {
					stk.push("[");
				} else if (s.charAt(i) == ')' || s.charAt(i) == ']') { // 닫는 괄호면
					String compare = null;
					if (s.charAt(i) == ')') { // 닫는 괄호의
						compare = "("; // 짝이되는 괄호를 compare에 넣고
					} else if (s.charAt(i) == ']') {
						compare = "[";
					}
					if (stk.size() != 0 && String.valueOf(stk.pop()).equals(compare)) { // 같으면
							continue; // 다음 검사로
					} else {
						stk.clear();
						System.out.println("no");
						continue Loop;
					}
				}
			}
			if (stk.size() != 0) {
				stk.clear();
				System.out.println("no");
				continue;
			}
			System.out.println("yes");
		}
	}
}
