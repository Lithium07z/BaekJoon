import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
 		
		while(true) {
			String num = bfr.readLine();
			if (num.equals("0")) {
				break;
			}
			StringBuffer sb = new StringBuffer(num);
			String reverseNum = sb.reverse().toString();
			
			if (num.equals(reverseNum)) {
				bfw.write("yes\n");
			} else {
				bfw.write("no\n");
			}
		}
		bfw.flush();
		bfw.close();
	}
}