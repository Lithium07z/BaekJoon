import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> ppq = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> npq = new PriorityQueue<Integer>();
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				ppq.add(num);
			} else {
				npq.add(num);
			}
		}
		
		while (npq.size() > 1) { 
			int n1 = npq.poll();
			int n2 = npq.poll();
			
			if (n1 < 0 && n2 < 0) {
				sum += n1 * n2;
			}
		}	
		if (npq.size() == 1) {
			sum += npq.poll();
		}
		
		while (ppq.size() > 1) {	
			int n1 = ppq.poll();
			int n2 = ppq.poll();
			
			sum += (n1 + n2 > n1 * n2)? n1 + n2 : n1 * n2;
		}
		if (ppq.size() == 1) {
			sum += ppq.poll();
		}
	 
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}