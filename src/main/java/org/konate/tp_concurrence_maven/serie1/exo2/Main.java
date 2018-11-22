package org.konate.tp_concurrence_maven.serie1.exo2;

public class Main {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(10);
		
		Runnable add = () -> warehouse.add();
		Runnable remove = () -> warehouse.remove();
	}

}
