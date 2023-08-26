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
		int N = Integer.parseInt(br.readLine());
		UnionFind uf = new UnionFind(1000001);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if (st.nextToken().equals("I")) { 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				uf.union(a, b);
			} else {
				bw.write(uf.size(uf.root(Integer.parseInt(st.nextToken()))) + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}

class UnionFind {
	int[] parent;
	int[] weight;

	public UnionFind(int n) {
		parent = new int[n];
		weight = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			weight[i] = 1;
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
	
		if (!find(i, j)) {
			if (weight[i] >= weight[j]) {
				parent[j] = i;
				weight[i] += weight[j];
			} else {
				parent[i] = j;
				weight[j] += weight[i];
			}
		}
	}
	
	public int size(int i) {
		return weight[i];
	}
}