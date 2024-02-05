package org.Monitores.Uem.Filosofos;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
    
    private boolean[] tenedores;
    
    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }
    
    public int tenedorIzquierda(int comensal){
        return comensal;
    }
    
    public int tenedorDerecha(int comensal){
        if(comensal == 0){
            return tenedores.length - 1;
        }else{
            return comensal - 1;
        }
    }
    
    public synchronized void cogerTenedores(int comensal){
        
        while(tenedores[tenedorIzquierda(comensal)] || tenedores[tenedorDerecha(comensal)]){
            try {   
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }
    
    public synchronized void dejarTenedores(int comensal){
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        notifyAll();
    }
    
}
