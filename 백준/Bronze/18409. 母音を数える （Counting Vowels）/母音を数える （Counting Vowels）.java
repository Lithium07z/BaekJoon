import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == 'a') {
				count++;
			} else if (S.charAt(i) == 'i') {
				count++;
			} else if (S.charAt(i) == 'u') {
				count++;
			} else if (S.charAt(i) == 'e') {
				count++;
			} else if (S.charAt(i) == 'o') {
				count++;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
}