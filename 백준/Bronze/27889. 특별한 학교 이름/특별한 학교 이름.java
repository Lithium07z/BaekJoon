import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int M;
	static long arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		
		if (N.equals("NLCS")) {
			bw.write("North London Collegiate School");
		} else if (N.equals("BHA")) {
			bw.write("Branksome Hall Asia");
		} else if (N.equals("KIS")) {
			bw.write("Korea International School");
		} else {
			bw.write("St. Johnsbury Academy");
		}
		
		bw.flush();
		bw.close();
	}
}