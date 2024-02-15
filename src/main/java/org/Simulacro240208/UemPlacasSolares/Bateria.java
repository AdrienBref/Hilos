package org.Simulacro240208.UemPlacasSolares;

public class Bateria {
    
   private int cargaActual;
   
   public Bateria() {
       cargaActual = 50;
   }
    
    public synchronized void llenado() {
       if(cargaActual == 100) {
           try {
               wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
       while(cargaActual < 90) {
           cargaActual += 10;
       }
        
    }
    
    public synchronized void vaciado() {
        
    }
}
