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
		StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
		int[] arr = new int[4];
		int min = 10000;
		
		for (int i = 0; i < arr.length; i++) { // 4번 반복
			if (i > 1) {
				arr[i] = Integer.parseInt(st.nextToken()) - arr[i - 2]; // 뒤의 2번은 다음 좌표값에서 x값, y값을 뺀 크기
			} else {
				arr[i] = Integer.parseInt(st.nextToken()); // 앞의 2번은 x, y값 저장 
			}
		}
		for (int a : arr) {
			if (a < min) { // 배열값 검사하면서 최소값 넣기
				min = a;
			}
		}
		bfw.write(String.valueOf(min));
		bfw.flush();
		bfw.close();
	} 
}