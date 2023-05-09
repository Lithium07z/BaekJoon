import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		int M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				graph[i][j] = temp.charAt(j) - '0';
			}
		}
		
		visited[0][0] = true;
		BFS(0, 0, graph, visited);
		
		bw.write(graph[N - 1][M - 1] + "\n");
		bw.flush();
		bw.close();
	}

	public static void BFS(int x, int y, int graph[][], boolean visited[][]) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { x, y });
		
		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
						
				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY] || graph[nextX][nextY] == 0) {
					continue;
				}
				
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
				graph[nextX][nextY] = graph[nowX][nowY] + 1;
			}
		}
	}
}