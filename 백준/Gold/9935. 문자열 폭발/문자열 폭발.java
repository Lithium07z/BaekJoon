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
		Stack<Character> stack = new Stack<>();
		String str = bfr.readLine();
		String bomb = bfr.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if (stack.size() >= bomb.length()) { // 스택 사이즈가 폭발 문자열과 같아지는 시점부터 검사 시작
				boolean check = true; // 확인용 변수 
				for (int j = 0; j < bomb.length(); j++) { // 이미 확인된 글자 제외하고 한 칸씩 뒤로가면서 확인
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						check = false; // 폭발 문자열이랑 다르면 패스 
						break;
					}
				}
				if (check) { // true이면 폭발 문자열을 발견한 것 
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop(); // 없애버림 
					}
				}
			}
		}
		
		for (Character temp : stack) {
			bfw.write(temp);
		}
		if (stack.size() == 0) {
			bfw.write("FRULA");
		}
		bfw.flush();
		bfw.close();
	}
}