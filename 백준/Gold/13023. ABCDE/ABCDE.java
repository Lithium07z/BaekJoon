import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			DFS(0, i);
		}
		
		bw.write("0");
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int dep, int s) {
		if (dep == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		visited[s] = true;
		
		for (int i : list.get(s)) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(dep + 1, i);
				visited[i] = false;
			}
		}
	}
}