package org.Simulacro240208.EstadioBenito;

public class Main {

    public static void main(String[] args) {
        
        int cantidadSalasVip = 4;
        int numeroDeAsistentes = 100;
        
        ZonaVip[] zonasVip = new ZonaVip[cantidadSalasVip];
        Asistente[] asistentes = new Asistente[numeroDeAsistentes];
        
        
        for(int i = 0; i < zonasVip.length; i++) {
            zonasVip[i] = new ZonaVip(i);
        }
        
        for(int i = 0; i < asistentes.length; i++) {
            asistentes[i] = new Asistente(zonasVip,i);
            asistentes[i].start();
        }

        try {
            for(int i = 0; i < asistentes.length; i++) {
                asistentes[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        System.out.println("Total de asistentes en palco Vip: " + Asistente.getContadorPersonas());    
        

    }
}
