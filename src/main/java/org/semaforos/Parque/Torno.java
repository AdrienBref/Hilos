package org.semaforos.Parque;

import java.util.concurrent.Semaphore;

public class Torno extends Thread{
    private Contador contador;
    private Semaphore mutex;

    public Torno(Contador contador, Semaphore mutex) {
        this.contador = contador;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        super.run();
    }
}
