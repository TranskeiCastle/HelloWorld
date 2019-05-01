package edu.bnuz;

public class HouseTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		House house1 = new House(1, 1750.0);
		House house2 = (House) house1.myClone();
		System.out.println(house1 == house2);
		System.out.println(house1.getId() == house2.getId());
		System.out.println(house1.getWhenBuilt() == house2.getWhenBuilt());
		System.out.println(house1.getWhenBuilt());
		// 对2的改变并不影响1
		house2.setArea(20.0);
		house2.setWhenBuilt(null);
		System.out.println(house1.getArea());
		System.out.println(house2.getArea());
		System.out.println(house1.getWhenBuilt());
		System.out.println(house2.getWhenBuilt());
	}
}
