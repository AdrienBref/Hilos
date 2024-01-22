package org.semaforos.bebedero;

import javax.imageio.ImageTranscoder;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Perros extends Thread {

    private int tiempo;
    private int id;
    private static int generadorId;
    private int litrosBebidos;
    private Semaphore semaforoBebedero;
    private int tiempoBebiendo;
    private Random random = new Random();


    public Perros(Semaphore semaphore) {
        this.id = generadorId;
        this.semaforoBebedero = semaphore;
        generadorId++;
        tiempoBebiendo= random.nextInt(5 - 0 + 1) + 0;
        this.litrosBebidos = tiempoBebiendo;


    }

    public void run() {
        System.out.println(id + " se dirige al bebedero");
        try {
            semaforoBebedero.acquire();
            System.out.println(id + " está bebiendo");
            Thread.sleep(tiempoBebiendo * 1000);
            semaforoBebedero.release();
            System.out.println(id + " ha dejado de beber");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLitrosBebidos() {
        return litrosBebidos;
    }
}
