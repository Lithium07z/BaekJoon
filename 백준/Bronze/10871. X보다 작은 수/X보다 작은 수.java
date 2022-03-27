import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    	List<Integer> list = new ArrayList<Integer>();
    	
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] array = new int[a];
        
        for (int i = 0; i < a; i++) {
            array[i] = sc.nextInt();
            if (array[i] < b) {
            	list.add(array[i]);
            }
        }
        for (int j = 0; j < list.size(); j++) {
        	System.out.print(list.get(j) + " ");
        }	
    }
}