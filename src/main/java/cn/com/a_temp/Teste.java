package cn.com.a_temp;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 */
public class Teste {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        Set<Integer> set = Sets.newHashSet();

        set.add(new Integer(1));
        int x=1;
        if(set.contains(x)){
            System.out.println("dddd");
        }


        List<Callable<Integer>> list = Lists.newArrayList();
        for (int i = 1; i <= 1000; i++) {
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int a = RandomUtils.nextInt();
                    if (set.contains(a)) {
                        System.out.println("xxxxxxxxxx");
                    }
                    set.add(a);
                    return a;
                }
            };
            list.add(callable);
        }

        executorService.invokeAll(list);

        executorService.shutdown();

        System.out.println(set.size());

    }
}