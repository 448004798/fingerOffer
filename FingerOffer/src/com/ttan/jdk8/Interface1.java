package com.ttan.jdk8;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月18日 下午3:57:05
 */
public interface Interface1 extends Interface2,Interface3{

	public void test1();
	
	public static void staticFunc(){
		System.out.println("Interface1");
	}
}
