package com.section2.constructor.intro;

public class FinalizeMethod {

	String name;
	@Override
	protected void finalize(){
		System.out.println("resourses released.");
	}
	
	public static void main(String[] args) {
		FinalizeMethod obj=new FinalizeMethod();
		obj=null;
		System.gc();
	}
}
