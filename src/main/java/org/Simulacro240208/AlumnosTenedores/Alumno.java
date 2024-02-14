package org.Simulacro240208.AlumnosTenedores;
import java.util.concurrent.Semaphore;

public class Alumno extends Thread {
    
    int numeroEstudiante;
    Semaphore tenedor1;
    Semaphore tenedor2;
    
    public Alumno(Semaphore tenedor1, Semaphore tenedor2, int numeroEstudiante) {
        this.tenedor1 = tenedor1;
        this.tenedor2 = tenedor2;
        this.numeroEstudiante = numeroEstudiante;
    }

    @Override
    public void run() {
            
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int tenedoresLibres = tenedor1.availablePermits() + tenedor2.availablePermits();
            
            if(tenedoresLibres != 2) {
                System.out.println("El estudiante " + numeroEstudiante + " espera" );
            } else {
                try {
                    tenedor1.acquire();
                    tenedor2.acquire();
                    System.out.println("El estudiante " + numeroEstudiante + " está comiendo");
                    
                    sleep(2500);
                    
                    System.out.println("El estudiante " + numeroEstudiante + " termina de comer");
                    tenedor1.release();
                    tenedor2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        
    }
}
