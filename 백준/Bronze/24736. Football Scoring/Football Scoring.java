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
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw.write(Integer.parseInt(st.nextToken()) *  6 + Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken()) * 2 + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) * 2 + " ");
		st = new StringTokenizer(br.readLine());
		bw.write(Integer.parseInt(st.nextToken()) *  6 + Integer.parseInt(st.nextToken()) * 3 + Integer.parseInt(st.nextToken()) * 2 + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) * 2 + " ");
		bw.flush();
		bw.close();
	}
}