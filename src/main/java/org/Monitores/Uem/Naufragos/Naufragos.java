package org.Monitores.Uem.Naufragos;

public class Naufragos {

    private String nombre;
    private boolean naufragoEmbarcado = false;
    public Naufragos(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void subeBalsa() throws InterruptedException {

        if(naufragoEmbarcado) {
            wait();
        }
        naufragoEmbarcado = true;
        System.out.println(nombre + " sube a la balsa");
        System.out.println(nombre + " salvado");
        notifyAll();


    }


}
