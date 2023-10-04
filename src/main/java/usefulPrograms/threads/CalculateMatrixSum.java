package usefulPrograms.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculateMatrixSum extends Thread {

    public static AtomicInteger totalSum = new AtomicInteger(0);
    public int rowSum;
    private final int[] row;

    public CalculateMatrixSum(int[] arr) {
        this.rowSum = 0;
        this.row = arr;
    }

    @Override
    public void run() {
        for (int i : row) rowSum += i;
        totalSum.addAndGet(rowSum);
    }
}
