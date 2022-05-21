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
		int correct = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		int result[] = new int[5];
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < 5; i++) {
			result[i] = Integer.parseInt(st.nextToken()) - correct;
		}
		for (int value : result) {
			bfw.write(String.valueOf(value) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}