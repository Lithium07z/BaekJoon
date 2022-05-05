import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Stack<Double> stk = new Stack<Double>();
		int cnt = Integer.parseInt(bfr.readLine());
		String s = bfr.readLine();
		double[] arr = new double[cnt];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(bfr.readLine());
		}

		double front; // double 타입으로 먼저 온 피연산자 저장하는 변수
		double back; // double 타입으로 뒤에 오는 피연산자 저장하는 변수
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-') { // 연산자면
				back = stk.pop(); // 먼저 pop해서 나오는 값을 back에
				front = stk.pop(); // 다음 pop해서 나오는 값을 front에 넣는다
				if (s.charAt(i) == '*') { // 각각의 연산자에 맞는 연산 수행
					stk.push(front * back); 
				} else if (s.charAt(i) == '/') {
					stk.push(front / back);
				} else if (s.charAt(i) == '+') {
					stk.push(front + back);
				} else if (s.charAt(i) == '-') {
					stk.push(front - back);
				}
			} else {
				stk.push(Double.valueOf(arr[s.charAt(i) - 'A']));
			}
		}
		bfw.write(String.format("%.2f", stk.peek()));
		bfw.flush();
		bfw.close();
	}
}