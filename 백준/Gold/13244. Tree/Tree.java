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
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int arr[][] = new int[M][2];
			boolean flag = true;
			UnionFind uf = new UnionFind(N + 1);
			
			for (int j = 0; j < M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			if (N - 1 != M) {
				bw.write("graph\n");
				continue;
			}
			
			for (int j = 0; j < M; j++) {
				if (uf.find(arr[j][0], arr[j][1])) {
					bw.write("graph\n");
					flag = false;
					break;
				} else {
					uf.union(arr[j][0], arr[j][1]);
				}
			}
			
			if (flag) {
				bw.write("tree\n");
			}
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