import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String num = bfr.readLine();
		int cnt = 0;
		
		while (num.length() != 1) {
			int value = 0;
			for (int i = 0; i < num.length(); i++) {
				value += num.charAt(i) - '0';
			}
			cnt++;
			num = String.valueOf(value);
		}
		bfw.write(String.valueOf(cnt) + "\n");
		if (Integer.parseInt(num) % 3 == 0) {
			bfw.write("YES");
		} else {
			bfw.write("NO");
		}
		bfw.flush();
		bfw.close();
	}
}