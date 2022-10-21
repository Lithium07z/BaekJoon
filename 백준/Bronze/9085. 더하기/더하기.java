import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(bfr.readLine());
		
		for (int m = 0; m < cases; m++) {
			int size = Integer.parseInt(bfr.readLine());
			int sum = 0;
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			for (int i = 0; i < size; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			bfw.write(String.valueOf(sum) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
