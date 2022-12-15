import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String sb = bfr.readLine();
		
		if (sb.equals("A+")) {
			bfw.write("4.3");
		} else if (sb.equals("A0")) {
			bfw.write("4.0");
		} else if (sb.equals("A-")) {
			bfw.write("3.7");
		} else if (sb.equals("B+")) {
			bfw.write("3.3");
		} else if (sb.equals("B0")) {
			bfw.write("3.0");
		} else if (sb.equals("B-")) {
			bfw.write("2.7");
		} else if (sb.equals("C+")) {
			bfw.write("2.3");
		} else if (sb.equals("C0")) {
			bfw.write("2.0");
		} else if (sb.equals("C-")) {
			bfw.write("1.7");
		} else if (sb.equals("D+")) {
			bfw.write("1.3");
		} else if (sb.equals("D0")) {
			bfw.write("1.0");
		} else if (sb.equals("D-")) {
			bfw.write("0.7");
		} else if (sb.equals("F")) {
			bfw.write("0.0");
		}
		bfw.flush();
		bfw.close();
	}
}