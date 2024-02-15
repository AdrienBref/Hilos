package org.Simulacro240208.EstadioBenito;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Asistente extends Thread{
    
    private int zonaVipAsignada = 0;
    private int numeroAsistente;
    private ZonaVip[] zonasVip;
    int asientosLibresTotales;
    private static final Object lock = new Object();
    private static int contadorPersonas;
    

    public Asistente(ZonaVip[] zonasVip, int numeroAsistente) {
        this.zonasVip = zonasVip;
        this.numeroAsistente = numeroAsistente;
    }
    
    @Override
    public void run() {
        super.run();
        try {
            
            for(int i = 0; i < zonasVip.length; i++) {
                asientosLibresTotales = zonasVip[i].getCantidadPermitida().availablePermits();
            }
            
            if(asientosLibresTotales > 0) {
                int asientosDisponibles = zonasVip[zonaVipAsignada].getCantidadPermitida().availablePermits();

                while(asientosDisponibles == 0) {
                    zonaVipAsignada++;
                    asientosDisponibles = zonasVip[zonaVipAsignada].getCantidadPermitida().availablePermits();
                }

                zonasVip[zonaVipAsignada].getCantidadPermitida().acquire();
                System.out.println("Asistente " + numeroAsistente + " entra en sala " + zonaVipAsignada);
                zonasVip[zonaVipAsignada].getTorno().acquire();
                sleep(1500);
                zonasVip[zonaVipAsignada].getTorno().release();
                synchronized (lock) {
                    contadorPersonas++;
                }
                
            } else {
                System.out.println("Asistente " + numeroAsistente + " sin sala vip");
            }
            

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }
    
}
