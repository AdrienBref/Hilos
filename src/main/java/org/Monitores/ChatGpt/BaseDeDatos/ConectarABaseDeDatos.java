package org.Monitores.ChatGpt.BaseDeDatos;

import java.util.concurrent.Semaphore;

public class ConectarABaseDeDatos implements Runnable {
    
    Semaphore semaphore;
    
    public ConectarABaseDeDatos(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    public void conectar(int idCliente) {
        System.out.println("Cliente con id: " + idCliente + " conectado");
    }

    @Override
    public void run() {
        
    }
}
