package org.konate.tp_concurrence_maven.serie1.exo1;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCompteur {
	private AtomicLong compteur = new AtomicLong();

	public AtomicLong getCompteur() {
		return compteur;
	}

	public void increment() {
		compteur.incrementAndGet();
	}
}
