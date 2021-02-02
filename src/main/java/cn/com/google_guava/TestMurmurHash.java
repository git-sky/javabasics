package cn.com.google_guava;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.junit.Test;

/**
 * MurmurHash 是一种非加密型哈希函数，适用于一般的哈希检索操作。
 * 与其它流行的哈希函数相比，对于规律性较强的key，MurmurHash的随机分布特征表现更良好。
 * <p>
 * <p>
 * 注意：需要强调的一点就是，如果你想在任何时候，相同的String值一定得出相同hash值，就一定要新创建hasher。
 */
public class TestMurmurHash {

    @Test
    public void test1() {
        /**
         * 需要强调的一点就是，如果你想在任何时候，相同的String值一定得出相同hash值，就一定要新创建hasher。
         */
        HashFunction hf = Hashing.murmur3_128();
        String str = "test";
        System.out.println(hf.newHasher().putString(str, Charsets.UTF_8).hash().asInt());
        System.out.println(hf.newHasher().putString(str, Charsets.UTF_8).hash().asInt());

    }


    @Test
    public void test2() {
        /**
         * 可以看到，如果复用hasher的话，即使是同一个string对象，hash值也不一样了。
         */
        HashFunction hf = Hashing.murmur3_128();
        Hasher hasher = hf.newHasher();
        String str = "test";
        System.out.println(hasher.putString(str, Charsets.UTF_8).hash().asInt());
        System.out.println(hasher.putString(str, Charsets.UTF_8).hash().asInt());
    }

}