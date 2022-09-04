import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		int size = Integer.parseInt(bfr.readLine());
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < size; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int result : set) {
			bfw.write(String.valueOf(result) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}