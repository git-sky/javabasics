package cn.com.sky;


import cn.com.sky.tools.json.jackson.JsonUtils;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * <pre>
 * 组装多级结构对象的方式:
 *
 * 方式1：for循环嵌套查询DB,一边查询一边组装（组装方向:Parent->Son->GrandSon）；优点：实现简单；缺点：多次查询DB，DB压力大；
 * 方式2：分别查询DB，完全查询出来之后，再组装（组装方向:GrandSon->Son->Parent）；优点：DB只查询一次；缺点：组装逻辑有点复杂；
 *
 * </pre>
 */
public class MultiObjectAssemble2 {

    /**
     * 方式1：for循环嵌套查询DB；
     */
    @Test
    public void assembleUseForLoop() {
        //获取 Parent 列表
        List<Parent> parentList = queryParentFromDB();
        for (Parent parent : parentList) {
            //获取 Son 列表
            List<Son> sonList = querySonFromDB(parent.getId());
            parent.setSonList(sonList);
            for (Son son : sonList) {
                //获取 GrandSon 列表
                List<GrandSon> grandSonList = queryGrandSonFromDB(son.getId());
                son.setGrandSonList(grandSonList);
            }
        }

        System.out.println(JsonUtils.object2Json(parentList));

        Parent parent=new Parent();





    }

    //获取 Parent 列表
    private List<Parent> queryParentFromDB() {
        List<Parent> parentList = Lists.newArrayList();
        for (int i = 1; i <= 3; i++) {
            Parent parent = new Parent();
            parent.setId(i);
            parent.setName("parent" + i);
            parentList.add(parent);
        }
        return parentList;
    }

    //获取 Son 列表
    private List<Son> querySonFromDB(Integer parentId) {
        List<Son> sonList = Lists.newArrayList();
        Integer baseId = parentId * 10;
        for (int i = 1; i <= 3; i++) {
            Son son = new Son();
            son.setId(baseId + i);
            son.setName("son" + (baseId + i));
            sonList.add(son);
        }
        return sonList;
    }

    //获取 GrandSon 列表
    private List<GrandSon> queryGrandSonFromDB(Integer parentId) {
        List<GrandSon> grandSonList = Lists.newArrayList();
        Integer baseId = parentId * 10;
        for (int i = 1; i <= 3; i++) {
            GrandSon grandSon = new GrandSon();
            grandSon.setId(baseId + i);
            grandSon.setName("grandSon" + (baseId + i));
            grandSonList.add(grandSon);
        }
        return grandSonList;
    }

    private class Parent {
        private Integer id;
        private String name;
        private List<Son> sonList;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Son> getSonList() {
            return sonList;
        }

        public void setSonList(List<Son> sonList) {
            this.sonList = sonList;
        }
    }

    private class Son {
        private Integer id;
        private String name;
        private List<GrandSon> grandSonList;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<GrandSon> getGrandSonList() {
            return grandSonList;
        }

        public void setGrandSonList(List<GrandSon> grandSonList) {
            this.grandSonList = grandSonList;
        }
    }

    private class GrandSon {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}