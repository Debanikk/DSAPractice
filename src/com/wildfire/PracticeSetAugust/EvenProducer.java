package com.wildfire.PracticeSetAugust;

import java.util.List;

public class EvenProducer implements Runnable {
    private int counter = 0;
    private final int N;
    private int evenInt = 0;
    private List<Integer> synchronizedQueue;

    public EvenProducer(int lengthOfIntegerForPrint, List<Integer> synchronizedQueue) {
        this.N = lengthOfIntegerForPrint;
        this.synchronizedQueue = synchronizedQueue;
    }

    @Override
    public void run() {
        while (synchronizedQueue.size() < N) {
            try {
                System.out.println("Queue size from even run method - " + synchronizedQueue.size());
                produceEvenIntegers(N);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produceEvenIntegers(int limit) throws InterruptedException {
        synchronized (synchronizedQueue) {
            while (counter > 0) {
                try {
                    counter--;
                    System.out.println("SynchronousQueue is waiting for next even print order");
                    synchronizedQueue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (evenInt % 2 == 0) {
                Thread.sleep(1000);
                synchronizedQueue.add(evenInt);
                System.out.println(String.format("Even value is - %s", evenInt));
                counter++;
                evenInt = evenInt + 2;
                synchronizedQueue.notify();
            }
        }
    }
}
