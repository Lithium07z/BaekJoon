import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (a == b && b == c && c == a) {
            System.out.print(10000 + (a * 1000));
        } else if (a == b) {
            System.out.print(1000 + (a * 100));
        } else if (b == c) {
            System.out.print(1000 + (b * 100));
        } else if (c == a) {
            System.out.print(1000 + (c * 100));
        } else {
            if (a > b && a > c) {
                System.out.print(a * 100);
            } else if (b > c && b > a) {
                System.out.print(b * 100);
            } else if (c > b && c > a) {
                System.out.print(c * 100);
            }
        }
        
    }
}