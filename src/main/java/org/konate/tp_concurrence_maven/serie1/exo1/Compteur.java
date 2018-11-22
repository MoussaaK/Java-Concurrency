package org.konate.tp_concurrence_maven.serie1.exo1;

public class Compteur {
	private int compteur;

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	public void increment() {
		synchronized (this) {
			this.compteur += 1;
		}
	}
}
