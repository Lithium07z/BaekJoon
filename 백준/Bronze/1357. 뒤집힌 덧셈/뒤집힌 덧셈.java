import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
		String fNum = st.nextToken();
		String bNum = st.nextToken();
		
		for (int i = 0; i < fNum.length(); i++) {
			list1.add(fNum.charAt(i));
		}
		for (int i = 0; i < bNum.length(); i++) {
			list2.add(bNum.charAt(i));
		}
		Collections.reverse(list1);
		Collections.reverse(list2);
		String value1 = "";
		String value2 = "";
		for (int i = 0; i < fNum.length(); i++) {
			value1 += list1.get(i);
		}
		for (int i = 0; i < bNum.length(); i++) {
			value2 += list2.get(i);
		}
		int Num = Integer.parseInt(value1) + Integer.parseInt(value2);
		for (int i = 0; i < String.valueOf(Num).length(); i++) {
			list3.add(String.valueOf(Num).charAt(i));
		}
		Collections.reverse(list3);
		String result = "";
		for (int i = 0; i < list3.size(); i++) {
			result += list3.get(i);
		}
		bfw.write(String.valueOf(Integer.parseInt(result)));
		bfw.flush();
		bfw.close();
	}
}