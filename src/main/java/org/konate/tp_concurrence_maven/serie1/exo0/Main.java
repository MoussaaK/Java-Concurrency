package org.konate.tp_concurrence_maven.serie1.exo0;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Runnable task = () -> System.out.println(Thread.currentThread().getName());
		
		
		Thread thread = new Thread(task);
		thread.start();
		
		Callable<Object> callable = Executors.callable(task);		
		try {
			callable.call();
		} catch (Exception e) {
			
		}
	}
}
