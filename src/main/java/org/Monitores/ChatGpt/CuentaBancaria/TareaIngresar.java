package org.Monitores.ChatGpt.CuentaBancaria;

import org.Monitores.ChatGpt.ContadorCompartido.TareaIncremento;

public class TareaIngresar implements Runnable{
    
    Cuenta_Monitor cuenta;
    private double cantidad;
    
    public TareaIngresar(Cuenta_Monitor cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }
    
    @Override
    public void run() {
        while(true) {
            cuenta.ingresar(cantidad);
        }
    }
}
