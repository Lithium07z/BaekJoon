import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 7; i++) {
			String ip = bfr.readLine();
			if (Integer.parseInt(ip) % 2 != 0) {
				if (Integer.parseInt(ip) < min) {
					min = Integer.parseInt(ip);
				}
				sum += Integer.parseInt(ip);
			}
		}
		if (sum == 0) {
			bfw.write("-1");
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(String.valueOf(sum) + "\n");
			bfw.write(String.valueOf(min));
			bfw.flush();
			bfw.close();
		}
	}
}