import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String value = "";
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			if ((a * a) + (b * b) == (c * c)) {
				value += "right\n";
			} else if ((a * a) + (c * c) == (b * b)) {
				value += "right\n";
			} else if ((b * b) + (c * c) == (a * a)) {
				value += "right\n";
			} else {
				value += "wrong\n";
			}
		}
		bfw.write(value);
		bfw.flush();
		bfw.close();
	}
}