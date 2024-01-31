package org.Monitores.Uem.Naufragos;

public class main {
    public static void main(String[] args) throws InterruptedException {
        int numeroNaufragos = 10;
        String[] naufragos = new String[numeroNaufragos];

        for(int i = 0; i < naufragos.length; i++) {
            Naufragos naufrago = new Naufragos("Naufrago " + i);
            Thread hiloNaufrago = new Thread(new Balsa(naufrago));
            hiloNaufrago.start();
            Thread.sleep(300);
        }
    }
}
