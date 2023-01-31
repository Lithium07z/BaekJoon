import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		int cnt = 0;
		
		while (!N.equals("0")) {
			if (N.length() != 1 && N.contains("1")) {
				N = String.valueOf(Integer.parseInt(N.replaceFirst("1", "")));
			} else {
				N = String.valueOf(Integer.parseInt(N) - 1);
			}
			cnt++;
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}