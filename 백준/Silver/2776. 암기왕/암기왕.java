import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < cases; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			int N = Integer.parseInt(bfr.readLine());
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			
			for (int j = 0; j < N; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(bfr.readLine());
			st = new StringTokenizer(bfr.readLine());
			
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (set.contains(temp)) {
					bfw.write("1\n");
				} else {
					bfw.write("0\n");
				}
			}
		}	
		bfw.flush();
		bfw.close();
	}
}