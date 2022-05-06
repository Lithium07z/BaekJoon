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
		Stack<Integer> stk = new Stack<Integer>();
		int loop = Integer.parseInt(bfr.readLine());
		int sum = 0;
		
		for (int i = 0; i < loop; i++) {
			int value = Integer.parseInt(bfr.readLine());
			if (value == 0) {
				stk.pop();
				continue;
			} 
			stk.push(value);
		}
		int fixedSize = stk.size();
		for (int i = 0; i < fixedSize; i++) {
			sum += stk.pop();
		}
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}