import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        
        for (int i = 1; i <= l; i++) {
            for (int j = l-i; j > 0; j--) {
                System.out.print(" ");
            }
        	for (int k = 0; k < i; k++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
    }
}