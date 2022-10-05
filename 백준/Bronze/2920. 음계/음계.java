import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp = bfr.readLine();
		
		if (temp.equals("1 2 3 4 5 6 7 8")) {
			bfw.write("ascending");
		} else if (temp.equals("8 7 6 5 4 3 2 1")) {
			bfw.write("descending");
		} else {
			bfw.write("mixed");
		}
		bfw.flush();
		bfw.close();
	}
}