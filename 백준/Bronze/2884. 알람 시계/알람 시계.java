import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int m = input.nextInt();
        
        if (h == 0 && m - 45 < 0) {
            System.out.print("23" + " " + (m +15));
        } else if (m - 45 < 0) {
        	System.out.println(h-1 + " " + (m +15));
        } else {
            System.out.print(h + " " + (m -45));
        }  
    }
}