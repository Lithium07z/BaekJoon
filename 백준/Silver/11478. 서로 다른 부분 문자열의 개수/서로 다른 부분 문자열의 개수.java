import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet<String>();
		
		String str = bfr.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			int first = 0;
			int end = i + 1;
			while (end <= str.length()) {
				set.add(str.substring(first, end));
				first++;
				end++;
			}
		}
		bfw.write(String.valueOf(set.size()));
		bfw.flush();
		bfw.close();
	}
}