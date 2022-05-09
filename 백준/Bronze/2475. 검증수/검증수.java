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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int sum = 0;
		
		while (st.hasMoreElements()) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		bfw.write(String.valueOf(sum % 10));
		bfw.flush();
		bfw.close();
	}
}
