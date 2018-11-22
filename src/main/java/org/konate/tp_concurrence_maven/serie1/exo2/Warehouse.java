package org.konate.tp_concurrence_maven.serie1.exo2;

public class Warehouse {
	private int capacity;
	private int state;
	
	public Warehouse(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	
	public boolean isFull() {
		return capacity==state;
	}
	public boolean isEmpty() {
		return state==0;
	}
	
	public int getCapacity() {
		return capacity;
	}


	public int getState() {
		return state;
	}


	public boolean add() {
		if (isFull()) {
			return false;
		} 
		state++;
		return true;
	}
	
	public boolean remove() {
		if (isEmpty()) {
			return false;
		} 
		state--;
		return true;
	}
	
	public int content() {
		return state;
		
	}
	
}
