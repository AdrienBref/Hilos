package org.Monitores.ChatGpt.CuentaBancaria;

public class Saldo implements Runnable{
    
    Cuenta_Monitor cuenta;
    
    public Saldo(Cuenta_Monitor cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Dinero en cuenta = " + cuenta.saldo);
        }
    }
}
