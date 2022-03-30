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
		int loop = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int arr[] = new int[loop];
		int count = 0;

		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 1) {
				arr[i] = 0;
			}
			for (int j = 2; j <= arr[i] - 1; j++) {
				if (arr[i] % j == 0) {
					arr[i] = 0;
				}
			}
		}
		
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] != 0) {
				count++;
			}
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}