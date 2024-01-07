import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Jewel> jewel = new ArrayList<Jewel>();
		ArrayList<Integer> bag = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long result = 0;
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < M; i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(jewel);
		Collections.sort(bag);
		
		for (int i = 0; i < M; i++) {
			for (int j = idx; j < N; j++) {
				if (jewel.get(j).M <= bag.get(i)) {
					pq.add(jewel.get(j).V);
					idx++;
				} else {
					break;
				}
			}
			
			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

class Jewel implements Comparable<Jewel> {
	int M;
	int V;
	
	public Jewel (int M, int V) { 
		this.M = M;
		this.V = V;
	}
	
	@Override
	public int compareTo(Jewel o) {
		return this.M - o.M == 0 ? o.V - this.V : this.M - o.M;
	}
}
