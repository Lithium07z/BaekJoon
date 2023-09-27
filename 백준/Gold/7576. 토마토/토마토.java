import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int c = 0;
	static int v = 0;
	static int graph[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = 0;
		graph = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					q.add(new int[] { i, j });
					c++;
					v++;
				} else if (graph[i][j] == -1) {
					c++;
				}
			}
		}

		r = BFS(graph, visited);

		bw.write(c == N * M ? r + "\n" : "-1");
		bw.flush();
		bw.close();
	}

	public static int BFS(int graph[][], boolean visited[][]) {
		int d = 0;
		int r = 0;

		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];

			v--;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY]
						|| graph[nextX][nextY] == -1 || graph[nextX][nextY] == 1) {
					continue;
				}

				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
				graph[nextX][nextY] = 1;
				c++;
				d++;
			}

			if (v == 0 && d != 0) {
				v += d;
				d = 0;
				r++;
			}
		}

		return r;
	}
}