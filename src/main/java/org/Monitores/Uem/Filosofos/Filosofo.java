package org.Monitores.Uem.Filosofos;

public class Filosofo extends Thread {
    
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;
    
    public Filosofo(Mesa m, int comensal){
        this.mesa = m;
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
    }
    
    public void run(){
        while(true){
            pensando();
            mesa.cogerTenedores(indiceComensal);
            comiendo();
            System.out.println("Filosofo " + comensal +  " deja de comer, tenedores libres " + (mesa.tenedorIzquierda(indiceComensal) + 1) + ", " + (mesa.tenedorDerecha(indiceComensal) + 1) );
            mesa.dejarTenedores(indiceComensal);
        }
    }
    
    public void pensando(){
       
        System.out.println("Filosofo " + comensal + " esta pensando");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }
        
    }
    
    public void comiendo(){
        System.out.println("Filosofo " + comensal + " esta comiendo");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }
    }
    
}
