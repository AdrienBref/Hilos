package org.Simulacro240208.EstadioBenito;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Asistente extends Thread{
    
    private static 
    ZonaVip zonaVipAsignada;
    private int numeroAsistente;
    private Random random = new Random();
    
    private int numeroZonaVip;
    
    public Asistente(ZonaVip[] zonasVip, int numeroAsistente) {
        numeroZonaVip = random.nextInt(3 - 0 + 1) + 0;
        zonaVipAsignada = new ZonaVip(numeroZonaVip);
        this.numeroAsistente = numeroAsistente;
        
    }
    
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Asistente numero " + numeroAsistente + " va a zona vip " + numeroZonaVip);
            
            zonaVipAsignada.getCantidadPermitida().acquire();
            zonaVipAsignada.getTorno().acquire();
            zonaVipAsignada.getTorno().release();
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    
}
