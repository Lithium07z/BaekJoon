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
		int loop = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		for (int i  = 0; i < loop; i++) {
			if (Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)) < Integer.parseInt(bfr.readLine())) {
				bfw.write("NE\n");
			} else {
				bfw.write("DA\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}