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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Point> list = new LinkedList<Point>();
		Queue<Point> q = new LinkedList<Point>();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char building[][] = new char[R][C];
		int graph[][] = new int[R][C];
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				building[i][j] = temp.charAt(j);
				if (building[i][j] == 'J') {
					q.add(new Point(i, j));
				} else if (building[i][j] == 'F') {
					list.add(new Point(i, j));
				}
			}
		}

		q.addAll(list);

		while (!q.isEmpty()) {
			Point pt = q.poll();
			int nowX = pt.x;
			int nowY = pt.y;

			for (int j = 0; j < 4; j++) {
				int nextX = nowX + dx[j];
				int nextY = nowY + dy[j];

				if ((nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) && building[nowX][nowY] == 'J') {
					bw.write(graph[nowX][nowY] + 1 + "\n");
					bw.flush();
					bw.close();
					return;
				}
				
				if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || building[nextX][nextY] == '#') {
					continue;
				}

				if (building[nowX][nowY] == 'J') {
					if (building[nextX][nextY] == '.') {
						building[nextX][nextY] = 'J';
						graph[nextX][nextY] = graph[nowX][nowY] + 1;
						q.add(new Point(nextX, nextY));
					}
				} else if (building[nowX][nowY] == 'F') {
					if (building[nextX][nextY] == '.' || building[nextX][nextY] == 'J') {
						building[nextX][nextY] = 'F';
						q.add(new Point(nextX, nextY));
					}
				}
			}
		}

		bw.write("IMPOSSIBLE");
		bw.flush();
		bw.close();
	}
}