package org.Simulacro240208.EstadioBenito;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        
        int cantidadSalasVip = 4;
        int numeroDeAsistentes = 32;
        int totalAsistentes = 0;
        
        ZonaVip[] zonasVip = new ZonaVip[cantidadSalasVip];
        Asistente[] asistentes = new Asistente[numeroDeAsistentes];
        
        for(int i = 0; i < numeroDeAsistentes; i++) {
            asistentes[i] = new Asistente(zonasVip, i);
            asistentes[i].start();
        }

        for(int i = 0; i < numeroDeAsistentes; i++) {
            try {
                asistentes[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
        for(int i = 0; i < zonasVip.length; i++) {
            
            totalAsistentes = totalAsistentes + ZonaVip.getContadorPersonas();
            System.out.println(totalAsistentes);
        }
    }
}
