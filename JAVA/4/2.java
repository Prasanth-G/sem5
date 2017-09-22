class Queue {
	int[] array;
	int head, tail, size;

	public Queue(int size){
		this.array = new int[size];
		this.head = 0;
		this.tail = 0;
		this.size = size;
	}
	synchronized void enqueue(int data) {
		if (head == (tail + 1) % size){
			try {
				wait();
			}
			catch(InterruptedException e1) {}
		}
		array[tail] = data;
		tail++;
		tail %= size;
		notify();
	}
	synchronized int dequeue() {
		if (head == tail){
			try {
				wait();
			}
			catch(InterruptedException e1) {}
		}
		int temp = array[head];
		head++;
		head %= size;
		notify();
		return temp;
	}
}

class Producer extends Thread{
	
	Queue queue;
	public Producer(Queue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			queue.enqueue(i);
		}
	}
}

class Consumer extends Thread {
	
	Queue queue;
	public Consumer(Queue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		for(int j=0; j<=10; j++) {
			System.out.println(queue.dequeue());
		}
	}
}

class Test{
	public static void main(String[] args){
		Queue CD = new Queue(5);
		Producer p = new Producer(CD);
		Consumer c = new Consumer(CD);
		System.out.println("Start");
		p.start();
		c.start();
		try{
			p.join();
			c.join();
		}catch (InterruptedException e){
			System.out.println(e);
		}
		System.out.println("End");
	}
}
