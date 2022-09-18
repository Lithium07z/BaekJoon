import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bfr.readLine();
		
		for (int i = 1; i <= input.length(); i++) {
			bfw.write(input.charAt(i - 1));
			if (i % 10 == 0) {
				bfw.write("\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}