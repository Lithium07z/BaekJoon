import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 3; i++) {
			String arr[] = bfr.readLine().split(" ");
			int count = 0;
			
			for (String temp : arr) {
				if (temp.equals("1")) {
					count++;
				}
			}
			
			if (count == 0) {
				bfw.write("D\n");
			} else if (count == 1) {
				bfw.write("C\n");
			} else if (count == 2) {
				bfw.write("B\n");
			} else if (count == 3) {
				bfw.write("A\n");
			} else if (count == 4) {
				bfw.write("E\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}