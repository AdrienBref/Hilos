package org.galgos;

public class Galgo extends Thread {

    private int id;
    private static int generadorIds = 1;
    private int tiempoCarrera;

    public Galgo(int tiempoCarrera) {
        this.id = generadorIds;
        this.tiempoCarrera = tiempoCarrera;
        generadorIds++;
    }

    public void run() {
        try {
            Thread.sleep(tiempoCarrera * 1000);
            System.out.println(id + " ha llegado a la meta.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
