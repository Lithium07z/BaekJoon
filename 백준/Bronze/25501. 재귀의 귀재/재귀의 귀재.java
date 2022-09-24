import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

		int loop = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < loop; i++) {
			bfw.write(isPalindrome(bfr.readLine()) + " " + count + "\n");
			count = 0;
		}
        bfw.flush();
        bfw.close();
	}

	public static int recursion(String s, int l, int r) {
		count++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}
}