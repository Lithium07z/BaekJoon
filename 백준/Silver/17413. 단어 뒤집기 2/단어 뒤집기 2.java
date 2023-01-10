import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stk = new Stack<Character>();
		char arr[] = br.readLine().toCharArray();
		boolean check = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '<') {
				while (!stk.isEmpty()) {
					bw.write(stk.pop());
				}
				check = !check;
			}
			if (arr[i] == '>') {
				bw.write(arr[i]);
				check = !check;
				continue;
			}
			if (arr[i] == ' ') {
				while (!stk.isEmpty()) {
					bw.write(stk.pop());
				}
				bw.write(arr[i]);
				continue;
			}
			if (check) {
				bw.write(arr[i]);
			} else {
				stk.push(arr[i]);
			}
		}
		while (!stk.isEmpty()) {
			bw.write(stk.pop());
		}
		bw.flush();
		bw.close();
	}
}