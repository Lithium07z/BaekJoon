import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long INF = Long.parseLong("3000000000");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()) - 1;
		int T = Integer.parseInt(st.nextToken()) - 1;
		long graph[][] = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			
			graph[u][v] = Math.min(graph[u][v], Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i != j && j != k && i != k) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
		}

		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken()) - 1;
			int b1 = Integer.parseInt(st.nextToken()) - 1;
			long c1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken()) - 1;
			int b2 = Integer.parseInt(st.nextToken()) - 1;
			long c2 = Integer.parseInt(st.nextToken());

			long min = graph[S][T];
			min = Math.min(min, graph[S][a1] + Math.min(graph[a1][b1], c1) + graph[b1][T]);
			min = Math.min(min, graph[S][a2] + Math.min(graph[a2][b2], c2) + graph[b2][T]);
			min = Math.min(min, graph[S][a1] + Math.min(graph[a1][b1], c1) + graph[b1][a2] + Math.min(graph[a2][b2], c2) + graph[b2][T]);
			min = Math.min(min, graph[S][a2] + Math.min(graph[a2][b2], c2) + graph[b2][a1] + Math.min(graph[a1][b1], c1) + graph[b1][T]);

			bw.write(min == INF ? "-1\n" : min + "\n");
		}

		bw.flush();
		bw.close();
	}
}