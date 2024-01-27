package org.semaforos.tiendaDeportes;

import java.util.Random;
import java.util.SequencedMap;
import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private int idCliente;
    private Semaphore limitePersonas;
    private Semaphore[] cajas;

    public Cliente(int id, Semaphore limitepersonas, Semaphore[]cajas) {
        this.idCliente = id;
        this.limitePersonas = limitepersonas;
        this.cajas = cajas;
    }

    @Override
    public void run() {
        try {
            // Intentar entrar a la tienda
            limitePersonas.acquire();

            // Elegir caja aleatoria
            int cajaElegida = new Random().nextInt(4);
            cajas[cajaElegida].acquire();

            // Simular proceso de pago
            int monto = new Random().nextInt(100); // Monto aleatorio
            System.out.println("Cliente " + idCliente + " pagando en caja " + cajaElegida + ": $" + monto);
            cajas[cajaElegida].release();
            System.out.println("Cliente " + idCliente + " termina de pagar");
            limitePersonas.release();
            System.out.println("Cliente " + idCliente + " sale de la tienda");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

