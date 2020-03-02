package com.ttan.jdk8;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月18日 下午3:57:55
 */
public class InterfaceImpl implements Interface2,Interface1{

	public static void main(String[] args) {
		Interface1.staticFunc();
		Interface2.staticFunc();
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ttan.jdk8.Interface1#test1()
	 */
	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

}
