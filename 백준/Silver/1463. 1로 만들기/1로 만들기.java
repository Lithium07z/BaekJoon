import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write(String.valueOf(loop(Integer.parseInt(bfr.readLine()), 0)));
		bfw.flush();
		bfw.close();
	}
	
	public static int loop(int value, int count) {
		if (value < 2) {
			return count;
		}
		return Math.min(loop(value / 2, count + 1 + (value % 2)), loop(value / 3, count + 1 + (value % 3)));
	}
}