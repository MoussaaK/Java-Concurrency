package org.konate.tp_concurrence_maven.serie1.exo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(10);
		
		Runnable add = () -> warehouse.add();
		Runnable remove = () -> warehouse.remove();
	
		System.out.println("State before add = " + warehouse.getState());
		System.out.println("Capacity = " + warehouse.getCapacity());
		add.run();
		System.out.println("State after add = " + warehouse.getState());
		
		remove.run();
		System.out.println("state after remove = " + warehouse.getState());
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		Runnable task = null;
		service.execute(task);
	}

}
