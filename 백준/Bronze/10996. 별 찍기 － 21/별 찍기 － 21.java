import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int height = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < height; i++) {
			if (height % 2 == 0) {
				for (int j = 0; j < height / 2; j++) {
					sb.append("* ");
				}
				sb.append("\n");
				for (int j = 0; j < height / 2; j++) {
					sb.append(" *");
				}
			} else {
				for (int j = 0; j < height / 2 + 1; j++) {
					sb.append("* ");
				}
				sb.append("\n");
				for (int j = 0; j < (height - 1) / 2; j++) {
					sb.append(" *");
				}
			}
			sb.append("\n");		
		}
		System.out.println(sb);
	}
}