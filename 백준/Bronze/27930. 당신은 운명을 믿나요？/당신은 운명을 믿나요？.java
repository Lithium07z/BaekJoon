import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		String K = "KOREA";
		String Y = "YONSEI";
		int k = 0;
		int y = 0;

		for (int i = 0; i < S.length(); i++) {
			if (k == 5) {
				bw.write("KOREA");
				break;
			} else if (y == 6) {
				bw.write("YONSEI");
				break;
			}

			if (S.charAt(i) == K.charAt(k)) {
				k++;
			} else if (S.charAt(i) == Y.charAt(y)) {
				y++;
			}
		}

		bw.flush();
		bw.close();
	}
}