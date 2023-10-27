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
		int R = 0;
		int X = 0;
		int Y = 0;
		int temp[][] = new int[N][M];
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = temp[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] != 0) {
					S++;
				}
			}
		}
		
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int nextX = i + dx[k];
							int nextY = j + dy[k];
							
							if (graph[nextX][nextY] == 0) {
								if (--temp[i][j] == 0) {
									if (--S == 0) {
										bw.write("0");
										bw.flush();
										bw.close();
										return;
									}
								}
								temp[i][j] = temp[i][j] < 0 ? 0 : temp[i][j];
							}
						}
						
						if (temp[i][j] != 0) {
							X = i;
							Y = j;
						}
					}
				}
			}
			
			R++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					graph[i][j] = temp[i][j];
				}
			}
			
			visited = new boolean[N][M];
			if (BFS(X, Y) != S) {
				bw.write(R + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}

	public static int BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int s = 0;
		
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
				
				s++;
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
			}
		}

		return s;
	}
}