import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int cnt = 0;
		UnionFind uf = new UnionFind(G + 1);
		
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int temp = uf.root(g);
			
			if (temp != 0) {
				uf.union(temp - 1, temp);
				cnt++;
			} else {
				break;
			}
		}

		bw.write(cnt + "\n");
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