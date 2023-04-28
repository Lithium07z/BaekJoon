import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			bw.write(search(str, 0, str.length() - 1, flag) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int search(String str, int s, int e, boolean flag) {		
		while (s < e) {
			if (str.charAt(s) == str.charAt(e)) {
				s++;
				e--;
			} else {
				if (!flag && (search(str, s, e - 1, true) == 0) || search(str, s + 1, e, true) == 0) {
					return 1;
				}
				return 2;
			}
		}
		
		return 0;
	}
}