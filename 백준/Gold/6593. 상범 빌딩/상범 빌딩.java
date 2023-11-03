import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int graph[][][];
	static char building[][][];
	static boolean visited[][][];
	static int dx[] = { -1, 1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, -1, 1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			boolean flag = true;
			graph = new int[R][C][L];
			building = new char[R][C][L];
			visited = new boolean[R][C][L];
			Queue<int[]> q = new LinkedList<int[]>();

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String temp = br.readLine();
					for (int k = 0; k < C; k++) {
						building[j][k][i] = temp.charAt(k) ;
						if (building[j][k][i] == 'S') {
							q.add(new int[] { j, k, i });
						} else if (building[j][k][i] == '.') {
							graph[j][k][i] = -1;
						}
					}
				}
				String tab = br.readLine();
			}
			
			Loop1 : while (!q.isEmpty()) {
				int crt[] = q.poll();
				int nowX = crt[0];
				int nowY = crt[1];
				int nowZ = crt[2];

				for (int i = 0; i < 6; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					int nextZ = nowZ + dz[i];

					if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= graph.length || nextY >= graph[0].length
							|| nextZ >= graph[0][0].length || visited[nextX][nextY][nextZ]
							|| building[nextX][nextY][nextZ] == '#') {
						continue;
					}

					graph[nextX][nextY][nextZ] = graph[nowX][nowY][nowZ] + 1;
					
					if (building[nextX][nextY][nextZ] == 'E') {
						bw.write("Escaped in " + graph[nextX][nextY][nextZ] + " minute(s).\n");
						flag = false;
						break Loop1;
					}
					
					visited[nextX][nextY][nextZ] = true;
					q.add(new int[] { nextX, nextY, nextZ });
					
				}
			}

			if (flag) {
				bw.write("Trapped!\n");
			}
		}
		bw.flush();
		bw.close();
	}
}