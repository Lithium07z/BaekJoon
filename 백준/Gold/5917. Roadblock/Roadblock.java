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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		graph = new ArrayList[N + 1];
		path = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}

		Dijkstra(1, N);
		min = dist[N];
		
		Stack<Integer> stk2 = stk;

		int a = stk2.pop();
		while (!stk2.isEmpty()) {
			int temp = stk2.pop();
			
			for (int i = 0; i < graph[a].size(); i++) {
				if (graph[a].get(i).idx == temp) {
					graph[a].get(i).v *= 2;
				}
			}
			
			Dijkstra(1, N);
			max = Math.max(max, dist[N]);
			
			for (int i = 0; i < graph[a].size(); i++) {
				if (graph[a].get(i).idx == temp) {
					graph[a].get(i).v /= 2;
				}
			}
			
			a = temp;
		}

		bw.write(max - min + "\n");
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