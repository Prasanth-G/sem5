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

class Producer extends Thread{
	
	CommonData data;
	public Producer(CommonData data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			data.enqueue(i);
		}
	}
}

class Consumer extends Thread {
	
	CommonData data;
	public Consumer(CommonData data) {
		this.data = data;
	}
	@Override
	public void run() {
		for(int j=0; j<=10; j++) {
			System.out.println(data.dequeue());
		}
	}
}

class Test{
	public static void main(String[] args){
		CommonData CD = new CommonData(5);
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
