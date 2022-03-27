import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int l = sc.nextInt();
        int[] array = new int[l];
        
        for(int i = 0; i < l; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            array[i] = a+b;
        }
        for (int value : array) {
            System.out.println(value);
        }
    }
}