import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String w = br.readLine();
		
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) != w.charAt(w.length() - i - 1)) {
				bw.write("0");
				bw.flush();
				bw.close();
				return;
			}
		}
		bw.write("1");
		bw.flush();
		bw.close();
	}
}