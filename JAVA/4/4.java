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

class Worker extends Thread{
	
	String name;
	Queue input, output;
	public Worker(String name, Queue input, Queue output) {
		this.name = name;
		this.input = input;
		this.output = output;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println(name + " Send " + i);
			output.enqueue(i);
			System.out.println(name + " Got " + input.dequeue());
		}
	}
}

class Test{
	public static void main(String[] args){
		Queue CD1 = new Queue(5);
		Queue CD2 = new Queue(5);
		
		Worker w1 = new Worker("W1", CD1, CD2);
		Worker w2 = new Worker("W2", CD2, CD1);
		System.out.println("Start");
		w1.start();
		w2.start();
		try{
			w1.join();
			w2.join();
		}catch (InterruptedException e){
			System.out.println(e);
		}
		System.out.println("End");
	}
}
