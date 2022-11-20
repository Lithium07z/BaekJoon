import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(bfr.readLine());
		int arr1[][] = new int[N][N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < N; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int arr2[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < N; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					 result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		for (int temp1[] : result) {
			for (int temp2 : temp1) {
				if (temp2 != 0) {
					count++;
				}
			}
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}