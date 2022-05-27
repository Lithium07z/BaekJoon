import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		Set<String> set = new HashSet<String>();
		Set<String> result = new TreeSet<String>();
		int cnt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < cnt; i++) {
			String name = bfr.readLine();
			if (!set.add(name)) {
				result.add(name);
			} 
		}
		System.out.println(result.size());
		result.forEach(item -> System.out.println(item));
	}
}