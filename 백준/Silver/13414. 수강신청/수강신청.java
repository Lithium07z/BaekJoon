import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		
		int limit = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < length; i++) {
			String temp = bfr.readLine();
			if (set.contains(temp)) {
				set.remove(temp);
				set.add(temp);
			} else {
				set.add(temp);
			}
		}
		
		Iterator<String> iter = set.iterator();
		for (int i = 0; i < limit; i++) {
			if (!iter.hasNext()) {
				break;
			}
			bfw.write(String.valueOf(iter.next()) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}