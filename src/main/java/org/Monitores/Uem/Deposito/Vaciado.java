package org.Monitores.Uem.Deposito;

public class Vaciado implements Runnable{
    private Deposito deposito;

    public Vaciado(Deposito deposito) {
        this.deposito = deposito;
    }
    @Override
    public void run() {
        while (true) {
            deposito.vaciado();
        }
    }
}
