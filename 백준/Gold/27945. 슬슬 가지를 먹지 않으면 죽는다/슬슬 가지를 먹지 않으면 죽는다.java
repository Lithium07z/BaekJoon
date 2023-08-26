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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[M][3];
		int cnt = 1;
		UnionFind uf = new UnionFind(N + 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[2] - o2[2]);
		
		for (int i = 0; i < N - 1; i++) {
			if (arr[i][2] != cnt) {
				bw.write(cnt + "\n");
				bw.flush();
				bw.close();
				return;
			} else {
				if (!uf.find(arr[i][0], arr[i][1])) {
					uf.union(arr[i][0], arr[i][1]);
					cnt++;
				}
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