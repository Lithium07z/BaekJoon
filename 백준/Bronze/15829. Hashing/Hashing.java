import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		String word = bfr.readLine();
		long sum = 0;
		long pow = 1;
		
		for (int i = 0; i < size; i++) {
			sum += (word.charAt(i) - 96) * pow;
			pow = (pow * 31) % 1234567891;
		}
		bfw.write(String.valueOf(sum % 1234567891));
		bfw.flush();
		bfw.close();
	}
}