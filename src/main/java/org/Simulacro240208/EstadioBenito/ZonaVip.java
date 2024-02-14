package org.Simulacro240208.EstadioBenito;

import java.util.concurrent.Semaphore;

public class ZonaVip {
    
    private static Semaphore torno = new Semaphore(1);
    private Semaphore cantidadPermitida = new Semaphore(6);
    private int numeroSalaVip;
    private static int contadorPersonas;
    

    public ZonaVip(int numeroSalaVip) {
        this.numeroSalaVip = numeroSalaVip;
        contadorPersonas++;
        
    }

    public int getNumeroSalaVip() {
        return numeroSalaVip;
    }

    public Semaphore getCantidadPermitida() {
        return cantidadPermitida;
    }

    public void setCantidadPermitida(Semaphore cantidadPermitida) {
        this.cantidadPermitida = cantidadPermitida;
    }

    public static Semaphore getTorno() {
        return torno;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public static void setTorno(Semaphore torno) {
        ZonaVip.torno = torno;
    }
}
