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

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Stack<Integer> stk = new Stack<Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean visited[] = new boolean[N + 1];
		int dist[] = new int[N + 1];
		int path[] = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			//graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		visited = new boolean[graph.length];
		dist = new int[graph.length];

		Arrays.fill(dist, INF);
		dist[s] = 0;
		pq.offer(new Node(s, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().idx;

			if (visited[crt]) {
				continue;
			}

			visited[crt] = true;
			
			if (crt == e) {
				while (crt != 0) {
					stk.push(crt);
					crt = path[crt];
				}
				break;
			}
			
			for (Node next : graph[crt]) {
				if (dist[next.idx] > dist[crt] + next.v) {
					path[next.idx] = crt;
					dist[next.idx] = dist[crt] + next.v;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		bw.write(dist[e] + "\n" + stk.size() + "\n");
		
		while (!stk.isEmpty()) {
			bw.write(stk.pop() + " ");
		}
		
		bw.flush();
		bw.close();
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
		return Integer.compare(this.v, o.v);
	}
}