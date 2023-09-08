import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	static ArrayList<Node>[] graph;
	static Stack<Integer> stk;
	static boolean visited[];
	static int path[];
	static int dist[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[M];
			path = new int[M];

			for (int j = 0; j < M; j++) {
				graph[j] = new ArrayList<Node>();
			}

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				graph[A].add(new Node(B, C));
				graph[B].add(new Node(A, C));
			}

			Dijkstra(0, M - 1);

			if (dist[M - 1] == INF) {
				bw.write("Case #" + i + ": -1\n");
			} else {
				bw.write("Case #" + i + ": ");
				while (!stk.isEmpty()) {
					sb.append(stk.pop()).append(" ");
				}
				
				bw.write(sb.append("\n").toString());
			}
		}

		bw.flush();
		bw.close();
	}

	public static void Dijkstra(int X, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		stk = new Stack<Integer>();
		visited = new boolean[graph.length];
		dist = new int[graph.length];

		Arrays.fill(dist, INF);
		dist[X] = 0;
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().idx;

			if (visited[crt]) {
				continue;
			}

			visited[crt] = true;
			
			if (crt == end) {
				while (crt != 0) {
					stk.push(crt);
					crt = path[crt];
				}
				
				stk.push(0);
				return;
			}
			
			for (Node next : graph[crt]) {
				if (dist[next.idx] > dist[crt] + next.v) {
					path[next.idx] = crt;
					dist[next.idx] = dist[crt] + next.v;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		return;
	}
}

class Node implements Comparable<Node> {
	int idx;
	int v;

	public Node(int idx, int v) {
		this.idx = idx;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}
}