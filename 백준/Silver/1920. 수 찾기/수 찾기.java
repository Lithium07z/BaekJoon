import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
 		LinkedHashSet<String> set = new LinkedHashSet<String>();
		
 		int n = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < n; i++) {
			set.add(st.nextToken());
		}
		
		int m = Integer.parseInt(bfr.readLine());
		st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < m; i++) {
			if (set.add(st.nextToken()) == false) {
				bfw.write("1\n");
			} else {
				bfw.write("0\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}