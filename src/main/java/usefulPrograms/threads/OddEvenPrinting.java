package usefulPrograms.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrinting extends Thread{
    boolean isOdd;

    //declaring it int not working
    static AtomicInteger i=new AtomicInteger(1);

    public OddEvenPrinting(boolean isOdd){
        this.isOdd=isOdd;
    }

    @Override
    public void run() {
        while(i.get()<100) {
            if (isOdd) while (i.get() % 2 == 0) ;
            else while (i.get() % 2 == 1) ;
            System.out.println("I am " + (this.isOdd?"ODD":"EVEN") +" thread and printing " + i.get());
            i.incrementAndGet();
        }
    }
}
