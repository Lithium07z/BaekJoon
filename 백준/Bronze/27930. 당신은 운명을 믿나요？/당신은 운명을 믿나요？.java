import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		
		if (N.contains("K") && N.contains("O") && N.contains("R") && N.contains("E") && N.contains("A")) {
			bw.write("KOREA");
		} else if (N.contains("Y") && N.contains("O") && N.contains("N") && N.contains("S") && N.contains("E") && N.contains("I")) {
			bw.write("YONSEI");
		}
		
		bw.flush();
		bw.close();
	}
}