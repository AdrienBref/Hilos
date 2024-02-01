package org.Monitores.ChatGpt.CuentaBancaria;

import java.util.Random;

public class MainCuentaBancaria {
    public static void main(String[] args) {
        Cuenta_Monitor cuentaMonitor = new Cuenta_Monitor();
        Random random = new Random();
        int randNum = random.nextInt(100 - 0 + 1) + 0;
        Thread[] hilosRetirada = new Thread[3];
        Thread[] hilosIngreso = new Thread[3];
        Thread hiloMostrar = new Thread(new Saldo(cuentaMonitor));
        
        for(int i = 0; i < hilosRetirada.length; i++) {
            hilosRetirada[i] = new Thread(new TareaRetirar(cuentaMonitor, 1));
            hilosRetirada[i].start();
        }
        
        for(int i = 0; i < hilosIngreso.length; i++) {
            hilosIngreso[i] = new Thread(new TareaIngresar(cuentaMonitor, 1));
            hilosIngreso[i].start();
        }
        
        hiloMostrar.start();
    }
}
