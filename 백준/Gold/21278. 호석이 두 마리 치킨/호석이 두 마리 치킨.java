import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int result = Integer.MAX_VALUE;
		int X = Integer.MAX_VALUE;
		int Y = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A][B] = graph[B][A] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (graph[i][j] == INF) {
//					System.out.print("N ");
//				} else {
//					System.out.print(graph[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
					int sum = 0;
				
					for (int k = 0; k < N; k++) {
						sum += Math.min(graph[i][k], graph[j][k]);
					}
					
					if (result > sum) {
						result = sum;
						X = i;
						Y = j;
					}
			}
		}

		bw.write((X + 1) + " " + (Y + 1) + " " + result * 2);
		bw.flush();
		bw.close();
	}
}