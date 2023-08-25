import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int arr[][] = new int[w][3];
		UnionFind uf = new UnionFind(p);
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);
		
		for (int i = 0; i < w; i++) {
			uf.union(arr[i][0], arr[i][1]);
			
			if (uf.find(c, v)) {
				bw.write(arr[i][2] + "\n");
				bw.flush();
				bw.close();
				return;
			}
		}
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