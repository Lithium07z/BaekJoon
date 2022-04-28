import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		int i = 0;
		int cnt = 0;
		
		while (true) {
			String value = String.valueOf(i);
			if (value.contains("666")) {
				cnt++;
				if (cnt == loop) {
					bfw.write(String.valueOf(value));
					bfw.flush();
					bfw.close();
					break;
				}
			}
			i++;
		}
	}
}