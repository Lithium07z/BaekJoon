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
		System.out.print(1 - Integer.parseInt(st.nextToken()) + " ");
		System.out.print(1 - Integer.parseInt(st.nextToken()) + " ");
		System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
		System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
		System.out.print(2 - Integer.parseInt(st.nextToken()) + " ");
		System.out.print(8 - Integer.parseInt(st.nextToken()));
	}
}
