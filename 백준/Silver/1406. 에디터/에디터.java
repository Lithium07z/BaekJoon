import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> list = new LinkedList<Character>();
		
		for (char t : bfr.readLine().toCharArray()) {
			list.add(t);
		}
		
		ListIterator<Character> liter = list.listIterator();
		int M = Integer.parseInt(bfr.readLine());
		
		while (liter.hasNext()) {
			liter.next();
		}
		
		for (int i = 0; i < M; i++) {
			String temp = bfr.readLine(); 
			if (temp.equals("L")) {
				if (liter.hasPrevious()) {
					liter.previous();
				}
			} else if (temp.equals("D")) {
				if (liter.hasNext()) {
					liter.next();
				}
			} else if (temp.equals("B")) {
				if (liter.hasPrevious()) {
					liter.previous();
					liter.remove();
				}
			} else {
				liter.add(temp.charAt(2));
			}
		}
		for (char r : list) {
			bfw.write(r);
		}
		bfw.flush();
		bfw.close();
	}
}