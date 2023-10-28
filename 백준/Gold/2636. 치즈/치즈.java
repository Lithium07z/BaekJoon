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
		int M = Integer.parseInt(st.nextToken());
		int S = 0;
		int H = 0;
		int R = 0;
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				S += graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(0, 0);
	
		while (true) {
			ArrayList<Point> list = new ArrayList<Point>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] == 1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nextX = i + dx[k];
							int nextY = j + dy[k];
							
							if (visited[nextX][nextY]) {
								cnt++;
							}
						}
						
						if (cnt > 0) {
							list.add(new Point(i, j));
						}
					}
				}
			}
			
			H++;
			R = S;
			
			for (Point pt : list) {
				graph[pt.x][pt.y] = 0;
				if (--S == 0) {
					bw.write(H + "\n" + R);
					bw.flush();
					bw.close();
					return;
				}
			}
			
			visited = new boolean[N][M];
			
			BFS(0, 0);
		}
	}

	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] { x, y });
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
						
				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY] || graph[nextX][nextY] == 1) {
					continue;
				}
				
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
			}
		}
	}
}