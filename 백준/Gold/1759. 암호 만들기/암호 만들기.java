import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Character> word = new LinkedList<Character>();
	static LinkedList<Character> list = new LinkedList<Character>();
	static String[] vowel = { "a", "e", "i", "o", "u" };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			word.add(st.nextToken().charAt(0));
		}
		
		Collections.sort(word);
		
		Select(L, 0);
		
		bw.flush();
		bw.close();
	}
	
	public static void Select(int L, int cnt) {
		if (list.size() == L) {
			StringBuilder sb = new StringBuilder();
			int consonant = 0;
			int vowel = 0;
			
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if (list.get(i) == 'a' || list.get(i) == 'e' || list.get(i) == 'i' || list.get(i) == 'o' || list.get(i) == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}
			
			if (vowel >= 1 && consonant >= 2) {
				System.out.println(sb.toString());
			}
			return;
		}
		
		for (int i = cnt; i < word.size(); i++) {
			list.add(word.get(i));
			Select(L, i + 1);
			list.removeLast();
		}
	}
}