package com.section2.constructor.intro;

public class Dog {
	String breed;
	String color;
	
	Dog(String b,String c){
		breed=b;
		color=c;
	}

	void bark() {
		System.out.println("Barks");
	}
	
	void run(){
		System.out.println("Runs");
	}

	public static void main(String[] args) {
		Dog dog=new Dog("Labrador","white");
	
		System.out.println(dog.breed);
		System.out.println(dog.color);
	}
}
