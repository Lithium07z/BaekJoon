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
		int num = Integer.parseInt(bfr.readLine());
		int loop = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < loop; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			num -= (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
		}
		if (num == 0) {
			bfw.write("Yes");
		} else {
			bfw.write("No");
		}
		bfw.flush();
		bfw.close();
	}
}