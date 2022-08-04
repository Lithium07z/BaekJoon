import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = 1000 - Integer.parseInt(bfr.readLine());
		int count = 0;

		while (num != 0) {
			if (num >= 500) {
				count += num / 500;
				num = num % 500;
			} else if (num >= 100 && num < 500) {
				count += num / 100;
				num = num % 100;
			} else if (num >= 50 && num < 100) {
				count += num / 50;
				num = num % 50;
			} else if (num >= 10 && num < 50) {
				count += num / 10;
				num = num % 10;
			} else if (num >= 5 && num < 10) {
				count += num / 5;
				num = num % 5;
			} else if (num >= 1 && num < 5) {
				count += num / 1;
				num = num % 1;
			}
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}