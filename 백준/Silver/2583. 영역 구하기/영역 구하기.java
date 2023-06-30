import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size = 0;
	static int graph[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = 1;
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int j = ly; j < ry; j++) {
				for (int k = lx; k < rx; k++) {
					graph[k][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != 0 && !visited[i][j]) {
					size = 0;
					BFS(i, j, graph, visited);
					pq.add(size);
					cnt++;
				}
			}
		}
		
		bw.write(cnt + "\n");
		while (!pq.isEmpty()) {
			bw.write(pq.poll() + " ");
		}
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
				
				size++;	
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
				graph[nextX][nextY] = graph[nowX][nowY] + 1;
			}
			
			if (size == 0) {
				size++;
			}
			
		}
	}
}