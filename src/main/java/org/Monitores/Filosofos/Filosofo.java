package org.Monitores.Filosofos;

public class Filosofo implements Runnable {
    private String nombreFilosofo;
    private int numeroFilosofo;
    private Tenedores tenedor1;
    private Tenedores tenedor2;

    public Filosofo(int numeroFilosofo, Tenedores tenedor1, Tenedores tenedor2) {
        this.numeroFilosofo = numeroFilosofo;
        this.tenedor1 = tenedor1;
        this.tenedor2 = tenedor2;
        nombreFilosofo = "Filosofo numero " + numeroFilosofo;
    }

    public String getNombreFilosofo() {
        return nombreFilosofo;
    }

    @Override
    public void run() {
        try {
            tenedor1.tenedorUsandose(nombreFilosofo);
            tenedor2.tenedorUsandose(nombreFilosofo);
            
            if(tenedor1.isTenedorFlag() && tenedor2.isTenedorFlag()) {
                System.out.println(nombreFilosofo + " comiendo...");
            } else {
                System.out.println(nombreFilosofo + " esperando...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
