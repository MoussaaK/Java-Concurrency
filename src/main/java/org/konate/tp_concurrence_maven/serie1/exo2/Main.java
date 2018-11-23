package org.konate.tp_concurrence_maven.serie1.exo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int capacity = 10;
		Warehouse warehouse = new Warehouse(capacity);
		
		Runnable producer = () -> {
			try {
				warehouse.add("Caisse");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable consumer = () -> {
			try {
				warehouse.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	
		/*System.out.println("State before add = " + warehouse.content());
		System.out.println("Capacity = " + capacity);
		producer.run();
		System.out.println("State after add = " + warehouse.content());
		
		consumer.run();
		System.out.println("state after remove = " + warehouse.content());*/
	
		//producer.run();
		ExecutorService executorS = Executors.newFixedThreadPool(4);
				/*executorS.execute(producer);
				executorS.execute(producer);
				Thread.sleep(10);*/
		List<Future<?>> futures = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			futures.add(executorS.submit(producer));
		}
		
		for (int i = 0; i < 95; i++) {
			Thread t = new Thread(consumer);
			t.start();
			t.join();
		}
		
		futures.forEach(t->{
			try {
				t.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		//Thread.sleep(10);
		System.out.println("Wharehouse's State : " + warehouse.content());
		
		//Runnable task = null;
		//service.execute(task);
	}

}
