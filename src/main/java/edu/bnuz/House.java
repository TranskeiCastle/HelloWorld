package edu.bnuz;

import java.util.Date;

public class House implements Cloneable {
	private int id;
	private double area;
	private Date whenBuilt;
	public House() {
		
	}
	public House(int id, double area) {
		this.id = id;
		this.area = area;
		this.whenBuilt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Date getWhenBuilt() {
		return whenBuilt;
	}

	public void setWhenBuilt(Date whenBuilt) {
		this.whenBuilt = whenBuilt;
	}

	public Object myClone() throws CloneNotSupportedException {
		return super.clone();
	}
	protected void f() {
		System.out.println(".,,,,,,,,,,,,,,.");
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		House house1 = new House(1, 1750.0);
		House house2 = (House) house1.clone();
		house1.setWhenBuilt(null);
		System.out.println(house1 == house2);// false
		System.out.println(house1.id == house2.id);// true
		System.out.println(house1.whenBuilt == house2.whenBuilt);// true
		// Date类型应该属于引用啊，为什么我改了其中之一，另一个不会受影响？？我是浅复制
		System.out.println(house1.getWhenBuilt() + "  " + house2.getWhenBuilt());
		System.out.println(house1.getClass().getSuperclass().getName());
		
	}
}
