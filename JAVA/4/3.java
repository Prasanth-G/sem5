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
			output.setData(i);
			System.out.println(name + " Got " + input.getData());
		}
	}
}

class Test{
	public static void main(String[] args){
		CommonData CD1 = new CommonData();
		CommonData CD2 = new CommonData();
		
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
