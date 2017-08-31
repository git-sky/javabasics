package cn.com.sky.basics.calculate;

import java.util.BitSet;

public class BitSort2 {  
    static int MAX = 10000000;  
                               
    public static void main(String[] args) {  
        int[] data = { 5746, 14, 498, 125, 8, 17, 1, 5 };  
        BitSet bitSet = new BitSet(MAX);  
        for (int i : data) {  
            bitSet.set(i);  
        }  
        for (int i = 0; i < MAX; i++) {  
            if(bitSet.get(i)){  
                System.out.println(i);  
            }  
        }  
    }  
}  