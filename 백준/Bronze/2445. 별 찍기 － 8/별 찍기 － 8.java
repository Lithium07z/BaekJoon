import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int height = Integer.parseInt(bfr.readLine());
		
		for (int i = 1; i <= height; i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			for (int j = 0; j < height * 2 - i * 2; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for (int i = 1; i <= height - 1; i++) {
			for (int j = 0; j < height - i; j++) {
				sb.append("*");
			}
			for (int j = 0; j < i * 2; j++) {
				sb.append(" ");
			}			
			for (int j = 0; j < height - i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
