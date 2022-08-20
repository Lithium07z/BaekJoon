import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
 		
		if (Long.parseLong(bfr.readLine()) % 2 == 0) {
			bfw.write("CY");
		} else {
			bfw.write("SK");
		}
		bfw.flush();
		bfw.close();
	}
}
