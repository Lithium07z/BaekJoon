import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stk = new Stack<Integer>();
		int loop = Integer.parseInt(bfr.readLine());
		int arr[] = new int[loop];
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < loop; i++) {
			while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) { // 사이즈 0인 경우 제외 + 배열에 있는 값이 스택의 가장 최근에 넣은 값보다 크면
				arr[stk.pop()] = arr[i]; // 그 인덱스위치는 전부 arr[i]번째보다 작은거니까 arr[i]번째가 오큰수가 됨 
			}
			stk.push(i); // 사이즈가 0 이거나 peek로 본 값보다 작으면 스택에 추가 
		}
		
		while (!stk.isEmpty()) { // 스택에 남아있는 값들은 오큰수가 없어 대체되지 않은 경우니까 
			arr[stk.pop()] = -1; // -1로 대체함 
		}
		
		for (int result : arr) {
			bfw.write(String.valueOf(result) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}