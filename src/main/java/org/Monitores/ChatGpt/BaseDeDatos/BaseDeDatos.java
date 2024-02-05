package org.Monitores.ChatGpt.BaseDeDatos;

public class BaseDeDatos {
    
    private static int numeroDeClientesConectados;
    private static final int numeroMaximoClientes = 3;
    private boolean transsacion = false;
    
    
    public synchronized void insert(int idCliente) {
        while(transsacion) {
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
