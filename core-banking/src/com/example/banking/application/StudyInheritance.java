package com.example.banking.application;

public class StudyInheritance {

	public static void main(String[] args) {
		A a = new A();
		E e = new E(42);

	}

}

//class A {}
class A extends Object { //no-arg constructor
	public A() {
		super();
	}
}

class E {
	public E(int x) {}
}

class F extends E {
	public F( ) {
		super(42);
	}
}
