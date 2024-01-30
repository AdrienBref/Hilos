package org.Monitores.Deposito;

public class Llenado implements Runnable{

    private Deposito deposito;

    public Llenado(Deposito deposito) {
        this.deposito = deposito;
    }
    @Override
    public void run() {
        while(true) {
            deposito.llenado();
        }
    }
}
