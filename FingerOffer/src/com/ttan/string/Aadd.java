package com.ttan.string;

import java.util.Hashtable;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @Description: 
 * @author ttan
 * @time 2019年10月22日 下午3:11:31
 */
public class Aadd {
	public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        String s3 = "Hello";
        String s4 = "World";
        String s5 = "Hello" + "World";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);  //false
        System.out.println(s1 == s5);  //true
        System.out.println(s1 == s6);  //false 此处s6=new String(s3 + s4)
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
	}
}
