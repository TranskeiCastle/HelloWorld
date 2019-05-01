package test.clone;

import java.util.Calendar;
import java.util.Date;

public class Person implements Cloneable {
	private String name;
	private int age;
	private Date birthday;
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	
	public static void main(String[] args) {
		Person p1 = new Person("zhangsan", 18);
		Calendar c = Calendar.getInstance();
		c.set(2016,  11, 17);
		p1.setBirthday(c.getTime());
		Person p2 = (Person) p1.clone();
		Calendar c2 = Calendar.getInstance();
		c2.set(2016, 10,17);
		p2.setName("lis");
		p2.setAge(20);
		p2.setBirthday(c2.getTime());
		// 修改p2后，没有对p1产生影响。我修改的日期不是一个引用对象嘛？
		System.out.println("name=" + p1.getName() + ",age=" + p1.getAge() + ",birthday=" + p1.getBirthday());
		System.out.println("name=" + p2.getName() + ",age=" + p2.getAge() + ",birthday=" + p2.getBirthday());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}