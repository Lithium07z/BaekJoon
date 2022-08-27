import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		long num = Long.parseLong(bfr.readLine());
		long sum = 0;
		int count = 0;
		
		for (int i = 1; true; i++) {
			sum += i;
			if (sum > num) {
				break;
			}
			count++;
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}