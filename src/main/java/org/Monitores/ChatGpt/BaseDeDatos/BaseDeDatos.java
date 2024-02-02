package org.Monitores.ChatGpt.BaseDeDatos;

import static java.lang.Thread.sleep;

public class BaseDeDatos {
    
    private int numeroDeClientesConectados;
    private static final int numeroMaximoClientes = 3;
    private boolean transsacion = false;
    
    public synchronized void conectar(int idCliente) {
        if(numeroDeClientesConectados == numeroMaximoClientes) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            numeroDeClientesConectados++;
            System.out.println("Cliente con id: " + idCliente +" se conecta");
            System.out.println("Numero de conexiones actuales: " + numeroDeClientesConectados );
            insert(idCliente);
            desconectar(idCliente);
            notifyAll();
        }
    }
    
    public synchronized void insert(int idCliente) {
        if(transsacion) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        transsacion = true;
        System.out.println("Cliente con id: " + idCliente + " realiza Insert");
        transsacion = false;
        notifyAll();
    }
    
    public void desconectar(int idCliente){
        numeroDeClientesConectados--;
        System.out.println("Cliente con id: " + idCliente + " se desconecta");
        System.out.println("Numero de conexiones actuales: " + numeroDeClientesConectados );
    }
    
}
