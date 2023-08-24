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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		UnionFind uf = new UnionFind(N + 1);
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			uf.union(v, w);
		}

		bw.write(uf.sum(arr) <= k ? uf.sum(arr) + "\n" : "Oh no");
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
	
	public int sum(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int t = 0;
		
		for (int i = 1; i < parent.length; i++) {
			if (map.containsKey(parent[i])) {
				map.put(root(i), Math.min(arr[i - 1], map.get(parent[i])));
			} else {
				map.put(root(i), arr[i - 1]);
			}
		}
		
		for (int v : map.values()) {
			t += v;
		}
		
		return t;
	}
}