import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final long INF = Long.MAX_VALUE;
	static int vertex;
	static long graph[][];
	static long dist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		graph = new long[vertex + 1][vertex + 1];
		dist = new long[vertex + 1];

		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		Arrays.fill(dist, INF);

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A][B] = Math.min(graph[A][B], C);
		}

		Bellman_Ford();
//		for (long a : dist) {
//			System.out.print(a + " ! ");
//		}

		if (CycleFind()) {
			bw.write("-1\n");
		} else {
			for (int i = 2; i <= vertex; i++) {
				if (dist[i] == INF) {
					bw.write("-1\n");
				} else {
					bw.write(dist[i] + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}

	public static void Bellman_Ford() {
		dist[1] = 0;
		for (int i = 1; i < vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				for (int k = 1; k <= vertex; k++) {
					if (graph[j][k] != INF) {
						if (dist[j] != INF) {
							if (dist[k] > dist[j] + graph[j][k]) {
								dist[k] = dist[j] + graph[j][k];
							}
						}
					}
				}
			}
		}
	}

	public static boolean CycleFind() {
		for (int j = 1; j <= vertex; j++) {
			for (int k = 1; k <= vertex; k++) {
				if (graph[j][k] != INF) {
					if (dist[j] != INF) {
						if (dist[k] > dist[j] + graph[j][k]) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}