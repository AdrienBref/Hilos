package org.Monitores.Uem.Deposito;


public class Deposito {

    private int litrosTotales = 10;
    private final int capacidadDeposito = 1000;
    private final int limiteArribaDesposito = 900;
    private final int limiteAbajoDeposito = 100;

    public synchronized void llenado(){

        while(litrosTotales != 0/*Condicion para estar esperando*/) {
            try {
                wait(); // Espera hasta que sea seguro llenar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

        System.out.println("COMIENZA LLENADO");
        if(litrosTotales >= limiteArribaDesposito) {
            litrosTotales += 5;
        }
        litrosTotales += 10;
        System.out.println("Llenado de deposito: " + litrosTotales);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        notifyAll();
    }
    public synchronized void vaciado(){
        System.out.println("COMIENZA VACIADO");
        while (litrosTotales > 0/*Condicion para estar esperando*/) {
            try {
                wait(); // Espera hasta que sea seguro vaciar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            if(litrosTotales >= limiteAbajoDeposito) {
                litrosTotales -= 10;
            }
            litrosTotales -= 5;
            System.out.println("Llenado de deposito: " + litrosTotales);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
    }
}
