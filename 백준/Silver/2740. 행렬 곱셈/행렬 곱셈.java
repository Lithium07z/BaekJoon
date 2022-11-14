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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr1[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < M; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bfr.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr2[][] = new int[L][K];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < K; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result[][] = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < M; k++) {
					 result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		for (int temp1[] : result) {
			for (int temp2 : temp1) {
				bfw.write(String.valueOf(temp2) + " ");
			}
			bfw.write("\n");
		}
		bfw.flush();
		bfw.close();
	}
}