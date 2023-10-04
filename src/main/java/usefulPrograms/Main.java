package usefulPrograms;

import usefulPrograms.threads.CalculateMatrixSum;
import usefulPrograms.threads.OddEvenPrinting;


public class Main{
    public static void main(String[] args) {
        //calculate matrix sum using threads
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        CalculateMatrixSum thread1=new CalculateMatrixSum(matrix[0]);
        thread1.start();
        CalculateMatrixSum thread2=new CalculateMatrixSum(matrix[1]);
        thread2.start();
        CalculateMatrixSum thread3=new CalculateMatrixSum(matrix[2]);
        thread3.start();
        while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());
        System.out.println("Total sum of your matrix is "+ CalculateMatrixSum.totalSum);
        //print even and odd number alternatively using two threads
        OddEvenPrinting oddNoThread=new OddEvenPrinting(true);
        oddNoThread.start();
        OddEvenPrinting evenNoThread=new OddEvenPrinting(false);
        evenNoThread.start();
        while(oddNoThread.isAlive() || evenNoThread.isAlive());
        /////////////////////////////////////////////////////////////////
        ///Check custom hashmap
        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put(5,100);
        System.out.println(myHashMap.get(5));
        myHashMap.put(5,99);
        System.out.println(myHashMap.get(5));
        myHashMap.remove(5);
        System.out.println(myHashMap.get(5));

    }
}