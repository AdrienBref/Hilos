package org.Monitores.ChatGpt.CuentaBancaria;

public class TareaMostrarSaldo implements Runnable{
    
    Cuenta_Monitor cuenta;
    
    public TareaMostrarSaldo(Cuenta_Monitor cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Dinero en cuenta = " + cuenta.saldo);
        }
    }
}
