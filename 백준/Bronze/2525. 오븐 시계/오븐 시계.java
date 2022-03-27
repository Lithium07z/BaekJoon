import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (b + c >= 60) {
            if ((b + c)/60 + a > 23 && (b + c) % 60 == 0) {
                a = ((b + c)/60 + a - 24);
                System.out.print(a + " " + "0");
            } else if ((b + c)/60 + a > 23 && (b + c) % 60 != 0) {
                a = ((b + c)/60 + a - 24);
                System.out.print(a + " " + (b + c)%60);
            } else if ((b + c) % 60 == 0) {
                System.out.print((a + (b + c)/60) + " " + "0");
            } else {
                System.out.print((a + (b + c)/60) + " " + (b + c)%60);
            }
        } else if (b + c < 60) {
            System.out.print(a + " " + (b + c));
        } 
    } 
}