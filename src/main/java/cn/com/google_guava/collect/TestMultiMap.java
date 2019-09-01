package cn.com.google_guava.collect;

import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

/**
 * <pre>
 *
 *     Multimap的实现
 *
 * 　　Multimap提供了丰富的实现，所以你可以用它来替代程序里的Map<K, Collection<V>>，具体的实现如下：
 * 　　Implementation            Keys 的行为类似       　　　Values的行为类似
 * 　　ArrayListMultimap         HashMap                   　　ArrayList
 * 　　HashMultimap               HashMap                  　　 HashSet
 * 　　LinkedListMultimap        LinkedHashMap*              LinkedList*
 * 　　LinkedHashMultimap      LinkedHashMap                LinkedHashSet
 * 　　TreeMultimap                TreeMap                          TreeSet
 * 　　ImmutableListMultimap  ImmutableMap                 ImmutableList
 * 　　ImmutableSetMultimap  ImmutableMap                 ImmutableSet
 *
 *
 * 　　以上这些实现，除了immutable的实现都支持null的键和值。
 * 　　1.LinkedListMultimap.entries()能维持迭代时的顺序。
 *
 * 　　2.LinkedHashMultimap维持插入的顺序，以及键的插入顺序。
 * 　　要注意并不是所有的实现都正真实现了Map<K, Collection<V>>！（尤其是有些Multimap的实现为了最小话开销，使用了自定义的hash table）
 *
 *
 *
 * </pre>
 */
public class TestMultiMap {

    Map<String, List<StudentScore>> StudentScoreMap = new HashMap<>();

    @Test
    public void testStudentScore() {
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            addStudentScore("peida", studentScore);
        }

        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("peida"));

        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("jerry"));
        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.get("peida").size());

        List<StudentScore> StudentScoreList = StudentScoreMap.get("peida");
        if (StudentScoreList != null && StudentScoreList.size() > 0) {
            for (StudentScore stuScore : StudentScoreList) {
                System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
            }
        }
    }

    private void addStudentScore(final String stuName, final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }


    @Test
    public void testStudentScoreByMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        studentScore.clear();
        StudentScore studentScoreNew = new StudentScore();
        studentScoreNew.CourseId = 1034;
        studentScoreNew.score = 67;
        studentScore.add(studentScoreNew);

        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());
    }


    @Test
    public void testStudentScoreByMultimap2() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1 = new StudentScore();
        studentScore1.CourseId = 1034;
        studentScore1.score = 67;
        studentScore.add(studentScore1);

        StudentScore studentScore2 = new StudentScore();
        studentScore2.CourseId = 1045;
        studentScore2.score = 56;
        scoreMultimap.put("jerry", studentScore2);

        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());


        for (StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
        }

        scoreMultimap.remove("jerry", studentScore2);
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.get("jerry"));

        scoreMultimap.put("harry", studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.get("harry"));
    }


}

class StudentScore {
    int CourseId;
    int score;
}