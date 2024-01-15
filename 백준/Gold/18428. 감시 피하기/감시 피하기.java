import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Point> teacher = new LinkedList<Point>();
	static boolean visited[][];
	static String graph[][];
	static String result = "";
	static boolean flag;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		graph = new String[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = st.nextToken();

				if (graph[i][j].equals("T")) {
					teacher.add(new Point(i, j));
				}
			}
		}

		DFS(0, 0, 0);
		
		bw.write("NO");
		bw.flush();
		bw.close();
	}

	static int cnt = 0;

	public static void DFS(int x, int y, int cnt) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (cnt == 3) {
			for (Point pt : teacher) {
				for (int i = 0; i < 4; i++) {
					int nextX = pt.x + dx[i];
					int nextY = pt.y + dy[i];

					while (nextX >= 0 && nextY >= 0 && nextX < graph.length && nextY < graph.length) {
						if (graph[nextX][nextY].equals("S")) {
							return;
						} else if (visited[nextX][nextY] || graph[nextX][nextY].equals("T")) {
							break;
						}
						
						nextX += dx[i];
						nextY += dy[i];
					}
				}
			}

			bw.write("YES");
			bw.flush();
			bw.close();
			System.exit(0);
		}

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j].equals("X") && !visited[i][j]) {
					visited[i][j] = true;
					DFS(i, j, cnt + 1);
					visited[i][j] = false;
				}
			}
		}
	}
}