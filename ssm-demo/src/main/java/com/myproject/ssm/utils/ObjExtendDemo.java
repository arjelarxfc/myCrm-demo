package com.myproject.ssm.utils;

public class ObjExtendDemo {

	public static void main(String[] args) {
		Derived d = new Derived();

		Base bd = new Derived();
		System.out.println(bd.count);// 2
		bd.info();// 20

		Base b2d = d;
		System.out.println(b2d.count);// 2
		b2d.info();// 20

	}

}

class Base {
	int count = 2;

	public void info() {
		System.out.println(this.count);
	}
}

class Derived extends Base {
	int count = 20;

	@Override
	public void info() {
		System.out.println(this.count);
	}
}
