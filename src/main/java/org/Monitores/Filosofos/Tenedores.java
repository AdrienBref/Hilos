package org.Monitores.Filosofos;

public class Tenedores {

    private boolean tenedorFlag = false;
    private String nombreTenedor;
    private int numeroTenedor;
    
    public Tenedores(int numeroTenedor) {
        this.numeroTenedor = numeroTenedor;
        nombreTenedor = "Tenedor numero " + numeroTenedor;
    }
    
    public synchronized void tenedorUsandose(String nombreFilosofo) throws InterruptedException {
        
        if(tenedorFlag) {
            wait();
        }
        tenedorFlag = true;
        System.out.println(nombreFilosofo + " usando " + nombreTenedor);
        Thread.sleep(5000);

        System.out.println(nombreFilosofo + " deja deja usar " + nombreTenedor);
        tenedorFlag = false;
        notifyAll();
    }

    public boolean isTenedorFlag() {
        return tenedorFlag;
    }
}
