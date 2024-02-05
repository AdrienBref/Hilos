package org.Monitores.Uem.Deposito;


public class Deposito {

    private int litrosTotales = 10;
    private final int capacidadDeposito = 1000;
    private final int limiteArribaDesposito = 900;
    private final int limiteAbajoDeposito = 100;

    public synchronized void llenado(){

        

        notifyAll();
    }
    public synchronized void vaciado(){
        
        notifyAll();
    }
}
