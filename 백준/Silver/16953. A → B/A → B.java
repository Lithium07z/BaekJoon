import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;
		
		while (true) {
			if (A == B) {
				bfw.write(String.valueOf(count + 1));
				break;
			}
			if (A > B) {
				bfw.write("-1");
				break;
			}
			if ((B - 1) % 10 == 0) {
				B /= 10;
				count++;
			} else if (B % 2 == 0) {
				B /= 2;
				count++;
			} else {
				bfw.write("-1");
				break;
			}
		}
		bfw.flush();
		bfw.close();
	}
}