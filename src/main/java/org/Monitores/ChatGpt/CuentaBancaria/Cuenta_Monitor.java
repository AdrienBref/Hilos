package org.Monitores.ChatGpt.CuentaBancaria;

public class Cuenta_Monitor {
    
    public double saldo = 0.0;
    
    public synchronized void ingresar(double cantidad) {
        
        saldo = saldo + cantidad;
        //System.out.println("Cantidad Ingresada: " + cantidad +". Saldo actual: " + saldo);
        
    }
    
    public synchronized void retirar(double cantidad) {

        saldo = saldo - cantidad;
        //System.out.println("Cantidad Retirada: " + cantidad +". Saldo actual: " + saldo);
        
    }
    
    public synchronized double mostrarSaldo() {

        return saldo;
        
    }
}
