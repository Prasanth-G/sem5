class CommonData {
	int data;
	boolean semaphore = false;
	synchronized void setData(int x) {
		if(semaphore == true) {
			try {
				wait();
			}
			catch(InterruptedException e1) {}
		}
		data = x;
		semaphore = true;
		notify();
	}
	synchronized int getData() {
		int x;
		if(semaphore == false) {
			try {
				wait();
			}
			catch(InterruptedException e2) {}
		}
		x = data;
		semaphore = false;
		notify();
		return x;
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
			data.setData(i);
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
			System.out.println(data.getData());
		}
	}
}

class Test{
	public static void main(String[] args){
		CommonData CD = new CommonData();
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
