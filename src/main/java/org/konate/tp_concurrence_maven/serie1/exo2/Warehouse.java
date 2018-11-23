package org.konate.tp_concurrence_maven.serie1.exo2;

public class Warehouse {
	private int capacity;
	private int state;
	private Object[] wharehouseData;
	private Object lock = new Object();
	static int buffer;
	//private static Warehouse warehouse;

	public Warehouse(int capacity) {
		super();
		this.capacity = capacity;
		wharehouseData = new Object[capacity];
	}


	public boolean isFull(Object[] Obj) {
		return Obj.length<capacity;
	}

	public boolean isEmpty(Object[] Obj) {
		return Obj.length==0;
	}
	
	//Producer
	public void add(Object obj) throws InterruptedException {
		
		synchronized (lock) {
			//Used a buffer to buffer incoming in the wharehouse once he is full
			buffer++;
			if(buffer>capacity) wharehouseData = new Object[buffer + capacity];
			
			while (isFull(wharehouseData)) {
				lock.wait();
			}
			wharehouseData[state] = obj;
			state++;
			lock.notifyAll();
		}
	}
	
	//Consumer	
	public Object remove() throws InterruptedException {
		Object removedObject;
		synchronized (lock) {
			while (isEmpty(wharehouseData)) {
				lock.wait();
			}
			removedObject = wharehouseData[state];
			state--;
			lock.notifyAll();
		}
		return removedObject;
	}

	public int content() {
		return state;
	}

}
