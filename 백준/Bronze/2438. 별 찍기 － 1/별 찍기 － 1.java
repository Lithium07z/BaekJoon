import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        
        for (int i = 1; i <= l; i++) {
        	for (int j = 0; j < i; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
    }
}