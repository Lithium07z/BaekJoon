import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String L = st.nextToken();
		String R = st.nextToken();
		int cnt = 0;
		
		if (L.length() == R.length()) { 
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == R.charAt(i) && L.charAt(i) == '8') {
					cnt++;
				} else if (L.charAt(i) != R.charAt(i)) {
					break;
				}
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}