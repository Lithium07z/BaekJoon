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
		HashSet<String> set = new HashSet<String>();
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int write = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < size; i++) {
			set.add(bfr.readLine());
		}
		
		for (int i = 0; i < write; i++) {
			st = new StringTokenizer(bfr.readLine(), ",");
			int count = 0;
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				if (set.contains(temp)) {
					set.remove(temp);
					count++;
				}
			}
			bfw.write(String.valueOf(size - count) + "\n");
			size -= count;
		}
		bfw.flush();
		bfw.close();
	}
}