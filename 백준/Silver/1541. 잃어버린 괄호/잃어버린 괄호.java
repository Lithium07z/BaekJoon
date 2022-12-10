import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(bfr.readLine(), "-");
		int sum = 0;

		StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
		while (st2.hasMoreTokens()) {
			sum += Integer.parseInt(st2.nextToken());
		}

		if (!st1.hasMoreTokens()) {
			bfw.write(String.valueOf(sum));
		} else {
			while (st1.hasMoreTokens()) {
				st2 = new StringTokenizer(st1.nextToken(), "-+");
				while (st2.hasMoreTokens()) {
					sum -= Integer.parseInt(st2.nextToken());
				}
			}
			bfw.write(String.valueOf(sum));
		}
		bfw.flush();
		bfw.close();
	}
}