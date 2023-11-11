import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result = Integer.MIN_VALUE;
	static int arr2[][];
	static int arr3[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr1[][] = new int[N][M];
		arr2 = new int[N][M];
		arr3 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr1[i][j] = arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BuildWall(N, M, 0);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void BuildWall(int N, int M, int c) {
		if (c == 3) {
			int cnt = 0;
			
			BFS(N, M);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr3[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			result = Math.max(cnt, result);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				if (arr2[i][j] == 0) {
					arr2[i][j] = 1;
					BuildWall(N, M, c + 1);
					arr2[i][j] = 0;
				}
			}
		}
	}
	
	public static void BFS(int N, int M) {
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				arr3[i][j] = arr2[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr3[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Point pt = q.poll();
			int nowX = pt.x;
			int nowY = pt.y;

			for (int j = 0; j < 4; j++) {
				int nextX = nowX + dx[j];
				int nextY = nowY + dy[j];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || arr3[nextX][nextY] != 0) {
					continue;
				}

				arr3[nextX][nextY] = 2;
				q.add(new Point(nextX, nextY));
			}
		}
	}
}