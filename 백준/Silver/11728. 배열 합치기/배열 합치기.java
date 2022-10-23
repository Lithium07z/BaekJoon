import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		st = new StringTokenizer(bfr.readLine());
		while(st.hasMoreTokens()) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bfr.readLine());
		while(st.hasMoreTokens()) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			bfw.write(String.valueOf(pq.poll()) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}
