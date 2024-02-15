package org.Simulacro240208.EstadioBenito;

import java.util.concurrent.Semaphore;

public class ZonaVip {
    
    /*
    * La zonaVip se ocupa de administrar los permisos de torno(semaforo de un 1 permiso) y asientos
    * de zonaVip(semaforo de 6 permisos) de cada instancia de zonaVip
    * 
    * */
    
    private Semaphore torno = new Semaphore(1);
    private Semaphore cantidadPermitida;
    private int numeroSalaVip;
    private int contadorPersonas;
    

    public ZonaVip(int numeroSalaVip) {
        this.cantidadPermitida = new Semaphore(6);
        this.numeroSalaVip = numeroSalaVip;
        
    }
    
    public Semaphore getCantidadPermitida() {
        return cantidadPermitida;
    }

    public void setCantidadPermitida(Semaphore cantidadPermitida) {
        this.cantidadPermitida = cantidadPermitida;
    }

    public Semaphore getTorno() {
        return torno;
    }
    


}
