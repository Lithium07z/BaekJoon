import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static int solution(int[][] maps) {
		boolean visited[][] = new boolean[maps.length][maps[0].length];

		BFS(0, 0, maps, visited);

		return (maps[maps.length - 1][maps[0].length - 1] == 1) ? -1 : maps[maps.length - 1][maps[0].length - 1];
	}

	public static void BFS(int x, int y, int graph[][], boolean visited[][]) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { x, y });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY]
						|| graph[nextX][nextY] == 0) {
					continue;
				}

				q.add(new int[] { nextX, nextY });
				graph[nextX][nextY] = graph[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}
}