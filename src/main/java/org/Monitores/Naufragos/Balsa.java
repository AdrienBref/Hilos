package org.Monitores.Naufragos;

public class Balsa implements Runnable {

    Naufragos naufrago;

    public Balsa(Naufragos naufrago) {
        this.naufrago = naufrago;
    }

    @Override
    public void run() {
        try {
            naufrago.subeBalsa();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
