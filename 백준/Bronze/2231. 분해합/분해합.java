import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String value = bfr.readLine();
		int sum = 0;
		
		for (int i = 0; i < Integer.parseInt(value); i++) {
			int len = String.valueOf(i).length();
			sum = 0;
			for (int j = 0; j < len; j++) {
				sum += String.valueOf(i).charAt(j) - '0';
			}
			if (i + sum == Integer.parseInt(value)) {
				bfw.write(String.valueOf(i));
				bfw.flush();
				bfw.close();
				System.exit(0);				
			}
		}
		bfw.write("0");
		bfw.flush();
		bfw.close();
	}
}