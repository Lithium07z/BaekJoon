import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int height = Integer.parseInt(bfr.readLine());

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			if (i == 0) {
				for (int j = 0; j < height - 1; j++) {
					sb.append("*");
				}
			} else {
				sb.append("*");
			}
			if (i != 0) {
				for (int j = 0; j < height - 2; j++) {
					sb.append(" ");
				}
			}
			sb.append("*");
			for (int j = 0; j < (height - 1 - i) * 2 - 1; j++) {
				sb.append(" ");
			}
			if (i == 0) {
				for (int j = 0; j < height - 1; j++) {
					sb.append("*");
				}
			} else if (i == height - 1) {
			
		 	} else {
				sb.append("*");
			}
			if (i != 0) {
				for (int j = 0; j < height - 2; j++) {
					sb.append(" ");
				}
			}
			sb.append("*");
			sb.append("\n");		
		}
		for (int i = 0; i < height - 1; i++) {
			for (int j = 0; j < height - 2 - i; j++) {
				sb.append(" ");
			}
			if (i == height - 2) {
				for (int j = 0; j < height; j++) {
					sb.append("*");
				}
			} else {
				sb.append("*");
			}
			if (i == height - 2) {
				
			} else {
				for (int j = 0; j < height - 2; j++) {
					sb.append(" ");
				}
			}		
			if (i == height - 2) {
				
			} else {
				sb.append("*");
			}
			for (int j = 0; j < (i + 1) * 2 - 1; j++) {
				sb.append(" ");
			}
			if (i == height - 2) {
				for (int j = 0; j < height - 1; j++) {
					sb.append("*");
				}
			} else {
				sb.append("*");
			}
			if (i == height - 2) {
				
			} else {
				for (int j = 0; j < height - 2; j++) {
					sb.append(" ");
				}
			}
			sb.append("*");
 			sb.append("\n");
		}
		System.out.println(sb);
	}
}