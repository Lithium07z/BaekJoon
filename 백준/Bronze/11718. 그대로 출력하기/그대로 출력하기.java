import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 101; i++) {
			String temp = bfr.readLine();
			if (temp == null || temp.isEmpty()) {
				break;
			} else {
				bfw.write(temp + "\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}