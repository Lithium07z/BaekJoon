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
		int V = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[V][V];
		int dist = INF;
		int min = INF;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			graph[a][b] = graph[b][a] = Math.min(graph[a][b], Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				for (int k = 0; k < V; k++) {
					if (i != j && j != k && i != k) {
						if (graph[j][k] > graph[j][i] + graph[i][k]) {
							graph[j][k] = graph[j][i] + graph[i][k];
						}
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int J = Integer.parseInt(st.nextToken()) - 1;
		int S = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < V; i++) {
			if (i != J && i != S) {
				min = Math.min(min, graph[J][i] + graph[S][i]);
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (i != J && i != S && min == graph[J][i] + graph[S][i] && graph[J][i] <= graph[S][i] && dist > graph[J][i]) {
				dist = graph[J][i];
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (i != J && i != S && min == graph[J][i] + graph[S][i] && dist == graph[J][i]) {
				bw.write((i + 1) + "\n");
				bw.flush();
				bw.close();
				return;
			}
		}

		bw.write("-1");
		bw.flush();
		bw.close();
	}
}