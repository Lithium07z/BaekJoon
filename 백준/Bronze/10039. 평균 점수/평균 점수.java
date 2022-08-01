import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int count = 0;
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value = Integer.parseInt(bfr.readLine());
			if (value < 40) {
				sum += 40;
			} else {
				sum += value;
			}
			count += 1;
		}
		bfw.write(String.valueOf(sum / count));
		bfw.flush();
		bfw.close();
	}
}