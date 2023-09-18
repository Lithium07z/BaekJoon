import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;

		if (graph[X][Y] != 0) {
			bw.write(graph[X][Y] + "\n");
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == 0 || (i == X && j == Y)) {
						continue;
					}

					int dist = Math.abs(i - X) + Math.abs(j - Y);

					if (min > dist) {
						min = dist;
						idx = graph[i][j];
					} else if (min == dist && idx > graph[i][j]) {
						idx = graph[i][j];
					}
				}
			}

			if (min <= S) {
				bw.write(idx + "\n");
			} else {
				bw.write("0");
			}
		}

		bw.flush();
		bw.close();
	}
}