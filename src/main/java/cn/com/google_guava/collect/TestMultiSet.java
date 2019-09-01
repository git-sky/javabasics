package cn.com.google_guava.collect;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multiset和Set的区别就是可以保存多个相同的对象。
 * <p>
 * List可以包含多个相同对象，且是有顺序的，而Set不能有重复，且不保证顺序（有些实现有顺序，例如LinkedHashSet和SortedSet等）所以Multiset占据了List和Set之间的一个灰色地带：允许重复，但是不保证顺序。
 * 常见使用场景：Multiset有一个有用的功能，就是跟踪每种对象的数量，所以你可以用来进行数字统计。
 *
 *
 * <pre>
 *
 * 　Multiset接口定义的接口主要有：
 * 　　　　add(E element) :向其中添加单个元素
 * 　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
 * 　　　　count(Object element) : 返回给定参数元素的个数
 * 　　　　remove(E element) : 移除一个元素，其count值 会响应减少
 * 　　　　remove(E element,int occurrences): 移除相应个数的元素
 * 　　　　elementSet() : 将不同的元素放入一个Set中
 * 　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
 * 　　　　setCount(E element ,int count): 设定某一个元素的重复次数
 * 　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数
 * 　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素
 * 　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
 *
 * </pre>
 *
 *
 * <pre>
 *
 *  　Multiset的实现
 *
 * 　　Guava提供了Multiset的多种实现，这些实现基本对应了JDK中Map的实现：
 * 　　Map                        Corresponding Multiset   Supports null elements
 * 　　HashMap                  HashMultiset                      Yes
 * 　　TreeMap                   TreeMultiset                       Yes (if the comparator does)
 * 　　LinkedHashMap         LinkedHashMultiset             Yes
 * 　　ConcurrentHashMap  ConcurrentHashMultiset       No
 * 　　ImmutableMap          ImmutableMultiset               No
 *
 * </pre>
 */
public class TestMultiSet {


    //使用Map实现元素统计
    @Test
    public void testWordCountByMap() {
        String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";

        String[] words = strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, count + 1);
            }
        }
        System.out.println("countMap：");
        for (String key : countMap.keySet()) {
            System.out.println(key + " count：" + countMap.get(key));
        }
    }

    //使用Multiset实现元素统计
    @Test
    public void testWordCountByMultiset() {
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);


        //System.out.println("wordsMultiset："+wordsMultiset);

        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (!wordsMultiset.contains("peida")) {
            wordsMultiset.add("peida", 2);
        }
        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }


        if (wordsMultiset.contains("peida")) {
            wordsMultiset.setCount("peida", 23);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (wordsMultiset.contains("peida")) {
            wordsMultiset.setCount("peida", 23, 45);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

        if (wordsMultiset.contains("peida")) {
            //说明：setCount(E element,int oldCount,int newCount): 方法，如果传入的oldCount和element的不一致的时候，是不能将element的count设置成newCount的。需要注意。
            wordsMultiset.setCount("peida", 44, 67);
        }

        System.out.println("============================================");
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }
    }

}