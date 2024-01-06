import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N][M];
		int B[][] = new int[N][M];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					Switching(A, B, i, j);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					bw.write("-1");
					bw.flush();
					bw.close();
					return;
				}
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void Switching(int A[][], int B[][], int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				A[i][j] = A[i][j] == 0 ? 1 : 0;
			}
		}
	}
}
