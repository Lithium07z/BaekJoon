import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) { 
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			UnionFind uf = new UnionFind(N * 2 + 1);
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				int aNum = 0;
				int bNum = 0;
				
				if (!map.containsKey(a)) {
					map.put(a, cnt);
					aNum = cnt++;
				} else {
					aNum = map.get(a);
				}
				
				if (!map.containsKey(b)) {
					map.put(b, cnt);
					bNum = cnt++;
				} else {
					bNum = map.get(b);
				}
				
				uf.union(aNum, bNum);

				bw.write(uf.size(uf.root(aNum)) + "\n");
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