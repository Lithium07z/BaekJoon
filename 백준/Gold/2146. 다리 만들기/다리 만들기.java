import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int graph[][];
	static boolean border[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		graph = new int[N][N];
		border = new boolean[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) { 
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { 
				if (graph[i][j] != 0 && !visited[i][j]) {
					BFS(i, j, idx++);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { 
				for (int k = 0; k < 4; k++) {
					int nextX = i + dx[k];
					int nextY = j + dy[k];
							
					if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || border[nextX][nextY] || graph[nextX][nextY] == 0) {
						continue;
					}
					
					border[nextX][nextY] = true;
					Bridge(nextX, nextY);
				}
			}
		}

		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}

	public static void BFS(int x, int y, int idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] { x, y });
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];
			graph[nowX][nowY] = idx;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
						
				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY] || graph[nextX][nextY] == 0) {
					continue;
				}
				
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
			}
		}
	}
	
	public static void Bridge(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[graph.length][graph.length];
		
		q.add(new int[] { x, y });
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
						
				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY] || graph[nextX][nextY] == graph[x][y]) {
					continue;
				}
				
				if (graph[nextX][nextY] != 0) {
					min = Math.min(min, Math.abs(x - nextX) + Math.abs(y - nextY) - 1);
				}
				
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
			}
		}
	}
}