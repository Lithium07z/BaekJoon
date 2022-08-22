import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet<String>();
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			set.add(bfr.readLine());
		}
		for (int i = 0; i < M; i++) {
			if (set.contains(bfr.readLine())) {
				count++;
			}
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}
