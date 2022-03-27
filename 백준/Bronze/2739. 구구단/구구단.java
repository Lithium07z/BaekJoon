import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        
        for (int i = 1; i < 10; i++) {
            System.out.println(l + " * " + i + " = " + (i * l));
        }
    }
}