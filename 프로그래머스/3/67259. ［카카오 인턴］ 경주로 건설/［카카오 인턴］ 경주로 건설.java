import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int graph[][][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

		public static int solution(int[][] board) {
		graph = new int[board.length][board[0].length][4];

		return BFS(board);
	}

	public static int BFS(int borad[][]) {
		Queue<Node> q = new LinkedList<Node>();
		int min = Integer.MAX_VALUE;

		q.add(new Node(0, 0, -1, 0));
		
		while (!q.isEmpty()) {
			Node crt = q.poll();
			int nowX = crt.x;
			int nowY = crt.y;

			if (nowX == graph.length - 1 && nowY == graph.length - 1) {
				min = Math.min(min, borad[nowX][nowY]);
			}

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length
						|| borad[nextX][nextY] == 1) {
					continue;
				}

				int nextCost = crt.cost;
				if (crt.dir == -1 || crt.dir == i) {
					nextCost += 100;
				} else {
					nextCost += 600;
				}
				
				if (graph[nextX][nextY][i] == 0 || borad[nextX][nextY] >= nextCost) {
					q.add(new Node(nextX, nextY, i, nextCost));
					borad[nextX][nextY] = nextCost;
					graph[nextX][nextY][i] = 1;
				}
			}
		}

		return min;
	}
}

class Node {
	int x;
	int y;
	int dir;
	int cost;
	
	public Node(int x, int y, int dir, int cost) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cost = cost;
	}
}