class CommonData {
	int[] arr;
	int i, j, n;
	boolean semaphore = false;
	public CommonData(int n){
		this.arr = new int[n];
		this.i = 0;
		this.j = 0;
		this.n = n;
	}
	synchronized void enqueue(int a) {
		if (i == (j+1)%n){
			try {
				wait();
			}
			catch(InterruptedException e1) {}
		}
		arr[j] = a;
		j++;
		j = j % n;
		notify();
	}
	synchronized int dequeue() {
		if (i == j){
			try {
				wait();
			}
			catch(InterruptedException e1) {}
		}
		int temp = arr[i];
		i++;
		i = i % n;
		notify();
		return temp;
	}
}

class Worker extends Thread{
	
	String name;
	CommonData input;
	CommonData output;
	public Worker(String name, CommonData input, CommonData output) {
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
		CommonData CD1 = new CommonData(5);
		CommonData CD2 = new CommonData(5);
		
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
