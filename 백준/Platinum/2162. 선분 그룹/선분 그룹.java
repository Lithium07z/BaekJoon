import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long arr[][] = new long[N][4];

		UnionFind uf = new UnionFind(N);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				long x1 = arr[i][0];
				long y1 = arr[i][1];
				long x2 = arr[i][2];
				long y2 = arr[i][3];

				long x3 = arr[j][0];
				long y3 = arr[j][1];
				long x4 = arr[j][2];
				long y4 = arr[j][3];

				long BAx = x1 - x2;
				long BAy = y1 - y2;
				long ACx = x3 - x1;
				long ACy = y3 - y1;
				long ADx = x4 - x1;
				long ADy = y4 - y1;
				long CDx = x4 - x3;
				long CDy = y4 - y3;
				long DAx = x1 - x4;
				long DAy = y1 - y4;
				long DBx = x2 - x4;
				long DBy = y2 - y4;

				if (((BAx * ACy) - (BAy * ACx)) * ((BAx * ADy) - (BAy * ADx)) == 0
						&& ((CDx * DAy) - (CDy * DAx)) * ((CDx * DBy) - (CDy * DBx)) == 0) {
					if ((x1 >= Math.min(x3, x4) && x1 <= Math.max(x3, x4)
							|| x2 >= Math.min(x3, x4) && x2 <= Math.max(x3, x4)
							|| x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2)
							|| x4 >= Math.min(x1, x2) && x4 <= Math.max(x1, x2))
							&& (y1 >= Math.min(y3, y4) && y1 <= Math.max(y3, y4)
									|| y2 >= Math.min(y3, y4) && y2 <= Math.max(y3, y4)
									|| y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2)
									|| y4 >= Math.min(y1, y2) && y4 <= Math.max(y1, y2))) {
						if (!uf.find(i, j)) {
							uf.union(i, j);
						}

						//bw.write("1");
					}
				} else if (((BAx * ACy) - (BAy * ACx)) * ((BAx * ADy) - (BAy * ADx)) <= 0
						&& ((CDx * DAy) - (CDy * DAx)) * ((CDx * DBy) - (CDy * DBx)) <= 0) {
					if (!uf.find(i, j)) {
						uf.union(i, j);
					}

					//bw.write("1");
				}
			}
		}
		// x1, y1 > A / x2, y2 > B
		// x3, y3 > C / x4, y4 > D

		bw.write(uf.print());
		bw.flush();
		bw.close();
	}
}

class UnionFind {
	int[] parent;

	public UnionFind(int n) {
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int root(int i) {
		while (i != parent[i]) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}

		return i;
	}

	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i > j) {
			parent[i] = j;
		} else {
			parent[j] = i;
		}
	}

	public String print() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;

		for (int i = 0; i < parent.length; i++) {
			map.put(root(parent[i]), map.getOrDefault(root(parent[i]), 0) + 1);
		}
		
		for (int t : map.values()) {
			max = Math.max(max, t);
		}

		return map.size() + "\n" + max;
	}
}