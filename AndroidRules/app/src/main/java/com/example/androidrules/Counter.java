package com.example.androidrules;

public class Counter extends Thread {

    private boolean isAlive=true;
    private int counter = 1;
    private onCounterChange observer;

    @Override
    public void run() {
        new Thread(
                ()->{
                    while(isAlive){
                        try {
                            Thread.sleep(1000);
                            observer.onCounterValue(counter);
                            counter++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    public void setObserver(onCounterChange observer){
        this.observer = observer;
    }

    public interface onCounterChange{
        void onCounterValue(int value);
    }
}
