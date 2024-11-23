package ru.itkacademy.practice.reqursiveFactorial;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
public class FactorialTask extends RecursiveTask<Long>{
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }
    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L;
        } else {

            FactorialTask subTask = new FactorialTask(n - 1);
            subTask.fork();

            long subResult = subTask.join();
            return n * subResult;
        }
    }

}
