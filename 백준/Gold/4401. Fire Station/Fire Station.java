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
		int graph[][] = new int[M][M];
		int position[] = new int[N];
		int dist[] = new int[M];
		int min = INF;
		int result = 0;
		String input = "";

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(br.readLine()) - 1;
		}

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input);
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A][B] = graph[B][A] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					if (i != j && j != k && i != k) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
		}

		for (int i = 0; i < M; i++) {
			dist[i] = INF;
			for (int j = 0; j < N; j++) {
				if (graph[i][position[j]] < dist[i]) {
					dist[i] = graph[i][position[j]];
				}
			}
		}

		for (int i = 0; i < M; i++) {
			int t1 = -1;

			for (int j = 0; j < M; j++) {
				int t2 = (graph[j][i] < dist[j]) ? graph[j][i] : dist[j];

				if (t2 > t1) {
					t1 = t2;
				}
			}
			
			if (t1 < min) {
				result = i;
				min = t1;
			}
		}

		bw.write(result + 1 + "\n");
		bw.flush();
		bw.close();
	}
}