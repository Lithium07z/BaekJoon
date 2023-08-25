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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) { 
			arr[i] = Integer.parseInt(st.nextToken()) == 1 ? 1 : -1;
		}
		
		UnionFind uf = new UnionFind(N + 1, arr);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			uf.union(u, v);	
		}
		
		for (int i = 0; i < Q; i++) {
			bw.write(uf.size(uf.root(Integer.parseInt(br.readLine()))) > 0? "1\n" : "0\n");
		}
		
		bw.flush();
		bw.close();
	}
}

class UnionFind {
	int[] parent;
	int[] weight;

	public UnionFind(int n, int arr[]) {
		parent = new int[n];
		weight = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			weight[i] = arr[i];
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
	
		if (find(i, j)) {
			return;
		}
		
		if (weight[i] > weight[j]) {
			parent[j] = i;
			weight[i] += weight[j];
		} else {
			parent[i] = j;
			weight[j] += weight[i];
		}
	}
	
	public int size(int i) {
		return weight[i];
	}
}