import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int a = -1;
		int b = -1;

		while (a != 0 && b != 0) {
			a = sc.nextInt();
			b = sc.nextInt();
			if (a != 0 && b != 0) {
				list.add(a + b);	
			}
		}
		int c = 0;
		while (c != list.size()) {
			System.out.println(list.get(c));
			c += 1;
		}
    }
}