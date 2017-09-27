//Deadlock

class Resource{
    public String name;
    public Integer value;

    public Resource(String name, Integer value){
        this.name = name;
        this.value = value;
    }
}

class addAndIncrement extends Thread{
    
    String name;
    Resource first, second;
    public addAndIncrement(String name, Resource first, Resource second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }
    
    @Override
    public void run() {
		while(true){
            synchronized(first.value){
                System.out.println(name + " is holding " + first.name);
                System.out.println(name + "is waiting for " + second.name);
                synchronized(second.value){
                    System.out.println(name + " is holding " + second.name);
                    System.out.println(first.value + second.value);
                    first.value++;
                    second.value++;
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args){
        Integer a = 1,b = 2;
        Resource r1 = new Resource("Resource 1", a);
        Resource r2 = new Resource("Resource 2", b);
        addAndIncrement w1 = new addAndIncrement("W1", r1, r2);
        addAndIncrement w2 = new addAndIncrement("W2", r2, r1);
        System.out.println("Start");
        w1.start();
        try { Thread.sleep(10);}
        catch (InterruptedException e) {}
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