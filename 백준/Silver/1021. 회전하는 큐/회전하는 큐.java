import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			Deque<Integer> left = new LinkedList<Integer>();
			Deque<Integer> right = new LinkedList<Integer>();
			left.addAll(dq);
			right.addAll(dq);
			
			int lcnt = 0;
			int rcnt = 0;
			
			while (true) {
				if (left.peek() == num) {
					left.pollFirst();
					break;
				} else {
					left.addLast(left.pollFirst());
					lcnt++;
				}
			}
			
			while (true) {
				if (right.peek() == num) {
					right.pollFirst();
					break;
				} else {
					right.addFirst(right.pollLast());
					rcnt++;
				}
			}
			
			dq.clear();
			
			if (lcnt < rcnt) {
				sum += lcnt;
				dq.addAll(left);
			} else {
				sum += rcnt;
				dq.addAll(right);
			}
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}