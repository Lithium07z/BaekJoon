import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int height = Integer.parseInt(bfr.readLine());
		
		for (int i = 1; i <= height; i++) {
			for (int j = 0; j < height - i; j++) {
				sb.append(" ");
			}
			sb.append("*");
			for (int j = 0; j < (i - 1) * 2 - 1; j++) {
				sb.append(" ");
			}
			if (i != 1) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}