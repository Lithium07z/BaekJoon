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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int sum = 0;
		int cnt = 0;
		int[] arr = new int[1000];
		int f = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				if (cnt == 1000) {
					break;
				}
				arr[cnt] = i;
				cnt++;
			}
		}
		
		for (int i = f - 1; i < b; i++) {
			sum += arr[i];
		}
		
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}