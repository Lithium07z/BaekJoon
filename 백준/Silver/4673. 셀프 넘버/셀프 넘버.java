public class Main {
    public static void main(String[] args) {
        int[] value = new int [10000];
        int[] NotSelf = new int [10000];
        
        for (int i = 0; i < value.length; i++) {
        	value[i] = i + 1;
        }
        for (int i = 0; i < value.length; i++) {
        	NotSelf[i] = count(value[i]); 
        }
        for (int i = 0; i < value.length; i++) {
        	for (int j = 0; j < NotSelf.length; j++) {
        		if (value[i] == NotSelf[j]) {
        			value[i] = 0;
        		}
        	}
        }
        for (int total : value) {
        	if (total == 0) {
        	} else {
        		System.out.println(total);
        	}
        }
    }
    
    public static int count(int value) {
    	int a = value;
		String s = String.valueOf(value);
		for (int i = 0; i < s.length(); i++) {
			a += s.charAt(i) - '0';
		}
		return a;
    }
}