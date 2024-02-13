import java.util.PriorityQueue;

class Solution {
    static boolean flag = false;
	static String res = "";
	static int dx[] = { 1, 0, 0, -1 };
	static int dy[] = { 0, -1, 1, 0 };
    
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
		int len = Math.abs(x - r) + Math.abs(y - c);

		if (((len % 2 == 0) && k % 2 != 0) || ((len % 2 == 1) && k % 2 != 1) || len > k) {
			return "impossible";
		}

		DFS(n, m, x, y, r, c, k, "");

		return res.isEmpty() ? "impossible" : res + "";
	}

	public static void DFS(int n, int m, int x, int y, int r, int c, int k, String val) {
		if ((x == r && y == c && k % 2 == 1) || flag) {
			return;
		}

		if (k == 0) {
			if (x == r && y == c && !flag) {
				res = val;
				flag = true;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX > 0 && nextY > 0 && nextX <= n && nextY <= m
					&& Math.abs(nextX - r) + Math.abs(nextY - c) <= k) {
				val += i == 0 ? "d" : i == 1 ? "l" : i == 2 ? "r" : "u";
				DFS(n, m, nextX, nextY, r, c, --k, val);
				val = val.substring(0, val.length() - 1);
			}
		}
	}
}