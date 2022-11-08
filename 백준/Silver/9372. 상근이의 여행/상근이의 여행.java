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
		int cases = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			bfw.write(String.valueOf(Integer.parseInt(st.nextToken()) - 1) + "\n");
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				bfr.readLine();
			}
		}
		bfw.flush();
		bfw.close();
	}
}