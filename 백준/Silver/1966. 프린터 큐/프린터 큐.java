import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < T; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				pq.add(temp);
				q.add(temp);
			}
			
			while (true) {
				if (q.peek() < pq.peek()) {
					q.add(q.poll());
					if (M - 1 < 0) {
						M = q.size() - 1;
					} else {
						M--;
					}
				} else {
					cnt++;
					if (M == 0) {
						bfw.write(String.valueOf(cnt) + "\n");
						break;
					}
					if (M - 1 < 0) {
						M = q.size() - 1;
					} else {
						M--;
					}
					pq.poll();
					q.poll();
				}
			}
		}
		bfw.flush();
		bfw.close();
	}
}