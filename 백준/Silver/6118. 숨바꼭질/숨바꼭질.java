import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	static LinkedList<Integer>[] graph;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		graph = new LinkedList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}
		
		BFS();
	}

	public static void BFS() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<>();
		int res = INF;
		int cnt = 0;
		int time = -1;
		
		q.add(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			res = INF;
			cnt = size;
			
			for (int i = 0; i < size; i++) {
				int crt = q.poll();
				res = Math.min(crt, res);
				
				for (int next : graph[crt]) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			time++;
		}
		
		bw.write(res + " " + time + " " + cnt);
		bw.flush();
		bw.close();
	}
}