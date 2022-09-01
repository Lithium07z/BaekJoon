import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		String temp1 = "";
		String temp2 = "";
		
		temp1 += st.nextToken();
		temp1 += st.nextToken();
		temp2 += st.nextToken();
		temp2 += st.nextToken();
		
		bfw.write(String.valueOf(Long.parseLong(temp1) + Long.parseLong(temp2)));
		bfw.flush();
		bfw.close();
	}
}