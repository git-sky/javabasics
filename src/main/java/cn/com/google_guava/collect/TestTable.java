package cn.com.google_guava.collect;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;


/**
 * <pre>
 *     当我们需要多个索引的数据结构的时候，通常情况下，我们只能用这种丑陋的Map<FirstName, Map<LastName, Person>>来实现。
 *     为此Guava提供了一个新的集合类型－Table集合类型，来支持这种数据结构的使用场景。Table支持“row”和“column”，而且提供多种视图。
 *
 *
 * </pre>
 */
public class TestTable {

    @Test
    public void TableTest() {
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable.column(2));
        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));
    }


}