import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		long arr[] = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		
		int caseCount = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < caseCount; i++) {
			int N = Integer.parseInt(bfr.readLine());
			for (int j = 5; j <= N; j++) {
				arr[j] = arr[j - 5] + arr[j - 1];
			}
			bfw.write(String.valueOf(arr[N]) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}