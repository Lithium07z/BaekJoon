import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int cnt = 0;
		boolean flag = true;
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(flag) {
			flag = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (BFS(i, j, L, R, graph, visited)) {
							flag = true;
						}
					}
				}
			}

			cnt = flag ? cnt + 1 : cnt;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

	public static boolean BFS(int x, int y, int L, int R, int graph[][], boolean visited[][]) {
		ArrayList<Point> list = new ArrayList<Point>();
		Queue<int[]> q = new LinkedList<int[]>();
		int sum = 0;
		boolean flag = false;

		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY]
						|| Math.abs(graph[nextX][nextY] - graph[nowX][nowY]) < L
						|| Math.abs(graph[nextX][nextY] - graph[nowX][nowY]) > R) {
					continue;
				}

				flag = true;
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
				sum += graph[nextX][nextY];
				list.add(new Point(nextX, nextY));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			graph[list.get(i).x][list.get(i).y] = sum / list.size();
		}

		return flag;
	}
}