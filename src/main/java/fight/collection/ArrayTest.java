package fight.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArrayTest {

    /**
     * 从后往前遍历
     */
    @Test
    public void removeFromEnd() {
        List<String> nameList = Arrays.asList("H", "I", "J", "K");
        List<Integer> ageList = Arrays.asList(20, 20, 30, 40);
        List<NPC> npcList = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            NPC temp = new NPC(nameList.get(i), ageList.get(i));
            npcList.add(temp);
        }
        // npcList.forEach(System.out::println);
        // 采用lambda表达式过滤
        // npcList.stream().filter(e -> e.getAge() != 20).forEach(System.out::println);

        // 从后往前遍历
        for (int i = npcList.size() - 1; i >= 0; i--) {
            NPC temp = npcList.get(i);
            if (temp.getAge() == 20 || temp.getAge() == 30) {
                npcList.remove(temp);
            }
        }
        npcList.forEach(System.out::println);
    }

    /**
     * 从前往后遍历，因为每删除一个元素，余下元素要往前挪一个位置，所以需要控制一下循环变量
     */
    @Test
    public void removeFromStart() {
        List<String> nameList = Arrays.asList("H", "I", "J", "K");
        List<Integer> ageList = Arrays.asList(20, 20, 30, 40);
        List<NPC> npcList = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            NPC temp = new NPC(nameList.get(i), ageList.get(i));
            npcList.add(temp);
        }
        // 从前往后遍历
        for (int i = 0, size = npcList.size(); i < size; i++) {
            NPC temp = npcList.get(i);
            if (temp.getAge() == 20 || temp.getAge() == 30) {
                npcList.remove(temp);
                size--;
                i--;
            }
        }
        npcList.forEach(System.out::println);
    }

    /**
     * for-each，如果不在删除操作之后执行break，下次就会发现集合被修改过了，报错java.util.ConcurrentModificationException
     * for-each的底层也是转化成iterator
     */
    @Test
    public void removeByForEach() {
        List<String> nameList = Arrays.asList("H", "I", "J", "K");
        List<Integer> ageList = Arrays.asList(20, 20, 30, 40);
        List<NPC> npcList = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            NPC temp = new NPC(nameList.get(i), ageList.get(i));
            npcList.add(temp);
        }

        // for-each
        for (NPC npc : npcList) {
            if (npc.getAge() == 20 || npc.getAge() == 30) {
                npcList.remove(npc);
                // break;
            }
        }
        npcList.forEach(System.out::println);
    }

    @Test
    public void removeByIterator() {
        List<String> nameList = Arrays.asList("H", "I", "J", "K");
        List<Integer> ageList = Arrays.asList(20, 20, 30, 40);
        List<NPC> npcList = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            NPC temp = new NPC(nameList.get(i), ageList.get(i));
            npcList.add(temp);
        }

        // iterator
        Iterator<NPC> it = npcList.iterator();
        while (it.hasNext()) {
            Integer age = it.next().getAge();
            if (age == 20 || age == 30) {
                it.remove();
            }
        }
        npcList.forEach(System.out::println);
    }

    /**
     * 删除时传递对象还是下标
     */
    @Test
    public void removeByIntegerOrInt() {
        List<Integer> list = new ArrayList<>(8);
        list.add(5);
        list.add(10);
        list.add(10);
        list.add(25);
        list.add(35);
        // 传“10”会报错，数组越界
        list.remove(0);
        list.remove(new Integer(10));
        // 打印内容：10、25、35
        list.forEach(System.out::println);
    }

    /**
     * 迭代器remove()方法虽然方便，但仍有需要注意的地方，要用此法删除元素的前提是该 List
     * 的实现类的iterator()方法返回的Iterator实现类支持remove()方法，否则会报
     * java.lang.UnsupportedOperationException异常，常用的ArrayList的Iterator支持remove()方法，但下面这种情况下就会有问题
     */
    @Test
    public void removeByIter() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.asList(arr);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer item = iter.next();
            if (item == 2) {
                iter.remove();
            }
        }
    }

}

class NPC {
    private String name;
    private Integer age;

    public NPC(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "NPC [name=" + name + ", age=" + age + "]";
    }

}
