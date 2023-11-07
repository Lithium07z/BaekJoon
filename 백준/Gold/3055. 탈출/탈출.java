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
				if (building[i][j] == 'S') {
					q.add(new Point(i, j));
				} else if (building[i][j] == '*') {
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

				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length
						|| building[nextX][nextY] == 'X') {
					continue;
				}

				if (building[nowX][nowY] == 'S') {
					if (building[nextX][nextY] == 'D') {
						bw.write(graph[nowX][nowY] + 1 + "\n");
						bw.flush();
						bw.close();
						return;
					}

					if (building[nextX][nextY] == '.') {
						building[nextX][nextY] = 'S';
						graph[nextX][nextY] = graph[nowX][nowY] + 1;
						q.add(new Point(nextX, nextY));
					}
				} else if (building[nowX][nowY] == '*') {
					if (building[nextX][nextY] == '.' || building[nextX][nextY] == 'S') {
						building[nextX][nextY] = '*';
						q.add(new Point(nextX, nextY));
					}
				}
			}
		}

		bw.write("KAKTUS");
		bw.flush();
		bw.close();
	}
}