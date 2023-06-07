import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int INF = 987654321;
		
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
			int C = Integer.parseInt(st.nextToken());
			graph[A][B] = Math.min(graph[A][B], C);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (graph[j][k] > graph[j][i] && graph[j][k] > graph[i][k]) {
						graph[j][k] = Math.max(graph[j][i], graph[i][k]);
					}
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			if (graph[s][e] == INF) {
				bw.write("-1\n");
			} else {
				bw.write(graph[s][e] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
