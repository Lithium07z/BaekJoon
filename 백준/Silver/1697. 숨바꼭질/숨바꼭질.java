import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		visited = new boolean[100001];
		
		if (N == K) { 
			bw.write("0\n");
		} else {
			bw.write(BFS(N, K) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int BFS(int N, int K) {
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(N, 0));
		
		while (!q.isEmpty()) {
			Point crt = q.poll();
	
			int num1 = crt.x - 1 ;
			int num2 = crt.x + 1 ;
			int num3 = crt.x * 2;
			
			if (num1 == K || num2 == K || num3 == K) {
				return crt.y + 1;
			}
	
			if (visited[crt.x]) {
				continue;
			}
			
			if (num1 >= 0 && num1 < 100001) {
				q.add(new Point(num1, crt.y + 1));
			}
		
			if (num2 >= 0 && num2 < 100001) {
				q.add(new Point(num2, crt.y + 1));
			}
			
			if (num3 >= 0 && num3 < 100001) {
				q.add(new Point(num3, crt.y + 1));
			}
			
			visited[crt.x] = true;
		}
		
		return -1;
	}
}
