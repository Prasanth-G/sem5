
class Resource{
    public String name;
    public Integer value;

    public Resource(String name, Integer value){
        this.name = name;
        this.value = value;
    }
}

class Variables{
    public boolean[] wantToEnter;
    public int turn;

    public Variables(){
        wantToEnter = new boolean[2];
        wantToEnter[0] = false;
        wantToEnter[1] = false;
        turn = 0;
    }
}
class Thread1 extends Thread{
    String name;
    Resource first, second;
    Variables var;                //To check whether we can enter into critical section or not.
    public Thread1(Variables v, String name, Resource first, Resource second) {
        this.var = v;
        this.name = name;
        this.first = first;
        this.second = second;
    }
    
    @Override
    public void run() {
        while(true){
            //Check resources are available using dekker's algo
            var.wantToEnter[0] = true;
            while (var.wantToEnter[1]){           //While Thread 2 want the resource, i'll check whose turn is this
                if (var.turn != 0){                 //if it is Not My Turn
                    var.wantToEnter[0] = false;   //I don't want the resource now
                    while (var.turn != 0){
                        try{ Thread.sleep(10);}
                        catch(InterruptedException e){}
                    }
                    var.wantToEnter[0] = true;
                }
            }

            //Critical section - start
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
            //End

            var.turn = 1;
            var.wantToEnter[0] = false;
        }
    }
}

class Thread2 extends Thread{
    String name;
    Resource first, second;
    Variables var;                //To check whether we can enter into critical section or not.
    public Thread2(Variables v, String name, Resource first, Resource second) {
        this.var = v;
        this.name = name;
        this.first = first;
        this.second = second;
    }
    
    @Override
    public void run() {
        while(true){
            //Check resources are available using dekker's algo
            var.wantToEnter[1] = true;
            while (var.wantToEnter[0]){           //While Thread 1 want the resource, i'll check whose turn is this
                if (var.turn != 1){                 //if it is Not My Turn
                    var.wantToEnter[1] = false;   //I don't want the resource now
                    while (var.turn != 1){
                        try{ Thread.sleep(10);}
                        catch(InterruptedException e){}
                    }
                    var.wantToEnter[1] = true;
                }
            }

            //Critical section - start
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
            //End

            var.turn = 0;
            var.wantToEnter[1] = false;
        }
    }
}


class Main{
    public static void main(String[] srgs){
        Variables v = new Variables();
        Integer a = 1,b = 2;
        Resource r1 = new Resource("Resource 1", a);
        Resource r2 = new Resource("Resource 2", b);
        Thread1 t1 = new Thread1(v, "W1", r1, r2);
        Thread2 t2 = new Thread2(v, "W2", r2, r1);
        System.out.println("Start");
        t1.start();
        try { Thread.sleep(10);}
        catch (InterruptedException e) {}
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("End");
    }
}