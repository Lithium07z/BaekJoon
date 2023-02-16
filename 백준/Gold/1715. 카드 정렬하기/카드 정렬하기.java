import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int temp = 0;
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		if (pq.size() == 0) {
			bw.write("0");
		} else {
			while(pq.size() != 1) {
				temp = pq.poll() + pq.poll();
				result += temp;
				pq.add(temp);
			}
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}