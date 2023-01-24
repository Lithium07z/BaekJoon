import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp = " ";
		for (int i = 0; i < 100; i++) {
			temp = br.readLine();
			if (temp == null) {
				break;
			}
			bw.write(temp + "\n");
		}
		bw.flush();
		bw.close();
	}
}