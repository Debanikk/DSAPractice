package com.wildfire.PracticeSetAugust;

import java.util.List;

public class OddProducer implements Runnable {

    private int counter = 0;
    private final int N;
    private int oddInt = 1;
    private List<Integer> synchronizedQueue;

    public OddProducer(int n, List<Integer> synchronizedQueue) {
        this.N = n;
        this.synchronizedQueue = synchronizedQueue;
    }

    @Override
    public void run() {
        while (synchronizedQueue.size() < N) {
            try {
                System.out.println("Queue size from odd run method - " + synchronizedQueue.size());
                produceOddIntegers(N);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void produceOddIntegers(int limit) throws InterruptedException {
        synchronized (synchronizedQueue) {
            while (counter > 0) {
                try {
                    counter--;
                    System.out.println("SynchronousQueue is waiting for next Odd print order");
                    synchronizedQueue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (oddInt % 2 == 1) {
                Thread.sleep(1000);
                synchronizedQueue.add(oddInt);
                System.out.println(String.format("Odd value is - %s", oddInt));
                counter++;
                oddInt = oddInt + 2;
                synchronizedQueue.notify();
            }
        }
    }
}
