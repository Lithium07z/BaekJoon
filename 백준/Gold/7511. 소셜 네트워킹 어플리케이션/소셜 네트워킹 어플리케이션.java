import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
	
		for (int i = 1; i <= T; i++) { 
			int N = Integer.parseInt(br.readLine());
			int K = Integer.parseInt(br.readLine());
			UnionFind uf = new UnionFind(N + 1);
			StringTokenizer st;
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				uf.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			bw.write("Scenario " + i + ":\n");
			
			for (int j = 0; j < M; j++) { 
				st = new StringTokenizer(br.readLine());
				if (uf.find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			}
			
			bw.write("\n");
		}

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
}