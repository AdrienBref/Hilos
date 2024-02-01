package org.Monitores.ChatGpt.CuentaBancaria;

public class TareaRetirar implements Runnable{
    
    private Cuenta_Monitor cuenta;
    private double cantidad;
    
    public TareaRetirar(Cuenta_Monitor cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }
    
    @Override
    public void run() {
        
        while(true) {
            cuenta.retirar(cantidad);
        }
    }
}
