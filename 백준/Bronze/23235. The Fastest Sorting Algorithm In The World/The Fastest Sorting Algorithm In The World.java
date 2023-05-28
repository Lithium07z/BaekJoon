import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; true; i++) { 
			if (br.readLine().subSequence(0, 1).equals("0")) {
				bw.flush();
				bw.close();
				return;
			} else {
				bw.write("Case " + i + ": Sorting... done!\n");
			}
		}
	}
}