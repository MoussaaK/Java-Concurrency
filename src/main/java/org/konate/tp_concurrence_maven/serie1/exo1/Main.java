package org.konate.tp_concurrence_maven.serie1.exo1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Compteur compteur = new Compteur();

		Runnable task = () -> {
			for (int i = 0; i < 100; i++) {
				compteur.increment();
			}
		};

		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(task));
		}
		threads.forEach(Thread::start);

		//wait for all thread to die to be sure all thread have done counting
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(compteur.getCompteur());
		
		//Using AtomicApproche
		AtomicCompteur atomicCompteur = new AtomicCompteur();
		Runnable atomiqueTask = () -> {
			for (int i = 0; i < 100; i++) {
				atomicCompteur.increment();
			}
		};

		threads.clear();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(atomiqueTask));
		}
		threads.forEach(Thread::start);
		//wait for all thread to die to be sure all thread have done counting
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(atomicCompteur.getCompteur());
	}

}
