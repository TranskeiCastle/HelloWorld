package test.clone;

/**
 * 修改p2后，没有对p1产生影响。
 * 
 * 是因为修改的数据域属于基本数据类型麽？那我弄个List试试。。。Date是属于什么类型？既不是基本数据类型，又不是引用
 * @author Castle
 *
 */

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("zhangsan", 18);
		Person p2 = (Person) p1.clone();
		p2.setName("lis");
		p2.setAge(20);
		// 修改p2后，没有对p1产生影响。
		System.out.println("name=" + p1.getName() + ",age=" + p1.getAge());
	}
}
