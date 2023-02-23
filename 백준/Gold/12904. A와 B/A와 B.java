import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		sb.append(br.readLine());
		
		while (sb.length() != S.length()) {
			if (sb.charAt(sb.length() - 1) == 'A') {
				sb.setLength(sb.length() - 1);
			} else {
				sb.setLength(sb.length() - 1);
				sb = sb.reverse();
			}
			if (sb.toString().equals(S)) {
				bw.write("1");
				bw.flush();
				bw.close();
				return;
			}
		}
		bw.write("0");
		bw.flush();
		bw.close();
	}
}