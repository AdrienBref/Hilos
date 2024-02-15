package org.Simulacro240208.EstadioBenito;

import java.util.concurrent.Semaphore;

public class ZonaVip {
    
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

    public int getContadorPersonas() {
        return contadorPersonas;
    }


}
