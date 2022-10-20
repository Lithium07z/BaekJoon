import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cases = Integer.parseInt(bfr.readLine());
		
		for (int k = 0; k < cases; k++) {
			st = new StringTokenizer(bfr.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int l = i - 1; l < x; l++) {
				for (int m = j - 1; m < y; m++) {
					sum += arr[l][m];
				}
			}
			bfw.write(String.valueOf(sum) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}