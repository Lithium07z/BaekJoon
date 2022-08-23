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
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < A; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < B; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (set.contains(temp)) {
				count++;
			} else {
				set.add(temp);
			}
		}
		bfw.write(String.valueOf(set.size() - count));
		bfw.flush();
		bfw.close();
	}
}