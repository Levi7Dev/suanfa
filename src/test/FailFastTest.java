package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Levi
 * @create 2023/9/1 20:52
 */
public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("c".equals(next)) {
                //iterator删除不会触发fail-fast
                iterator.remove();
            }
            //直接修改原有list等集合惠触发fail-fast
            //如：list.add("h");
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
