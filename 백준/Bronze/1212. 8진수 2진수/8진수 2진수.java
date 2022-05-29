import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String octaNum = bfr.readLine();

		for (int i = 0; i < octaNum.length(); i++) {
			switch (octaNum.charAt(i) - '0') {
			case 0:
				if (i == 0) {
					bfw.write("0");
				} else {
					bfw.write("000");
				}
				break;
			case 1:
				if (i == 0) {
					bfw.write("1");
				} else {
					bfw.write("001");
				}
				break;
			case 2:
				if (i == 0) {
					bfw.write("10");
				} else {
					bfw.write("010");
				}
				break;
			case 3:
				if (i == 0) {
					bfw.write("11");
				} else {
					bfw.write("011");
				}
				break;
			case 4:
				bfw.write("100");
				break;
			case 5:
				bfw.write("101");
				break;
			case 6:
				bfw.write("110");
				break;
			case 7:
				bfw.write("111");
				break;
			}
		}
		bfw.flush();
		bfw.close();
	}
}