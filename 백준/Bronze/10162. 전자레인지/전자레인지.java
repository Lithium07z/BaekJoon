import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bfr.readLine());
		int A = 0;
		int B = 0;
		int C = 0;

		if (num >= 300) {
			A += (num / 300);
			num = num % 300;
		}
		if (num >= 60 && num < 300) {
			B += (num / 60);
			num = num % 60;
		}
		if (num >= 10 && num < 60) {
			C += (num / 10);
			num = num % 10;
		}
		if (num != 0) {
			bfw.write("-1");
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(String.valueOf(A) + " " + String.valueOf(B) + " " + String.valueOf(C));
			bfw.flush();
			bfw.close();
		}
	}
}