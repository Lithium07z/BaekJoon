import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = bfr.readLine();
		int sum = 0;

		for (int i = 1; i <= str.length(); i++) {
			if (str.charAt(i - 1) >= 65 && str.charAt(i - 1) <= 70) {
				sum += Math.pow(16, str.length() - i) * (str.charAt(i - 1) - '7');
			} else {
				sum += Math.pow(16, str.length() - i) * (str.charAt(i - 1) - '0');
			}
		}
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}