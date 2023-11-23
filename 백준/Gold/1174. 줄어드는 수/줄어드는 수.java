import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

class Main {
	static LinkedList<Long> list = new LinkedList<Long>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()) - 1;

		if (N <= 10) {
			bw.write(N + "\n");
		} else if (N > 1022) {
			bw.write("-1");
		} else {
			for (int i = 0; i < 10; i++) {
				DFS(i, 1);
			}
			
			Collections.sort(list);
			
			bw.write(list.get(N) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void DFS(long n, int idx) {
		if (idx > 10) {
			return;
		}
		
		list.add(n);
		
		for (int i = 0; i < n % 10; i++) {
			DFS((n * 10) + i, idx + 1);
		}
	}
}