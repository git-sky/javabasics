package cn.com.sky.basics.test_file;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;

import javax.mail.search.SearchTerm;
import java.io.*;
import java.util.List;
import java.util.Set;

public class TestDifffile {
    public static void main(String args[]) {


        try {
            Set<String> allOpenIds = Sets.newHashSet();

            BufferedReader br = new BufferedReader(new FileReader("/Users/Downloads/abc.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                allOpenIds.add(StringUtils.trim(line));
            }


            Set<String> hasOpenIds = Sets.newHashSet();

            BufferedReader br2 = new BufferedReader(new FileReader("/Users/sky/Documents/openId_mgcId_result.txt"));
            String line2 = "";
            while ((line2 = br2.readLine()) != null) {
                if (StringUtils.isBlank(line2)) {
                    continue;
                }
                String[] openId = line2.split(",");
                hasOpenIds.add(StringUtils.trim(openId[0]));
            }

            System.out.println(allOpenIds.size());
            System.out.println(hasOpenIds.size());

            System.out.println();
            System.out.println(Sets.difference(allOpenIds, hasOpenIds));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
