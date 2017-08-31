package cn.com.sky.basics.calculate;

public class BitSort {  
    static int WORDLENGTH = 32;  
    static int SHIFT = 5;  
    static int MASK = 0x1F;  
    static int MAX = 10000000;  
    static int[] A = new int[(1 + MAX / WORDLENGTH)];  
                                                
    public static void main(String[] args) {  
        int[] data = {568746,12354,45798,1245,8,17,1,5};  
        bitsort(data);  
    }  
                                                
    public static void bitsort(int[] array) {  
        for (int i = 0; i < array.length; i++)  
            set(array[i]);  
        for (int i = 0; i < MAX; i++)  
            if (test(i))  
                System.out.println(i);  
    }  
                                                
    //将A[i>>SHIFT]的第(i & MASK)位置1  
    public static void set(int i) {  
        A[i >> SHIFT] |= (1 << (i & MASK));  
    }  
                                                
    //测试A[i>>SHIFT]的第(i & MASK)位置是否为1  
    public static boolean test(int i) {  
        return (A[i >> SHIFT] & (1 << (i & MASK)))  
                == (1 << (i & MASK));  
    }  
}  