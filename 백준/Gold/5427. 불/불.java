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
		int T = Integer.parseInt(br.readLine());
		
		Loop : for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<Point> list = new LinkedList<Point>();
			Queue<Point> q = new LinkedList<Point>();
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char building[][] = new char[h][w];
			int graph[][] = new int[h][w];
			int dx[] = { -1, 1, 0, 0 };
			int dy[] = { 0, 0, -1, 1 };

			for (int j = 0; j < h; j++) {
				String temp = br.readLine();
				for (int k = 0; k < w; k++) {
					building[j][k] = temp.charAt(k);
					if (building[j][k] == '@') {
						q.add(new Point(j, k));
					} else if (building[j][k] == '*') {
						list.add(new Point(j, k));
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

					if ((nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) && building[nowX][nowY] == '@') {
						bw.write(graph[nowX][nowY] + 1 + "\n");
						continue Loop;
					}
					
					if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w || building[nextX][nextY] == '#') {
						continue;
					}

					if (building[nowX][nowY] == '@') {
						if (building[nextX][nextY] == '.') {
							building[nextX][nextY] = '@';
							graph[nextX][nextY] = graph[nowX][nowY] + 1;
							q.add(new Point(nextX, nextY));
						}
					} else if (building[nowX][nowY] == '*') {
						if (building[nextX][nextY] == '.' || building[nextX][nextY] == '@') {
							building[nextX][nextY] = '*';
							q.add(new Point(nextX, nextY));
						}
					}
				}
			}

			bw.write("IMPOSSIBLE\n");
		}
		
		bw.flush();
		bw.close();
	}
}