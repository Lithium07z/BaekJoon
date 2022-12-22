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
		String input  = bfr.readLine();
		StringTokenizer st1 = new StringTokenizer(input, "1");
		StringTokenizer st2 = new StringTokenizer(input, "0");
		bfw.write((st1.countTokens() > st2.countTokens())? String.valueOf(st2.countTokens()) : String.valueOf(st1.countTokens()));
		bfw.flush();
		bfw.close();
	}
}