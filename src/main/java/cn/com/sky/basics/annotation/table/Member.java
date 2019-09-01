package cn.com.sky.basics.annotation.table;

import cn.com.sky.basics.annotation.table.anno.Constraints;
import cn.com.sky.basics.annotation.table.anno.DBTable;
import cn.com.sky.basics.annotation.table.anno.SQLInteger;
import cn.com.sky.basics.annotation.table.anno.SQLString;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;
    public String getHandle() { return handle; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String toString() { return handle; }
    public Integer getAge() { return age; }
}
