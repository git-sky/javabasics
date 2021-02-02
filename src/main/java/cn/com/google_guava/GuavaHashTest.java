package cn.com.google_guava;

import com.google.common.collect.Sets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.Set;

public class GuavaHashTest {

    public static void main(String[] args) {

        HashFunction hf = Hashing.murmur3_128();

        Integer testSize = 20000000;

        Set<Integer> set = Sets.newHashSetWithExpectedSize(testSize);

        int containsSize = 0;

        for (int i = 0; i < testSize; i++) {
            int tmp = hf.newHasher().putInt(i).hash().asInt();
            if (i % 5000 == 0) {
                System.out.println("i=" + i);
            }
            if (set.contains(tmp)) {
                System.out.println("stopped at :" + i);
                containsSize++;
            } else {
                set.add(tmp);
            }
        }

        System.out.println("containsSize=" + containsSize);
        System.out.println("dup_ratio   =" + containsSize / (1.0 * testSize));
    }

}