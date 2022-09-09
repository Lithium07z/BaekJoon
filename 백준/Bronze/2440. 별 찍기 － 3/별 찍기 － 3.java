import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		
		for (int i = 0; i < height; i++ ) {
			for (int j = height - i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}