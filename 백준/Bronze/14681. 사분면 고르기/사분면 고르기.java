import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        if (a > 0 && b > 0) {
            System.out.print("1");
        } else if (a > 0 && b < 0) {
            System.out.print("4");
        } else if (a < 0 && b > 0) {
            System.out.print("2");
        } else if (a < 0 && b < 0) {
            System.out.print("3");
        }
    }
}