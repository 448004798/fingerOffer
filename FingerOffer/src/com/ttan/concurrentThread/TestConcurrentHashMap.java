package com.ttan.concurrentThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月25日 上午11:24:57
 */
public class TestConcurrentHashMap {

	public static void main(String[] args) {
		new ConcurrentHashMap<>();
		new ConcurrentLinkedQueue<>();
		new ArrayBlockingQueue<>(10);
		new LinkedBlockingQueue<>();
		new PriorityBlockingQueue<>();
		new DelayQueue<>();
		new SynchronousQueue<>();
		new CopyOnWriteArrayList<>();
	}
}
